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
	Teacher teacherUpdate1(String teachno1)throws SQLException;//����Ա��ѯ��ʦ�б�չ��
	int teacherUpdate2(Teacher teacher1)throws SQLException;//����Ա����ĳ����Ϣ
	int teacherdelete(int teachno)throws SQLException;//����Աɾ��ĳ����ʦ
	Teacher teacherselfUpdate1(int teachno1);//��ʦ���Ҹ���֮��ѯ
	int teacherselfUpdate2(Teacher teacher1);//��ʦ������Ϣ����
	Teacher teacherselfPwd1(int teachno1);//��ʦ�޸��û�������֮��ѯ
	int teacherselfPwd2(Teacher teacher1);//��ʦ�޸��û�������
	 int teacherAdd(Teacher teacher);//����Ա����һ����ʦ
	List<Teacher> teacherDisplayList(Teacher teacher);//�б���ʾ��ʦ����
	Teacher teacherDisplay(int teachno1);//��ʦ������Ϣչʾ
	List<Teacher> questionteachers();//�ύ����ʱѡ����ʦ
	int teacherphoto(Teacher teacher);//�޸Ľ�ʦͷ��
	List<Teacher> mainteacherList();//��ҳ��ʾ��ʦ�б�
	
	

}
