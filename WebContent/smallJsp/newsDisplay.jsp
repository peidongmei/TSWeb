<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/news.css" />
</head>
<body>
	<div class="wrap clearFix">
		<div class="top">
			<h3>标题:${news.newstitle}</h3>
			<h6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${news.newsdate}</h6>
		</div>
		<div class="bottom">
			<label>正文: </label><br /> ${news.newsdetail}
		</div>
	</div>
</body>
</html>