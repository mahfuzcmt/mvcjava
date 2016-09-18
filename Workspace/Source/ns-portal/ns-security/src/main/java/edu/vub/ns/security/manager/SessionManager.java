package edu.vub.ns.security.manager;


import edu.vub.ns.security.bean.LoginBean;
import edu.vub.ns.webcore.manager.Manager;

public interface SessionManager extends Manager {
	
	public void setUserInSession(LoginBean model);
	
	public LoginBean getUserInSession(LoginBean model);

	public void clearSession(LoginBean model);
	
	public boolean isValid(LoginBean model);

}
