<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
		
		<link rel="stylesheet" type="text/css" href="./css/bootstrap-select.css">
		<link href="./css/bootstrap.min.css" rel="stylesheet">
    
<div class="M_Col2Left">
							
	<div class="caption_right_170_h3"> 
		<h3>重要公告<a href="list.jsp">&gt;&gt; 更多</a></h3>
	</div>
	<div class="content_right_170">	
		<div id="listmarquee">
                          	<div id="b1">
		
			<div class="listpro">
				<a href="detail.jsp">关于詹永枢同志任职的通知</a> <!--em> {fn:substring(prop.docIntime,0,11)}</em-->
			</div>
		
			<div class="listpro">
				<a href="detail.jsp">高级快递业务员职业技能鉴定培训教...</a> <!--em> {fn:substring(prop.docIntime,0,11)}</em-->
			</div>
		
			<div class="listpro">
				<a href="detail.jsp">关于缴纳2015年会费的通知</a> <!--em> {fn:substring(prop.docIntime,0,11)}</em-->
			</div>
		
			<div class="listpro">
				<a href="detail.jsp">关于批准入会的通知</a> <!--em> {fn:substring(prop.docIntime,0,11)}</em-->
			</div>
		
			<div class="listpro">
				<a href="detail.jsp">关于浙江省快递行业协会新增副会长...</a> <!--em> {fn:substring(prop.docIntime,0,11)}</em-->
			</div>
		
			<div class="listpro">
				<a href="detail.jsp">关于变更浙江省快递行业协会副会长...</a> <!--em> {fn:substring(prop.docIntime,0,11)}</em-->
			</div>
		
			<div class="listpro">
				<a href="detail.jsp">关于加入浙江省快递行业协会会员的...</a> <!--em> {fn:substring(prop.docIntime,0,11)}</em-->
			</div>
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
		</script> 
			
	</div>
                      
                      <!-- 站内搜索开始 -->
	<div class="caption_right_170_h3"> 
		<h3>站内搜索</h3>				
	</div>
	<div class="content_right_170">
		<form method="get" action="morepage.jsp" class="search">
			<input type="text" style="width:172px" name="querystring" value=""/> 
			<button type="submit" class="btn" style="padding:0 0 0 0"> 搜索</button>
		</form>
	</div>
	
	<!-- 站内搜索结束 -->
	
                      <div class="caption_right_170_h3"> 
		<h3>联系我们</h3>				
	</div>
	<div class="content_right_170">
		<div id="contact">联系人：沈斌  胡晏平<br />电话：0571-87893019    0571-87893027<br />传真：0571-87893038    0571-87893030<br />地址：杭州市天目山路142号1002室</font></div>
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