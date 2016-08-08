<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生登录</title>
<link rel="stylesheet" href="/bishe/css/userLogincss.css" />
<script type="text/javascript">
	function change() {
		var timenow = new Date().getTime();
		var vc = document.getElementById("vc");
		vc.src = "/bishe/validateCode?id=" + timenow;//重新设置img的src属性，会自动请求servlet
		return false;
	}
</script>
</head>
<body>
	<div class="head">
		<a href=""><label class="xuebi"><img alt=""
				src="/bishe/img/logo.gif"></label></a> <span>欢迎登录</span>
	</div>
	<div class="content">
		<div class="post"></div>
		<div class="fff">
			<form action="/bishe/student/login" method="post">
				<label class="jdhy">学生登录</label>
				<!-- <a class="ljzc" href="">立即注册</a> -->
				<!-- <label class="xuebi02"></label> -->
				<div class="diushi">
					<label class="xuebi03"></label><label class="gg">公共场所不建议自动登录，以防账号丢失</label>
				</div>
				<div class="i1"></div>
				<div class="biaodan">
					<div class="d0">
						<div class="d1">
							<label class="l1" for="t1"></label><input type="text"
								name="stunickname" class="c1" id="t1" value="" /><br />
						</div>
						<div class="d2">
							<label class="l2" for="t2"></label><input type="password"
								name="stupwd" class="" id="t2" /><br />
						</div>
						<%-- <div class="">
							<label for="validateCode" >验证码</label>
								<input type="text" name="vc" id="validateCode" value="" />
								<img alt="" src="validateCode" id="vc"><a href="javascript:void(0)" onclick="change()">换一张</a> 
						</div>--%>
						<div class="item" style="width: 308px; height: 38px;">
							<label for="validateCode">验证码</label> <input type="text"
								name="vc" id="validateCode" value=""
								style="border: solid 1px #bdbdbd; width: 50px; height: 20px; margin-right: 200px;" />
							<img alt="" src="/bishe/validateCode" id="vc"
								style="margin-left: 120px; position: relative; top: -22px;"><a
								href="javascript:void(0)" onclick="change()">换一张</a>

						</div>
					</div>
					<div class="d3">
						<span>没有账号？</span> <a href="studentRegist.jsp">现在注册</a>
					</div>
					<div class="d4">
						<input type="submit"
							style="position: relative; right: 20px; top: 37px; font-family: '微软雅黑'; color: white;"
							value="登 录" />
					</div>

				</div>
			</form>
			<div>${msg}</div>

		</div>
	</div>
</body>
</html>