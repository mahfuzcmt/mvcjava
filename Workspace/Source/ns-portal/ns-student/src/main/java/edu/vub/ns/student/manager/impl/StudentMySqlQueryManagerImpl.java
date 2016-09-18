package edu.vub.ns.student.manager.impl;


import edu.vub.ns.course.util.CourseTable;
import edu.vub.ns.student.manager.StudentQueryManager;
import edu.vub.ns.student.util.StudentTable;
import edu.vub.ns.webcore.manager.impl.MySqlQueryManagerImpl;
import edu.vub.ns.webcore.util.Constant;

public class StudentMySqlQueryManagerImpl extends MySqlQueryManagerImpl implements StudentQueryManager, Constant {

	@Override
	public String saveStudent() {
		String sql = "Insert into "+StudentTable.STUDENT+"(oid, batch, name, gender, mobileNo, email, image, program, shift, createdBy, createdOn) "
				+ " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return sql;
	}
	
	@Override
	public String getCourseByShift() {
		String sql = "Select * from "+CourseTable.COURSE+" where shift = ? ";
		return sql;
	}

	@Override
	public String saveCourseMapping() {
		String sql = "Insert into "+CourseTable.COURSE_MAPPING+"(oid, studentID, courseID, status, shift, createdBy, createdOn) "
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		return sql;
	}

	
}





