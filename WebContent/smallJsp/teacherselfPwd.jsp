<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师修改用户名、密码</title>

<style>
.c1 {
	width: 120px;
	height: 10px;
}

.c2 {
	height: auto;
}
</style>
</head>
<body>
	<label>教师修改用户名、密码</label>

	<form action="/bishe/teacher/teacherselfPwd2" method="post">
		<input type="hidden" name="teachno" id="teachno"
			value="${tea.teachno}" /> <label for="t1">&nbsp;用户名 </label><input
			type="text" name="teachnickname" class="c1"
			value="${teacher.teachnickname}" /><br /> <label for="t2">&nbsp;密&nbsp;码
		</label> <input type="password" name="teachpwd" class="c1"
			value="${teacher.teachpwd}" /><br />
		<br /> <input type="submit" value="更新" />
		<%-- 	<% 
		session.invalidate();//使session失效
		%>  --%>
	</form>
	</div>
</body>
</html>