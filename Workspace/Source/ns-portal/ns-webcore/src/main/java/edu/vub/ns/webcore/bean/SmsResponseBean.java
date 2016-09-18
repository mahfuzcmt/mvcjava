package edu.vub.ns.webcore.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SmsResponseBean implements Serializable {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
