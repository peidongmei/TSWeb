package com.igeek11.bishe.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.igeek11.bishe.bean.Teacher;

public interface ITeacherDao {
Teacher tealogin(Teacher teacher);

List<Teacher> queryteacher(Teacher teacher);

Teacher teacherUpdate1(String teachno1);

int teacherUpdate2(Teacher teacher1);

int teacherdelete(int teachno);

Teacher teacherselfUpdate1(int teachno1);

int teacherselfUpdate2(Teacher teacher1);

Teacher teacherselfPwd1(int teachno1);

int teacherselfPwd2(Teacher teacher1);

int teacherAdd(Teacher teacher);

List<Teacher> teacherDisplayList(Teacher teacher);

Teacher teacherDisplay(int teachno1);

List<Teacher> teacherQuestionList(String teachno);

List<Teacher> questionteachers();

int teacherphoto(Teacher teacher);

List<Teacher> mainteacherList();



}
