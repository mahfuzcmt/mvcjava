package edu.vub.ns.webcore.util;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import edu.vub.ns.webcore.bean.ResponseBean;
import net.sf.jxls.transformer.XLSTransformer;



public class ReportUtil implements Constant {

	private final String REPORTS = "reports";
	private final String XLS = "xls";
	private String folderName;
	public String logo;
	
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

	
	
	public String getDestPathName(ServletContext servletContext, String reportFileName) throws Exception {		
		String rootPath = servletContext.getRealPath("");
		File file = new File(rootPath + File.separator + folderName);
		if (!file.exists()) {
			file.mkdir();
		} else {
			delete(file);
		}			
		String destFileName = rootPath + File.separator + folderName + File.separator + reportFileName ;				
        return destFileName;
	}
	
	public String getSourcePathName(ServletContext servletContext, String sourceFileName) throws Exception {		
		String rootPath = servletContext.getRealPath("");
		File file = new File(rootPath + File.separator + folderName);
		if (!file.exists()) {
			file.mkdir();
		} else {
			delete(file);
		}			
		String sourceFileDestination = rootPath + File.separator + REPORTS + File.separator + XLS + File.separator + sourceFileName;				
        return sourceFileDestination;
	}
	
	@SuppressWarnings("rawtypes")
	public ResponseBean GenerateJXLReport(ServletContext servletContext, ResponseBean resbean, Map beans, String templateName, String reportFileName) throws Exception{
		   String templateFileName = getSourcePathName(servletContext, templateName);
		   String reportFileLocation = getDestPathName(servletContext, reportFileName);
		   XLSTransformer transformer = new XLSTransformer();	   
	       transformer.transformXLS(templateFileName, beans, reportFileLocation);   
			if (reportFileLocation != null) {
				resbean.setSuccess(true);
				resbean.setData(reportFileName);
			}
		   
		   return resbean;
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

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
