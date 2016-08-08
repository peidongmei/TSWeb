package com.igeek11.bishe.bean;

import java.io.Serializable;

public class Subject implements Serializable{//ÉùÃ÷ĞòÁĞ»¯
private int subno;
private String subname;
private String subdetail;
public Subject() {
	// TODO Auto-generated constructor stub
}
public int getSubno() {
	return subno;
}
public void setSubno(int subno) {
	this.subno = subno;
}
public String getSubname() {
	return subname;
}
public void setSubname(String subname) {
	this.subname = subname;
}
public String getSubdetail() {
	return subdetail;
}
public void setSubdetail(String subdetail) {
	this.subdetail = subdetail;
}



}
