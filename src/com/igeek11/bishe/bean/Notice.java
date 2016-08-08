package com.igeek11.bishe.bean;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable{
	private int noticeno;
	private String noticetitle;
	private String noticedetail;
	private Date noticedate;
	private int noticesupno;
	public Notice() {
	}
	public int getNoticeno() {
		return noticeno;
	}
	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}
	public String getNoticetitle() {
		return noticetitle;
	}
	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}
	public String getNoticedetail() {
		return noticedetail;
	}
	public void setNoticedetail(String noticedetail) {
		this.noticedetail = noticedetail;
	}
	public Date getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(Date noticedate) {
		this.noticedate = noticedate;
	}
	public int getNoticesupno() {
		return noticesupno;
	}
	public void setNoticesupno(int noticesupno) {
		this.noticesupno = noticesupno;
	}
	
}
