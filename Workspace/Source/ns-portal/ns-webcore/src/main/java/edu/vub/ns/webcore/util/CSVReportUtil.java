package edu.vub.ns.webcore.util;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSVReportUtil implements Constant {

	private final String REPORT = "reports";
	private String folderName;
	public String logo;

	private DriverManagerDataSource dataSource;
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	@SuppressWarnings("unused")
	private void init() {
		if (folderName == null || folderName.isEmpty()) {
			folderName = "generatereport";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public String generateReport(ServletContext servletContext,
			String sourceFileName, String reportFileName, String fileType,
			Map params, List data, String reportDataSource, String reportType)
			throws Exception {
		JasperPrint jasperPrint = null;
		String rootPath = servletContext.getRealPath("");
		File file = new File(rootPath + File.separator + folderName);
		if (!file.exists()) {
			file.mkdir();
		} else {
			delete(file);
		}
		String sourceFileDestination = rootPath + File.separator + REPORT
				+ File.separator + sourceFileName;
		String reportFileDestination = rootPath + File.separator + folderName
				+ File.separator + reportFileName;
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObjectFromFile(sourceFileDestination);
		if (reportDataSource.equalsIgnoreCase(JAVA_BEAN)) {
			jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					new JRBeanCollectionDataSource(data));

		} else {
			jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					dataSource.getConnection());
		}
	    
		if (fileType.equalsIgnoreCase(REPORT_FORMAT_PDF)) {
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					reportFileDestination);
		} else if (fileType.equalsIgnoreCase(REPORT_FORMAT_CSV)) {

			JRCsvExporter csvExporter = new JRCsvExporter();
			csvExporter.setParameter(JRCsvExporterParameter.JASPER_PRINT,
					jasperPrint);
			csvExporter.setParameter(
					JRCsvExporterParameter.IGNORE_PAGE_MARGINS, false);
			csvExporter.setParameter(JRCsvExporterParameter.OUTPUT_FILE_NAME,
					reportFileDestination);
			csvExporter.exportReport();

			return rootPath + File.separator + folderName + File.separator
					+ reportFileName;

		}
		return folderName + "/" + reportFileName;
	}

	private void delete(File file) {
		String[] fileList = file.list();
		int size = fileList.length;
		for (int i = 0; i < size; i++) {
			File fileOrFolder = new File(file.getPath() + "/" + fileList[i]);
			fileOrFolder.delete();
		}
	}

	
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
