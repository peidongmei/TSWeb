<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生注册</title>
<link rel="stylesheet" type="text/css" href="css/studentRegistPage.css" />
</head>
<body>
	<div class="page">
		<div class="head clearFix">
			<div class="head1">
				<img alt="" src="img/logo2.jpg"> <span>欢迎注册</span>
			</div>
			<div class="head2">
				<span>已有账号<a href="studentLogin.jsp">请登录</a></span>
			</div>
		</div>
		<hr>
		<div class="body clearfix">
			<div class="left">
				<form action="student/regist" method="post">
					<div class="item">
						<label for="t1">* 昵 称 </label> <input type="text"
							name="stunickname" class="c1" id="t1" placeholder="您的账户名和登录名" />
					</div>
					<div class="item">
						<label for="t2">* 密 码 </label> <input type="password"
							name="stupwd" class="c1" id="t2" placeholder="建议使用两种字符" />
					</div>
					<div class="item">
						<label for="t3">* 姓 名</label> <input type="text" name="stuname"
							class="c1" id="t3" placeholder="请输入你的姓名" />
					</div>
					<div class="item11">
						<label for="">* 性别</label> <input type="radio" name="stusex"
							id="man" value="1" checked="checked" /><label for="man">男</label>
						<input type="radio" name="stusex" id="female" value="0" /><label
							for="female">女</label>
					</div>
					<div class="item">
						<label for="t4">* 学院名称</label> <select id="questionid"
							name="stuinsti" class="c1 c2" id="t4">
							<option value="计算机与信息学院">计算机与信息学院</option>
							<option value="信息工程系">信息工程系</option>
						</select>
					</div>
					<div class="item">
						<label for="t5">* 邮 箱 </label> <input type="text" name="stumail"
							class="c1" id="t5" placeholder="请输入您常用的邮箱号码" />
						<!--权限级别 -->
						<input type="hidden" name="stupermlevel" value="1">
					</div>
					<div class="item1">
						<input type="submit" value="注册"/ >
					</div>
				</form>
			</div>
			<div class="right">
				<img alt="" src="img/背景.jpg">
			</div>

		</div>

	</div>
</body>
</html>