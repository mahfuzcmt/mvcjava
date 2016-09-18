package edu.vub.ns.student.manager;

import edu.vub.ns.student.bean.StudentBean;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.Manager;

public interface StudentManager extends Manager {

	public ResponseBean saveStudent(ResponseBean response, StudentBean model);
	
}
