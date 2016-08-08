<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载列表</title>
</head>
<body>

	<!-- resno,oldname,restype,ressubno,resupdate -->
	<table border="1" width="600">
		<label>下载管理</label>
		<tr>

			<th>文件名</th>
			<th>文件类型</th>
			<th>所属学科</th>
			<th>上传日期</th>
			<th>操作</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${teas}" var="teas">
			<tr>
				<td>${teas.oldname}</a></td>
				<td>${teas.restype}</td>
				<td>${teas.ressubno}</td>
				<td>${teas.resupdate}</td>
				<td><a href="resUpdate1?resno=${teas.resno}">重命名</a> <a
					href="resdelete?resno=${teas.resno}"
					onclick='return confirm("确认删除？")'>删除</a></td>
			</tr>
		</c:forEach>
</body>
</html>