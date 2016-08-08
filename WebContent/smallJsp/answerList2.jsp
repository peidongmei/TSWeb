<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<!--  前端页面显示list-->
			<th>问题标题</th>
			<th>解答时间</th>
			<th>解答教师</th>
		</tr>
		<!-- 循环标签 -->
		<c:forEach items="${answers}" var="answers">
			<tr>
				<td><a href="answerDisplay?answerno=${answers.answerno}">${answers.answertitle}</a>
				</td>
				<td>${answers.answerdate}</td>
				<td>${answers.teacher.teachname}</td>

			</tr>
		</c:forEach>
	</table>