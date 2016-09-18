package edu.vub.ns.security.util;


import edu.vub.ns.security.bean.LoginBean;
import edu.vub.ns.security.manager.SecurityQueryManager;
import edu.vub.ns.webcore.dao.SpringJdbcDao;

public class LoginUtil implements SecurityConstant {
	
	public static LoginBean getLogin(SpringJdbcDao springJdbcDao, SecurityQueryManager securityQueryManager, String loginID) throws Exception {
		LoginBean login = (LoginBean) springJdbcDao.getObject(securityQueryManager.getLoginSql(loginID), null, LoginBean.class);
		return login;
	}
}
