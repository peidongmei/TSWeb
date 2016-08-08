<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 导入包jstl 必须写下面的配置信息 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 前端显示数据库内容    el表达式-->
	<%-- ${tea.teachno } --%>
	<%-- 	${sup.superno } --%>
	<%-- 	${ stu.stuno} --%>

	<!-- 要将requset中users显示成一个表格 -->
	<table border="1" width="400">
		<label>教师管理</label>
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>权限</th>
			<th>学科号</th>
			<th>操作</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${teachers}" var="teacher">
			<tr>

				<td>${teacher.teachno }</td>
				<td>${teacher.teachname }</td>
				<td>${teacher.teachpermlevel}</td>
				<td>${teacher.teachsubjectnum}</td>
				<td><a href="teacherUpdate1?teachno=${teacher.teachno}">修改</a>
					<a href="teacherdelete?teachno=${teacher.teachno}"
					onclick='return confirm("确认删除？")'>删除</a></td>
			</tr>
		</c:forEach>
</body>
</html>