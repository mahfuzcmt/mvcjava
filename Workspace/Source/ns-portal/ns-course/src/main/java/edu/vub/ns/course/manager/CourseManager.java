package edu.vub.ns.course.manager;

import edu.vub.ns.course.bean.CourseBean;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.Manager;

public interface CourseManager extends Manager {

	ResponseBean getCourseByCourseTeacher(ResponseBean response, CourseBean model);
	
}
