<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加新闻</title>
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
	<p class="p1">增加新闻</p>
	<form action="/bishe/news/newsAdd" method="post">
		<div>
			<label for="t1">* 新闻标题</label><br /> <input type="text"
				name="newstitle" class="c1" id="t1" /><br /> <br />
		</div>
		<div>
			<label for="t3">* 新闻描述</label> <br />
			<textarea rows="8" cols="60" name="newsdetail" id="newsdetail"
				placeholder="限200字以内"></textarea>
			<br />
		</div>
		<br /> <input type="submit" value="添加" />
	</form>

</body>
</html>