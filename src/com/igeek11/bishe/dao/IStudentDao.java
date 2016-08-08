package com.igeek11.bishe.dao;

import java.util.List;

import com.igeek11.bishe.bean.Student;

public interface IStudentDao {

	int saveStudent(Student student);

	Student login(Student student);

	Student studentUpdate1(int stuno1);
	int studentUpdate2(Student student);

	List<Student> querystudent(Student student);

	int studentdelete(int stuno);

	

}
