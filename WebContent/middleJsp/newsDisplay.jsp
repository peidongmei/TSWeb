<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="/bishe/css/index.css">
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
		<div class="link">
			<div class="link1">
				<ul>
					<li><a href="">网站<br />首页
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
					<li><a href="#">在线<br />答疑
					</a></li>
				</ul>
			</div>
		</div>
		<div class="content1">
			<%@ include file="/smallJsp/newsDisplay.jsp"%>
		</div>

		<div class="jump">
			<div class="xn">
				<a href="">校 内 链 接</a>
			</div>
			<div class="xw">
				<a href="">校 外 链 接</a>
			</div>
		</div>
		<div class="login">
			<a href="/bishe/commonlogin.jsp">管理登陆</a>
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