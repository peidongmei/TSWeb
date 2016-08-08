package com.igeek11.bishe.biz;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.igeek11.bishe.bean.Teacher;

public interface ITeacherBiz {

	Teacher tealogin(Teacher teacher);
	List<Teacher> queryteacher(Teacher teacher);	
	List<Teacher> Sessionqueryteacher(HttpSession teacher);
	Teacher teacherUpdate1(String teachno1)throws SQLException;//管理员查询教师列表展现
	int teacherUpdate2(Teacher teacher1)throws SQLException;//管理员更新某条信息
	int teacherdelete(int teachno)throws SQLException;//管理员删除某个教师
	Teacher teacherselfUpdate1(int teachno1);//教师自我更新之查询
	int teacherselfUpdate2(Teacher teacher1);//教师自我信息更新
	Teacher teacherselfPwd1(int teachno1);//教师修改用户名密码之查询
	int teacherselfPwd2(Teacher teacher1);//教师修改用户名密码
	 int teacherAdd(Teacher teacher);//管理员增加一个教师
	List<Teacher> teacherDisplayList(Teacher teacher);//列表显示教师姓名
	Teacher teacherDisplay(int teachno1);//教师个人信息展示
	List<Teacher> questionteachers();//提交问题时选择老师
	int teacherphoto(Teacher teacher);//修改教师头像
	List<Teacher> mainteacherList();//首页显示教师列表
	
	

}
