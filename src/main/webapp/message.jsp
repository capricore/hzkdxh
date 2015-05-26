<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>浙江省快递行业协会</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<meta name="keywords" content="浙江省快递行业协会" />
		<meta name="description" content="" />
		<link rel="stylesheet" href="css/system.css" type="text/css" />
		<link rel="stylesheet" href="css/layout.css" type="text/css" /> 
		<link rel="stylesheet" href="css/css.css" type="text/css" /> 
		<link href="css/xslider.css" rel="stylesheet" />
		
		<script type="text/javascript" src="javascript/style.js"></script>
		<script src="javascript/yu.js" type="text/javascript"></script>
		<script src="javascript/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="javascript/jquery.Xslider.js"></script>
	
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
function displaySubMenu(li) {
var subMenu = li.getElementsByTagName("ul")[0];
subMenu.style.display = "block";
}
function hideSubMenu(li) {
var subMenu = li.getElementsByTagName("ul")[0];
subMenu.style.display = "none";
}
</script>

		<div id="Header">
			<h1><a href="index.jsp" title="营业管理人门户"></a>
			</h1>
				<ul id="navigation" style="padding-top:2px">            
		                     <li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px" href="index.jsp"><span>首页</span></a></li>
		                     <li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px" href="list.jsp"><span>关于协会</span></a></li>
		                     <li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px" href="list.jsp"><span>协会动态</span></a></li>
		                     <li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px"><span>政策法规</span></a>
		                         <ul>
		                         <li><a href="list.jsp">行业法律法规</a></li>
		                         <li><a href="list.jsp">部门规章</a></li>
		                         <li><a href="list.jsp">规范性文件</a></li>
		                         <li><a href="list.jsp">地方性法规</a></li>
		                         <li><a href="list.jsp">其他行业要求</a></li>
		                         </ul>
		                     </li>
					<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px" href="list.jsp"><span>行业公告</span></a></li>
					<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px" href="list.jsp"><span>行业资讯</span></a></li>
					<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px" href="list.jsp"><span>行业统计</span></a></li>
					<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px" href="list.jsp"><span>会员风采</span></a></li>
					<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px" href="downloadZone.jsp"><span>下载专区</span></a></li>
					<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a style="width:96px; height:36px"><span>会员中心</span></a>
		                     	<ul>
		                         <li><a href="downloadList.jsp">下载中心</a></li>
		                         <li><a href="message.jsp">短信发送</a></li>
		                         <li><a href="messageList.jsp">短信查看</a></li>
		                         <li><a href="blackList.jsp">诚信建设</a></li>
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

