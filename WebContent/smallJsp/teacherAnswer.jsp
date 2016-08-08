<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>教师答疑</title>
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
	<form action="/bishe/answer/teacherAnswer" method="get">
		<input type="hidden" name="queno" id="" value="${question.queno}"
			readonly="readonly" /><br />
		<br /> <input type="hidden" name="questuno" id=""
			value="${question.questuno}" readonly="readonly" /><br />
		<br /> <label for="account">在线答疑</label><br />
		<div class="item">
			<label for="account">提问标题</label> <input type="text"
				name="answertitle" id="answertitle" value="${question.quetitle}"
				readonly="readonly" /><br />
			<br />
		</div>
		<div class="item">
			<label for="account">问题描述</label><br />
			<textarea rows="5" cols="60" name="answerque" id="answerque"
				readonly="readonly">${question.quedetail}</textarea>
			<br />
			<br />
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<div class="item">
			<label for="account">问题解答</label><br />
			<textarea rows="8" cols="60" name="answerdetail" id="answerdetail"></textarea>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />o
		<div class="item">
			<input type="submit" value="提交" />
		</div>
		<br />
		<br />
	</form>
</body>
</html>