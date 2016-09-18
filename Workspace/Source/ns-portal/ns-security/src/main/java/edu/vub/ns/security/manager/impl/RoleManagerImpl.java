package edu.vub.ns.security.manager.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.vub.ns.security.bean.RoleBean;
import edu.vub.ns.security.manager.RoleManager;
import edu.vub.ns.security.util.SecurityConstant;
import edu.vub.ns.webcore.bean.Code;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.util.ParamUtil;


public class RoleManagerImpl extends SecurityManagerImpl implements RoleManager, SecurityConstant {
	
	private static Logger log = LoggerFactory.getLogger(RoleManagerImpl.class);
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ResponseBean getAllRole(ResponseBean response, RoleBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" getting all roles ");
		try {
			List<RoleBean> roleList = springJdbcDao.getObjectList(securityQueryManager.getAllRoleSql(), null, RoleBean.class);
			if(roleList != null && !roleList.isEmpty()){
				response.setData(roleList);
				response.setSuccess(true);
				response.setCode(Code.Su1003);
			}
		log.info("Successfully Load All Role");
		} catch (Exception e){			
		log.error("An Exception occured while get all roles : ", e);
			response.setCode(Code.Nd1000);
		}
		return response;
	}


	@Override
	public ResponseBean getMenuJsonTemplateFromMetaProperty(ResponseBean response, RoleBean model) {
		try {
			RoleBean data = null;
			try {
				data = (RoleBean) springJdbcDao.getObject(securityQueryManager.getMenuJsonTemplateFromMetaProperty(), new Object[]{model.getOid()}, RoleBean.class);
			} catch(Exception e){
				log.error("An Exception occured while getting menu json template : ", e);
			}
			if(data == null){
				log.warn("menu json template not found!!!");
				return response;
			}
			response.setData(data);
			response.setSuccess(true);
		} catch (Exception e) {
			log.error("An Exception occurred while getting menu json template : ", e);
		}
		return response;
	}


	@Override
	public ResponseBean saveRole(ResponseBean response, RoleBean model) {
		try {
			if (isDuplicateRole(model)){
				response.setCode(Code.Ed1000);
				return response;
			}
		} catch (Exception e1) {
			log.error("An Exception occured while checking duplicate value for role : ", e1);
		}
		try {
			
			Object[] param = ParamUtil.getParamsWithoutObject(model.getRoleID(), model.getRoleDescription(), model.getMenuJSON(), model.getLoginBean().getLoginID(),
					new Date());
			springJdbcDao.saveObject(securityQueryManager.saveRole(), param);
			response.setSuccess(true);
			response.setCode(Code.Sc1000);
			log.info("Successfully Saved Role");
		} catch (Exception e){			
			log.error("An Exception occured while Saving Role : ", e);
			response.setCode(Code.Us1000);
		}
		return response;
	}
	
	public Boolean isDuplicateRole( RoleBean model) throws Exception{
		RoleBean	res = (RoleBean) springJdbcDao.getObject(securityQueryManager.getRole(model.getRoleID().toUpperCase()),null, RoleBean.class);
		if(res == null){
			return false;
		}
		
		return true;
	}


	@Override
	public ResponseBean getRoleByRoleID(ResponseBean response, RoleBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" getting role by roleID ");
		try {
			RoleBean data = (RoleBean) springJdbcDao.getObject(securityQueryManager.getRoleByRoleID(), new Object[]{model.getRoleID()}, RoleBean.class);
			if(data != null){
				response.setData(data);
				response.setSuccess(true);
				log.info("Successfully Loaded role by roleID : ");
			}
		} catch(Exception e){
			log.error("An Exception occured while getting role by roleID : ", e);
			response.setCode(Code.Un1003);
		}
	return response;
	}
	
	@Override
	public ResponseBean updateRole(ResponseBean response, RoleBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" updating user ");
			try {
				Object[] param = ParamUtil.getParamsWithoutObject(model.getRoleID(), model.getRoleDescription(), model.getMenuJSON(), new Date(), 
						model.getLoginBean().getLoginID());
				springJdbcDao.updateObject(securityQueryManager.updateRole(model.getRoleID()), param);
				response.setSuccess(true);
				response.setCode(Code.Su1000);
				log.info("Successfully Updated role for role ID : "+model.getRoleID());
			} catch (Exception e){			
				log.error("An Exception occured while Updating role  for role ID : "+model.getRoleID(), e);
				response.setCode(Code.Up1000);
			}
			return response;
	} 


	@Override
	public ResponseBean deleteRole(ResponseBean response, RoleBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" deleting role ");
		try {
			Object[] param =  ParamUtil.getParamsWithoutObject(model.getRoleID()); 
				springJdbcDao.deleteObject(securityQueryManager.deleteRole(), param);
			response.setSuccess(true);
			response.setCode(Code.SD100);
			log.info("Successfully deleted role for role ID : "+model.getRoleID());
		} catch (Exception e){			
			log.error("An Exception occured while deleting role  for role ID : "+model.getRoleID(), e);
			response.setCode(Code.UD100);
		}
		return response;
	
	}
}
