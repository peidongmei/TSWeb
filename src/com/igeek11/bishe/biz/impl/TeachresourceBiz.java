package com.igeek11.bishe.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.Teachresource;
import com.igeek11.bishe.biz.ITeachresourceBiz;
import com.igeek11.bishe.dao.ITeachresourceDao;

import oracle.net.aso.i;

@Service
public class TeachresourceBiz implements ITeachresourceBiz {
@Autowired
	private ITeachresourceDao teachresourceDao;
@Override
public int upload(Teachresource teachresource){
	return teachresourceDao.upload(teachresource);
}
@Override
public List<Teachresource> queryteachresource(Teachresource teachresource){
	return teachresourceDao.queryteachresource(teachresource);
}
@Override
public Teachresource downquery(Teachresource teachresource){
	return teachresourceDao.downquery(teachresource);
}
@Override
public Teachresource resUpdate1(String resno){
	return teachresourceDao.resUpdate1(resno);
}
@Override 
public int resUpdate2(Teachresource teachresource){
	return teachresourceDao.resUpdate2(teachresource);
}
@Override
public List<Teachresource> typesubjectres(Teachresource teachresource){
	return teachresourceDao. typesubjectres(teachresource);
}
@Override
public int teachresourcedelete(Teachresource teachresource){
	return teachresourceDao.teachresourcedelete(teachresource);
}

}
