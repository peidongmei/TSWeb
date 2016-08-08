<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入包jstl 必须写下面的配置信息 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理界面</title>
<!-- 	<link rel="stylesheet" type="text/css" href="css/include.css"/> -->
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
		<label>当前教师为:${tea.teachname}</label> <a
			href="/bishe/teacher/teacherquit">退出</a><br>
		<div class="menu">
			<ul>
				<li><span>教师自我更新</span>
					<ul>
						<li><a href="/bishe/smallJsp/teacherPhoto.jsp"
							target="function">个人头像更新</a></li>
						<br />
						<li><a
							href="/bishe/teacher/teacherselfUpdate1?teachno=${tea.teachno}"
							target="function">个人信息更新</a></li>
						<br />
						<li><a
							href="/bishe/teacher/teacherselfPwd1?teachno=${tea.teachno}"
							target="function">修改用户名或密码</a></li>
						<br />
						<br />
					</ul></li>
			</ul>
			<ul>
				<li><span>教学问题管理</span>
					<ul>
						<li><a href="/bishe/question/questionList" target="function">回答教学问题</a></li>
						<br />
						<li><a href="/bishe/answer/answerList" target="function">教学问题列表</a></li>
						<br />
						<br />
					</ul></li>
			</ul>
			<ul>
				<li><span>教学资源管理</span>
					<ul>
						<li><a href="/bishe/smallJsp/upload.jsp" target="function">添加教学资源</a></li>
						<br />
						<li><a href="/bishe/teachresource/resourceList"
							target="function">教学资源列表</a></li>
						<br />
						<br />
					</ul></li>
			</ul>
		</div>
		<!--menu-->
		<div class="func">
			<iframe name="function"></iframe>
			<script type="text/javascript">
			${msg}
			</script>
		</div>


	</div>
	<!--clearFix-->
</body>
</html>