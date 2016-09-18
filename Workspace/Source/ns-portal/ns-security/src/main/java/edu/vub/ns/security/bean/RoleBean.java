package edu.vub.ns.security.bean;

import edu.vub.ns.webcore.bean.AbstractBean;

@SuppressWarnings("serial")
public class RoleBean extends AbstractBean {
	
	private String roleID;
	private String roleDescription;
	private String menuJSON;
	private String valueJson; 
	private LoginBean loginBean;
	private String featureJSON;
	private String roleType;
	
	
	public RoleBean() {}
	
	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getMenuJSON() {
		return menuJSON;
	}

	public void setMenuJSON(String menuJSON) {
		this.menuJSON = menuJSON;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getValueJson() {
		return valueJson;
	}

	public void setValueJson(String valueJson) {
		this.valueJson = valueJson;
	}

	public String getFeatureJSON() {
		return featureJSON;
	}

	public void setFeatureJSON(String featureJSON) {
		this.featureJSON = featureJSON;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@Override
	public String getOperation() {
		return operation;
	}

	@Override
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String getOid() {
		return oid;
	}

	@Override
	public void setOid(String oid) {
		this.oid = oid;
	}

	

}
