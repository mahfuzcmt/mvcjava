package edu.vub.ns.teacher.manager.impl;


import edu.vub.ns.teacher.manager.TeacherManager;
import edu.vub.ns.teacher.manager.TeacherQueryManager;
import edu.vub.ns.teacher.util.TeacherConstant;
import edu.vub.ns.webcore.manager.impl.ManagerImpl;

public class TeacherManagerImpl extends ManagerImpl implements TeacherManager, TeacherConstant {
	
	protected TeacherQueryManager teacherQueryManager;

	public void setTeacherQueryManager(TeacherQueryManager teacherQueryManager) {
		this.teacherQueryManager = teacherQueryManager;
	}



}