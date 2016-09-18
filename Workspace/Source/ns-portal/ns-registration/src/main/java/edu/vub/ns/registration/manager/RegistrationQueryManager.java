package edu.vub.ns.registration.manager;

import edu.vub.ns.webcore.manager.QueryManager;

public interface RegistrationQueryManager extends QueryManager {

	public String getStudentInfoFromCourseMapping(String studetnID);

	public String doRegistration();

	public String updateCourseMapping();
	
	
}



