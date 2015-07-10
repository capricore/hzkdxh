<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/hzkdxh/ztree/css/demo.css" type="text/css">
<link rel="stylesheet" href="/hzkdxh/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/hzkdxh/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="/hzkdxh/ztree/js/jquery.ztree.excheck-3.5.js"></script>

<SCRIPT type="text/javascript">
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

	var zNodes =[
		{ id:1, pId:0, name:"can check 1"},
		{ id:11, pId:1, name:"can check 1-1",phone:null},
		{ id:111, pId:11, name:"can check 1-1-1",phone:123},
		{ id:112, pId:11, name:"can check 1-1-2",phone:456},
		{ id:12, pId:1, name:"can check 1-2"},
		{ id:121, pId:12, name:"can check 1-2-1"},
		{ id:122, pId:12, name:"can check 1-2-2"},
		{ id:2, pId:0, name:"can check 2"},
		{ id:21, pId:2, name:"can check 2-1"},
		{ id:22, pId:2, name:"can check 2-2"},
		{ id:221, pId:22, name:"can check 2-2-1"},
		{ id:222, pId:22, name:"can check 2-2-2"},
		{ id:23, pId:2, name:"can check 2-3"}
	];

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
        	
        v+=nodes[i].phone + ",";
        alert(nodes[i].id); //获取选中节点的值
        }
        alert(v);
    }

</SCRIPT>


<script type="text/javascript">

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

    function login(){
    	
    	
    	submitById('loginForm');
    	return false;
    }
</script>
<div class="M_Col2Right">
<p class="C_Crumbs"><em>当前位置:</em> <a href="/hzkdxh">首页</a> &gt; <a href="/hzkdxh/news/message.do">短信群发</a> </p>
<!-- 内容左边开始 -->
    <div class="caption_content_780"><h3>短信群发</h3></div>
    <div class="content_780">

            <form class="form-horizontal"  action="/hzkdxh/message/save.do" role="form" id="loginForm">
            	<input type="hidden" name="phone" value="" />
                <div class="form-group">
                    <label for="bs3Select"class="col-lg-2 control-label">选择联系人</label>
                    <div class="col-lg-10">
                    	<ul id="treeDemo" class="ztree"></ul>
                    </div>
                    <br /><br />
                    <label for="bs3Select" class="col-lg-2 control-label">输入短信：</label>
                    <div class="col-lg-10">
                    	<textarea style="width:545px" name="content"></textarea>
                        <br /><br />
                        <input class="buttonLogin" type="button" onclick="onCheck();" value="发送" />
                    </div>
                  </div>
            </form>

    </div>
</div>
