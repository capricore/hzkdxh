<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<style type="text/css">
<!--
.ProImg {
	overflow: hidden;
	height: 60px;
	width: 880px;
	margin: 5px auto;
	float: left;
	-->
	#
	a1
	a{
	display
	:
	block;
}
</style>

<script type="text/javascript">
	//表单验证 
	function query() {
		var query = document.form1.querystring; //在这里我认为： name 代表的name 为 txtUser 的文本框 
		if (query.value.length == 0) {
			alert("请输入搜索内容");
			query.focus();
			return false;
		} else {
			return true;
		}
	}

	function login() {
		var username = document.form2.username;
		var psw = document.form2.userpass;
		if (username.value.length == 0) {
			alert("请输入用户名");
			username.focus();
			return false;
		}
		if (psw.value.length == 0) {
			alert("请输入密码");
			psw.focus();
			return false;
		}
	}

	function contact() {
		var id = document.form3.id;
		var ms = document.form3.message;
		if (id.value.length == 0) {
			alert("请输入联系方式");
			id.focus();
			return false;
		}
		if (ms.value.length == 0) {
			alert("请输入留言");
			ms.focus();
			return false;
		}
	}
</script>


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
		<h1 style="padding-bottom: 2px">
			<a href="index.jsp" title="营业管理人门户"></a>
		</h1>
		<ul id="navigation">
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a
				href="index.html"><span>首页</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a
				href="list.html"><span>关于协会</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a
				href="list.html"><span>协会动态</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a><span>政策法规</span></a>
				<ul>
					<li><a href="#">行业法律法规</a></li>
					<li><a href="#">部门规章</a></li>
					<li><a href="#">规范性文件</a></li>
					<li><a href="#">地方性法规</a></li>
					<li><a href="#">其他行业要求</a></li>
				</ul></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a
				href="list.html"><span>行业公告</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a
				href="list.html"><span>行业资讯</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a
				href="list.html"><span>行业统计</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a
				href="list.html"><span>会员风采</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a
				href="downloadZone.html"><span>下载专区</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a><span>会员中心</span></a>
				<ul>
					<li><a href="downlist.html">下载中心</a></li>
					<li><a href="message.html">短信发送</a></li>
					<li><a href="messageList.html">短信查看</a></li>
					<li><a href="blackList.html">诚信建设</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- Header End -->
	<div id="Content">
		<div class="M_Col2">

			<div class="M_Col2Left">
				<div class="caption_right_170_h3">
					<h3>
						重要公告<a href="morepage.jsp?colname=zygg">&gt;&gt; 更多</a>
					</h3>
				</div>
				<div class="content_right_170">
					<div id="listmarquee">
						<div id="b1">

							<div class="listpro">
								<a href="documentDetail.jsp?docid=2417">关于詹永枢同志任职的通知</a>
								<!--em> {fn:substring(prop.docIntime,0,11)}</em-->
							</div>

							<div class="listpro">
								<a href="documentDetail.jsp?docid=2138">高级快递业务员职业技能鉴定培训教...</a>
								<!--em> {fn:substring(prop.docIntime,0,11)}</em-->
							</div>

							<div class="listpro">
								<a href="documentDetail.jsp?docid=2023">关于缴纳2015年会费的通知</a>
								<!--em> {fn:substring(prop.docIntime,0,11)}</em-->
							</div>

							<div class="listpro">
								<a href="documentDetail.jsp?docid=2022">关于批准入会的通知</a>
								<!--em> {fn:substring(prop.docIntime,0,11)}</em-->
							</div>

							<div class="listpro">
								<a href="documentDetail.jsp?docid=2021">关于浙江省快递行业协会新增副会长...</a>
								<!--em> {fn:substring(prop.docIntime,0,11)}</em-->
							</div>

							<div class="listpro">
								<a href="documentDetail.jsp?docid=2020">关于变更浙江省快递行业协会副会长...</a>
								<!--em> {fn:substring(prop.docIntime,0,11)}</em-->
							</div>

							<div class="listpro">
								<a href="documentDetail.jsp?docid=2019">关于加入浙江省快递行业协会会员的...</a>
								<!--em> {fn:substring(prop.docIntime,0,11)}</em-->
							</div>
						</div>
						<div id="b2"></div>
					</div>
					<script language="javascript">
						var speed = 80

						b2.innerHTML = b1.innerHTML
						function Marquee() {
							if (b2.offsetHeight - listmarquee.scrollTop <= 0)
								listmarquee.scrollTop = listmarquee.scrollTop
										- b1.offsetHeight
							else {
								listmarquee.scrollTop++
							}
						}
						var MyMar = setInterval(Marquee, speed)
						listmarquee.onmouseover = function() {
							clearInterval(MyMar)
						}
						listmarquee.onmouseout = function() {
							MyMar = setInterval(Marquee, speed)
						}
					</script>

				</div>

				<!-- 站内搜索开始 -->
				<div class="caption_right_170_h3">
					<h3>站内搜索</h3>
				</div>
				<div class="content_right_170">
					<form method="get" name="form1" action="morepage.jsp"
						class="search" onsubmit="return query()">
						<input type="text" name="querystring" value="" />
						<button type="submit" class="btn">搜索</button>
					</form>
				</div>

				<!-- 站内搜索结束 -->
				<div
					style="border: 1px solid #ccc; margin-bottom: 10px; padding-top: 8px;">


					<!-- 天气预报开始 -->
					<iframe name="weather_inc"
						src="http://i.tianqi.com/index.php?c=code&id=7"
						style="padding-left: 5px; padding-bottom: 5px" width="240"
						height="90" frameborder="0" marginwidth="0" marginheight="0"
						scrolling="no"></iframe>

					<!-- 天气预报结束 -->
				</div>

				<div class="caption_right_170_h3">
					<h3>理事会成员</h3>
				</div>
				<div class="content_right_170">
					<div id="contact"
						style="overflow: hidden; height: 200px; text-aling: center;">
						<div id="c1">
							<p>
								会长单位：<br /> 浙江省邮政速递物流有限公司杭州分公司
							</p>
							<p>
								副会长单位：<br /> 浙江顺丰速运有限公司<br /> 浙江申通快递有限公司<br /> 浙江圆通速递有限公司<br />
								浙江中通速递有限公司<br /> 浙江浙韵速递有限公司<br /> 浙江天天快递有限公司<br />
								浙江百世网络科技有限公司<br /> 浙江红楼国通快递有限公司<br /> 浙江德邦货运代理有限公司
							</p>
							<p>
								理事单位：<br /> 杭州萧申快递有限公司<br /> 杭州圆通秋涛速递有限公司<br /> 富阳市圆通快递有限公司
							</p>
							<p>
								监事单位：<br /> 富阳市盛彤快件服务有限公司
							</p>
						</div>
						<div id="c2"></div>
					</div>
					<script type="text/javascript">
						boxmove("contact", "c1", "c2", 1);
					</script>
				</div>

				<!-- 登录开始 -->
				<div class="caption_right_170_h3">
					<h3>会员登录</h3>
				</div>
				<div class="content_right_170">
					<div class="QuickLinksRight">
						<form action="login.jsp" method="get" name="form2"
							onsubmit="return login()">
							<ul style="list-style-type: none;">
								<li><label for="">用户</label> <input type="text"
									name="username" value="" /> <a href="downloadZone.html">会员申请</a></li>
								<li><label for="">密码</label> <input type="password"
									name="userpass" value="" /> <input class="buttonLogin"
									type="submit" name="submit" value="登录" /></li>
							</ul>
						</form>
					</div>

				</div>

				<!-- 登录结束 -->

				<div class="caption_right_170_h3">
					<h3>联系我们</h3>
				</div>
				<div class="content_right_170">
					<div id="contact">
						联系人：沈斌 胡晏平<br />电话：0571-87893019 0571-87893027<br />传真：0571-87893038
						0571-87893030<br />地址：杭州市天目山路142号1002室</font>
					</div>
				</div>

				<div class="caption_right_170_h3">
					<h3>留言提交</h3>
				</div>
				<div class="content_right_170">
					<div class="QuickLinksRight">
						<form name="form3" action="mes.jsp" method="get"
							onsubmit="return contact()">
							<ul style="list-style-type: none;">

								<li><textarea name="message" style="width: 200px"></textarea></li>
								<li><label for="">联系方式</label> <input style="width: 148px"
									name="id" value="" /></li>
								<li><input class="buttonLogin" type="submit" name="submit"
									value="提交" /></li>
							</ul>
						</form>
					</div>
				</div>

				<!-- =========== 12305========= -->
				<div class="tel12305">
					<img alt="" border="0" src="images/12305.gif" />
				</div>


				<!-- =========== 浙江省《快递服务》标准达标企业========= -->
				<div class="caption_right_170_h3">
					<h3>浙江省《快递服务》标准达标企业</h3>
				</div>
				<div class="content_right_170">
					<div id="a"
						style="overflow: hidden; height: 300px; text-aling: center;">
						<div id="a1">
							<a href="http://www.ems.com.cn/" target="_black"><img
								src="images/f-1.gif" alt="邮政EMS"></a> <a
								href="http://www.sf-express.com/" target="_black"><img
								src="images/f-2.gif" alt="顺丰速运"></a> <a
								href="http://www.sto.cn/" target="_black"><img
								src="images/f-3.gif" alt="申通快递"></a> <a
								href="http://www.ttkdex.com/" target="_black"><img
								src="images/f-4.gif" alt="天天快递"></a> <a
								href="http://www.fedex.com/cn/" target="_black"><img
								src="images/f-5.gif" alt="联邦快递"></a> <a
								href="http://www.cn.dhl.com" target="_black"><img
								src="images/f-6.gif" alt="中外运敦豪"></a> <a
								href="http://www.apex100.com/" target="_black"><img
								src="images/f-7.gif" alt="全一快递"></a> <a
								href="http://www.ups.com/content/cn/zh/index.jsx"
								target="_black"><img src="images/f-8.gif" alt="UPS"></a> <a
								href="http://www.zto.cn/" target="_black"><img
								src="images/f-9.gif" alt="中通快递"></a> <a
								href="http://www.yto.net.cn/" target="_black"><img
								src="images/f-10.gif" alt="圆通快递"></a> <a
								href="http://www.yundaex.com/www/index.html" target="_black"><img
								src="images/f-11.gif" alt="韵达快递"></a> <a
								href="http://www.sinoair.com/" target="_black"><img
								src="images/f-12.gif" alt="中外运空运"></a> <a
								href="http://www.tnt.com.cn/index.asp" target="_black"><img
								src="images/f-13.gif" alt="TNT"></a> <a
								href="http://www.cae.com.cn" target="_black"><img
								src="images/f-16.gif" alt="民航快递"></a> <a
								href="http://www.gto365.com/" target="_black"><img
								src="images/f-17.jpg" alt="国通快递"></a> <a
								href="http://www.zjs.com.cn/" target="_black"><img
								src="images/f-18.gif" alt="宅急送"></a> <a
								href="http://www.uc56.com/" target="_black"><img
								src="images/f-15.gif" alt="优速快递" height="40"></a> <a
								href="http://www.800bestex.com/" target="_black"><img
								src="images/f-14.gif" alt="百世汇通"></a>
						</div>
						<div id="a2"></div>
					</div>
					<script type="text/javascript">
						boxmove("a", "a1", "a2", 1);
					</script>
				</div>
				<!-- =====协会网站链接==== -->

				<div class=caption_right_170_h3>
					<h3>行业链接</h3>
				</div>
				<div class=content_right_170>
					<select name="select" onChange="MM_jumpMenu(this)"
						style="margin-left: 20px; margin-bottom: 8px;">
						<option selected="selected">------快递行业协会网站------</option>
						<option value="http://www.gdea.org/index.asp">广东省快递行业协会</option>
						<option value="http://www.fjkdxh.com/">福建省快递行业协会</option>
						<option value="http://www.sdkdw.com">山东省快递行业协会</option>
						<option value="http://www.shkdxh.com/">上海市快递协会</option>

					</select>
				</div>
				<!-- <a href="zazhi/200902.exe" target="_blank"><img alt="" border="0" src="images/zjkdzazhi.jpg" /></a> -->

			</div>

			<div class="M_Col2Right">
				<!-- 协会动态  -->
				<div class="TabADS">
					<ul>
						<li class="TasADSOn"><span>协会动态</span></li>
					</ul>
					<a href="morepage.jsp?colname=xhdt">&gt;&gt; 更多</a>
				</div>
				<div class="TabADSCon">
					<div style="display: block;" id="tabadcontent_10">
						<div id="center_02">
							<!-- 图片轮换开始 -->
							<div class="ttimg">
								<div id="slider3" class="slider">
									<div class="conbox">
										<div>
											<a href="#" title="李克强总理看望慰问快递一线员工"><img width="262"
												height="182" src="images/scroll1.JPG"></a>
										</div>
										<div>
											<a href="#" title="陈继松会长在第二届第一次会员代表大会讲话"><img width="262"
												height="182" src="images/scroll2.jpg"></a>
										</div>
										<div>
											<a href="#" title="浙江省快递行业协会第二届第一次会员代表大会"><img
												width="262" height="182" src="images/scroll3.jpg"></a>
										</div>
										<div>
											<a href="#" title="第二届第一次理事会选举"><img width="262"
												height="182" src="images/scroll4.jpg"></a>
										</div>
										<div>
											<a href="#" title="杨传堂部长视察京交会快递展区"><img width="262"
												height="182" src="images/scroll5.JPG"></a>
										</div>
										<div>
											<a href="#" title="国家邮政局赵晓光副局长在温州调研指导"><img width="262"
												height="182" src="images/scroll6.JPG"></a>
										</div>
									</div>
									<div class="switcher"></div>
									<div class="showtitle">
										<a class="atitle" href="javascript:"></a>
									</div>
								</div>
							</div>
							<!-- 图片轮换结束 -->
							<ul class="ulli">

								<li><a href="documentDetail.jsp?docid=2875" target="_blank">全国人大常委会决定修改五部法律
										邮政法调整三...</a> <em> 2015-05-05 </em></li>

								<li><a href="documentDetail.jsp?docid=2874" target="_blank">浙江申通举办2015年春季趣味运动会</a>
									<em> 2015-05-05 </em></li>

								<li><a href="documentDetail.jsp?docid=2873" target="_blank">杨世忠秘书长前往“湖州织里中国童装城”调研</a>
									<em> 2015-04-30 </em></li>

								<li><a href="documentDetail.jsp?docid=2854" target="_blank">浙江省快递行业协会第二届三次理事会在杭州召开</a>
									<em> 2015-04-28 </em></li>

								<li><a href="documentDetail.jsp?docid=2837" target="_blank">《浙江省跨境电子商务发展三年行动计划》发布
										...</a> <em> 2015-04-28 </em></li>

								<li><a href="documentDetail.jsp?docid=2835" target="_blank">国家邮政局公布2015年一季度邮政行业运行情...</a>
									<em> 2015-04-27 </em></li>

								<li><a href="documentDetail.jsp?docid=2834" target="_blank">浙江省成立寄递渠道安全管理领导小组</a>
									<em> 2015-04-08 </em></li>

								<li><a href="documentDetail.jsp?docid=2822" target="_blank">湖州局搭建政银企三方合作平台破解快递企业“融...</a>
									<em> 2015-04-03 </em></li>

							</ul>
						</div>
					</div>
				</div>
				<div style="margin-bottom: 8px;">
					<a href="http://www.chinapost.gov.cn/" target="_block"><img
						alt="" border="0" src="images/ad20091012.jpg" /></a>
				</div>

				<!-- 内容左边开始 -->
				<div class="MainLeft">
					<!-- =========TAB块========== -->

					<!-- =========== 热点聚焦 ============== -->
					<div class="caption_left_470">
						政策法规 <a href="morepage.jsp?colname=rdjj">&gt;&gt; 更多</a>
					</div>
					<div class="content_left_470">
						<ul class="ulli">

							<li><a href="documentDetail.jsp?docid=2845" target="_blank">马军胜局长做客人民日报两会e客厅...</a>
								<em> 2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2844" target="_blank">国务院正式批准设立中国（杭州）跨...</a>
								<em> 2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2843" target="_blank">李克强：很愿意为网购、快递和带动...</a>
								<em> 2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2842" target="_blank">习总书记寄语邮政：农村市场广阔，...</a>
								<em> 2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2826" target="_blank">浙江省政府多项措施支持行业发展</a>
								<em> 2015-04-03</em></li>

							<li><a href="documentDetail.jsp?docid=2825" target="_blank">“中国快递量世界第一”引热议</a>
								<em> 2015-04-03</em></li>

							<li><a href="documentDetail.jsp?docid=2824" target="_blank">李克强：发展物流快递，把新兴消费...</a>
								<em> 2015-04-03</em></li>

							<li><a href="documentDetail.jsp?docid=2823" target="_blank">中国快递发展指数首次发布发展规模...</a>
								<em> 2015-04-03</em></li>


						</ul>
					</div>
				</div>

				<div class="MainRight">
					<!-- ===================行业资讯====================== -->
					<div class="caption_right_298_h3">
						<h3>
							行业公告<a href="morepage.jsp?colname=hyzx">&gt;&gt; 更多</a>
						</h3>
						<ul class="ulli">
							<c:forEach items="${hyList}" var="item" varStatus="status">
								<c:set var="time" value="${item.crtime}" />
								<c:set var="date" value="${fn:substring(time, 0, 10)}" />
									<li><a href="news/newsDetail.do?newsid=${item.newsid}" target="_blank" title="${item.title}">${item.title}</a><em>${date}</em></li>
							</c:forEach>
						</ul>
					</div>
				</div>



				<div class="MainLeft">
					<!-- =========== 政策法规 ============== -->
					<div class="caption_left_470">
						行业资讯 <a href="morepage.jsp?colname=zcfg">&gt;&gt; 更多</a>
					</div>
					<div class="content_left_470">
						<ul class="ulli">
							<li><a href="documentDetail.jsp?docid=2876" target="_blank">全国人大常委会决定修改五部法律
									...</a> <em>2015-05-05</em></li>

							<li><a href="documentDetail.jsp?docid=2849" target="_blank">交通运输部
									农业部 供销合作总社...</a> <em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2848" target="_blank">邮政业标委会审查通过《邮政业安全...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2847" target="_blank">国务院印发《关于加快发展服务贸易...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2846" target="_blank">邮政业标委会审查通过《邮政业信息...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2839" target="_blank">北京市政府将快递服务设施用地纳入...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2838" target="_blank">《浙江省跨境电子商务发展三年行动...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2813" target="_blank">国家邮政局审议并原则通过《邮政业...</a>
								<em>2015-03-27</em></li>

						</ul>
					</div>
					<!-- =========== 行业统计 ============== -->
					<div class="caption_left_470">
						行业统计 <a href="morepage.jsp?colname=hytj">&gt;&gt; 更多</a>
					</div>
					<div class="content_left_470">
						<ul class="ulli">
							<li><a href="documentDetail.jsp?docid=2840" target="_blank">国家邮政局关于2015年3月邮政...</a>
								<em> 2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2836" target="_blank">国家邮政局公布2015年一季度邮...</a>
								<em> 2015-04-27</em></li>

							<li><a href="documentDetail.jsp?docid=2803" target="_blank">2014年浙江省邮政行业经济运行...</a>
								<em> 2015-01-29</em></li>

							<li><a href="documentDetail.jsp?docid=2801" target="_blank">国家邮政局关于2014年12月邮...</a>
								<em> 2015-01-29</em></li>

							<li><a href="documentDetail.jsp?docid=2795" target="_blank">国家邮政局公布2014年邮政行业...</a>
								<em> 2015-01-15</em></li>

							<li><a href="documentDetail.jsp?docid=2753" target="_blank">2014年9月浙江省邮政行业经济...</a>
								<em> 2014-10-22</em></li>

							<li><a href="documentDetail.jsp?docid=2752" target="_blank">国家邮政局公布2014年9月份邮...</a>
								<em> 2014-10-22</em></li>

							<li><a href="documentDetail.jsp?docid=2696" target="_blank">国家邮政局关于2014年上半年重...</a>
								<em> 2014-07-24</em></li>

						</ul>
					</div>
				</div>
				<div class="MainRight">
					<!-- =========== 会员风采========= -->
					<div class="caption_right_298_h3">
						<h3>
							会员风采<a href="morepage.jsp?colname=hyfc">&gt;&gt; 更多</a>
						</h3>
						<ul class="ulli">
							<li><a href="documentDetail.jsp?docid=2877" target="_blank">浙江申通举办2015年春季趣味运...</a>
								<em>2015-05-05</em></li>

							<li><a href="documentDetail.jsp?docid=2871" target="_blank">中国邮政集团公司开通包裹“自提”...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2870" target="_blank">中通国际正式上线
									七大快递公司“...</a> <em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2869" target="_blank">FedEx联邦快递特早快递业务扩...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2868" target="_blank">百世汇通称2015年打造“五朵金...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2867" target="_blank">顺丰开通中蒙快递服务
									可送至乌兰...</a> <em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2866" target="_blank">韵达快递跨境电商平台“优递爱”正...</a>
								<em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2865" target="_blank">申通快递推进偏远地区快递网络建设...</a>
								<em>2015-04-28</em></li>

						</ul>
					</div>
					<!-- =========== 社会广角========= -->
					<div class="caption_right_298_h3">
						<h3>
							社会广角<a href="morepage.jsp?colname=shgj">&gt;&gt; 更多</a>
						</h3>
						<ul class="ulli">
							<li><a href="documentDetail.jsp?docid=2853" target="_blank">浙江各市局扎实开展“诚信传递你我...</a><em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2852" target="_blank">宁波电子商务孵化基地正式开园</a><em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2851" target="_blank">国家邮政局：2015年快递投诉满...</a><em>2015-04-28</em></li>

							<li><a href="documentDetail.jsp?docid=2688" target="_blank">杭州两快递员勇救落水儿童
									申通...</a><em>2014-07-24</em></li>

							<li><a href="documentDetail.jsp?docid=2685" target="_blank">温州邮政全力支撑国际小包发展</a><em>2014-07-24</em></li>

							<li><a href="documentDetail.jsp?docid=2682" target="_blank">浙江嘉兴深入推进“规范提升年”活...</a><em>2014-07-24</em></li>

							<li><a href="documentDetail.jsp?docid=2681" target="_blank">浙江湖州推动快递业纳入市财政扶持...</a><em>2014-07-24</em></li>

							<li><a href="documentDetail.jsp?docid=2680" target="_blank">广东省局进一步部署邮政行业诚信体...</a><em>2014-07-24</em></li>


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

					<div id="outer"
						style="width: 690px; height: 105px; overflow: hidden">
						<div id="demo">
							<table width="565px" border="0" cellpadding="0" bgcolor="#FFFFFF">
								<tr>
									<td id="demo1" valign="top">
										<table border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr valign="top">
												<td align="center" style="border: 1px solid #FFFFFF;">
													<div>
														<a href="#nogo" class="listname"> <img
															src="images/gd-1.jpg" class="listimage" />
														</a>
													</div>
												</td>
												<td align="center" style="border: 1px solid #FFFFFF;">
													<div>
														<a href="#nogo" class="listname"> <img
															src="images/gd-2.jpg" class="listimage" />
														</a>
													</div>

												</td>

												<td align="center" style="border: 1px solid #FFFFFF;">
													<div>
														<a href="#nogo" class="listname"> <img
															src="images/gd-3.jpg" class="listimage" />
														</a>
													</div>
												</td>
												<td align="center" style="border: 1px solid #FFFFFF;">

													<div>
														<a href="#nogo" class="listname"> <img
															src="images/gd-4.jpg" class="listimage" />
														</a>
													</div>
												</td>
												<td align="center" style="border: 1px solid #FFFFFF;">
													<div>
														<a href="#nogo" class="listname"> <img
															src="images/gd-5.jpg" class="listimage" />
														</a>
													</div>
												</td>
												<td align="center" style="border: 1px solid #FFFFFF;">
													<div>
														<a href="#nogo" class="listname"> <img
															src="images/gd-6.jpg" class="listimage" />
														</a>
													</div>

												</td>
												<td align="center" style="border: 1px solid #FFFFFF;">
													<div>
														<a href="#nogo" class="listname"> <img
															src="images/gd-7.jpg" class="listimage" />
														</a>
													</div>
												</td>
												<td align="center" style="border: 1px solid #FFFFFF;">

													<div>
														<a href="#nogo" class="listname"> <img
															src="images/gd-8.jpg" class="listimage" />
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
							window.onload = function() {
								function getElement(id) {
									return document.getElementById(id);
								}
								var speed = 30;//滚动速度
								var demo = getElement("demo");
								var demo2 = getElement("demo2");
								var demo1 = getElement("demo1");
								demo2.innerHTML = demo1.innerHTML//复制demo1中的图片到demo2中

								function Marqueeleft() {//向左滚动
									if (demo2.offsetWidth - demo.scrollLeft <= 0)
										demo.scrollLeft -= demo1.offsetWidth
									else
										demo.scrollLeft++
								}

								function Marqueeright() {//向右滚动
									if (demo2.offsetWidth - demo.scrollLeft >= 565)
										demo.scrollLeft += demo1.offsetWidth
									else
										demo.scrollLeft--
								}

								var MyMar = setInterval(Marqueeleft, speed)//自动开始滚动
								Direction = 'Left';//设定初始方向为向左滚
								demo.onmouseover = function() {
									clearInterval(MyMar)
								}
								demo.onmouseout = function() {
									if (Direction == 'Left') {
										MyMar = setInterval(Marqueeleft, speed)
									} else if (Direction == 'Right') {
										MyMar = setInterval(Marqueeright, speed)
									}
								};
							}
						</script>
					</div>

				</div>

			</div>
		</div>


		<!-- =========== 浙江省《快递服务》标准达标企业 ========= -->
		<div class="friendLink">
			<strong></strong> <a href="http://www.chinapost.gov.cn/"
				target="_block"><img alt="中华人民共和国国家邮政局" border="0"
				src="images/yq-1.jpg" style="margin-bottom: 5px; margin-top: 2px;" /></a>
			<a href="http://zj.spb.gov.cn/" target="_block"><img
				alt="浙江省邮政管理局" border="0" src="images/yq-2.jpg"
				style="margin-bottom: 5px; margin-top: 2px;" /></a> <a
				href="http://www.cea.org.cn/" target="_block"><img alt="中国快递协会"
				border="0" src="images/yq-7.jpg" style="margin-bottom: 5px;" /></a> <a
				href="http://www.moc.gov.cn/" target="_block"><img
				alt="中华人民共和国交通运输部" border="0" src="images/yq-4.jpg"
				style="margin-bottom: 5px;" /></a> <a href="http://mjzz.zjmz.gov.cn/"
				target="_block"><img alt="浙江省民间管理局" border="0"
				src="images/yq-5.jpg" style="margin-bottom: 5px;" /></a>

		</div>
	</div>
	<!-- =========== 内容结束 ========= -->
	<!-- Footer Start -->





	<div id="Footer">
		<div>
			<ul>
				<li><a href="about.jsp">关于协会</a></li>
				<li><a href="recruit.jsp">加入我们</a></li>
			</ul>
		</div>
		<div class="copyright">
			<span>地 址：浙江省杭州市天目山路142号1002室 邮 编：310007 <br />电话：0571-87893019
				0571-87893027 传真：0571-87893038 0571-87893030 版权所有&copy; 2015
				杭州市快递行业协会
			</span>
		</div>
	</div>
	<!--webbot bot="Include" U-Include="about.jsp" TAG="BODY" -->
	<!-- Footer End -->
</body>
</html>

