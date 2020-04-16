package com.hotmail.ch.leon.familymedia.dto;

public class FileInfoDTO {
	String localpath = "";
	
	String dispname = "";

	public FileInfoDTO(String localpath, String dispname) {
		this.localpath=localpath;
		this.dispname=dispname;
	}
	
	public String getLocalpath() {
		return localpath;
	}

	public void setLocalpath(String localpath) {
		this.localpath = localpath;
	}

	public String getDispname() {
		return dispname;
	}

	public void setDispname(String dispname) {
		this.dispname = dispname;
	}
}
