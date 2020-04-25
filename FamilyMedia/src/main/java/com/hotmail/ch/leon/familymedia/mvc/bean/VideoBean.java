package com.hotmail.ch.leon.familymedia.bean;

public class VideoBean {
	/** 文件ID */
	private String id = "";
	
	/** 文件名 */
	private String fname = "";
	
	/** 文件后缀 */
	private String ftype = "";

	/** 注释 */
	private String cmt = "";

	/** 文件大小 */
	private long size = 0;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
}
