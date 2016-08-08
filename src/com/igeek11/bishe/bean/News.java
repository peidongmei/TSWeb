package com.igeek11.bishe.bean;
import java.io.Serializable;
import java.util.Date;
public class News  implements Serializable{
//	newsno number(5) primary key,--新闻编号
//	newstitle varchar2(60),--新闻标题
//	newsdetail varchar2(400),--新闻描述
//	newsdate date,--新闻创建时间
//	newssupno
	private int newsno;
	private String newstitle;
	private String newsdetail;
	private Date newsdate;
	private int newssupno;
	public News() {
	}
	public int getNewsno() {
		return newsno;
	}
	public void setNewsno(int newsno) {
		this.newsno = newsno;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewsdetail() {
		return newsdetail;
	}
	public void setNewsdetail(String newsdetail) {
		this.newsdetail = newsdetail;
	}
	public Date getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(Date newsdate) {
		this.newsdate = newsdate;
	}
	public int getNewssupno() {
		return newssupno;
	}
	public void setNewssupno(int newssupno) {
		this.newssupno = newssupno;
	}
	
}
