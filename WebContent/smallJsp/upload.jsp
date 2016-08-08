<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>

<body>
	<form action="/bishe/teachresource/upload"
		enctype="multipart/form-data" method="post">
		<label for="">资源上传</label><br /> <label for="">选择资源类型</label><br /> <select
			name="type" id="type" size="1">
			<option value="1">教学作业</option>
			<option value="2" selected="selected">教学课件</option>
			<option value="3">教学视频</option>
		</select><br /> 上传&nbsp;文件：<input type="file" name="resname"><br />
		<br /> <input type="submit" value="提交">
	</form>
</body>
</html>