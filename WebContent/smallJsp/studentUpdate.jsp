<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>学生自我更新</title>
<style type="text/css">
.item {
	height: 30px;
	line-height: 30px;
}

.item label {
	display: inline-block;
	width: 100px;
}

.tt {
	height: auto;
}
</style>
</head>
<body>
	<form action="/bishe/student/studentUpdate2" method="post">
		<label>当前学生用户为:</label>${student.stunickname}<br> <input
			type="hidden" name="stuno" id="stuno" value="${student.stuno}" />
		<div class="item">
			<label for=" ">用 户 名</label> <input type="text" name="stunickname"
				id="stunickname" value="${student.stunickname}" />
		</div>
		<%--<div class="item"> --%>
		<div class="item">
			<label for="account">学生密码</label> <input type="password"
				name="stupwd" id="stupwd" value="${student.stupwd}" />
		</div>
		<div class="item">
			<label for="account">学生姓名</label> <input type="text" name="stuname"
				id="stuname" value="${student.stuname}" />
		</div>
		<div class="item">
			<label for="sex">学生性别</label> <input type="radio" name="stusex"
				id="sex1" ${(student.stusex==1)?"checked":"" } value="1" /><label
				for="sex1">男</label> <input type="radio" name="stusex" id="sex2"
				${(student.stusex==2)?"checked":"" } value="2" /><label for="sex2">女</label>
		</div>
		<div class="item">
			<label for="account">所属学科</label> <input type="text" name="stuinsti"
				id="stuinsti" value="${student.stuinsti}" />
		</div>
		<div class="item">
			<label for="account">学生邮箱</label> <input type="text" name="stumail"
				id="stumail" value="${student.stumail}" />
		</div>
		<div class="item">
			<input type="submit" id="" value="更新" />
		</div>
	</form>
</body>
</html>