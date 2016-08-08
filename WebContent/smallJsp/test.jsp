<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
</style>
<!-- 导入包jstl 必须写下面的配置信息 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/bishe/js/jquery-2.2.3.js"></script>
<script type="text/javascript">
//当页面加载完毕后，异步请求服务器加载省的数据
$(function(){
	//异步请求servlet,加载一级区域数据
	$.getJSON("/bishe/news/mainnewsList",function(data){
		//data就是请求得到的json格式的数据
		var op="";
		//遍历json的方法$.each
		$.each(data,function(index,item){
			//op+='<option value="'+item.newsno+'">'+item.newstitle+'----'+item.newsdate+'</option>';
		op+="<label><a href=/bishe/news/newsDisplay?newsno="+item.newsno+">"+item.newstitle+"-----"+item.newsdate+"</a></label><br/><br/>"
		});
		$("#news1").append(op);
	});
});
</script>



<h2>新闻列表</h2>
<table class="bordered">
	<thead>
		<div id="news1"></div>
	</thead>


</table>
