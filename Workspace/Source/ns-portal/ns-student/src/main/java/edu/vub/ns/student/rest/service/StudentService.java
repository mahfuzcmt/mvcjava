/**
 * <p>This class has been created for  Notification System .</p>
 * 
 * @author Mahfuz Ahmed
 * @version 1.0
 * @since   22-08-2016
 * @Mobile +8801975585960
 */

package edu.vub.ns.student.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import edu.vub.ns.student.bean.StudentBean;
import edu.vub.ns.student.manager.StudentManager;
import edu.vub.ns.student.util.StudentConstant;
import edu.vub.ns.webcore.bean.ResponseBean;


@Component
@Path("/student")
public class StudentService implements StudentConstant {
	
	private StudentManager studentManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(StudentBean model) {
		ResponseBean response = new ResponseBean();
		if(model.getOperation().equalsIgnoreCase(SAVE)){
			response = studentManager.saveStudent(response, model);
		}
		return response;
	}

	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	
	
}

