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
		<link href="/hzkdxh/css/xslider.css" rel="stylesheet" />
		
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
                        <p class="C_Crumbs"><em>当前位置:</em> <a href="/hzkdxh">首页</a> &gt; <c:choose><c:when test="${level=='1'}"><a href="/hzkdxh/news/downloadList.do">${type }</a> </c:when><c:otherwise><a href="/hzkdxh/news/download.do">${type }</a> </c:otherwise></c:choose></p>
							<!-- 内容左边开始 -->
                            <div class="caption_content_780"><h3>下载中心</h3></div>
			<div class="content_780">
				<div class="copyrightCenter">
					<ul class="ulli">
						<c:forEach  items="${downlist}"  var="item"  varStatus="status">
						<c:set var="time" value="${item.crtime}" />
						<c:set var="date" value="${fn:substring(time, 0, 10)}" />
							<li><a href="/epUpload${item.filesrc }" target="_blank">${item.filename }</a> <em>${date}</em></li>
						</c:forEach>
						
					</ul>
					<form action="/hzkdxh/news/downloadList.do" method="get">
                                          <div align="right" style="font-size:12px ">
                                           		 第 ${start} 页 共 ${pagecount} 页 
                                              <c:if test="${start==1}"><font color="#CCCCCC">上一页</font></c:if>
                                              <c:if test="${start gt 1}"><c:choose><c:when test="${level=='1'}"><a href="/hzkdxh/news/downloadList.do?start=${start-1}">上一页</a></c:when><c:otherwise><a href="/hzkdxh/news/download.do?start=${start-1}">上一页</a></c:otherwise></c:choose></c:if>
                                              <c:if test="${start==pagecount}"><font color="#CCCCCC">下一页</font></c:if>
                                              <c:if test="${start lt pagecount}"><c:choose><c:when test="${level=='1'}"><a href="/hzkdxh/news/downloadList.do?start=${start+1}">下一页</a></c:when><c:otherwise><a href="/hzkdxh/news/download.do?start=${start+1}">下一页</a></c:otherwise></c:choose></c:if> 
                                           		 转到第 
                                            <input type="text" size="2" name="start"> 页
                                            <input onMouseOver="this.className='input3'" onMouseOut="this.className='input2'" type="submit" class="input2" value="GO"/>&nbsp;&nbsp;&nbsp;
                                          </div>
                     </form>

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

