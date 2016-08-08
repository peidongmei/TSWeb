package com.igeek11.bishe.bean;

import java.io.Serializable;

public class Student implements Serializable{//ÉùÃ÷ĞòÁĞ»¯
	private int seq_stuno;
	private int stuno;
	private String stunickname;
	private String stupwd;
	private String stuname;
	private String stusex;
	private String stuinsti;
	private int stupermlevel;
	private String stumail;
public Student() {
	// TODO Auto-generated constructor stub
}

public int getSeq_stuno() {
	return seq_stuno;
}

public void setSeq_stuno(int seq_stuno) {
	this.seq_stuno = seq_stuno;
}

public int getStuno() {
	return stuno;
}

public void setStuno(int stuno) {
	this.stuno = stuno;
}

public String getStunickname() {
	return stunickname;
}

public void setStunickname(String stunickname) {
	this.stunickname = stunickname;
}

public String getStupwd() {
	return stupwd;
}

public void setStupwd(String stupwd) {
	this.stupwd = stupwd;
}

public String getStuname() {
	return stuname;
}

public void setStuname(String stuname) {
	this.stuname = stuname;
}

public String getStusex() {
	return stusex;
}

public void setStusex(String stusex) {
	this.stusex = stusex;
}

public String getStuinsti() {
	return stuinsti;
}

public void setStuinsti(String stuinsti) {
	this.stuinsti = stuinsti;
}

public int getStuPermLevel() {
	return stupermlevel;
}

public void setStuPermLevel(int stuPermLevel) {
	this.stupermlevel = stuPermLevel;
}

public String getStumail() {
	return stumail;
}

public void setStumail(String stumail) {
	this.stumail = stumail;
}

	
	
}
