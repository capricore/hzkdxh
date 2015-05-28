<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="M_Col2Left">
                       
<div style="border:1px solid #ccc; margin-bottom:8px; padding-top:2px;">
    <!-- 天气预报开始 -->
    <iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=7" style="padding-left:5px; padding-bottom:5px" width="240" height="85" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
    <!-- 天气预报结束 -->
</div>						
                     
<!-- 站内搜索开始 -->
<div class="caption_right_170_h3"> 
	<h3>站内搜索</h3>				
</div>
<div class="content_right_170">
	<form method="get" name="form1" action="/hzkdxh/news/search.do" class="search" onsubmit="return query()">
		<input type="text" name="title" value=""/> 
		<button type="submit" class="btn"> 搜索</button>
	</form>
</div>

<!-- 站内搜索结束 -->
                     
                     <div class="caption_right_170_h3"> 
	<h3>理事会成员</h3>				
</div>
<div class="content_right_170">                             
<div id="contact" style="overflow:hidden;height:150px;  text-aling:center;">  
	<div id="c1" > 
  	<p>会长单位：<br />
                         浙江省邮政速递物流有限公司杭州分公司</p>
                         <p>副会长单位：<br />
                         浙江顺丰速运有限公司<br />
                         浙江申通快递有限公司<br />
                         浙江圆通速递有限公司<br />
                         浙江中通速递有限公司<br />
                         浙江浙韵速递有限公司<br />
                         浙江天天快递有限公司<br />
                         浙江百世网络科技有限公司<br />
                         浙江红楼国通快递有限公司<br />
                         浙江德邦货运代理有限公司
                         </p>
                         <p>理事单位：<br />
                         杭州萧申快递有限公司<br />
                         杭州圆通秋涛速递有限公司<br />
                         富阳市圆通快递有限公司
                         </p>
                         <p>监事单位：<br />
                         富阳市盛彤快件服务有限公司</p>
 	</div>  
	<div id="c2"></div> 
</div>  
<script type="text/javascript"> 
boxmove("contact","c1","c2",1); 
</script> 
</div>

	<!-- 登录开始 -->
<div class="caption_right_170_h3"> 
	<h3>会员登录</h3>				
</div>
<div class="content_right_170">
	<div class="QuickLinksRight" id="loginDiv">		
	<%String name=((String)session.getAttribute("username"));%>						
	<form id="loginForm" action="/hzkdxh/user/login.do" method="get" name="form2">
		<ul style="list-style-type:none;">
		<li><label for="">用户</label> <input type="text" name="username" value="" /> <a href="downloadZone.jsp">会员申请</a></li>
		<li><label for="">密码</label> <input type="password" name="password" value="" /> <input class="buttonLogin" type="button" name="submit" onclick="login();" value="登录"/> </li>
		</ul>
	</form>							
	</div>
	<div id="welcomeDiv" style="display:none;text-align:center" >
		<span><label id="welLabel" for=""></label></span>
	</div>
</div>

<!-- 登录结束 --> 

<div class="caption_right_170_h3"> 
	<h3>联系我们</h3>				
</div>
<div class="content_right_170">
	<div id="contact">联系人：沈斌  胡晏平<br />电话：0571-87893019    0571-87893027<br />传真：0571-87893038    0571-87893030<br />地址：杭州市天目山路142号1002室</font></div>
</div>
	<div class="caption_right_170_h3">
		<h3>留言提交<a href="/hzkdxh/mail/contact.do">更多</a></h3>
	</div>
	<div class="content_right_170">
		<div class="QuickLinksRight">
			<form id="contactForm" action="/hzkdxh/mail/send.do">
				<ul style="list-style-type: none;">
					<li><textarea name="message"
							style="height: 50px; width: 200px"></textarea></li>
					<li><label for="">联系方式</label> <input style="width: 148px"
						name="contact" value="" /></li>
					<li><input class="buttonLogin" type="button" name="submit"
						value="提交" onclick="mail();" /></li>
				</ul>
			</form>
		</div>
	</div>
	<!-- =========== 12305========= -->
<div class="tel12305"><img alt="" border="0" src="images/12305.gif" /></div>


<!-- =========== 浙江省《快递服务》标准达标企业========= -->
<div class="caption_right_170_h3"> 
	<h3>浙江省《快递服务》标准达标企业</h3>				
</div>
<div class="content_right_170">
<div id="a" style="overflow:hidden;height:200px;  text-aling:center;">  
	<div id="a1" >  
  <a href="http://www.ems.com.cn/" target="_black" ><img  src="images/f-1.gif" alt="邮政EMS"></a>
  <a href="http://www.sf-express.com/" target="_black"><img src="images/f-2.gif" alt="顺丰速运"></a>
  <a href="http://www.sto.cn/" target="_black"><img src="images/f-3.gif" alt="申通快递"></a>
  <a href="http://www.ttkdex.com/" target="_black"><img src="images/f-4.gif" alt="天天快递"></a>
  <a href="http://www.fedex.com/cn/" target="_black"><img src="images/f-5.gif" alt="联邦快递"></a>
  <a href="http://www.cn.dhl.com" target="_black"><img src="images/f-6.gif" alt="中外运敦豪"></a>
  <a href="http://www.apex100.com/" target="_black"><img src="images/f-7.gif" alt="全一快递"></a>
  <a href="http://www.ups.com/content/cn/zh/index.jsx" target="_black"><img src="images/f-8.gif" alt="UPS"></a>
  <a href="http://www.zto.cn/" target="_black"><img src="images/f-9.gif" alt="中通快递"></a>
  <a href="http://www.yto.net.cn/" target="_black"><img src="images/f-10.gif" alt="圆通快递"></a>
  <a href="http://www.yundaex.com/www/index.html" target="_black"><img src="images/f-11.gif" alt="韵达快递"></a>
  <a href="http://www.sinoair.com/" target="_black"><img src="images/f-12.gif" alt="中外运空运"></a>
  <a href="http://www.tnt.com.cn/index.asp" target="_black"><img src="images/f-13.gif" alt="TNT"></a>	
     <a href="http://www.cae.com.cn" target="_black"><img src="images/f-16.gif" alt="民航快递"></a>
  <a href="http://www.gto365.com/" target="_black"><img src="images/f-17.jpg" alt="国通快递"></a>
  <a href="http://www.zjs.com.cn/" target="_black"><img src="images/f-18.gif" alt="宅急送"></a>
  <a href="http://www.uc56.com/" target="_black"><img src="images/f-15.gif" alt="优速快递" height="40"></a> 
  <a href="http://www.800bestex.com/" target="_black"><img src="images/f-14.gif" alt="百世汇通"></a> 
  </div>  
<div id="a2"></div> 
</div>  
<script type="text/javascript"> 
boxmove("a","a1","a2",1); 
</script> 
</div>
<!-- =====协会网站链接==== -->

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

<script>

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
		    		 if(res=="sendSuccess"){
		    			 alert("发送成功！");
		    		 }else{
			    		 alert("登录成功！");
		    		 }
		    		 location.reload();
		    	 }
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

function mail(){
	submitById('contactForm');
	return false;
}


function checkLogin(){
	var username = "<%=session.getAttribute("username")%>";
	if(username !== null && username !== undefined && username !== "null"){
		 $("#loginDiv").hide();
		 var wel = '欢迎您, <%=name%>!';
		 $("#welLabel").text(wel);
    	 $("#welcomeDiv").show();
	}
}
checkLogin();

</script>