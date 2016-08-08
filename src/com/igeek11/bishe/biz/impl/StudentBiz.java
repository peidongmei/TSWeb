package com.igeek11.bishe.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.Student;
import com.igeek11.bishe.biz.IStudentBiz;
import com.igeek11.bishe.dao.IStudentDao;

@Service
public class StudentBiz implements IStudentBiz {
	
	@Autowired
	private IStudentDao studentDao;
	@Override
	public int registStudent(Student student) {
		
		return studentDao.saveStudent(student);
	}
	@Override
	public Student login(Student student) {
		return studentDao.login(student);
	}
	@Override
	public Student studentUpdate1(int stuno1){
		return studentDao.studentUpdate1(stuno1);
	}
	@Override
	public int studentUpdate2(Student student){
		return studentDao.studentUpdate2(student);
	}
	@Override
	public List<Student> querystudent(Student student){
		return studentDao.querystudent(student);
	}
	@Override 
	public int studentdelete (int stuno){
		return studentDao.studentdelete(stuno);
	}


}
