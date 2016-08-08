<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入包jstl 必须写下面的配置信息 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bishe/css/include.css" />
</head>
<body>
	<!--  后台管理-->
	<div class="wrap clearFix">
		<div class="left">
			<div class="menu">
				<ul>
					<li><span>教师自我更新</span>
						<ul>
							<li><a href="/bishe/smallJsp/teacherPhoto.jsp">个人头像更新</a></li>
							<br />
							<li><a
								href="/bishe/teacher/teacherselfUpdate1?teachno=${tea.teachno}">个人信息更新</a>
							</li>
							<br />
							<li><a
								href="/bishe/teacher/teacherselfPwd1?teachno=${tea.teachno}">修改用户名或密码</a></li>
							<br />
							<br />
							<br />
						</ul></li>
				</ul>
				<ul>
					<li><span>教学资源管理</span>
						<ul>
							<li><a href="#" target="function">添加教学资源</a></li>
							<br />
							<li><a href="#" target="function">教学资源列表</a></li>
							<br />
							<br />
							<br />
						</ul></li>
				</ul>
				<ul>
					<li><span>教学问题管理</span>
						<ul>
							<li><a href="#" target="function">回答教学问题</a></li>
							<br />
							<li><a href="/bishe/teacher/teacherList" target="function">教学问题列表</a></li>
							<br />
							<br />
							<br />
						</ul></li>
				</ul>
			</div>
			<!--menu-->
		</div>
		<!--left-->
		<div class="right">
			<%@ include file="/smallJsp/resourceList.jsp"%>
		</div>
		<!--right-->
	</div>
	<!--all-->
</body>
</html>