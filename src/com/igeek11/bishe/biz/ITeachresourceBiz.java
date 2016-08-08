package com.igeek11.bishe.biz;

import java.util.List;

import com.igeek11.bishe.bean.Teachresource;

public interface ITeachresourceBiz {

int upload(Teachresource teachresource);

List<Teachresource> queryteachresource(Teachresource teachresource);

Teachresource downquery(Teachresource teachresource);

Teachresource resUpdate1(String resno);

int resUpdate2(Teachresource teachresource);

List<Teachresource> typesubjectres(Teachresource teachresource);

int teachresourcedelete(Teachresource teachresource);

}
