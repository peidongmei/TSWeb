<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<form ction="/bishe/teacher/teacherDisplay" method="post">
	<div
		style="padding: 15px; text-align: center; line-height: 25px; font-size: 14px;">
		<table id="teach_main" style="font-size: 12px;" align="center"
			border="0" cellpadding="0" cellspacing="1">
			<tbody>
				<!-- begin -->
				<tr>
					<td><table align="center" border="0" cellpadding="0"
							cellspacing="0" width="555">
							<tbody>
								<tr>

									<td bgcolor="#336699" width="390"><strong><font
											color="#ffffff">教师信息</font></strong></td>
									<td bgcolor="#336699" width="156"><font color="#ffffff"><strong>个人照片</strong></font></td>
								</tr>
							</tbody>
						</table></td>
				</tr>
				<tr>
					<td valign="top">
						<table style="font-size: 12px;" align="center" bgcolor="#336699"
							border="0" cellpadding="4" cellspacing="1" width="553">
							<tbody>
								<tr bgcolor="#ffffff">
									<td align="center" height="24" width="84">姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
									<td width="156">${teacher.teachname}</td>
									<td align="center" width="47">性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
									<td width="74">&nbsp;&nbsp; <c:choose>
											<c:when test="${teacher.teachsex==1}">男</c:when>
											<c:when test="${teacher.teachsex==2}">女</c:when>
										</c:choose>


									</td>
									<td rowspan="7" align="center" valign="top" width="146">
										<!-- 	<img src="http://ci.hfut.edu.cn/htdocs/newcomputer/" pagespeed_url_hash="1275662579" onload="pagespeed.CriticalImages.checkImageForCriticality(this);" height="120" width="110">
               --> <img
										src="/bishe/teacherimgs/${teacher.teachphurl}.jpg"
										height="120" width="110">
									</td>

								</tr>
								<tr bgcolor="#ffffff">
									<td align="center" height="24">出生年月</td>
									<td>${teacher.teachbirth}</td>
									<td align="center">最终学位</td>
									<td>${teacher.terminaldegree}</td>
								</tr>
								<!--  <tr bgcolor="#ffffff"> 
                  <td align="center" height="24">毕业学校</td>
                  <td colspan="3">合肥工业大学计算机与信息学院</td>
                </tr>-->
								<!--  <tr bgcolor="#ffffff"> 
                  <td align="center" height="24">从事专业</td>
                  <td>教学科研  
                  </td>
                </tr>-->
								<!--<tr bgcolor="#ffffff"> 
                  <td align="center" height="24">所属院系</td>
                  <td colspan="3">计算机科学与技术系</td>
                </tr>
                <tr bgcolor="#ffffff"> 
                  <td align="center" height="24">所属科室（研究所）</td>
                  <td>网络与信息安全所  
                  </td>-->
								<tr bgcolor="#ffffff">
									<td align="center">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</td>
									<td>${teacher.teachtitle}</td>
									<!-- teachno,teachname,teachsex,teachbirth,
	terminaldegree,teachresume,resdirection,teachtitle,teachtreatise,teachprize,teachmail,
	teachphurl,teachsubjectnum from teacher -->
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td height="25" bgcolor="#336699"><strong><font
							color="#ffffff">联系方式</font></strong></td>

				</tr>
				<tr>
					<td valign="top">
						<table style="font-size: 12px;" align="center" bgcolor="#336699"
							border="0" cellpadding="2" cellspacing="1" width="555">
							<tbody>
								<tr>
									<td align="center" height="24" bgcolor="#ffffff">E－mail</td>
									<td colspan="2" bgcolor="#ffffff">${teacher.teachmail}</td>
								</tr>
								<tr>
									<td align="center" height="24" bgcolor="#ffffff">通讯地址</td>
									<td colspan="2" bgcolor="#ffffff">合肥工业大学计算机与信息学院</td>
								</tr>
								<tr>
									<td align="center" height="24" bgcolor="#ffffff">邮 编</td>
									<td colspan="2" bgcolor="#ffffff">230009</td>
								</tr>
								<tr>
									<td colspan="3" height="25" bgcolor="#336699"><strong><font
											color="#ffffff">简&nbsp;&nbsp;&nbsp;&nbsp;历</font></strong></td>
								</tr>
								<tr>
									<td align="center" bgcolor="#ffffff">&nbsp;</td>
									<td colspan="2" height="100" bgcolor="#ffffff" valign="top">${teacher.teachresume}
									</td>
								</tr>
								<tr>
									<td colspan="3" height="25" bgcolor="#336699"><font
										color="#ffffff"><strong>研究方向</strong></font></td>
								</tr>
								<tr>
									<td align="center" bgcolor="#ffffff">&nbsp;
									<td colspan="2" height="100" bgcolor="#ffffff" valign="top">${teacher.resdirection}
										<br>
									</td>
								</tr>
								<!--    <tr> 
                  <td colspan="3" height="25" bgcolor="#336699"><font color="#ffffff"><strong>教学工作</strong></font></td>
                </tr>
                <tr> 
                  <td align="center" bgcolor="#ffffff">&nbsp;</td>
                  <td colspan="2" height="100" bgcolor="#ffffff" valign="top"></td>
                </tr>
                <tr> -->
								<td colspan="3" height="25" bgcolor="#336699"><font
									color="#ffffff"><strong>获奖情况</strong></font></td>
								</tr>
								<tr>
									<td align="center" bgcolor="#ffffff">&nbsp;</td>
									<td colspan="2" height="100" bgcolor="#ffffff" valign="top">${teacher.teachprize}</td>
								</tr>
								<tr>
									<td colspan="3" height="25" bgcolor="#336699"><font
										color="#ffffff"><strong>主要论著</strong></font></td>
								</tr>
								<tr>
									<td align="center" bgcolor="#ffffff">&nbsp;</td>
									<td colspan="2" height="100" bgcolor="#ffffff" valign="top">
										${teacher.teachtreatise}</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<!-- end -->
			</tbody>
		</table>
	</div>
</form>
