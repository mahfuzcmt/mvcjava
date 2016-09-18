package edu.vub.ns.student.manager.impl;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import edu.vub.ns.course.bean.CourseBean;
import edu.vub.ns.student.bean.StudentBean;
import edu.vub.ns.student.manager.StudentManager;
import edu.vub.ns.student.manager.StudentQueryManager;
import edu.vub.ns.student.util.StudentConstant;
import edu.vub.ns.webcore.bean.Code;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.impl.ManagerImpl;
import edu.vub.ns.webcore.util.ParamUtil;

public class StudentManagerImpl extends ManagerImpl implements StudentManager, StudentConstant {
	
	protected StudentQueryManager studentQueryManager;
	private static Logger log = LoggerFactory.getLogger(StudentManagerImpl.class);
	
	public void setStudentQueryManager(StudentQueryManager studentQueryManager) {
		this.studentQueryManager = studentQueryManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseBean saveStudent(ResponseBean response, StudentBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" saving student");
		TransactionDefinition transDef = new DefaultTransactionDefinition();
		TransactionStatus transStatus = springJdbcDao.getTransactionManager().getTransaction(transDef);
		  
		  
		try {
			Object[] param = ParamUtil.getParamsWithoutObject(model.getOid(), model.getBatch(), model.getName(), model.getGender(), 
					model.getMobileNo(), model.getEmail(),model.getImage(), model.getProgram(), model.getShift(), model.getLoginBean().getLoginID(),
					new Date());
			springJdbcDao.saveObject(studentQueryManager.saveStudent(), param);
			
			List<CourseBean> dataList = springJdbcDao.getObjectList(studentQueryManager.getCourseByShift(), new Object []{model.getShift()}, CourseBean.class);
			
			for(CourseBean childBean : dataList){
				Object[] courseMappingParam = ParamUtil.getParamsWithoutObject(idGenerator.generateId(),model.getOid(), childBean.getOid(), "remaining",
						model.getShift(), model.getLoginBean().getLoginID(), new Date());
				springJdbcDao.saveObject(studentQueryManager.saveCourseMapping(), courseMappingParam);
			}
			
			response.setSuccess(true);
			springJdbcDao.getTransactionManager().commit(transStatus);
			response.setCode(Code.Sc1000);
			log.info("Successfully Saved Student ");
			return response;
		
		} catch (Exception e){			
				response.setCode(Code.Us1000);
				log.error("An Exception occured while trying to save Student : ", e);
				springJdbcDao.getTransactionManager().rollback(transStatus);
				return response;
		}
	}

	


}