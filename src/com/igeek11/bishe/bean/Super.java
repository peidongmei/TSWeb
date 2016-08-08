package com.igeek11.bishe.bean;

import java.io.Serializable;

public class Super  implements Serializable  {
	private int superno;
	private String supername;
	private String superpwd;
	public Super() {
		// TODO Auto-generated constructor stub
	}
	public int getSuperno() {
		return superno;
	}
	public void setSuperno(int superno) {
		this.superno = superno;
	}
	public String getSupername() {
		return supername;
	}
	public void setSupername(String supername) {
		this.supername = supername;
	}
	public String getSuperpwd() {
		return superpwd;
	}
	public void setSuperpwd(String superpwd) {
		this.superpwd = superpwd;
	}
	
}
