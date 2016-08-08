package com.igeek11.bishe.biz;

import java.util.List;

import com.igeek11.bishe.bean.Student;

public interface IStudentBiz {

	int registStudent(Student student);

	Student login(Student student);

	Student studentUpdate1(int stuno1);
	
	int studentUpdate2(Student student);
	List<Student> querystudent(Student student);//列表查询学生

	int studentdelete(int stuno);


}
