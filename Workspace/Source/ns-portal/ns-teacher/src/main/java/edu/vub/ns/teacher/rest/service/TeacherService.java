/**
 * <p>This class has been created for  Notification System .</p>
 * 
 * @author Mahfuz Ahmed
 * @version 1.0
 * @since   22-08-2016
 * @Mobile +8801975585960
 */
package edu.vub.ns.teacher.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import edu.vub.ns.teacher.bean.TeacherBean;
import edu.vub.ns.teacher.manager.TeacherManager;
import edu.vub.ns.teacher.util.TeacherConstant;
import edu.vub.ns.webcore.bean.ResponseBean;


@Component
@Path("/teacher")
public class TeacherService implements TeacherConstant {
	
	private TeacherManager teacherManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(TeacherBean model) {
		ResponseBean response = new ResponseBean();
		System.out.println("Hello I'm from Teacher");
		return response;
	}

	public void setTeacherManager(TeacherManager teacherManager) {
		this.teacherManager = teacherManager;
	}
	
}

