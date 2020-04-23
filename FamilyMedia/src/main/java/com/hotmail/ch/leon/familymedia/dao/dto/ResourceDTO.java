package com.hotmail.ch.leon.familymedia.dao.dto;

public class ResourceDTO {
private long  id = 0;
private String name  = "";
private String  url ="";
private String owner = "";
private String gname ="";
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}

}
