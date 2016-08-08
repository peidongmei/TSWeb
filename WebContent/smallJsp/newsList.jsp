<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 导入包jstl 必须写下面的配置信息 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body style="width: 440px; height: 220px;">
	<table border="1" width="400px" height="200px">
		<label>新闻列表</label>
		<tr>
			<th>编号</th>
			<th>标题</th>
			<th>日期</th>
			<th>操作</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${news1}" var="news1">
			<tr>
				<td>${news1.newsno}</td>
				<td><a href="newsDisplay?newsno=${news1.newsno}">${news1.newstitle}</a></td>
				<td>${news1. newsdate}</td>

				<td><a href="newsdelete?newsno=${news1.newsno}"
					onclick='return confirm("确认删除？")'>删除</a></td>
			</tr>
		</c:forEach>
</body>
</html>