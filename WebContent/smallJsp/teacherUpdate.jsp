
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/bishe/teacher/teacherUpdate2" method="post">
		<input type="hidden" name="teachno" value="${teacher.teachno }"
			readonly="readonly" />
		<div class="item">
			<label for="account">教师姓名</label> <input type="text" name="account"
				id="account" value="${teacher.teachname } " readonly="readonly" />
		</div>
		<div class="item ">
			<label for="account">权限级别</label> <select name="teachpermlevel"
				id="teachpermlevel" value='${teacher.teachpermlevel}' size="1">
				<option>1</option>
				<option selected="selected">2</option>
				<option>3</option>
			</select>
		</div>
		<div class="item ">
			<label for="account">所属学科号</label> <select name="teachsubjectnum"
				id="teachsubjectnum" value='${teacher.teachsubjectnum}' size="1">
				<option>1</option>
				<option selected="selected">2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
			</select>
		</div>
		<div class="item">
			<input type="submit" value="更新" />
		</div>
	</form>
	<%-- <div class="item">
			<label for="sex">性别</label>
			<input type="radio" name="sex" id="sex1" ${(teacher.teachsex ==1)?"checked":"" } value="1" /><label for="sex1">男</label>
			<input type="radio" name="sex" id="sex2" ${(teacher.teachsex==2)?"checked":"" } value="2" /><label for="sex2">女</label>
		</div>  --%>
	<%-- 
		<div class="item">
			<label >爱好</label>
			<c:forEach items="${hobbies }" var="hobby">
				<input type="checkbox" name="hobbyIds" value="${hobby.id }" id="hobby1"/><label for="hobby1">${hobby.name}</label>
			</c:forEach>
		</div>
		<div class="item">
			<label for="account">学历</label>
			<select name="gradeid">
				<c:forEach items="${grades }" var="grade">
					<option value="${grade.id }"  ${(admin.gradeid==grade.id)?"selected":"" }>${grade.name }</option>
				</c:forEach>
			</select>
		</div> --%>

</body>
</html>