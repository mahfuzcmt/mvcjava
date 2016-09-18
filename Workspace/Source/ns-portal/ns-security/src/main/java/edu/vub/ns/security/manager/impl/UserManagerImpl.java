package edu.vub.ns.security.manager.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.google.common.base.Strings;

import edu.vub.ns.security.bean.UserBean;
import edu.vub.ns.security.manager.UserManager;
import edu.vub.ns.security.util.SecurityConstant;
import edu.vub.ns.webcore.bean.Code;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.util.ParamUtil;
import edu.vub.ns.webcore.util.PasswordCipher;


public class UserManagerImpl extends SecurityManagerImpl implements UserManager, SecurityConstant {
	
	private static Logger log = LoggerFactory.getLogger(UserManagerImpl.class);
	
	@Override
	public ResponseBean updateUser(ResponseBean response, UserBean model) {
		if(!Strings.isNullOrEmpty(model.getPurpose()) && model.getPurpose().equalsIgnoreCase(UpdateFeatureJSON)){
			return updateFeatureJSON(response, model);
		}
		
		log.info(A_REQUESR_IS_RECEIVED_FOR+" updating user ");
			try {
				
				if(Strings.isNullOrEmpty(model.getPhoneNo())){
					model.setPhoneNo("");
				};
				if(Strings.isNullOrEmpty(model.getEmail())){
					model.setEmail("");
				};
				
				Object[] param = ParamUtil.getParamsWithoutObject(model.getFeatureJSON(), model.getLoginBean().getLoginID(), 
						new Date(), model.getLoginID() );
				springJdbcDao.updateObject(securityQueryManager.updateUser(model.getName(), model.getPhoneNo(), model.getEmail(),
						 model.getRoleID(),  model.getStatus(), model.getImagePath()), param);
				response.setSuccess(true);
				response.setCode(Code.Su1000);
				log.info("Successfully Updated user info for login ID : "+model.getLoginID());
			} catch (Exception e){			
				log.error("An Exception occured while Updating user info for login ID : "+model.getLoginID(), e);
				response.setCode(Code.Up1000);
			}
			return response;
	}
	
	public ResponseBean updateFeatureJSON(ResponseBean response, UserBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" updating feature JSON ");
			try {
				
				Object[] param = ParamUtil.getParamsWithoutObject(model.getFeatureJSON(), model.getLoginBean().getLoginID(), 
						new Date(), model.getLoginBean().getLoginID() );
				springJdbcDao.updateObject(securityQueryManager.updateFeatureJSON(), param);
				response.setSuccess(true);
				response.setCode(Code.Su1000);
				log.info("Successfully Updated feature JSON  for login ID : "+model.getLoginBean().getLoginID());
			} catch (Exception e){			
				log.error("An Exception occured while Updating feature JSON for login ID : "+model.getLoginBean().getLoginID(), e);
				response.setCode(Code.Up1000);
			}
			return response;
	}

	@Override
	public ResponseBean saveUser(ResponseBean response, UserBean model) {
		TransactionDefinition transDef = new DefaultTransactionDefinition();
		TransactionStatus transStatus = springJdbcDao.getTransactionManager().getTransaction(transDef);
		try {
			if (isDuplicateRole(model)){
				response.setCode(Code.Ed1000);
				return response;
			}
			
			if(!Strings.isNullOrEmpty(model.getRoleID()) && model.getRoleID().equalsIgnoreCase(TEACHER)){
				model.setLoginID(TCR+"-"+model.getLoginID());
			}
			Object[] param = ParamUtil.getParamsWithoutObject(model.getLoginID(),
					model.getPhoneNo(), model.getEmail(),model.getRoleID(), model.getFeatureJSON(), PasswordCipher.encrypt(model.getPassword()),
					model.getStatus(), model.getName(), model.getImagePath(), model.getLoginBean().getLoginID(), new Date());
			springJdbcDao.saveObject(securityQueryManager.insertLoginSql(), param);
			
			if(!Strings.isNullOrEmpty(model.getLoginID()) && model.getLoginID().contains(TCR)){
				Object[] teacherParam = ParamUtil.getParamsWithoutObject(idGenerator.generateId(), model.getLoginID(),
						model.getName(), model.getGender(), model.getPhoneNo(), model.getEmail(), model.getImage(), model.getDesignation(),
						model.getLoginBean().getLoginID(), new Date());
				springJdbcDao.saveObject(securityQueryManager.insertIntoTeacher(), teacherParam);
				log.info("Successfully saved teacher info : "+model.getLoginID());
			}
			springJdbcDao.getTransactionManager().commit(transStatus);
			response.setSuccess(true);
			response.setCode(Code.Sc1001);
			response.setData("Thanks for user registration. Login ID is: "+model.getLoginID() +" and password: "+ model.getPassword());
			log.info("Successfully Save User for User ID : "+model.getLoginID());
		} catch (Exception e){			
			log.error("An Exception occured while Saving User : ", e);
			response.setCode(Code.Us1000);
			springJdbcDao.getTransactionManager().rollback(transStatus);
		}
		return response;
	}

	public Boolean isDuplicateRole( UserBean model) throws Exception{
		UserBean	res = (UserBean) springJdbcDao.getObject(securityQueryManager.getLoginID(model.getLoginID().toUpperCase()),null, UserBean.class);
		if(res == null){
			return false;
		}
		
		return true;
	}

	@Override
	public ResponseBean getAllUsers(ResponseBean response, UserBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" getting user list ");
		try {
			@SuppressWarnings("unchecked")
			List<UserBean> nodes = springJdbcDao.getObjectList(securityQueryManager.getAllUsers(), null, UserBean.class);
			if(nodes != null && !nodes.isEmpty()){
				response.setData(nodes);
			}
			response.setSuccess(true);
			log.info("Successfully Loaded user list");
		} catch (Exception e){			
			log.error("An Exception occured while getting user list : ", e);
			response.setCode(Code.Un1003);
		}
		return response;
	}

	@Override
	public ResponseBean getUserByLoginID(ResponseBean response, UserBean model) {
			log.info(A_REQUESR_IS_RECEIVED_FOR+" getting user info by loginID ");
			try {
				UserBean data = (UserBean) springJdbcDao.getObject(securityQueryManager.getUserByLoginID(), new Object[]{model.getLoginID()}, UserBean.class);
				if(data != null){
					response.setData(data);
					response.setSuccess(true);
					log.info("Successfully Loaded user info by loginID : ");
				}
			} catch(Exception e){
				log.error("An Exception occured while getting user info by loginID : ", e);
				response.setCode(Code.Un1003);
			}
		
		return response;
	}
}
