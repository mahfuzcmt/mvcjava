package edu.vub.ns.routine.bean;

import edu.vub.ns.webcore.bean.AbstractBean;

@SuppressWarnings("serial")
public class RoutineBean extends AbstractBean {
	
	private String loginID;
	private String password;
	private String roleID;
	private String roleDescription;
	private String name;
	private String imagePath;
	private String status;
	private String menuJSON;
	private String sessionId;
	private String phoneno;
	private String orgID;
	private String instanceID;
	private String nodeID;
	private String email;
	private String orgName;
	private String mnememonic;
	private String orgStatus;
	private String description;
	private String roleType;
	private String selectedLeftMenu;
	private String oldPassword;
	private String newPassword;
	private String instanceType;
	
	public RoutineBean() {}
	
	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleDescription() {
		return roleDescription;
	}
	
	public String getOrgID() {
		return orgID;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getMnememonic() {
		return mnememonic;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public void setMnememonic(String mnememonic) {
		this.mnememonic = mnememonic;
	}

	public String getOrgStatus() {
		return orgStatus;
	}

	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	public String getInstanceID() {
		return instanceID;
	}

	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	public String getNodeID() {
		return nodeID;
	}

	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenuJSON() {
		return menuJSON;
	}

	public void setMenuJSON(String menuJSON) {
		this.menuJSON = menuJSON;
	}

	public String getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public String getSelectedLeftMenu() {
		return selectedLeftMenu;
	}

	public void setSelectedLeftMenu(String selectedLeftMenu) {
		this.selectedLeftMenu = selectedLeftMenu;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
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
