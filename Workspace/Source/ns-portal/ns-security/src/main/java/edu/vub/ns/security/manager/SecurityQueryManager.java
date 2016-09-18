package edu.vub.ns.security.manager;

import edu.vub.ns.webcore.manager.QueryManager;

public interface SecurityQueryManager extends QueryManager {
	
	public String getLoginSql(String loginID);
	
	public String insertLoginSql();
	
	public String insertLoginLog();
	
	public String updateLoginLog();
	
	//public String getLoginByLoginIDSql();

	public String getAllLoginSql();

	public String updateLoginPasswordSql();
	
	public String getAllRoleSql();

	public String updateLoginSql();

	public String getOldPassword(String loginID);

	public String changePassword();

	public String getMenuJsonTemplateFromMetaProperty();

	public String saveRole();

	public String getRole(String roleID);

	public String getLoginID(String loginID);

	public String getAllUsers();

	public String getUserByLoginID();

	public String getRoleByRoleID();

	public String updateRole(String roleID);

	public String deleteRole();

	public String updateUser(String name, String phoneNo, String email, String roleID, String status, String imagePath);

	public String insertIntoTeacher();

	
}



