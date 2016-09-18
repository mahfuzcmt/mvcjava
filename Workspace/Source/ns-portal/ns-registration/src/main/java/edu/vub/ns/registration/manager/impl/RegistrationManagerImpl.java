package edu.vub.ns.registration.manager.impl;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.vub.ns.registration.bean.RegistrationBean;
import edu.vub.ns.registration.manager.RegistrationManager;
import edu.vub.ns.registration.manager.RegistrationQueryManager;
import edu.vub.ns.registration.util.RegistrationConstant;
import edu.vub.ns.webcore.bean.Code;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.impl.ManagerImpl;
import edu.vub.ns.webcore.util.ParamUtil;

public class RegistrationManagerImpl extends ManagerImpl implements RegistrationManager, RegistrationConstant {
	
	protected RegistrationQueryManager registrationQueryManager;
	private static Logger log = LoggerFactory.getLogger(RegistrationQueryManager.class);

	public void setRegistrationQueryManager(RegistrationQueryManager registrationQueryManager) {
		this.registrationQueryManager = registrationQueryManager;
	}

	@Override
	public ResponseBean getStudentInfoFromCourseMapping(ResponseBean response, RegistrationBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" getting course mapping list by student ID");
		try {
			@SuppressWarnings("unchecked")
			List<RegistrationBean> dataList = springJdbcDao.getObjectList(registrationQueryManager.getStudentInfoFromCourseMapping(model.getStudentID()),
					null, RegistrationBean.class);
			
			if(dataList != null && !dataList.isEmpty()){
				response.setData(dataList);
				response.setSuccess(true);
				log.info("Successfully loaded course mapping list ");
				return response;
			}
			log.info("No data found ");
			response.setCode(Code.Nd1000);
		} catch (Exception e){			
			log.error("An Exception occured while getting course mapping list : ", e);
			response.setCode(Code.Un1003);
		}
		return response;
	}

	@Override
	public ResponseBean doRegistration(ResponseBean response, RegistrationBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" register student for student id: "+model.getStudentID()+" and course code: "+ model.getCourseID());
		  
		try {
			Object[] param = ParamUtil.getParamsWithoutObject(idGenerator.generateId(), model.getStudentID(), model.getCourseID(),model.getShift(),
					RegistrationConstant.REGISTERED, model.getSessionYear(), model.getBatch(), model.getMobileNo(), model.getEmail(),
					model.getLoginBean().getLoginID(), new Date());
			springJdbcDao.saveObject(registrationQueryManager.doRegistration(), param);
			
			Object[] courseMappingParam = ParamUtil.getParamsWithoutObject(RegistrationConstant.REGISTERED,
					model.getLoginBean().getLoginID(), new Date(), model.getCourseMappingID());
			springJdbcDao.saveObject(registrationQueryManager.updateCourseMapping(), courseMappingParam);
			
			response.setSuccess(true);
			response.setCode(Code.SR1000);
			log.info("Successfully registered course for student id: "+model.getStudentID()+" and course code: "+ model.getCourseID());
			return response;
		
		} catch (Exception e){			
				response.setCode(Code.UR1000);
				log.error("An Exception occured while trying to register course for student id: "+model.getStudentID()+" and course code: "+ model.getCourseID(), e);
				return response;
		}
	}



}