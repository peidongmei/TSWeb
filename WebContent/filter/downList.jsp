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
		<label>资源管理</label>
		<tr>
			<th>文件名</th>
			<th>所属学科</th>
			<th>文件类型</th>
			<th>上传日期</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${teas}" var="teas">
			<tr>
				<td><a href="/bishe/teachresource/down?resno=${teas.resno}">${teas.oldname}</a></td>
				<td>${teas.ressubno}<c:choose>
						<c:when test="${teas.ressubno==2}">信息安全专业</c:when>
						<c:when test="${teas.ressubno==3}">内容安全与隐私保护</c:when>
						<c:when test="${teas.ressubno==4}">复杂网络、无线及光网络</c:when>
						<c:when test="${teas.ressubno==5}">电子取证与网络攻防</c:when>
						<c:when test="${teas.ressubno==6}">应用密码学与网络访问控制</c:when>
					</c:choose>
				</td>
				<td><c:choose>
						<c:when test="${teas.restype==1}">教学作业</c:when>
						<c:when test="${teas.restype==2}">教学课件</c:when>
						<c:when test="${teas.restype==3}">教学视频</c:when>
					</c:choose></td>

				<td>${teas.resupdate}</td>
			</tr>
		</c:forEach>
</body>
</html>