<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="400">
		<label>学生管理</label>
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>学院</th>
			<th>操作</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.stuno }</td>
				<td>${student.stuname }</td>
				<td>${student.stuinsti}</td>
				<td>
					<%-- 				<a href="teacherUpdate1?teachno=${student.stuno}">修改</a>
 --%> <a href="studentdelete?stuno=${student.stuno}"
					onclick='return confirm("确认删除?")'>删除</a>
				</td>
			</tr>
		</c:forEach>
</body>
</html>