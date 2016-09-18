package edu.vub.ns.security.manager;



import edu.vub.ns.security.bean.RoleBean;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.Manager;



public interface RoleManager extends Manager {
	
	
	public ResponseBean getAllRole(ResponseBean response, RoleBean model);

	public ResponseBean getMenuJsonTemplateFromMetaProperty(ResponseBean response, RoleBean model);

	public ResponseBean saveRole(ResponseBean response, RoleBean model);

	public ResponseBean getRoleByRoleID(ResponseBean response, RoleBean model);

	public ResponseBean updateRole(ResponseBean response, RoleBean model);

	public ResponseBean deleteRole(ResponseBean response, RoleBean model);


}
