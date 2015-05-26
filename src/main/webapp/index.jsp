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
		
		function login(){
		var username = document.form2.username;
		var psw = document.form2.userpass;
		if(username.value.length==0){
			alert("请输入用户名");
			username.focus();
			return false;
		}
		if(psw.value.length==0){
			alert("请输入密码");
			psw.focus();
			return false;
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
	</script>	
</head>
<body id="Homepage" class="">
	
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
								<a href="list.jsp">&gt;&gt; 更多</a>
							</div>
							<div class="TabADSCon">
								<div style="display: block;" id="tabadcontent_10">
									<div id="center_02">
										<!-- 图片轮换开始 --><div class="ttimg">
										<div id="slider3" class="slider">
                                               <div class="conbox">
                                                   <div><a href="detail.jsp" title="李克强总理看望慰问快递一线员工"><img width="262" height="182"  src="images/scroll1.JPG"></a></div>
                                                   <div><a href="detail.jsp" title="陈继松会长在第二届第一次会员代表大会讲话"><img width="262" height="182"  src="images/scroll2.jpg"></a></div>
                                                   <div><a href="detail.jsp" title="浙江省快递行业协会第二届第一次会员代表大会"><img width="262" height="182"  src="images/scroll3.jpg"></a></div>
                                                   <div><a href="detail.jsp" title="第二届第一次理事会选举"><img width="262" height="182" src="images/scroll4.jpg"></a></div>
                                                   <div><a href="detail.jsp" title="杨传堂部长视察京交会快递展区"><img width="262" height="182"  src="images/scroll5.JPG"></a></div>
                                                   <div><a href="detail.jsp" title="国家邮政局赵晓光副局长在温州调研指导"><img width="262" height="182"  src="images/scroll6.JPG"></a></div>
                                               </div>
                                               <div class="switcher">
                                               </div>
                                               <div class="showtitle" >
                                                   <a class="atitle" href="javascript:"></a>
                                               </div>
                                   		</div></div>
                                   		<!-- 图片轮换结束 -->
										<ul class="ulli">
											
											<li>
											<a href="detail.jsp">全国人大常委会决定修改五部法律 邮政法调整三全国人大常委会决定修改五部法律 ...</a> <em>												
												 2015-05-05
												</em>
											</li>
											
											<li>
											<a href="detail.jsp" target="_blank">浙江申通举办2015年春季趣味运动会</a> <em>
												 2015-05-05
												</em>
											</li>
											
											<li>
											<a href="detail.jsp" target="_blank">杨世忠秘书长前往“湖州织里中国童装城”调研</a> <em>
												 2015-04-30
												</em>
											</li>
											
											<li>
											<a href="detail.jsp" target="_blank">浙江省快递行业协会第二届三次理事会在杭州召开</a> <em>
												 2015-04-28
												</em>
											</li>
											
											<li>
											<a href="detail.jsp" target="_blank">《浙江省跨境电子商务发展三年行动计划》发布 ...</a> <em>
												 2015-04-28
												</em>
											</li>
											
											<li>
											<a href="detail.jsp" target="_blank">国家邮政局公布2015年一季度邮政行业运行情...</a> <em>
												 2015-04-27
												</em>
											</li>
											
											<li>
											<a href="detail.jsp" target="_blank">浙江省成立寄递渠道安全管理领导小组</a> <em>
												 2015-04-08
												</em>
											</li>
											
											<li>
											<a href="detail.jsp" target="_blank">湖州局搭建政银企三方合作平台破解快递企业“融...</a> <em>
												 2015-04-03
												</em>
											</li>
											
										</ul>
									</div>
								</div>
							</div>
							<div style="margin-bottom:8px;"><a href="http://www.chinapost.gov.cn/" target="_block"><img alt="" border="0" src="images/ad20091012.jpg" /></a></div>

						<!-- 内容左边开始 -->
						<div class="MainLeft">
							<div class="caption_left_470">重要公告 <a  href="list.jsp">&gt;&gt; 更多</a></div>
							<div class="content_left_470">
								<ul class="ulli">
								
									<li><a href="detail.jsp" target="_blank">马军胜局长做客人民日报两会e客厅...</a> <em> 2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">国务院正式批准设立中国（杭州）跨...</a> <em> 2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">李克强：很愿意为网购、快递和带动...</a> <em> 2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">习总书记寄语邮政：农村市场广阔，...</a> <em> 2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">浙江省政府多项措施支持行业发展</a> <em> 2015-04-03</em></li>
								
									<li><a href="detail.jsp" target="_blank">“中国快递量世界第一”引热议</a> <em> 2015-04-03</em></li>
								
									<li><a href="detail.jsp" target="_blank">李克强：发展物流快递，把新兴消费...</a> <em> 2015-04-03</em></li>
								
									<li><a href="detail.jsp" target="_blank">中国快递发展指数首次发布发展规模...</a> <em> 2015-04-03</em></li>
								

								</ul>
							</div>
						</div>
						
						<div class="MainRight">
							<div class="caption_right_298_h3"> 
								<h3>行业公告<a href="list.jsp">&gt;&gt; 更多</a></h3>
								<ul class="ulli">
								
									<li><a href="detail.jsp" target="_blank">日本邮政首次公开募股或超阿里巴巴</a><em>2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">市邮政公司和快递企业共同建设“农...</a><em>2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">杭州市电商与物流快递协同发展试点...</a><em>2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">宁波启动快递从业人员万人轮训计划</a><em>2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">义乌局“十个课题”打造“五个邮政...</a><em>2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">15家快递企业发表诚信宣言公布社...</a><em>2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">2015中国快递论坛在沪召开探讨...</a><em>2015-04-28</em></li>
								
									<li><a href="detail.jsp" target="_blank">浙江省快递行业协会前往杭州“跨境...</a><em>2015-04-03</em></li>
								
								</ul>
							</div>
					</div>

					

					<div class="MainLeft">
							<div class="caption_left_470">行业资讯 <a href="morepage.jsp?colname=zcfg">&gt;&gt; 更多</a></div>
							<div class="content_left_470">
								<ul class="ulli">
									<li><a href="detail.jsp" target="_blank">全国人大常委会决定修改五部法律 ...</a> <em>2015-05-05</em></li>
									
									<li><a href="detail.jsp" target="_blank">交通运输部 农业部 供销合作总社...</a> <em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">邮政业标委会审查通过《邮政业安全...</a> <em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">国务院印发《关于加快发展服务贸易...</a> <em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">邮政业标委会审查通过《邮政业信息...</a> <em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">北京市政府将快递服务设施用地纳入...</a> <em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">《浙江省跨境电子商务发展三年行动...</a> <em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">国家邮政局审议并原则通过《邮政业...</a> <em>2015-03-27</em></li>
									
								</ul>
							</div>
					</div>
					<div class="MainRight">
						<div class="caption_right_298_h3"> 
							<h3>行业统计<a href="list.jsp">&gt;&gt; 更多</a></h3>
							<ul class="ulli">
								<li><a href="detail.jsp" target="_blank">浙江申通举办2015年春季趣味运...</a> <em>2015-05-05</em></li>
								
								<li><a href="detail.jsp" target="_blank">中国邮政集团公司开通包裹“自提”...</a> <em>2015-04-28</em></li>
								
								<li><a href="detail.jsp" target="_blank">中通国际正式上线 七大快递公司“...</a> <em>2015-04-28</em></li>
								
								<li><a href="detail.jsp" target="_blank">FedEx联邦快递特早快递业务扩...</a> <em>2015-04-28</em></li>
								
								<li><a href="detail.jsp" target="_blank">百世汇通称2015年打造“五朵金...</a> <em>2015-04-28</em></li>
								
								<li><a href="detail.jsp" target="_blank">顺丰开通中蒙快递服务 可送至乌兰...</a> <em>2015-04-28</em></li>
								
								<li><a href="detail.jsp" target="_blank">韵达快递跨境电商平台“优递爱”正...</a> <em>2015-04-28</em></li>
								
								<li><a href="detail.jsp" target="_blank">申通快递推进偏远地区快递网络建设...</a> <em>2015-04-28</em></li>
								
							</ul>
						</div>
					</div>
					<div class="MainLeft">
							<div class="caption_left_470">会员风采<a href="list.jsp">&gt;&gt; 更多</a></div>
							<div class="content_left_470">
								<ul class="ulli">
										<li><a href="detail.jsp" target="_blank">国家邮政局关于2015年3月邮政...</a> <em>  2015-04-28</em></li>
									
										<li><a href="detail.jsp" target="_blank">国家邮政局公布2015年一季度邮...</a> <em>  2015-04-27</em></li>
									
										<li><a href="detail.jsp" target="_blank">2014年浙江省邮政行业经济运行...</a> <em>  2015-01-29</em></li>
									
										<li><a href="detail.jsp" target="_blank">国家邮政局关于2014年12月邮...</a> <em>  2015-01-29</em></li>
									
										<li><a href="detail.jsp" target="_blank">国家邮政局公布2014年邮政行业...</a> <em>  2015-01-15</em></li>
									
										<li><a href="detail.jsp" target="_blank">2014年9月浙江省邮政行业经济...</a> <em>  2014-10-22</em></li>
									
										<li><a href="detail.jsp" target="_blank">国家邮政局公布2014年9月份邮...</a> <em>  2014-10-22</em></li>
									
										<li><a href="detail.jsp" target="_blank">国家邮政局关于2014年上半年重...</a> <em>  2014-07-24</em></li>
									
								</ul>
							</div>
						</div>
						
						<div class="MainRight">
							<div class="caption_right_298_h3"> 
								<h3>政策法规<a href="list.jsp">&gt;&gt; 更多</a></h3>
								<ul class="ulli">
									<li><a href="detail.jsp" target="_blank">浙江各市局扎实开展“诚信传递你我...</a><em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">宁波电子商务孵化基地正式开园</a><em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">国家邮政局：2015年快递投诉满...</a><em>2015-04-28</em></li>
									
									<li><a href="detail.jsp" target="_blank">杭州两快递员勇救落水儿童  申通...</a><em>2014-07-24</em></li>
									
									<li><a href="detail.jsp" target="_blank">温州邮政全力支撑国际小包发展</a><em>2014-07-24</em></li>
									
									<li><a href="detail.jsp" target="_blank">浙江嘉兴深入推进“规范提升年”活...</a><em>2014-07-24</em></li>
									
									<li><a href="detail.jsp" target="_blank">浙江湖州推动快递业纳入市财政扶持...</a><em>2014-07-24</em></li>
									
									<li><a href="detail.jsp" target="_blank">广东省局进一步部署邮政行业诚信体...</a><em>2014-07-24</em></li>
									
									
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
				                               <td align="center" style="border:1px solid #FFFFFF;">
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="images/gd-1.jpg" class="listimage" />
				                                       </a>
				                                   </div>
				                               </td>
				                               <td align="center" style="border:1px solid #FFFFFF;">
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="images/gd-2.jpg" class="listimage" />
				                                       </a>
				                                   </div>
				
				                               </td>
				
				                               <td align="center" style="border:1px solid #FFFFFF;">
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="images/gd-3.jpg" class="listimage" />
				                                       </a>
				                                   </div>
				                               </td>
				                               <td align="center" style="border:1px solid #FFFFFF;">
				
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="images/gd-4.jpg" class="listimage" />
				                                       </a>
				                                   </div>
				                               </td>
				                               <td align="center" style="border:1px solid #FFFFFF;">
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="images/gd-5.jpg" class="listimage" />
				                                       </a>
				                                   </div>
				                               </td>
				                               <td align="center" style="border:1px solid #FFFFFF;">
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="images/gd-6.jpg" class="listimage" />
				                                       </a>
				                                   </div>
				
				                               </td>
				                               <td align="center" style="border:1px solid #FFFFFF;">
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="images/gd-7.jpg" class="listimage" />
				                                       </a>
				                                   </div>
				                               </td>
				                               <td align="center" style="border:1px solid #FFFFFF;">
				
				                                   <div>
				                                       <a href="#nogo" class="listname">
				                                           <img src="images/gd-8.jpg" class="listimage" />
				                                       </a>
				                                   </div>
				                               </td>
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

