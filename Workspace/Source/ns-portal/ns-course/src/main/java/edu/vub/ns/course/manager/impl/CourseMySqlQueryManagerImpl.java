package edu.vub.ns.course.manager.impl;


import edu.vub.ns.course.manager.CourseQueryManager;
import edu.vub.ns.course.util.CourseTable;
import edu.vub.ns.webcore.manager.impl.MySqlQueryManagerImpl;
import edu.vub.ns.webcore.util.Constant;

public class CourseMySqlQueryManagerImpl extends MySqlQueryManagerImpl implements CourseQueryManager, Constant {
	
	
	
	@Override
	public String getCourseByCourseTeacher() {
		String sql = "Select * from "+CourseTable.COURSE+" where courseTeacher = ? ";
		return sql;
	}
	
}





