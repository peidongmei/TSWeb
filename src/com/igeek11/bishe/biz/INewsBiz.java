package com.igeek11.bishe.biz;

import java.util.List;

import com.igeek11.bishe.bean.News;

public interface INewsBiz {

	int newsAdd(News news);

	List<News> newsList(News news);

	News newsDisplay(int newsno1);


	int newsdelete(int newsno1);

	List<News> mainnewsList();

}
