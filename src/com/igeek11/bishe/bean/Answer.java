package com.igeek11.bishe.bean;

import java.io.Serializable;
import java.util.Date;

public class Answer  implements Serializable{
private int 	answerno;//--�ش���
	private String answertitle; //varchar2(60),--�������
	private String	answerque ;//varchar2(200),--��������
	private int 	answerstuno;//  number(5),--����ѧ�����
	private int 	answerteachno;//  number(5),--�ش��ʦ���
	private String	answerdetail; //varchar2(800),--��
	private Date answerdate;//
	private Teacher teacher;//map������ 
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
