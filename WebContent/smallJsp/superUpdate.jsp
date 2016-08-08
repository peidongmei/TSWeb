<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/bishe/super/superUpdate2" method="post">
		<input type="hidden" name="superno" value="${sup.superno}"
			readonly="readonly" />
		<div class="item">
			<label for="account">管理员姓名</label> <input type="text"
				name="supername" id="supername" value="${super1.supername}"
				placeholder="请输入新用户名" />
		</div>
		<div class="item">
			<label for="account">管理员密码</label> <input type="password"
				name="superpwd" id="superpwd" value="${super1.superpwd}"
				placeholder="确保熟记该密码" />
		</div>

		<div class="item">
			<input type="submit" value="更新" />
		</div>
	</form>
</body>
</html>