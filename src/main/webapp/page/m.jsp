<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/hzkdxh/ztree/css/demo.css" type="text/css">
<link rel="stylesheet" href="/hzkdxh/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="/hzkdxh/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="/hzkdxh/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<SCRIPT type="text/javascript">
function submitById(id){			
	//Callback handler for form submit event
	$("#"+id).submit(function(e)
	{
		  	e.preventDefault();
		    var formData = $(this).serializeArray();
		    var formURL = $(this).attr("action");
		    $.ajax({
		        url: formURL,
		    type: 'POST',
		        data:  formData,
		    success: function(transport)
		    {
		    	 var jresp = new JsonRespUtils(transport);
		    	 if (jresp.isSuccessfully()){
		    		alert("发送成功！");
		    		location.reload();
		    	 }else{
		    		 alert("发送失败！");
		    	 }
		    },
		     error: function(transport) 
		     {
		    	alert("发送失败！");
		     }          
		    });
		}); 
		$("#"+id).submit();
	}

	var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};

	/*
	*/
	
</SCRIPT>
<div class="M_Col2Right">
<p class="C_Crumbs"><em>当前位置:</em> <a href="/hzkdxh">首页</a> &gt; <a href="/hzkdxh/news/message.do">短信群发</a> </p>
<!-- 内容左边开始 -->
    <div class="caption_content_780"><h3>短信群发</h3></div>
    <div class="content_780">

            <form class="form-horizontal"  action="/hzkdxh/message/save.do" role="form" id="loginForm">
            	<input id="messageList" type="hidden" name="messageList" value="${messageList}" />
            	<input id="phone" type="hidden" name="phone" value="" />
                <div>
                <div style="float:left">选择联系人：</div>                   
                <ul id="treeDemo" class="ztree"></ul>
                
            	<div style="padding-top:5px">输入短信：                   
            	<textarea style="width:545px; margin-left:12px" name="content"></textarea>
                <br /><br />
                </div>
                <input id="sendButton" class="buttonLogin" type="button" style="margin-left:80px" onclick="onCheck();" value="发送" />
                </div>
            </form>

    </div>
</div>
<script type="text/javascript">
	
	var json = ${messageList};
	var zNodes = new Array();
	for(var i=0;i<json.length;i++){
		var zNode = new Object();
		zNode.id = json[i].id;
		zNode.pId = json[i].pid;
		zNode.name = json[i].name;
		zNode.phone = json[i].phone;
		zNodes[i] = zNode;
	}
	
	var code;

	function setCheck() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		type = { "Y":"s", "N":"ps"};
		zTree.setting.check.chkboxType = type;
	}
	
	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		setCheck();
	});
	
    function onCheck(){
        var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
        nodes=treeObj.getCheckedNodes(true),
        v="";
        for(var i=0;i<nodes.length;i++){
        	if(nodes[i].phone != "null")
	        	v+=nodes[i].phone + ",";
        }
       	$("#phone").val(v);
		submitById('loginForm');
        $("#sendButton").attr("disabled","disabled");
    	return false;
    }

</script>