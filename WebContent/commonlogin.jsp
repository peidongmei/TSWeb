<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理员登录</title>
<link rel="stylesheet" href="css/adminLogincss.css" />
</head>
<body>

	<div class="head">
		<a href=""><label class="xuebi"><img alt=""
				src="/bishe/img/logo.gif"></label></a> <span>欢迎登录</span>
	</div>
	<div class="content">
		<div class="post"></div>
		<div class="fff">
			<form action="/bishe/super/commonlogin" method="post">
				<label class="jdhy">管理员/老师登录</label>
				<div class="diushi">
					<label class="xuebi03"></label><label class="gg">公共场所不建议自动登录，以防账号丢失</label>
				</div>
				<br> <label for="" style="font-family: '宋体'; font-size: 15px">身&nbsp;份</label>
				<select name="grade" id="grade" size="1" style="width: 250px;">
					<option value="1">管理员</option>
					<option value="2" selected="selected">教师</option>
				</select><br />
				<!-- <label for="t1">* 昵  称  </label><input type="text" name="name" class="c1"id="t1"/><br/>  
				<label for="t2">* 密  码 </label>  <input type="password" name="pwd"class="c1"id="t2"/><br/><br/> -->
				<!-- <input type="submit" value="登录"/>
				<input type="reset" value="重置"/> -->
				<div class="i1"></div>
				<div class="biaodan">
					<div class="d0">
						<div class="d1">
							<label class="l1" for="t1"></label><input type="text" name="name"
								class="c1" id="t1" /><br />
						</div>
						<div class="d2">
							<label class="l2" for="t2"></label><input type="password"
								name="pwd" class="" id="t2" /><br />
						</div>
					</div>
					<!-- <div class="d3">
							<span >没有账号？</span>
							<a href="studentRegist.jsp">现在注册</a>
						</div> -->
					<div class="d4">
						<input type="submit"
							style="position: relative; right: 20px; top: 37px; font-family: '微软雅黑'; color: white;"
							value="登 录" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>