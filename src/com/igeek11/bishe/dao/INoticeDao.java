package com.igeek11.bishe.dao;

import java.util.List;

import com.igeek11.bishe.bean.Notice;

public interface INoticeDao {

	int noticeAdd(Notice notice);

	List<Notice> noticeList(Notice notice);

	Notice noticeDiaplay(int noticeno1);

	int noticedelete(int noticeno1);

	List<Notice> mainnoticeList();

}
