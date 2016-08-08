package com.igeek11.bishe.bean;

import java.io.Serializable;
import java.util.Date;

public class Question  implements Serializable{
	private int queno;
	private String quetitle;
	private int questuno;
	private int queteachno;
	private String quedetail;
	private Date	quedate;
	
	public Date getQuedate() {
		return quedate;
	}
	public void setQuedate(Date quedate) {
		this.quedate = quedate;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public int getQueno() {
		return queno;
	}
	public void setQueno(int queno) {
		this.queno = queno;
	}
	public String getQuetitle() {
		return quetitle;
	}
	public void setQuetitle(String quetitle) {
		this.quetitle = quetitle;
	}

	public int getQuestuno() {
		return questuno;
	}
	public void setQuestuno(int questuno) {
		this.questuno = questuno;
	}
	public int getQueteachno() {
		return queteachno;
	}
	public void setQueteachno(int queteachno) {
		this.queteachno = queteachno;
	}
	public String getQuedetail() {
		return quedetail;
	}
	public void setQuedetail(String quedetail) {
		this.quedetail = quedetail;
	}


		
}
