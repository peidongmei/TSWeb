package com.igeek11.bishe.bean;

import java.io.Serializable;
import java.util.Date;

public class Teachresource implements Serializable{
	//resno,resname,restype,ressubno,resupdate,resteachno
	private int resno;
	private String resname;
	private int restype;
	private int ressubno;
	private Date resupdate;
	private int resteachno;
	private String oldname;
	public Teachresource() {
	}
	
	public String getOldname() {
		return oldname;
	}

	public void setOldname(String oldname) {
		this.oldname = oldname;
	}

	public int getResno() {
		return resno;
	}
	public void setResno(int resno) {
		this.resno = resno;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public int getRestype() {
		return restype;
	}
	public void setRestype(int restype) {
		this.restype = restype;
	}
	public int getRessubno() {
		return ressubno;
	}
	public void setRessubno(int ressubno) {
		this.ressubno = ressubno;
	}
	public Date getResupdate() {
		return resupdate;
	}
	public void setResupdate(Date resupdate) {
		this.resupdate = resupdate;
	}
	public int getResteachno() {
		return resteachno;
	}
	public void setResteachno(int resteachno) {
		this.resteachno = resteachno;
	}
	
}
