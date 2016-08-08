package com.igeek11.bishe.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.Subject;
import com.igeek11.bishe.biz.ISubjectBiz;
import com.igeek11.bishe.dao.ISubjectDao;
@Service
public class SubjectBiz implements ISubjectBiz {
@Autowired
private ISubjectDao subjectDao;
@Override
public List<Subject> subjectDisplayList(Subject subject){
	return  subjectDao.subjectDisplayList(subject);
}
}
