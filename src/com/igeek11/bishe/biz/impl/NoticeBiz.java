package com.igeek11.bishe.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.Notice;
import com.igeek11.bishe.biz.INoticeBiz;
import com.igeek11.bishe.dao.INoticeDao;
@Service
public class NoticeBiz implements INoticeBiz {


	@Autowired
	private INoticeDao noticeDao;	
	@Override
	public  int noticeAdd(Notice notice) {	
		return noticeDao.noticeAdd(notice);
	}
	@Override
	public List<Notice> noticeList(Notice notice){
		return noticeDao.noticeList(notice);
	}
	@Override
	public Notice  noticeDisplay(int noticeno1){
		return noticeDao.noticeDiaplay(noticeno1);
	}
	@Override
	public int noticedelete(int noticeno1){
		return noticeDao.noticedelete(noticeno1);
	}
	@Override
	public List<Notice> mainnoticeList() {
		// TODO Auto-generated method stub
		return noticeDao.mainnoticeList();
	}

}
