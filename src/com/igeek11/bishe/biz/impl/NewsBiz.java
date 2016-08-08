package com.igeek11.bishe.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.News;
import com.igeek11.bishe.biz.INewsBiz;
import com.igeek11.bishe.dao.INewsDao;
@Service
public class NewsBiz implements INewsBiz {
@Autowired
private INewsDao newsDao;	
@Override
public  int newsAdd(News news) {	
	return newsDao.newsAdd(news);
}
@Override
public List<News> newsList(News news){
	return newsDao.newsList(news);
}
@Override
public News  newsDisplay(int newsno1){
	return newsDao.newsDiaplay(newsno1);
}
@Override
public int newsdelete(int newsno1){
	return newsDao.newsdelete(newsno1);
}
@Override
public List<News> mainnewsList(){
	return newsDao.mainnewsList();
}

}
