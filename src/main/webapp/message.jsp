<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>杭州市快递行业协会</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<meta name="keywords" content="杭州市快递行业协会" />
		<meta name="description" content="" />
		<link rel="stylesheet" href="/hzkdxh/css/system.css" type="text/css" />
		<link rel="stylesheet" href="/hzkdxh/css/layout.css" type="text/css" /> 
		<link rel="stylesheet" href="/hzkdxh/css/css.css" type="text/css" /> 
		<link rel="stylesheet" href="/hzkdxh/css/xslider.css" type="text/css" />
		
		<script src="/hzkdxh/javascript/style.js" type="text/javascript" ></script>
		<script src="/hzkdxh/javascript/yu.js" type="text/javascript"></script>
		<script src="/hzkdxh/javascript/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="/hzkdxh/javascript/jquery.Xslider.js"></script>
		<script src="/hzkdxh/javascript/jsonRespUtils.js" type="text/javascript"></script>
		<style type="text/css" >
		<!--
		.ProImg{
			overflow: hidden;
			height: 60px;
			width: 880px;
			margin:5px auto;
			float:left;
		
		-->
		#a1 a{
			display: block;
		}
		</style>
  
		
	</head>
	<body id="Homepage" class="">
		
		<!-- Header Start -->
		 
<meta name="keywords" content="浙江,快递,浙江快递,快递协会,行业协会,浙江快递行业协会" />

<script type="text/javascript">
$(function(){
	$('#navigation li').hover(function(){
		$(this).children('ul').stop(true,true).show('slow');
	},function(){
		$(this).children('ul').stop(true,true).hide('slow');
	});
	
});

</script>

		<div id="Header">
	<h1></h1>
		<ul id="navigation" style="padding-top:2px">            
                     <li><a style="width:96px; height:36px" href="/hzkdxh"><span>首页</span></a></li>
                     <li><a style="width:96px; height:36px"><span>关于协会</span></a>
                         <ul>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=1&start=1">协会简介</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=2&start=1">协会章程</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=3&start=1">协会制度</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=4&start=1">协会成员</a></li>
                         </ul>
                     </li>
                     <li><a style="width:96px; height:36px" href="#"><span>协会动态</span></a></li>
                     <li><a style="width:96px; height:36px"><span>政策法规</span></a>
                         <ul>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=1&start=1">行业法律法规</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=2&start=1">部门规章</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=3&start=1">规范性文件</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=4&start=1">地方性法规</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=5&start=1">其他行业要求</a></li>
                         </ul>
                     </li>
					 <li><a style="width:96px; height:36px"><span>行业公告</span></a>
					   <ul>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=3&subtype=1&start=1">邮政统计报告</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=3&subtype=2&start=1">消费者申述通告</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=3&subtype=3&start=1">旺季消费提示</a></li>
                         </ul>
					 </li>
					 <li><a style="width:96px; height:36px" href="/hzkdxh/news/newsList.do?newstype=6&subtype=0&start=1"><span>行业资讯</span></a></li>
					 <li><a style="width:96px; height:36px" href="/hzkdxh/news/newsList.do?newstype=7&subtype=0&start=1"><span>行业统计</span></a></li>
					 <li><a style="width:96px; height:36px" href="/hzkdxh/news/newsList.do?newstype=4&subtype=1&start=1"><span>会员风采</span></a></li>
					 <li><a style="width:96px; height:36px" href="/hzkdxh/downloadZone.jsp"><span>下载专区</span></a></li>
					 <li><a style="width:96px; height:36px"><span>会员中心</span></a>
                     	<ul>
                         <li><a href="/hzkdxh/news/downloadList.do">下载中心</a></li>
                         <li><a href="/hzkdxh/news/message.do">短信发送</a></li>
                         <li><a href="/hzkdxh/news/messageList.do">短信查看</a></li>
                         <li><a href="/hzkdxh/news/blackList.do">诚信建设</a></li>
                         </ul>
                     </li>
		</ul>
</div>
		<!-- Header End -->
			<div id="Content">
					<div class="M_Col2">
						<%@include file="page/left2.jsp" %>
                                            
                        <%@include file="page/m.jsp" %>
					</div>
					
		</div>
		<!-- =========== 内容结束 ========= -->
		<!-- Footer Start -->
		<%@include file="page/bottom.jsp" %>
		<!--webbot bot="Include" U-Include="about.jsp" TAG="BODY" --> 
		<!-- Footer End -->
	</body>
	</html>

