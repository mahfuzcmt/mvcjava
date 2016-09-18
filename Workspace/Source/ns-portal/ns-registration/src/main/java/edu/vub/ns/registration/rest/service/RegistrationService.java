/**
 * <p>This class has been created for  Notification System .</p>
 * 
 * @author Mahfuz Ahmed
 * @version 1.0
 * @since   22-08-2016
 * @Mobile +8801975585960
 */

package edu.vub.ns.registration.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import edu.vub.ns.registration.bean.RegistrationBean;
import edu.vub.ns.registration.manager.RegistrationManager;
import edu.vub.ns.registration.util.RegistrationConstant;
import edu.vub.ns.webcore.bean.ResponseBean;


@Component
@Path("/registration")
public class RegistrationService implements RegistrationConstant {
	
	private RegistrationManager registrationManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(RegistrationBean model) {
		ResponseBean response = new ResponseBean();
		 if(model.getOperation().equalsIgnoreCase(GET_ALL)){
			response = registrationManager.getStudentInfoFromCourseMapping(response, model);
		} 
		else if(model.getOperation().equalsIgnoreCase(DO_REGISTRATION)){
			response = registrationManager.doRegistration(response, model);
		}
		return response;
	}

	public void setRegistrationManager(RegistrationManager registrationManager) {
		this.registrationManager = registrationManager;
	}

	
}

