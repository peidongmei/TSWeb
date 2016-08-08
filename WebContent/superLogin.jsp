<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>超级管理员登录</title>
<style>
.nav {
	width: 300px;
	margin: 10px auto;
	display: inline-block;
}

.nav {
	text-decoration: none;
}

.next {
	width: 20px;
	height: 20px;
}

.p1 {
	width: 200px;
	background: red;
	color: white;
}

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
	<p class="p1">管理员登录</p>
	<form action="super/login" method="post">
		<label for="t1">* 用户名 </label><input type="text" name="supername"
			class="c1" id="t1" /><br /> <label for="t2">* 密&nbsp;码 </label> <input
			type="password" name="superpwd" class="c1" id="t2" /><br />
		<br /> <input type="submit" value="登录" /> <input type="reset"
			value="重置" />
	</form>
	</div>
</body>
</html>