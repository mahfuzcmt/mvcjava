/**
 * <p>This class has been created for  Notification System .</p>
 * 
 * @author Mahfuz Ahmed
 * @version 1.0
 * @since   22-08-2016
 * @Mobile +8801975585960
 */

package edu.vub.ns.routine.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import edu.vub.ns.routine.bean.RoutineBean;
import edu.vub.ns.routine.manager.RoutineManager;
import edu.vub.ns.routine.util.RoutineConstant;
import edu.vub.ns.webcore.bean.ResponseBean;


@Component
@Path("/routine")
public class RoutineService implements RoutineConstant {
	
	private RoutineManager routineManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(RoutineBean model) {
		ResponseBean response = new ResponseBean();
		System.out.println("Hello I'm from Routine");
		return response;
	}

	public void setRoutineManager(RoutineManager routineManager) {
		this.routineManager = routineManager;
	}

	
	
}

