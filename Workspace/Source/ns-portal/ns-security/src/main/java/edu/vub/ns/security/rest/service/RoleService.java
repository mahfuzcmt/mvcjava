package edu.vub.ns.security.rest.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import edu.vub.ns.security.bean.RoleBean;
import edu.vub.ns.security.manager.RoleManager;
import edu.vub.ns.security.util.SecurityConstant;
import edu.vub.ns.webcore.bean.ResponseBean;

@Component
@Path("/role")
public class RoleService implements SecurityConstant {
	
	
	private RoleManager roleManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(RoleBean model) {
		ResponseBean response = new ResponseBean();
		
		if(model.getOperation().equalsIgnoreCase(GET_ALL_ROLE)){
			response = roleManager.getAllRole(response, model);
		}
		if(model.getOperation().equalsIgnoreCase(GET_MENU_JSON_TEMPLATE)){
			response = roleManager.getMenuJsonTemplateFromMetaProperty(response, model);
		}
		if(model.getOperation().equalsIgnoreCase(SAVE)){
			response = roleManager.saveRole(response, model);
		}
		if(model.getOperation().equalsIgnoreCase(GET_ROLE_BY_ROLEID)){
			response = roleManager.getRoleByRoleID(response, model);
		}
		if(model.getOperation().equalsIgnoreCase(UPDATE)){
			response = roleManager.updateRole(response, model);
		}
		if(model.getOperation().equalsIgnoreCase(DELETE)){
			response = roleManager.deleteRole(response, model);
		}
		return response;
	}
	
	// Setter
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

    

	
}


