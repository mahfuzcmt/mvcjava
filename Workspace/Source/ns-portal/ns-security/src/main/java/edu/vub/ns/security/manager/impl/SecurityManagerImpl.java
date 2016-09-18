package edu.vub.ns.security.manager.impl;


import edu.vub.ns.security.manager.SecurityManager;
import edu.vub.ns.security.manager.SecurityQueryManager;
import edu.vub.ns.security.manager.SessionManager;
import edu.vub.ns.security.util.SecurityConstant;
import edu.vub.ns.webcore.manager.impl.ManagerImpl;

public class SecurityManagerImpl extends ManagerImpl implements SecurityManager, SecurityConstant {
	
	protected SecurityQueryManager securityQueryManager;
	
	protected SessionManager sessionManager;
	

	public void setSecurityQueryManager(SecurityQueryManager securityQueryManager) {
		this.securityQueryManager = securityQueryManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}


}
