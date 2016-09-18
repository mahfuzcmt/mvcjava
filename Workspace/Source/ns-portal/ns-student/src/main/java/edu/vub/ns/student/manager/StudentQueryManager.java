package edu.vub.ns.student.manager;

import edu.vub.ns.webcore.manager.QueryManager;

public interface StudentQueryManager extends QueryManager {

	public String saveStudent();
	
	public String getCourseByShift();

	public String saveCourseMapping();
}



