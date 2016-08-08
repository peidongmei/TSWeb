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

	<table border="1">
		<label>问题管理</label>
		<tr>
			<th>编号</th>
			<th>问题标题</th>
			<th>解答时间</th>
			<th>操作</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${answers}" var="answer">
			<tr>
				<td>${answer.answerno }</td>
				<td>${answer.answertitle }</td>
				<td>${answer.answerdate}</td>
				<td><a href="answerDelete?answerno=${answer.answerno}">删除</a></td>
			</tr>
		</c:forEach>
</body>
</html>