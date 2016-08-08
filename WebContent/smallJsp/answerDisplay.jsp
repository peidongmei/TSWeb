<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="css/news.css" />
</head>
<body>
	<div class="wrap clearFix">
		<div class="top">
			<h3>标题:${answer.answertitle}</h3>
			<h6>&nbsp;&nbsp;&nbsp;解答日期：${answer.answerdate}</h6>
		</div>
		<div class="bottom">
			<label>问题描述: </label><br /> ${answer.answerque}
		</div>
		<br />
		<br />
		<div class="bottom">
			<label>教师解答: </label><br /> ${answer.answerdetail}
		</div>
	</div>