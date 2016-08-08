<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/bishe/css/jxzy.css" />
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
					<li><a href="">在线<br />答疑
					</a></li>
				</ul>
			</div>
		</div>
		<!--link结束  -->
		<div class="dqzt">
			<label class="wz" style="float: left;">当前位置:教学资源</label> <label
				class="yh" style="float: right;">当前用户:${student1.stunickname}</label>
		</div>
		<div class="content">
			<div class="left">
				<div class="left1">
					<label
						style="font-size: 20px; font-family: '微软雅黑'; font-weight: 600;">教学资源</label>
					<ul>
						<li><a href="/bishe/studentLogin.jsp">->登录</a></li>
						<li><a href="/bishe/middleJsp/informationPanel.jsp">->信息安全专业</a></li>
						<li><a href="/bishe/middleJsp/netWork.jsp">->复杂网络、无线及光网络</a></li>
						<li><a href="/bishe/middleJsp/contentSecurity.jsp">->内容安全与隐私保护</a></li>
						<li><a href="/bishe/middleJsp/electronicPanel.jsp">->电子取证与网络攻防</a></li>
						<li><a href="/bishe/middleJsp/passwordPanel.jsp">->应用密码学与访问控制</a></li>
					</ul>
				</div>
				<div class="left2">
					<a class="yqlj" href="">友情链接</a> <a class="more" href="">More</a>
				</div>
			</div>
			<div class="right">
				<!-- ////////////////////////////////////////////// -->
				<!-- resno,oldname,restype,ressubno,resupdate -->
				<table border="1" width="600">
					<label>资源管理</label>
					<tr>
						<th>文件名</th>
						<th>所属学科</th>
						<th>文件类型</th>
						<th>上传日期</th>
					</tr>
					<!-- 循环标签 -->
					<c:forEach items="${teas}" var="teas">
						<tr>
							<td><a href="/bishe/teachresource/down?resno=${teas.resno}">${teas.oldname}</a></td>
							<td>${teas.ressubno}<c:choose>
									<c:when test="${teas.ressubno==2}">信息安全专业</c:when>
									<c:when test="${teas.ressubno==3}">内容安全与隐私保护</c:when>
									<c:when test="${teas.ressubno==4}">复杂网络、无线及光网络</c:when>
									<c:when test="${teas.ressubno==5}">电子取证与网络攻防</c:when>
									<c:when test="${teas.ressubno==6}">应用密码学与网络访问控制</c:when>
								</c:choose>
							</td>
							<td><c:choose>
									<c:when test="${teas.restype==1}">教学作业</c:when>
									<c:when test="${teas.restype==2}">教学课件</c:when>
									<c:when test="${teas.restype==3}">教学视频</c:when>
								</c:choose></td>

							<td>${teas.resupdate}</td>
						</tr>
					</c:forEach>
					<!-- ////////////////////////////////////////////// -->
				</table>
			</div>
			<!-- rightde 结束   -->
		</div>
		<!--content  -->
		<div class="foot">
			<div class="f1">
				<label>
					地址：合肥工业大学逸夫楼511室邮编：230009电话：0551-62904642邮箱：hudh@hfut.edu.cn </label>
			</div>
			<div class="f2">
				<label> Copyright@2016NSRI_HFUT.访问总次数 </span>
			</div>
		</div>
</body>
</html>