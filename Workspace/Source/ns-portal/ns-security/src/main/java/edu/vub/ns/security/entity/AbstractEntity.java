package edu.vub.ns.security.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractEntity implements Serializable {
	
	
	protected String oid;

	abstract public String getOid();
	
	abstract public void setOid(String oid);


}
