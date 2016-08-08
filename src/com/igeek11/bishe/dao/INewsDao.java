package com.igeek11.bishe.dao;

import java.util.List;

import com.igeek11.bishe.bean.News;

public interface INewsDao {
	int newsAdd(News news);

	List<News> newsList(News news);

	News newsDiaplay(int newsno1);

	int newsdelete(int newsno1);


	List<News> mainnewsList();



}
