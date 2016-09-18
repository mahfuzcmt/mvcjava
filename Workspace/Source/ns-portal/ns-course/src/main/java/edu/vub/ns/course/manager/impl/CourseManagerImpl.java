package edu.vub.ns.course.manager.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.vub.ns.course.bean.CourseBean;
import edu.vub.ns.course.manager.CourseManager;
import edu.vub.ns.course.manager.CourseQueryManager;
import edu.vub.ns.course.util.CourseConstant;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.impl.ManagerImpl;

public class CourseManagerImpl extends ManagerImpl implements CourseManager, CourseConstant {
	
	protected CourseQueryManager courseQueryManager;
	private static Logger log = LoggerFactory.getLogger(CourseManagerImpl.class);

	public void setCourseQueryManager(CourseQueryManager courseQueryManager) {
		this.courseQueryManager = courseQueryManager;
	}

	@Override
	public ResponseBean getCourseByCourseTeacher(ResponseBean response, CourseBean model) {
		log.info(A_REQUESR_IS_RECEIVED_FOR+" getting course list by course teacher ID");
		try {
			@SuppressWarnings("unchecked")
			List<CourseBean> dataList = springJdbcDao.getObjectList(courseQueryManager.getCourseByCourseTeacher(), new Object[]{model.getLoginBean().getCourseTeacher()} , CourseBean.class);
			
			if(dataList != null && !dataList.isEmpty()){
				response.setData(dataList);
				response.setSuccess(true);
				log.info("Successfully loaded course list by course teacher ID ");
				return response;
			}
			log.info("No data found ");
		} catch (Exception e){			
			log.error("An Exception occured while getting course list by course teacher ID: ", e);
			//response.setCode(Code.Ul1000);
		}
		return response;
	}
	


}