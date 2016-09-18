package edu.vub.ns.registration.manager.impl;


import edu.vub.ns.registration.manager.RegistrationQueryManager;
import edu.vub.ns.registration.util.RegistrationConstant;
import edu.vub.ns.registration.util.RegistrationTable;
import edu.vub.ns.webcore.manager.impl.MySqlQueryManagerImpl;
import edu.vub.ns.webcore.util.Constant;

public class RegistrationMySqlQueryManagerImpl extends MySqlQueryManagerImpl implements RegistrationQueryManager, Constant {
	
	@Override
	public String getStudentInfoFromCourseMapping(String studetnID) {
		String sql = "SELECT cm.oid, s.name as studentName, s.email, s.batch, s.mobileNo, s.gender, s.shift, s.program, cm.courseID, cm.sessionYear, "
				+ " (select name from course where oid = cm.courseID ) as courseName, "
				+ " (select credit from "+RegistrationTable.COURSE+" where oid = cm.courseID ) as credit, "
				+ " (select t.name from "+RegistrationTable.TEACHER+" t, "+RegistrationTable.COURSE+" c where  t.oid = c.courseTeacher "
				+ " and c.oid = cm.courseID) as courseTeacher "
				+ " FROM "+RegistrationTable.STUDENT+" s "
				+ " LEFT JOIN "+RegistrationTable.COURSEMAPPING+" cm "
				+ " ON s.oid = cm.studentID "
				+ " where 1=1 "
				+ " and s.oid = '"+studetnID+"' and cm.status = '"+RegistrationConstant.REMAINING+"' "
				+ " ORDER BY cm.createdOn";
		return sql;
	}

	@Override
	public String doRegistration() {
		String sql = "Insert into "+RegistrationTable.REGISTRATION+"(oid, sid, courseID, shift, status, sessionYear, batch, mobileNo, email, createdBy, createdOn) "
				+ " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return sql;
	}

	@Override
	public String updateCourseMapping() {
		String sql = "Update "+RegistrationTable.COURSEMAPPING+" set status = ?, updatedBy = ?, updatedOn = ? where oid = ?";
		return sql;
	}
}





