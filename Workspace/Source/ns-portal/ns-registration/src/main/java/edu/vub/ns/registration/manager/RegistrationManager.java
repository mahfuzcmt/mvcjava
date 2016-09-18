package edu.vub.ns.registration.manager;

import edu.vub.ns.registration.bean.RegistrationBean;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.Manager;

public interface RegistrationManager extends Manager {

	public ResponseBean getStudentInfoFromCourseMapping(ResponseBean response, RegistrationBean model);

	public ResponseBean doRegistration(ResponseBean response, RegistrationBean model);
	
}
