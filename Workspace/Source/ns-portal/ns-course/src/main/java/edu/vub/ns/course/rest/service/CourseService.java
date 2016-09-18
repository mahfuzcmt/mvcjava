/**
 * <p>This class has been created for  Notification System .</p>
 * 
 * @author Mahfuz Ahmed
 * @version 1.0
 * @since   22-08-2016
 * @Mobile +8801975585960
 */


package edu.vub.ns.course.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import edu.vub.ns.course.bean.CourseBean;
import edu.vub.ns.course.manager.CourseManager;
import edu.vub.ns.course.util.CourseConstant;
import edu.vub.ns.webcore.bean.ResponseBean;


@Component
@Path("/course")
public class CourseService implements CourseConstant {
	
	private CourseManager courseManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(CourseBean model) {
		ResponseBean response = new ResponseBean();
		if(model.getOperation().equalsIgnoreCase(GET_BY_COURSE_TEACHER)){
			response = courseManager.getCourseByCourseTeacher(response, model);
		}
		return response;
	}

	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}
	
}

