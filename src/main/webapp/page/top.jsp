<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<script type="text/javascript">
$(function(){
	$('#navigation li').hover(function(){
		$(this).children('ul').stop(true,true).show('slow');
	},function(){
		$(this).children('ul').stop(true,true).hide('slow');
	});
	
});

</script>

	<div id="Header">
	<h1></h1>
		<ul id="navigation">            
                     <li><a href="/hzkdxh"><span>首页</span></a></li>
                     <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=0&start=1"><span>关于协会</span></a>
                         <ul>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=1&start=1">协会简介</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=2&start=1">协会章程</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=3&start=1">协会制度</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=1&subtype=4&start=1">协会成员</a></li>
                         </ul>
                     </li>
                     <li><a href="/hzkdxh/news/newsList.do?newstype=8&subtype=0&start=1"><span>协会动态</span></a></li>
                     <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=0&start=1"><span>政策法规</span></a>
                         <ul>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=1&start=1">行业法律法规</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=2&start=1">部门规章</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=3&start=1">规范性文件</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=4&start=1">地方性法规</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=2&subtype=5&start=1">其他行业要求</a></li>
                         </ul>
                     </li>
					 <li><a href="/hzkdxh/news/newsList.do?newstype=3&subtype=0&start=1"><span>行业统计</span></a>
					   <ul>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=3&subtype=1&start=1">统计报告</a></li>
                         <li><a href="/hzkdxh/news/newsList.do?newstype=3&subtype=2&start=1">申诉通告</a></li>
                       </ul>
					 </li>
					 <li><a href="/hzkdxh/news/newsList.do?newstype=7&subtype=0&start=1"><span>行业公告</span></a>
					 </li>
					 <li><a href="/hzkdxh/news/newsList.do?newstype=6&subtype=0&start=1"><span>行业资讯</span></a></li>
					 <li><a href="/hzkdxh/news/newsList.do?newstype=4&subtype=0&start=1"><span>会员风采</span></a>
					 </li>
					 <li><a href="/hzkdxh/news/download.do"><span>下载专区</span></a></li>
					 <li><a><span>会员中心</span></a>
                     	<ul>
                         <li><a href="/hzkdxh/news/downloadList.do">下载中心</a></li>
                         <li><a href="/hzkdxh/news/message.do">短信发送</a></li>
                         <li><a href="/hzkdxh/news/messageList.do">短信查看</a></li>
                         <li><a href="/hzkdxh/news/blackList.do">诚信建设</a></li>
                         </ul>
                     </li>
		</ul>
</div>