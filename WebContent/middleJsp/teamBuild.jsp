<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bishe/css/teamBuild.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/bishe/js/jquery-2.2.3.js"></script>
<script type="text/javascript">
$(function(){
	//异步请求servlet
	$.getJSON("/bishe/teacher/mainteacherList",function(data){
		//data就是请求得到的json格式的数据
		var op="";
		$.each(data,function(index,item){
			//op+='<option value="'+item.newsno+'">'+item.newstitle+'----'+item.newsdate+'</option>';
		op+="<label><a href=/bishe/teacher/teacherDisplay?teachno="+item.teachno+">"+item.teachname+"</a></label><br/>"
		});
		$("#tea").append(op);/* tea是个标记，留给后面用  */
	});
});
</script>

</head>
<body>
	<div class="page">
		<div class="head">
			<img class="logo" src="/bishe/img/logo.gif" />
			<div class="font">
				<p>合肥工业大学网络安全研究所</p>
				<p>Research on Security of Hefei University of Technology
					network</p>
			</div>
		</div>
		<div class="nav">
			<ul>
				<li class="n2"><a href="/bishe/middleJsp/index.jsp">网站<br />首页
				</a></li>
				<li><a href="/bishe/middleJsp/wangguansuojianjie.jsp">网安所<br />简介
				</a></li>
				<li><a href="/bishe/middleJsp/electronicPanel.jsp">科研<br />工作
				</a></li>
				<li><a href="/bishe/middleJsp/teamBuild.jsp">队伍<br />建设
				</a></li>
				<li><a href="/bishe/middleJsp/jxzy.jsp">教学<br />资源
				</a></li>
				<li class="n1"><a href="/bishe/middleJsp/tiwen.jsp">在线<br />答疑
				</a></li>
			</ul>
		</div>
		<div class="position">
			<div class="left">
				<span id=""> 当前位置：队伍建设 </span>
			</div>
			<div class="right">
				<span id=""> 当前用户：${student1.stunickname} </span>
			</div>
		</div>
		<div class="content">
			<div class="left">
				<div class="lf1">
					<label>队伍建设</label>
					<ul>
						<!-- <li><a href="/bishe/smallJspJsp/studentUpquestion">->提问</a></li> -->

					</ul>
				</div>
				<div class="lf2">
					<span><a href=""
						style="float: right; font-family: '微软雅黑'; font-weight: 700;">More</a></span>
					<label><a href=""
						style="line-height: 182px; position: relative; left: 80px;">友情链接</a></label>
				</div>
			</div>
			<div class="right">
				<h2>导 师 简 介</h2>
				<div id="teacher" class="teacher">
					<ul>
						<!-- 						<li class="teacher1"><div class="block"></div>
							<a class="link" href="">胡 东 辉(所 长)</a></li> -->

						<div id="tea">
							<!-- 前面的东西会加在这里$("#tea").append(op);/* tea是个标记，留给后面用  */	 -->
						</div>
					</ul>
				</div>
			</div>
		</div>
		<div class="foot">
			<div class="f1">
				<span>
					地址：合肥工业大学逸夫楼511室邮编：230009电话：0551-62904642邮箱：hudh@hfut.edu.cn </span>
			</div>
			<div class="f2">
				<span> Copyright@2016NSRI_HFUT.访问总次数（45711,since March
					26,2012) </span>
			</div>
		</div>
	</div>
</body>
</html>