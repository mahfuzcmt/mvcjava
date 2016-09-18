package edu.vub.ns.webcore.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import edu.vub.ns.webcore.dao.SimpleJdbcDao;
import edu.vub.ns.webcore.dao.SpringJdbcDao;
import edu.vub.ns.webcore.entity.AbstractEntity;
import edu.vub.ns.webcore.manager.IdGenerator;
import edu.vub.ns.webcore.manager.Manager;
import edu.vub.ns.webcore.manager.QueryManager;
import edu.vub.ns.webcore.util.CSVReportUtil;
import edu.vub.ns.webcore.util.ReportUtil;


public class ManagerImpl implements Manager {
	
	//protected SessionManager sessionManager;
	protected QueryManager queryManager;
	protected IdGenerator idGenerator;
	protected SpringJdbcDao springJdbcDao;
	//protected MemoryDao memoryDao;
    protected SimpleJdbcDao simpleJdbcDao;
    protected ReportUtil reportUtil;
    protected CSVReportUtil csvreportUtil;
    protected DriverManagerDataSource dataSource;
	protected List<AbstractEntity> entityList = new ArrayList<AbstractEntity>();

	public void setIdGenerator(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	public void setSpringJdbcDao(SpringJdbcDao springJdbcDao) {
		this.springJdbcDao = springJdbcDao;
	}

	public void setSimpleJdbcDao(SimpleJdbcDao simpleJdbcDao) {
		this.simpleJdbcDao = simpleJdbcDao;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	public void setReportUtil(ReportUtil reportUtil) {
		this.reportUtil = reportUtil;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setCsvreportUtil(CSVReportUtil csvreportUtil) {
		this.csvreportUtil = csvreportUtil;
	}
	

}
