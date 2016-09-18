package edu.vub.ns.webcore.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseBean implements Serializable {
	
	private boolean success;
	private Code code;
	private Object data;
	
	public ResponseBean() {
		this.success = false;
		this.data = null;
	}
	
	public ResponseBean(boolean isSuccess, Object data, Code code) {
		this.success = isSuccess;
		this.data = data;
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
		if(data != null){
			this.setSuccess(true);
		}
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}
	
	

}
