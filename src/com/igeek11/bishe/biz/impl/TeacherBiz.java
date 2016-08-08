package com.igeek11.bishe.biz.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek11.bishe.bean.Teacher;
import com.igeek11.bishe.biz.ITeacherBiz;
import com.igeek11.bishe.dao.ITeacherDao;

@Service
public class TeacherBiz implements ITeacherBiz {
	@Autowired
	private ITeacherDao teacherDao;
	@Override
	public Teacher tealogin(Teacher teacher){
		return teacherDao.tealogin(teacher);
	}
	@Override
	public  List<Teacher> queryteacher(Teacher teacher){
		return teacherDao.queryteacher(teacher);
	}
	@Override
	public List<Teacher> Sessionqueryteacher(HttpSession teacher) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Teacher teacherUpdate1(String teachno){
		return teacherDao.teacherUpdate1(teachno);
	}
	@Override
	public int teacherUpdate2(Teacher teacher1){
		return teacherDao.teacherUpdate2(teacher1);
	}
	@Override
	public int teacherdelete(int teachno){
		return teacherDao.teacherdelete(teachno);
	}
	@Override
	public Teacher teacherselfUpdate1 (int teachno1){
		return teacherDao.teacherselfUpdate1(teachno1);
	}
	@Override
	public int teacherselfUpdate2(Teacher teacher1){
		return teacherDao.teacherselfUpdate2(teacher1);
	}
	@Override
	public Teacher teacherselfPwd1(int teachno1){
		return teacherDao.teacherselfPwd1(teachno1);
	}
	@Override
	public int teacherselfPwd2(Teacher teacher1){
		return teacherDao.teacherselfPwd2(teacher1);
	}
	@Override
	public  int teacherAdd(Teacher teacher) {
		
		return teacherDao.teacherAdd(teacher);
	}
	@Override
	public List<Teacher> teacherDisplayList(Teacher teacher){
		return teacherDao.teacherDisplayList(teacher);
	}
	@Override
	public Teacher teacherDisplay(int teachno1){
		return teacherDao.teacherDisplay(teachno1);
	}
	@Override
	public List<Teacher> questionteachers() {
		return teacherDao.questionteachers();
	}
	@Override
	public int teacherphoto(Teacher teacher){
		return teacherDao.teacherphoto(teacher);
	}
@Override
public List<Teacher> mainteacherList(){
	return teacherDao.mainteacherList();
}
	
}
