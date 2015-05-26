<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
	<h1 style="padding-bottom:2px"><a href="index.jsp" title="营业管理人门户"></a>
</h1>
		<ul id="navigation">            
                     <li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a href="index.jsp"><span>首页</span></a></li>
                     <li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a href="list.jsp"><span>关于协会</span></a></li>
                     <li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a href="list.jsp"><span>协会动态</span></a></li>
                     <li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a><span>政策法规</span></a>
                         <ul>
                         <li><a href="list.jsp">行业法律法规</a></li>
                         <li><a href="list.jsp">部门规章</a></li>
                         <li><a href="list.jsp">规范性文件</a></li>
                         <li><a href="list.jsp">地方性法规</a></li>
                         <li><a href="list.jsp">其他行业要求</a></li>
                         </ul>
                     </li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a href="list.jsp"><span>行业公告</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a href="list.jsp"><span>行业资讯</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a href="list.jsp"><span>行业统计</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a href="list.jsp"><span>会员风采</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a href="downloadZone.jsp"><span>下载专区</span></a></li>
			<li onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)"><a><span>会员中心</span></a>
                     	<ul>
                         <li><a href="downloadList.jsp">下载中心</a></li>
                         <li><a href="message.jsp">短信发送</a></li>
                         <li><a href="messageList.jsp">短信查看</a></li>
                         <li><a href="blackList.jsp">诚信建设</a></li>
                         </ul>
                     </li>
		</ul>
</div>