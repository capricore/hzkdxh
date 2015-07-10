<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

		<link rel="stylesheet" href="/hzkdxh/css/system.css" type="text/css" />
		<link rel="stylesheet" href="/hzkdxh/css/layout.css" type="text/css" /> 
		<link rel="stylesheet" href="/hzkdxh/css/css.css" type="text/css" /> 
		<link rel="stylesheet" href="/hzkdxh/css/xslider.css" type="text/css" />
		
		<script src="/hzkdxh/javascript/style.js" type="text/javascript" ></script>
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
		
		<link href="/hzkdxh/css/bootstrap-select.css" rel="stylesheet" type="text/css" >
		<link href="/hzkdxh/css/bootstrap.min.css" rel="stylesheet">
    
<div class="M_Col2Left">
							
	<div class="caption_right_170_h3"> 
		<h3>重要公告<a href="/hzkdxh/news/newsList.do?newstype=5&subtype=0&start=1">&gt;&gt; 更多</a></h3>
	</div>
	<div class="content_right_170">	
		<div id="listmarquee">
            <div id="b1">
				<c:forEach  items="${zyggList}"  var="item"  varStatus="status">
				<div class="listpro">
					<a href="/hzkdxh/news/detail.do?newsid=${item.newsid}">${item.title }</a> <!--em> {fn:substring(prop.docIntime,0,11)}</em-->
				</div>
				</c:forEach>
            </div>
           <div id="b2"></div>								
		</div>
		<script language="javascript"> 
		var speed=80
		
		b2.innerHTML=b1.innerHTML 
		function Marquee(){ 
		if(b2.offsetHeight-listmarquee.scrollTop<=0) 
		listmarquee.scrollTop = listmarquee.scrollTop - b1.offsetHeight
		else{ 
		listmarquee.scrollTop++ 
		} 
		} 
		var MyMar=setInterval(Marquee,speed) 
		listmarquee.onmouseover=function() {clearInterval(MyMar)} 
		listmarquee.onmouseout=function() {MyMar=setInterval(Marquee,speed)} 
		
		function MM_jumpMenu(selObj)
		{ //v3.0
		 if(selObj.options[selObj.selectedIndex].value != "" )
		 {
		window.open(selObj.options[selObj.selectedIndex].value,'','height=400,width=600,top=200,left=200,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=yes,status=yes');
		 }
		}
		</script> 
			
	</div>
                      
<!-- 站内搜索开始 -->
<div class="caption_right_170_h3"> 
	<h3>站内搜索</h3>				
</div>
<div class="content_right_170">
	<form method="get" name="form1" action="/hzkdxh/news/search.do" class="search" onsubmit="return query()">
		<input type="text" name="title" value=""/> 
		<button type="submit" class="btn" style="padding:0 0 0 0"> 搜索</button>
	</form>
</div>

	
	<!-- 站内搜索结束 -->
	
                      <div class="caption_right_170_h3"> 
		<h3>联系我们</h3>				
	</div>
	<div class="content_right_170">
		<div id="contact">联系人<B>:</B> &nbsp;沈斌  胡晏平<br />电话<B>:</B> &nbsp;0571-87893019<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0571-87893027<br />传真<B>:</B> &nbsp;0571-87893038<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0571-87893030<br />地址<B>:</B> &nbsp;杭州市天目山路142号1002室</font></div>
	</div>

	<div class=caption_right_170_h3> 
		<h3>相关链接</h3>				
	</div>
	<div class=content_right_170>
		<select name="select" onChange="MM_jumpMenu(this)" style="margin-left:20px; margin-bottom:8px;"> 
			<option selected="selected">------相关链接------</option>
			<option value="http://www.spb.gov.cn/">国家邮政局</option>
			<option value="http://zj.spb.gov.cn/">浙江省邮政管理局</option>
			<option value="http://zjhz.spb.gov.cn/">杭州市邮政管理局</option>
			<option value="http://www.cea.org.cn/">中国快递协会</option>
			<option value="http://www.zjkd.org/">浙江省快递行业协会</option>
			
		 </select>
	</div>
	<!-- <a href="zazhi/200902.exe" target="_blank"><img alt="" border="0" src="images/zjkdzazhi.jpg" /></a> -->

</div>