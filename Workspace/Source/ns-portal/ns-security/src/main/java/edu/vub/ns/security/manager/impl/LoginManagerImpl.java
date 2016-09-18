package edu.vub.ns.security.manager.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.vub.ns.security.bean.LoginBean;
import edu.vub.ns.security.bean.LoginLogBean;
import edu.vub.ns.security.manager.LoginManager;
import edu.vub.ns.security.util.DataProviderUtil;
import edu.vub.ns.security.util.SecurityConstant;
import edu.vub.ns.webcore.bean.Code;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.util.ParamUtil;
import edu.vub.ns.webcore.util.PasswordCipher;

public class LoginManagerImpl extends SecurityManagerImpl implements LoginManager, SecurityConstant {
	
	private static Logger log = LoggerFactory.getLogger(LoginManagerImpl.class);
	
	DataProviderUtil dataProviderUtil = new DataProviderUtil();
	
	@Override
	public ResponseBean doLogin(ResponseBean response, LoginBean model, String ipAddress) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" loging by " + model.getLoginID());
		try {
			LoginBean loginBean = dataProviderUtil.getLoginByLoginID(springJdbcDao, securityQueryManager, model.getLoginID());

			if(loginBean == null){
				log.warn("Not found Login info of  : "+model.getLoginID());
				response.setCode(Code.Nl1000);
				return response;
			}
			else if(!loginBean.getStatus().equalsIgnoreCase(ACTIVE_SHORT)){
				log.warn("Inactive user : "+model.getLoginID());
				response.setCode(Code.Ia1000);
				return response;
			}
			else if(!loginBean.getPassword().equalsIgnoreCase(PasswordCipher.encrypt(model.getPassword()))){
				log.warn("Password not match of : "+ model.getLoginID());
				response.setCode(Code.Pw1000);
				return response;
			}
			loginBean.setSessionId(idGenerator.getSessionId());
			loginBean.setPassword(null);
			response.setData(loginBean);
			sessionManager.setUserInSession(loginBean);
			LoginLogBean loginLog = new LoginLogBean(loginBean);
			Object[] loginLogParam = ParamUtil.getParamsWithoutObject(loginLog.getOid(), loginLog.getLoginID(), loginLog.getRoleID(), 
					loginLog.getIpAddress(), loginLog.getLoginTime(), loginLog.getLogoutTime(), loginLog.getLoginStatus());
			springJdbcDao.saveObject(securityQueryManager.insertLoginLog(), loginLogParam);
			log.info("Successfully Login : "+ model.getLoginID());
		} catch (Exception e){	
			
			e.printStackTrace();
			log.error("An Exception occured while trying to Login : ", e);
		}
		return response;
	}
	
	public ResponseBean doLogout(ResponseBean resBean, LoginBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" loging out by "+ model.getLoginID());
		try {
			LoginLogBean loginLog = (LoginLogBean) springJdbcDao.getObject(securityQueryManager.getLoginLogBySessionID(model.getSessionId()), null, LoginLogBean.class);
			Date loginTime = loginLog.getLoginTime();
			Date logoutTime = new Date();
			long duration = (logoutTime.getTime()-loginTime.getTime())/1000;
			Object[] params = ParamUtil.getParamsWithoutObject(new Date(), duration, model.getSessionId());
			springJdbcDao.updateObject(securityQueryManager.updateLoginLog(), params);
			resBean.setSuccess(true);
			sessionManager.clearSession(model);
			log.info("Successfully Logout : "+ model.getLoginID());
		} catch (Exception e) {
			log.error("An exception occured while trying to Logout : "+model.getLoginID(), e);
		}
		return resBean;
	}

	@Override
	public ResponseBean changePassword(ResponseBean response, LoginBean model) {
		log.info(INITIAL_MESSAGE_IN_MANAGER);
		try
			{
				if(isOldPasswordValid(model)){
				springJdbcDao.updateObject(securityQueryManager.changePassword(), new Object []{PasswordCipher.encrypt(model.getNewPassword()), new Date(), 
						model.getLoginID(), model.getLoginID()});
				
				response.setSuccess(true);
				response.setCode(Code.SCP001);
				log.info(FINAL_MESSAGE_IN_SERVICE);
				log.info(SUCCESSFUL_UPDATED_MESSAGE+PASSWORD+FOR+model.getLoginID());
				
				}
				else {
					log.error(INVALID_OLD_PASSWORD);
					response.setCode(Code.INVP003);
					response.setSuccess(false);
				}
			}
			catch(Exception e)
			{
				response.setSuccess(false);
				response.setCode(Code.UCP002);
				log.error(EXCEPTION_MESSAGE+UPDATING+PASSWORD+FOR+model.getLoginID());
			}
		return response;
	}
	
	
	private boolean isOldPasswordValid(LoginBean model) throws Exception {
		 try{
			LoginBean userInfo = (LoginBean) springJdbcDao.getObject(securityQueryManager.getOldPassword(model.getLoginID()), null, LoginBean.class);
			 if(userInfo.getPassword().equalsIgnoreCase(PasswordCipher.encrypt(model.getOldPassword()))){
				 return true;
			 }
		}
		 catch(Exception e){
			 log.error(EXCEPTION_MESSAGE+LOADING+OLD_PASSWORD_BY_LOGINID+" "+model.getLoginID()+": ");
		 }
			return false;
	}

}
