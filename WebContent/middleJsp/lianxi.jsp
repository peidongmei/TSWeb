<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="/bishe/css/wangguansuo.css">
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
			<span id=""> 当前用户：${student1.stunickname} </span>
		</div>
		<div class="link">
			<div class="link1">
				<ul>
					<li><a href="/bishe/middleJsp/index.jsp">网站<br />首页
					</a></li>
				</ul>
				<ul>
					<li><a href="/bishe/middleJsp/wangguansuojianjie.jsp">网安所<br />简介
					</a></li>
				</ul>
				<ul>
					<li><a href="/bishe/middleJsp/electronicPanel.jsp">科研<br />工作
					</a></li>
				</ul>
				<ul>
					<li><a href="/bishe/middleJsp/teamBuild.jsp">队伍<br />建设
					</a></li>
				</ul>
				<ul>
					<li><a href="/bishe/middleJsp/jxzy.jsp">教学<br />资源
					</a></li>
				</ul>
				<ul>
					<li><a href="/bishe/middleJsp/tiwen.jsp">在线<br />答疑
					</a></li>
				</ul>
			</div>
		</div>
		<div class="Clear">
			<span>当前位置</span> <span>当前用户</span>
		</div>
		<div class="content">
			<div class="left">
				<div class="left1">
					<label
						style="font-size: 20px; font-family: '微软雅黑'; font-weight: 600;">网安所简介</label>
					<ul>
						<li><a href="/bishe/middleJsp/wangguansuojianjie.jsp">网安所概况</a></li>
						<li><a href="/bishe/middleJsp/lianxi.jsp">联系我们</a></li>
					</ul>
				</div>
				<div class="left2">
					<a class="yqlj" href="">友情链接</a> <a class="more" href="">More</a>
				</div>
			</div>
			<div class="right">
				<ul>
					<li><img alt="" src="/bishe/img/lianxiwomen.jpg"></li>
				</ul>
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