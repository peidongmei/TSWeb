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

	<table border="1" width="600">
		<label>问题管理</label>
		<tr>
			<th>编号</th>
			<th>标题</th>
			<th>日期</th>
			<th>提问者</th>
			<th>操作</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${questions}" var="question">
			<tr>

				<td>${question.queno}</td>
				<td>${question.quetitle}</td>
				<td>${question.quedate}</td>
				<td>${question.questuno}</td>
				<td><a href="questionUpdate1?queno=${question.queno}">解答</a> <a
					href="answerDelete?answerno=${answer.answerno}">删除</a></td>
			</tr>
		</c:forEach>
</body>
</html>