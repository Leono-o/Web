package com.hotmail.ch.leon.familymedia.dao.dto;

import java.math.BigDecimal;

public class FileDTO {

	private BigDecimal id = null;
	private BigDecimal folderl = null;
	private String url = "";
	private String name = "";
	private String ftype = "";
	private BigDecimal fsize = null;
	private String cmt = "";

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getFolder() {
		return folderl;
	}

	public void setFolderBigDecimal(BigDecimal folderl) {
		this.folderl = folderl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public BigDecimal getFsize() {
		return fsize;
	}

	public void setFsize(BigDecimal fsize) {
		this.fsize = fsize;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

}
