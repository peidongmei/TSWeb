package com.igeek11.bishe.bean;

import java.io.Serializable;
import java.sql.Date;
public class Teacher implements Serializable{
private int teachno;
private String teachnickname;
private String teachpwd;
private String teachname;
private int teachsex;
private Date teachbirth;
private String terminaldegree;
private String teachresume;
private String resdirection;
private String teachtitle;//职称
private String teachtreatise;//论著
private String teachprize;//获奖
private String teachmail;
private String teachphurl;
private int teachpermlevel;//权限级别
private int teachsubjectnum;//所属学科号
public Teacher() {

}
public int getTeachsubjectnum() {
	return teachsubjectnum;
}
public void setTeachsubjectnum(int teachsubjectnum) {
	this.teachsubjectnum = teachsubjectnum;
}

public int getTeachno() {
	return teachno;
}
public void setTeachno(int teachno) {
	this.teachno = teachno;
}
public String getTeachnickname() {
	return teachnickname;
}
public void setTeachnickname(String teachnickname) {
	this.teachnickname = teachnickname;
}
public String getTeachpwd() {
	return teachpwd;
}
public void setTeachpwd(String teachpwd) {
	this.teachpwd = teachpwd;
}
public String getTeachname() {
	return teachname;
}
public void setTeachname(String teachname) {
	this.teachname = teachname;
}
public int getTeachsex() {
	return teachsex;
}
public void setTeachsex(int teachsex) {
	this.teachsex = teachsex;
}
public Date getTeachbirth() {
	return teachbirth;
}
public void setTeachbirth(Date teachbirth) {
	this.teachbirth = teachbirth;
}
public String getTerminaldegree() {
	return terminaldegree;
}
public void setTerminaldegree(String terminaldegree) {
	this.terminaldegree = terminaldegree;
}
public String getTeachresume() {
	return teachresume;
}
public void setTeachresume(String teachresume) {
	this.teachresume = teachresume;
}
public String getResdirection() {
	return resdirection;
}
public void setResdirection(String resdirection) {
	this.resdirection = resdirection;
}
public String getTeachtitle() {
	return teachtitle;
}
public void setTeachtitle(String teachtitle) {
	this.teachtitle = teachtitle;
}
public String getTeachtreatise() {
	return teachtreatise;
}
public void setTeachtreatise(String teachtreatise) {
	this.teachtreatise = teachtreatise;
}
public String getTeachprize() {
	return teachprize;
}
public void setTeachprize(String teachprize) {
	this.teachprize = teachprize;
}
public String getTeachmail() {
	return teachmail;
}
public void setTeachmail(String teachmail) {
	this.teachmail = teachmail;
}
public String getTeachphurl() {
	return teachphurl;
}
public void setTeachphurl(String teachphurl) {
	this.teachphurl = teachphurl;
}
public int getTeachpermlevel() {
	return teachpermlevel;
}
public void setTeachpermlevel(int teachpermlevel2) {
	this.teachpermlevel = teachpermlevel2;
}



}
