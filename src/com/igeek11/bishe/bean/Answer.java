package com.igeek11.bishe.bean;

import java.io.Serializable;
import java.util.Date;

public class Answer  implements Serializable{
private int 	answerno;//--回答编号
	private String answertitle; //varchar2(60),--问题标题
	private String	answerque ;//varchar2(200),--问题描述
	private int 	answerstuno;//  number(5),--提问学生编号
	private int 	answerteachno;//  number(5),--回答教师编号
	private String	answerdetail; //varchar2(800),--答案
	private Date answerdate;//
	private Teacher teacher;//map新增的 
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Answer() {
	}
	public int getAnswerno() {
		return answerno;
	}
	public void setAnswerno(int answerno) {
		this.answerno = answerno;
	}
	public String getAnswertitle() {
		return answertitle;
	}
	public void setAnswertitle(String answertitle) {
		this.answertitle = answertitle;
	}
	public String getAnswerque() {
		return answerque;
	}
	public void setAnswerque(String answerque) {
		this.answerque = answerque;
	}
	public int getAnswerstuno() {
		return answerstuno;
	}
	public void setAnswerstuno(int answerstuno) {
		this.answerstuno = answerstuno;
	}
	public int getAnswerteachno() {
		return answerteachno;
	}
	public void setAnswerteachno(int answerteachno) {
		this.answerteachno = answerteachno;
	}
	public String getAnswerdetail() {
		return answerdetail;
	}
	public void setAnswerdetail(String answerdetail) {
		this.answerdetail = answerdetail;
	}
	public Date getAnswerdate() {
		return answerdate;
	}
	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}
	
}
