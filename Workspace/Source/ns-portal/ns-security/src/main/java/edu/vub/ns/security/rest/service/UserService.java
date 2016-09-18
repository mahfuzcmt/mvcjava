package edu.vub.ns.security.rest.service;


import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import edu.vub.ns.security.bean.UserBean;
import edu.vub.ns.security.manager.UserManager;
import edu.vub.ns.security.util.SecurityConstant;
import edu.vub.ns.webcore.bean.ResponseBean;


@Component
@Path("/user")
public class UserService implements SecurityConstant {
	
	
	private UserManager userManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(UserBean model) {
		ResponseBean response = new ResponseBean();
		 if(model.getOperation().equalsIgnoreCase(UPDATE)){
			response = userManager.updateUser(response, model);
		} 
		 if(model.getOperation().equalsIgnoreCase(SAVE)){
				response = userManager.saveUser(response, model);
		}
		if(model.getOperation().equalsIgnoreCase(GET_ALL_USERS)){
				response = userManager.getAllUsers(response, model);
		}
		if(model.getOperation().equalsIgnoreCase(GET_USER_BY_LOGINID)){
			response = userManager.getUserByLoginID(response, model);
		}
		
		return response;
	}
	
	// Setter

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	
}


