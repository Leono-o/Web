package com.hotmail.ch.leon.familymedia.dto;

public class FileInfoDTO {
	String localpath = "";
	
	String dispname = "";
	
	String fileType = "";

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public FileInfoDTO(String localpath, String dispname, String fileType) {
		this.localpath=localpath;
		this.dispname=dispname;
		this.fileType =fileType;
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
