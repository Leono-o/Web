package com.hotmail.ch.leon.familymedia.mvc.bean;

public class ResponseBean {
	/** status */
	private String status = "";
	
	/** statusText */
	private String statusText = "";
	
	/** responseText */
	private String responseText = "";
	
	/** data */
	private Object data = "";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
