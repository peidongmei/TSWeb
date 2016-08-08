<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 导入包jstl 必须写下面的配置信息 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告列表</title>
</head>
<body>
	<table border="1" width="460px" height="220px">
		<label>公告列表</label>
		<tr>
			<th>编号</th>
			<th>标题</th>
			<th>日期</th>
			<th>操作</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${notice1}" var="notice1">
			<tr>
				<td>${notice1.noticeno}</td>
				<td><a href="noticeDisplay?noticeno=${notice1.noticeno}">${notice1.noticetitle}</a></td>
				<td>${notice1.noticedate}</td>

				<td><a href="noticedelete?noticeno=${notice1.noticeno}"
					onclick='return confirm("确认删除？")'>删除</a></td>
			</tr>
		</c:forEach>
</body>
</html>