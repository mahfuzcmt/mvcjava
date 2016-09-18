package edu.vub.ns.routine.manager.impl;


import edu.vub.ns.routine.manager.RoutineManager;
import edu.vub.ns.routine.manager.RoutineQueryManager;
import edu.vub.ns.routine.util.RoutineConstant;
import edu.vub.ns.webcore.manager.impl.ManagerImpl;

public class RoutineManagerImpl extends ManagerImpl implements RoutineManager, RoutineConstant {
	
	protected RoutineQueryManager routineQueryManager;

	public void setRoutineQueryManager(RoutineQueryManager routineQueryManager) {
		this.routineQueryManager = routineQueryManager;
	}



}