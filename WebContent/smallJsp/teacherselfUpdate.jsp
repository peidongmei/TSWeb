<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师自我更新</title>
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

	<label for=""></label>
	<form action="/bishe/teacher/teacherselfUpdate2" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="teachno" id="teachno"
			value="${tea.teachno}" />
		<div class="item">
			<label for="account">教师姓名</label> <input type="text" name="teachname"
				id="teachname" value="${teacher.teachname}" />
		</div>
		<div class="item">
			<label for="sex">教师性别</label> <input type="radio" name="teachsex"
				id="sex1" ${(teacher.teachsex ==1)?"checked":"" } value="1" /><label
				for="sex1">男</label> <input type="radio" name="teachsex" id="sex2"
				${(teacher.teachsex==2)?"checked":"" } value="2" /><label
				for="sex2">女</label>
		</div>
		<div class="item">
			<label for="account">教师出生年月</label> <input type="text"
				name="teachbirth" id="teachbirth" value="${teacher.teachbirth}" />
			(输入格式:1970-01-01)<br>
		</div>
		<div class="item">
			<label for="account">最终学位</label> <input type="text"
				name="terminaldegree" id="terminaldegree"
				value="${teacher.terminaldegree}" />
		</div>
		<div class="item">
			<label for="account">教师简历</label>

			<textarea rows="6" cols="50" name="teachresume" id="teachresume">${teacher.teachresume}</textarea>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<div class="item">
			<label for="account">研究方向</label>
			<!-- 		placeholder="限200字以内"
 -->
			<input type="text" name="resdirection" id="resdirection"
				value="${teacher.resdirection}" />
		</div>
		<div class="item">
			<label for="account">教师职称</label> <input type="text"
				name="teachtitle" id="teachtitle" value="${teacher.teachtitle}" />
		</div>
		<div class="item">
			<label for="account">教师论著</label> <input type="text"
				name="teachtreatise" id="teachtreatise"
				value="${teacher.teachtreatise}" />
		</div>
		<div class="item">
			<label for="account">教师获奖</label> <input type="text"
				name="teachprize" id="teachprize" value="${teacher.teachprize}" />
		</div>
		<div class="item">
			<label for="account">教师邮箱</label> <input type="text" name="teachmail"
				id="teachmail" value="${teacher.teachmail}" />
		</div>


		<div class="item">
			<input type="submit" id="" value="更新" />
		</div>
	</form>
</body>
</html>