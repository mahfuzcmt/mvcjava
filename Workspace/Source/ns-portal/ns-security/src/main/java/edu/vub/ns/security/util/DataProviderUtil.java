package edu.vub.ns.security.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.vub.ns.security.bean.LoginBean;
import edu.vub.ns.security.manager.SecurityQueryManager;
import edu.vub.ns.security.rest.service.LoginService;
import edu.vub.ns.webcore.dao.SpringJdbcDao;



public class DataProviderUtil implements SecurityConstant {
	
	private static Logger log = LoggerFactory.getLogger(LoginService.class);
	
	public LoginBean getLoginByLoginID(SpringJdbcDao springJdbcDao, SecurityQueryManager queryManager, String loginID) {
		LoginBean loginBean = null;
		try {
			loginBean = LoginUtil.getLogin(springJdbcDao, queryManager, loginID);
		} catch (Exception e){			
			log.error("An Exception occured while try to get Login Info by LoginID : ", e);
		}
		return loginBean;
	}
	
	
	
}
