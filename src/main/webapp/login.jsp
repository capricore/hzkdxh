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
		<script type="text/javascript" src="/hzkdxh/javascript/jsonRespUtils.js"></script>
	
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

function submitById(id){			
	//Callback handler for form submit event
	$("#"+id).submit(function(e)
	{
		  	e.preventDefault();
		  	var formObj = $(this);
		    var formURL = formObj.attr("action");
		    var formData = new FormData(this);
		    $.ajax({
		        url: formURL,
		    type: 'POST',
		        data:  formData,
		    mimeType:"multipart/form-data",
		    contentType: false,
		    cache: false,
		    processData:false,
		    success: function(transport)
		    {
		    	 var jresp = new JsonRespUtils(transport);
		    	 if (jresp.isSuccessfully()){
		    		 var res = jresp.getMessage();
		    		alert("登录成功！");
		    	 }
	    	 	var returnUri = '/hzkdxh<%=session.getAttribute("returnUri")%>';
		    	window.location.href= returnUri;
		    },
		     error: function(transport) 
		     {
		    	alert("登录失败！");
		     }          
		    });
		}); 
		$("#"+id).submit();
	}

function login(){
	submitById('loginForm');
	return false;
}
</script>

		<%@ include file="page/top.jsp"%>
		<!-- Header End -->
			<div id="Content">
					<div class="M_Col2">

						<%@include file="page/left2.jsp" %>
						 <div class="M_Col2Right">
						 <p class="C_Crumbs"><em>当前位置:</em> <a href="index.jsp">首页</a> &gt; <strong>会员登录</strong> </p>
						 <div class="caption_right_170_h3"> 
								<h3>会员登录</h3>				
							</div>
							<div class="content_right_170">
								<div class="QuickLinksRight" id="loginDiv">		
								<form id="loginForm" action="/hzkdxh/user/login.do" method="get" name="form2">
									<ul style="list-style-type:none;">
									<li><label for="">用户</label> <input type="text" name="username" value="" /> 
									<li><label for="">密码</label> <input type="password" name="password" value="" /> <input class="buttonLogin" type="button" name="submit" onclick="login();" value="登录"/> </li>
									</ul>
								</form>							
								</div>
							</div>
					</div>
					
		</div>
		<!-- =========== 内容结束 ========= -->
		<!-- Footer Start -->
		<%@include file="page/bottom.jsp" %>
		<!--webbot bot="Include" U-Include="about.jsp" TAG="BODY" --> 
		<!-- Footer End -->
	</body>
	</html>

