<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是主页</title>
</head>
<body>

	<%-- <label>当前学生用户为:</label>${student1.stunickname}<br/>
<a href="/bishe/student/studentUpdate1?stuno=${sessionScope.student1.stuno}">修改学生信息</a><br/>
<a href="/bishe/teacher/teacherDisplayList">老师们</a><br/>
<a href="/bishe/smallJsp/subjectDisplayList.jsp">五个展板静态的先</a><br/>
 <a href="/bishe/smallJsp/studentUpquestion.jsp">学生提问</a><br/>
  --%>
	<form action="/bishe/teachresource/downList">
		<!-- /bishe/teachresource/downList -->
		<label>资源下载</label><br /> <label for="">选择所属学科</label><br /> <select
			name="subject" id="subject" size="1">
			<option value="2">信息安全专业</option>
			<option value="3" selected="selected">内容安全与隐私保护</option>
			<option value="4">复杂网络、无线及光网络</option>
			<option value="5">电子取证与网络攻防</option>
			<option value="6">应用密码学与网络访问控制</option>
		</select><br /> <label for="">选择资源类型</label><br /> <select name="type"
			id="type" size="1">
			<option value="1">教学作业</option>
			<option value="2" selected="selected">教学课件</option>
			<option value="3">教学视频</option>
		</select><br />
		<div class="item">
			<input type="submit" id="" value="查询" />
		</div>
	</form>



</body>
</html>