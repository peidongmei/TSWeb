<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="/bishe/teachresource/resUpdate2" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="resno" id="resno"
			value="${teachresource.resno}" />
		<div class="item">
			<label for="account">重命名</label> <input type="text" name="oldname"
				id="oldname" value="${teachresource.oldname}" />
		</div>
		<div class="item">
			<input type="submit" id="" value="更新" />
		</div>
	</form>
</body>
</html>