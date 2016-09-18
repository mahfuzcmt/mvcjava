package edu.vub.ns.security.manager.impl;


import com.google.common.base.Strings;

import edu.vub.ns.security.manager.SecurityQueryManager;
import edu.vub.ns.security.util.SecurityConstant;
import edu.vub.ns.security.util.SecurityTable;
import edu.vub.ns.webcore.manager.impl.MySqlQueryManagerImpl;
import edu.vub.ns.webcore.util.Table;

public class SecurityMySqlQueryManagerImpl extends MySqlQueryManagerImpl implements SecurityQueryManager, SecurityConstant {
	
	@Override
	public String getLoginSql(String loginID) {
		String sql = "SELECT l.loginID, l.password, l.roleID, l.status, l.imagePath, l.name, l.phoneno,"
				+ " l.FEATUREJSON as menuJSON,";
				if(!Strings.isNullOrEmpty(loginID) && loginID.contains("tcr")){
					sql = sql + " t.oid as courseTeacher, ";
				}
				sql = sql + " r.ROLEDESCRIPTION as roleDescription "
				+ " FROM "+SecurityTable.LOGIN+" l "
				+ " INNER JOIN "+SecurityTable.ROLE+" r "
				+ " on r.ROLEID = l.ROLEID";
				if(!Strings.isNullOrEmpty(loginID) && loginID.contains(TCR)){
					sql = sql  + " INNER JOIN "+SecurityTable.TEACHER+" t "
							+ " on t.loginID = l.loginID";
				};
				sql = sql+ " WHERE l.loginID = '"+loginID+"' ";
		return sql;
	}

	@Override
	public String insertLoginSql() {
		String sql = "insert into "+SecurityTable.LOGIN+"(loginID, phoneNo, email, roleID, featureJSON, password, status, name, imagePath, createdBy, createdOn) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return sql;
	}

	@Override
	public String insertLoginLog() {
		String sql = "insert into "+SecurityTable.LOGIN_LOG+"(oid, loginID, roleID, ipAddress, loginTime, logoutTime, loginStatus) " +
				"values(?, ?, ?, ?, ?, ?, ?)";
		return sql;
	}

	@Override
	public String updateLoginLog() {
		String sql = "update "+SecurityTable.LOGIN_LOG+" set logoutTime = ?, LOGINDURATION = ? where oid = ?";
		return sql;
	}

	@Override
	public String updateLoginPasswordSql() {
		String sql = "update "+SecurityTable.LOGIN+" set password = ?, editedOn = ?, editedBy = ? where loginID = ?";
		return sql;
	}

	@Override
	public String getAllLoginSql() {
		String sql = "SELECT l.loginID, l.imagePath, l.roleID, l.name, l.status, r.roleDescription, r.menuJSON "
				+ "FROM "+SecurityTable.LOGIN+" l, "+SecurityTable.ROLE+" r WHERE l.roleID = r.roleID order by l.createdOn desc";
		return sql;
	}

	@Override
	public String getAllRoleSql() {
		String sql = "SELECT r.roleID, r.roleDescription, r.featureJSON FROM "+SecurityTable.ROLE+" r ";
		return sql;
	}

	@Override
	public String updateLoginSql() {
		String sql = "update "+SecurityTable.LOGIN+" set roleID = ?, status = ?, name = ?, "
				+ "imagePath = ?, editedBy = ?, editedOn = ? where loginID = ?";
		return sql;
	}

	@Override
	public String getOldPassword(String loginID) {
		String sql = "SELECT password FROM login WHERE loginid = '"+loginID+"'";
		return sql;
	}

	@Override
	public String changePassword() {
		String sql = "update "+SecurityTable.LOGIN+" set password = ? , updatedOn = ? , updatedby = ? where loginid = ? ";
		return sql;
	}

	@Override
	public String getMenuJsonTemplateFromMetaProperty() {
		String sql = "select * from "+SecurityTable.META_PROPERTY+" where OID = ? ";
		return sql;
	}
	
	@Override
	public String saveRole() {
		String sql = "insert into "+SecurityTable.ROLE+"(roleID, roleDescription, featureJSON, createdBy, createdOn) values(?, ?, ?, ?, ?)";
		return sql;
	}

	@Override
	public String getRole(String roleID) {
		String sql = "Select roleID from "+SecurityTable.ROLE+" where UPPER(roleID)  = '"+roleID+"' ";
		return sql;
	}

	@Override
	public String getLoginID(String loginID) {
		String sql = "Select loginID from "+SecurityTable.LOGIN+" where UPPER(loginID)  = '"+loginID+"' ";
		return sql;
	}

	@Override
	public String getAllUsers() {
		return "SELECT l.loginID, l.imagePath, l.roleID, l.name, l.status, l.phoneNo, l.email, r.roleDescription, r.featureJSON "
				+ "FROM "+SecurityTable.LOGIN+" l, "+SecurityTable.ROLE+" r WHERE l.roleID = r.roleID order by l.createdOn desc";
	}

	@Override
	public String getUserByLoginID() {
		return "SELECT l.loginID, l.featureJSON, l.imagePath, l.roleID, l.name, l.status, l.phoneNo, l.email, r.roleDescription "
				+ "FROM "+SecurityTable.LOGIN+" l, "+SecurityTable.ROLE+" r WHERE l.roleID = r.roleID and l.loginID = ? ";
	}
	
	@Override
	public String updateUser(String name, String phoneNo, String email, String roleID, String status, String imagePath) {
		return "update "+Table.LOGIN+"  set name = '"+name+"', phoneNo = '"+phoneNo+"', email = '"+email+"',"
				+ " roleID = '"+roleID+"', status = '"+status+"', featureJSON = ? , UPDATEDBY = ?, UPDATEDON = ?, imagePath = '"+imagePath+"'  where loginID = ? ";
	}

	@Override
	public String getRoleByRoleID() {
		String sql = "SELECT r.roleID,  r.roleDescription, r.featureJSON FROM "+SecurityTable.ROLE+" r where roleID = ?";
		return sql;
	}

	@Override
	public String updateRole(String roleID) {
		String sql = "Update "+SecurityTable.ROLE+" set roleID = ?, roleDescription = ?, featureJSON = ?, updatedon = ?, updatedBy = ? where roleID = '"+roleID+"' ";
		return sql;
	}

	@Override
	public String deleteRole() {
		String sql = "Delete from "+SecurityTable.ROLE+" where roleID = ? ";
		return sql;
	}

	@Override
	public String insertIntoTeacher() {
		String sql = "insert into "+SecurityTable.TEACHER+"(oid, loginID, name, gender, mobileNo, email, image, designation, createdBy, createdOn) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return sql;
	}
	
}





