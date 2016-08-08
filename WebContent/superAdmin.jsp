<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>超级管理界面</title>
<link rel="stylesheet" type="text/css" href="/bishe/css/Admin.css" />
</head>
<body>
	<script type="text/javascript">
		alert{${msg}}
	</script>
	<div class="head">
		<a href=""><label class="xuebi"><img alt=""
				src="/bishe/img/logo.gif"></label></a> <span>欢迎登录</span>
	</div>
	<div class="content clearFix">
		<label>当前管理员为:</label>${sup.supername} <a
			href="/bishe/super/superquit">退出</a><br>
		<div class="menu">
			<ul>
				<li>
					<ul>
						<li><a
							href="/bishe/super/superUpdate1?superno=${sup.superno}"
							target="function">修改用户名或密码</a></li>
					</ul>
				</li>
				<br />
				<li>
					<ul>
						<li><a href="/bishe/student/studentList" target="function">学生管理</a></li>
					</ul>
				</li>
				<br />
				<li><span>教师管理</span>
					<ul>
						<li><a href="/bishe/smallJsp/teacherAdd.jsp"
							target="function">添加教师</a></li>
						<li><a href="/bishe/teacher/teacherList" target="function">教师列表</a></li>
					</ul></li>
				<br />
				<li><span>新闻管理</span>
					<ul>
						<li><a href="/bishe/smallJsp/newsAdd.jsp" target="function">添加新闻</a></li>
						<li><a href="/bishe/news/newsList" target="function">新闻列表</a></li>
					</ul></li>
				<br />
				<li><span>公告管理</span>
					<ul>
						<li><a href="/bishe/smallJsp/noticeAdd.jsp"
							" target="function">添加公告</a></li>
						<li><a href="/bishe/notice/noticeList" target="function">公告列表</a></li>
					</ul></li>
				<br />
		</div>
		<div class="func">
			<iframe name="function"></iframe>
			<script type="text/javascript">
			alert{${msg}}
			</script>
		</div>
	</div>


</body>
</html>