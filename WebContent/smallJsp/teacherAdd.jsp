<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加教师</title>
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
	background: dodgerblue;
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
	<p class="p1">增加教师</p>
	<form action="/bishe/teacher/teacherAdd" method="post">
		<label for="t1">* 用户名</label><input type="text" name="teachnickname"
			class="c1" id="t1" /><br /> <label for="t3">* 姓 名</label> <input
			type="text" name="teachname" class="c1" id="t3" /><br /> <label
			for="t3">* 密 码</label> <input type="password" name="teachpwd"
			class="c1" id="t3" value="000000" readonly="readonly" /><br />
		<div>
			<label for="">* 性 别</label> <input type="radio" name="teachsex"
				id="sex1" value="1" checked="checked" /><label for="sex1">男</label>
			<input type="radio" name="teachsex" id="sex2" value="2" /><label
				for="sex2">女</label>
		</div>
		<!--权限级别 -->
		<input type="hidden" name="teachpermlevel" value="2"><br /> <input
			type="submit" value="添加" /> <input type="hidden" name="teachbirth"
			value="1970-01-01"><br /> <input type="hidden"
			name="terminaldegree" value="0"><br /> <input type="hidden"
			name="teachresume" value="0"><br /> <input type="hidden"
			name="resdirection" value="0"><br /> <input type="hidden"
			name="teachtitle" value="0"><br /> <input type="hidden"
			name="teachtreatise" value="0"><br /> <input type="hidden"
			name="teachprize" value="0"><br /> <input type="hidden"
			name="teachmail" value="0"><br /> <input type="hidden"
			name="teachphurl" value="0"><br /> <input type="hidden"
			name="teachsubjectnum" value="2"><br />
	</form>

</body>
</html>