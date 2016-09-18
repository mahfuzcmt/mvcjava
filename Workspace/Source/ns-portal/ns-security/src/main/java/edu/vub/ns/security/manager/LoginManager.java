package edu.vub.ns.security.manager;

import edu.vub.ns.security.bean.LoginBean;
import edu.vub.ns.webcore.bean.ResponseBean;
import edu.vub.ns.webcore.manager.Manager;

public interface LoginManager extends Manager {
	
	//public ResponseBean doLogin(HttpServletRequest request, ResponseBean response, LoginBean model);
	
	public ResponseBean doLogin(ResponseBean response, LoginBean model, String ipAddress);
	
	public ResponseBean doLogout( ResponseBean resBean, LoginBean model);

	public ResponseBean changePassword(ResponseBean response, LoginBean model);



}
