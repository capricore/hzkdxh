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
		<link href="css/xslider.css" rel="stylesheet" />
		
		<script type="text/javascript" src="/hzkdxh/javascript/style.js"></script>
		<script src="/hzkdxh/javascript/yu.js" type="text/javascript"></script>
		<script src="/hzkdxh/javascript/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="/hzkdxh/javascript/jquery.Xslider.js"></script>
		
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

		<%@ include file="page/top.jsp"%>
		<!-- Header End -->
			<div id="Content">
					<div class="M_Col2">

						<%@ include file="page/left2.jsp"%>
                        
                        <div class="M_Col2Right">
                        <p class="C_Crumbs"><em>当前位置:</em> <a href="/hzkdxh">首页</a> &gt; <strong>诚信建设</strong> </p>
							<!-- 内容左边开始 -->
                            <div class="caption_content_780"><h3>诚信建设</h3></div>
			<div class="content_780">
				<div class="copyrightCenter">
					<ul class="ulli">
						
						<li><a href="/hzkdxh/userblacklist/getList.do" target="_blank">员工黑名单</a></li>
						
						<li><a href="/hzkdxh/mercblacklist/getList.do" target="_blank">电商黑名单</a></li>
						
						<li><a href="/hzkdxh/organizationblacklist/getList.do" target="_blank">快递公司黑名单</a></li>
						
					</ul>
				</div>
			</div>
					
		</div>
		<!-- =========== 内容结束 ========= -->
		<!-- Footer Start -->
		<%@ include file="page/bottom.jsp"%>
		<!--webbot bot="Include" U-Include="about.jsp" TAG="BODY" --> 
		<!-- Footer End -->
	</body>
	</html>

