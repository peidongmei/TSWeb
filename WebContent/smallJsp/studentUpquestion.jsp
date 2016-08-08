<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="/bishe/js/jquery-2.2.3.js"></script>
<script type="text/javascript">
//当页面加载完毕后，异步请求服务器加载省的数据
$(function(){
	//异步请求servlet,加载一级区域数据
	$.getJSON("/bishe/question/questionteachersList",function(data){
		//data就是请求得到的json格式的数据
		var options = null;
		$.each(data,function(index,item){
			options+='<option value="'+item.teachno+'">'+item.teachname+'</option>';
		});
		$("#questionteachers").append(options);
	});
});

</script>

<form action="/bishe/question/studentUpquestion" method="get"
	style="height: 400px;">
	<label for="account">在线提问</label><br />
	<div>
		<label>选择教师</label> <select id="questionteachers" name="teachno">
		</select><br />
		<br />
	</div>
	<div>
		<label for="account">提问标题</label> <input type="text" name="quetitle"
			id="quetitle" value="${question.quetitle}" placeholder="输入标题" /><br />
		<br />
	</div>
	<div class="item">
		<label for="account">问题描述</label>
		<textarea rows="5" cols="40" name="quedetail" id="quedetail"
			value="${question.quedetail}" placeholder="限300字以内"></textarea>
	</div>
	<br />
	<br />
	<br /> <input type="submit" value="提交" /> <input type="reset"
		value="重置" /><br />
	<br />
</form>
