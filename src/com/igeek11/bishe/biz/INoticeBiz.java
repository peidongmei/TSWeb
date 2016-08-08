package com.igeek11.bishe.biz;

import java.util.List;

import com.igeek11.bishe.bean.Notice;

public interface INoticeBiz {
	int noticeAdd(Notice notice);

	List<Notice> noticeList(Notice notice);

	Notice noticeDisplay(int noticeno1);


	int noticedelete(int noticeno1);

	List<Notice> mainnoticeList();
}
