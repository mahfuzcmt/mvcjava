package edu.vub.ns.security.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.vub.ns.security.bean.LoginBean;
import edu.vub.ns.security.manager.LoginManager;
import edu.vub.ns.security.util.SecurityConstant;
import edu.vub.ns.webcore.bean.ResponseBean;

@Component
@Path("/security")
public class LoginService implements SecurityConstant {
	
	private static Logger log = LoggerFactory.getLogger(LoginService.class);
	private LoginManager loginManager;
	
	@POST
	@Path("/useraccess")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(LoginBean model, @Context HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		
		ResponseBean response = new ResponseBean();
		
		if(model.getOperation().equalsIgnoreCase(LOGIN)){
			response = loginManager.doLogin(response, model, ipAddress);
		} 
		else if(model.getOperation().equalsIgnoreCase(LOGOUT)){
			response = loginManager.doLogout(response, model);
		}
		
		return response;
	}
	
	@POST
	@Path("/changePassword")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean changePassword(LoginBean model, @Context HttpServletRequest request) {
		log.info(INITIAL_MESSAGE_IN_SERVICE);
		ResponseBean response = new ResponseBean();
		response = loginManager.changePassword(response, model);
		log.info(FINAL_MESSAGE_IN_SERVICE);
		return response;
	}
	
	
	// Setter
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
	
}


