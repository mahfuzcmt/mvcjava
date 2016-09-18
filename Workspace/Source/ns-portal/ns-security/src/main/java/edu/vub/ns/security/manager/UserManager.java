package edu.vub.ns.security.manager;


import edu.vub.ns.security.bean.UserBean;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.Manager;

public interface UserManager extends Manager {
	
	public ResponseBean updateUser(ResponseBean response, UserBean model);

	public ResponseBean saveUser(ResponseBean response, UserBean model);

	public ResponseBean getAllUsers(ResponseBean response, UserBean model);

	public ResponseBean getUserByLoginID(ResponseBean response, UserBean model);

}
