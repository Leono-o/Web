package com.hotmail.ch.leon.familymedia.dao.dto;

import java.math.BigDecimal;

public class ResourceDTO {
	
private BigDecimal  id = null;
private String name  = "";
private String rtype ="";
private String cmt ="";


public BigDecimal getId() {
	return id;
}
public void setId(BigDecimal id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRtype() {
	return rtype;
}
public void setRtype(String rtype) {
	this.rtype = rtype;
}
public String getCmt() {
	return cmt;
}
public void setCmt(String cmt) {
	this.cmt = cmt;
}

}
