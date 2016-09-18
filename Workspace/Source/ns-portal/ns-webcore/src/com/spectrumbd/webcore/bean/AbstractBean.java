package com.spectrumbd.webcore.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractBean implements Serializable {

	protected String UTIL_DATE_FORMAT = "dd/MM/yyyy";
	protected String operation;
	protected String oid;	
	
	abstract public String getOperation();
	abstract public void setOperation(String operation);
	
	abstract public String getOid();
	abstract public void setOid(String oid);
	
	
	
	
	

	
}
