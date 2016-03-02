<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	
	 <style type="text/css">
	 div.floats {/*浮动容器通用样式*/
	  position:absolute;
	  left:-1000px;
	  /*上面两句是必需的，下面看实际情况去定义了*/
	  padding:3px;
	  color:white;
	  width:150px;
	  height:410px;
	  
	 }
	div#test3,div#test4{top:200px;}/*左右定位的两个容器初始高度*/
 	</style>
    
    <script type="text/javascript">
	 var D=new Function('obj','return document.getElementById(obj);')
	 function htmlbody(){
	  return (
	   document.documentElement.clientHeight<=document.body.clientHeight
	   &&document.documentElement.clientHeight!=0
	  )
	  ?document.documentElement:document.body;
	 }
	 //浏览器滚动条位置
	function scrollLeft(){return (!window.pageYOffset)?htmlbody().scrollLeft:window.pageXOffset;}
	 function scrollTop(){return (!window.innerHeight)?htmlbody().scrollTop:window.pageYOffset;}
	 
	//实际应距左距离
	function getleft(strobjs,strLeftType,strleft){
	  var temp_getleft = 0;
	  if (strLeftType=="left"){
	   temp_getleft = scrollLeft()*1 + strleft*1;
	  }else if (strLeftType=="mid"){
	   (strleft*1<0)
	   ?temp_getleft = scrollLeft()*1 + strleft*1
	   + htmlbody().clientWidth*1/2 - strobjs.offsetWidth*1
	   :temp_getleft = (scrollLeft()*1+strleft*1 + htmlbody().clientWidth*1/2);
	  }else if (strLeftType=="right"){
	    temp_getleft 
	    = scrollLeft()*1 + htmlbody().clientWidth*1 
	    - strleft*1 - strobjs.offsetWidth*1;
	  }
	  return temp_getleft;
	 }
	 
	function moveTips(strobj,theTop,theLeft,theLeftType) {
	  var old,nowobj = D(strobj);
	  var nowleft = nowobj.style.left.replace("px","")*1;//返回在改变窗口大小或移动横滚动条前的距左部距离（数值）
	 var temp_left = getleft(nowobj,theLeftType,theLeft);//实际应距左距离
	 var re_theTop = theTop;
	  if (temp_left!=nowleft){//横向递增
	  (Math.abs(temp_left-nowleft)>3&&Math.abs(temp_left-nowleft)<600)
	   ?((temp_left>nowleft)?nowleft += Math.abs(temp_left-nowleft)/5
	   :nowleft -= Math.abs(temp_left-nowleft)/5)
	   :nowleft = temp_left;
	   nowobj.style.left = nowleft + "px";
	  }
	  if (!openweb){old = re_theTop;var openweb;}/*这是默认高度*/;
	   var pos,tt=50;
	   pos = scrollTop()*1-nowobj.offsetTop*1+re_theTop*1;
	   pos = nowobj.offsetTop+pos/10;//纵向开始递增
	  if (pos < re_theTop) pos = re_theTop;
	   if (pos != old) {nowobj.style.top = pos+"px";tt=5;}
	   old = pos;
	   setTimeout("moveTips('"+strobj+"','"+theTop+"','"+theLeft+"','"+theLeftType+"')",tt);
	 }
	</script>
	<script type="text/javascript">         
		//表单验证 
		function query(){ 
		var query = document.form1.querystring; //在这里我认为： name 代表的name 为 txtUser 的文本框 
		if(query.value.length==0){ 
			alert("请输入搜索内容"); 
			query.focus(); 
			return false; 
		}else{
			return true;
		}
		}
		
		function contact(){
		var id = document.form3.id;
		var ms = document.form3.message;
		if(id.value.length==0){
			alert("请输入联系方式");
			id.focus();
			return false;
		}
		if(ms.value.length==0){
			alert("请输入留言");
			ms.focus();
			return false;
		}
		}
	</script>
	<script language="javascript" type="text/javascript">
			$(document).ready(function () {
	
	           // 焦点图片淡隐淡现
	           $("#slider3").Xslider({
	               affect: 'fade',
	               ctag: 'div',
	               space: 3000, //时间间隔
	           });
	
	       });
			
			function MM_jumpMenu(selObj)
			{ //v3.0
			 if(selObj.options[selObj.selectedIndex].value != "" )
			 {
			window.open(selObj.options[selObj.selectedIndex].value,'','height=400,width=600,top=200,left=200,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=yes,status=yes');
			 }
			}
	</script>
<script type="text/javascript">
 $(document).ready(function(){
     var duilian = $("div.duilian");
     var duilian_close = $("a.duilian_close");
     
     var screen_w = screen.width;
     if(screen_w>1024){duilian.show();}
     $(window).scroll(function(){
         var scrollTop = $(window).scrollTop();
         duilian.stop().animate({top:scrollTop+260});
     });
     duilian_close.click(function(){
         $(this).parent().hide();
         return false;
     });
     
     
 });
 </script>    
	<script type="text/javascript">         
		//表单验证 
		function query(){ 
		var query = document.form1.querystring; //在这里我认为： name 代表的name 为 txtUser 的文本框 
		if(query.value.length==0){ 
			alert("请输入搜索内容"); 
			query.focus(); 
			return false; 
		}else{
			return true;
		}
		}
		
		function contact(){
		var id = document.form3.id;
		var ms = document.form3.message;
		if(id.value.length==0){
			alert("请输入联系方式");
			id.focus();
			return false;
		}
		if(ms.value.length==0){
			alert("请输入留言");
			ms.focus();
			return false;
		}
		}
	</script>
	<script language="javascript" type="text/javascript">
			$(document).ready(function () {
	
	           // 焦点图片淡隐淡现
	           $("#slider3").Xslider({
	               affect: 'fade',
	               ctag: 'div',
	               space: 3000, //时间间隔
	           });
	
	       });
			
			function MM_jumpMenu(selObj)
			{ //v3.0
			 if(selObj.options[selObj.selectedIndex].value != "" )
			 {
			window.open(selObj.options[selObj.selectedIndex].value,'','height=400,width=600,top=200,left=200,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=yes,status=yes');
			 }
			}
	</script>	
</head>
<body id="Homepage" class="" onload="checkLogin();">

 <div id="test3" class="floats"><a href="${add0.link}" target="_blank"><img src="/epUpload/${add0.pic}" /></a><a href="${add1.link}" target="_blank"><img src="/epUpload/${add1.pic}" style="padding-top:5px" /></a><a onclick="close3();">关闭</a></div>
 <div id="test4" class="floats"><a href="${add2.link}" target="_blank"><img src="/epUpload/${add2.pic}" /></a><a href="${add3.link}" target="_blank"><img src="/epUpload/${add3.pic}" style="padding-top:5px"/></a><a onclick="close4();" style="float:right">关闭</a></div>
 
	<script type="text/javascript">
	  moveTips('test3','200','10','left',"1");
	  moveTips('test4','200','10','right',"1");
	 </script>
	
	<script language="javascript">
	<!--
	function close3(){	 
	test3.style.display='none'               	 
	}
	function close4(){	 
	test4.style.display='none'               	 
	}
	//-->
	</script>
	
	<!-- Header Start -->
	<%@ include file="page/top.jsp"%>
	<!-- Header End -->
	
		<div id="Content">
				<div class="M_Col2">
                      
                      <%@ include file="page/left.jsp"%>
                      
                       <div class="M_Col2Right">
						<!-- 协会动态  -->
							<div class="TabADS">
								<ul>
									<li class="TasADSOn"><span>协会动态</span></li>
								</ul>
								<a href="/hzkdxh/news/newsList.do?newstype=8&subtype=0&start=1">&gt;&gt; 更多</a>
							</div>
							<div class="TabADSCon">
								<div style="display: block;" id="tabadcontent_10">
									<div id="center_02">
										<!-- 图片轮换开始 --><div class="ttimg">
										<div id="slider3" class="slider">
                                               <div class="conbox">
	                                               <c:forEach  items="${rpList}"  var="item"  varStatus="status">
	                                               	    <div><a href="${item.link}" title="${item.title}"><img width="262" height="182"  src="/epUpload/${item.filesrc}"></a></div>
	                                               </c:forEach>
                                               </div>
                                               <div class="switcher">
                                               </div>
                                               <div class="showtitle" >
                                                   <a class="atitle" href="javascript:"></a>
                                               </div>
                                   		</div></div>
                                   		<!-- 图片轮换结束 -->
										<ul class="ulli">
											<c:forEach  items="${xhdtList}"  var="item"  varStatus="status">
												<c:set var="time" value="${item.crtime}" />
												<c:set var="date" value="${fn:substring(time, 0, 10)}" />
												<li>
												<a href="/hzkdxh/news/detail.do?newsid=${item.newsid}">${item.title }</a> <em>												
													${date}
													</em>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
							<div style="margin-bottom:8px;"><a href="http://www.chinapost.gov.cn/" target="_block"><img alt="" border="0" src="images/ad20091012.jpg" /></a></div>

						<!-- 内容左边开始 -->
						<div class="MainLeft">
							<div class="caption_left_470">重要公告 <a  href="/hzkdxh/news/newsList.do?newstype=5&subtype=0&start=1">&gt;&gt; 更多</a></div>
							<div class="content_left_470">
								<ul class="ulli">
									<c:forEach  items="${zyggList}"  var="item"  varStatus="status">
										<c:set var="time" value="${item.crtime}" />
										<c:set var="date" value="${fn:substring(time, 0, 10)}" />
										<li>
										<a href="/hzkdxh/news/detail.do?newsid=${item.newsid}">${item.title }</a> <em>												
											${date}
											</em>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
						
						<div class="MainRight">
							<div class="caption_right_298_h3"> 
								<h3>行业公告<a href="/hzkdxh/news/newsList.do?newstype=7&subtype=0&start=1">&gt;&gt; 更多</a></h3>
								<ul class="ulli">
									<c:forEach  items="${hyggList}"  var="item"  varStatus="status">
										<c:set var="time" value="${item.crtime}" />
										<c:set var="date" value="${fn:substring(time, 0, 10)}" />
										<li>
										<a href="/hzkdxh/news/detail.do?newsid=${item.newsid}">${item.title }</a> <em>												
											${date}
											</em>
										</li>
									</c:forEach>
								</ul>
							</div>
					</div>

					

					<div class="MainLeft">
							<div class="caption_left_470">行业资讯 <a href="/hzkdxh/news/newsList.do?newstype=6&subtype=0&start=1">&gt;&gt; 更多</a></div>
							<div class="content_left_470">
								<ul class="ulli">
									<c:forEach  items="${hyzxList}"  var="item"  varStatus="status">
										<c:set var="time" value="${item.crtime}" />
										<c:set var="date" value="${fn:substring(time, 0, 10)}" />
										<li>
										<a href="/hzkdxh/news/detail.do?newsid=${item.newsid}">${item.title }</a> <em>												
											${date}
											</em>
										</li>
									</c:forEach>
								</ul>
							</div>
					</div>
					<div class="MainRight">
						<div class="caption_right_298_h3"> 
							<h3>行业统计<a href="/hzkdxh/news/newsList.do?newstype=3&subtype=0&start=1">&gt;&gt; 更多</a></h3>
							<ul class="ulli">
								<c:forEach  items="${hytjList}"  var="item"  varStatus="status">
									<c:set var="time" value="${item.crtime}" />
									<c:set var="date" value="${fn:substring(time, 0, 10)}" />
									<li>
									<a href="/hzkdxh/news/detail.do?newsid=${item.newsid}">${item.title }</a> <em>												
										${date}
										</em>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="MainLeft">
							<div class="caption_left_470">会员风采<a href="/hzkdxh/news/newsList.do?newstype=4&subtype=0&start=1">&gt;&gt; 更多</a></div>
							<div class="content_left_470">
								<ul class="ulli">
									<c:forEach  items="${hyfcList}"  var="item"  varStatus="status">
										<c:set var="time" value="${item.crtime}" />
										<c:set var="date" value="${fn:substring(time, 0, 10)}" />
										<li>
										<a href="/hzkdxh/news/detail.do?newsid=${item.newsid}">${item.title }</a> <em>												
											${date}
											</em>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
						
						<div class="MainRight">
							<div class="caption_right_298_h3"> 
								<h3>政策法规<a href="/hzkdxh/news/newsList.do?newstype=2&subtype=0&start=1">&gt;&gt; 更多</a></h3>
								<ul class="ulli">
									<c:forEach  items="${zcfgList}"  var="item"  varStatus="status">
										<c:set var="time" value="${item.crtime}" />
										<c:set var="date" value="${fn:substring(time, 0, 10)}" />
										<li>
										<a href="/hzkdxh/news/detail.do?newsid=${item.newsid}">${item.title }</a> <em>												
											${date}
											</em>
										</li>
									</c:forEach>
								</ul>
							</div>
					</div>
					
                       <!-- ==========中间滚动图片============== -->
					<div class="zhuantibaogao">
						<!-- 广告条 -->
						<!-- <div>
							<img alt="" border="0" src="images/adbutton.jpg" />
						</div> -->
						<!-- 中间滚动图片 -->

						<div id="outer" style="width:690px;height:105px;overflow:hidden">
				       <div id="demo">
				           <table width="565px" border="0" cellpadding="0" bgcolor="#FFFFFF">
				               <tr>
				                   <td id="demo1" valign="top">
				                       <table border="0" align="center" cellpadding="0" cellspacing="0">
				                           <tr valign="top">
			                           		 <c:forEach  items="${spList}"  var="item"  varStatus="status">
				                               <td align="center" style="border:1px solid #FFFFFF;">
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="/epUpload/${item.picturesrc}" class="listimage" />
				                                       </a>
				                                   </div>
				                                </td>
			                                  </c:forEach>
				                           </tr>
				                       </table>
				                   </td>
				
				                   <td id="demo2" valign="top"></td>
				               </tr>
				           </table>
				       </div>
						<script type="text/javascript" language="javascript">
							window.onload=function(){
								function getElement(id){
									return document.getElementById(id);
								}
								var speed=30;//滚动速度
								var demo=getElement("demo");
								var demo2=getElement("demo2");
								var demo1=getElement("demo1");
								demo2.innerHTML=demo1.innerHTML//复制demo1中的图片到demo2中
						
								function Marqueeleft(){//向左滚动
									if(demo2.offsetWidth-demo.scrollLeft<=0)
										demo.scrollLeft-=demo1.offsetWidth
									else
										demo.scrollLeft++
								}
						
								function Marqueeright(){//向右滚动
									if(demo2.offsetWidth-demo.scrollLeft>=565)
										demo.scrollLeft+=demo1.offsetWidth
									else
										demo.scrollLeft--
								}
						
								var MyMar=setInterval(Marqueeleft,speed)//自动开始滚动
								Direction='Left';//设定初始方向为向左滚
								demo.onmouseover=function() {clearInterval(MyMar)}
								demo.onmouseout=function() {
									if(Direction=='Left'){
										MyMar=setInterval(Marqueeleft,speed)
									}else if(Direction=='Right'){
										MyMar=setInterval(Marqueeright,speed)
									}
								};
							}
						</script>
   					</div>

					</div>
                       	
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
