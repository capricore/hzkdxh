<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/hzkdxh/message/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/hzkdxh/javascript/bootstrap-select.js"></script>
<link rel="stylesheet" type="text/css" href="/hzkdxh/css/bootstrap-select.css">
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(window).on('load', function () {

        $('.selectpicker').selectpicker({
            'selectedText': 'cat'
        });

        // $('.selectpicker').selectpicker('hide');
    });
    
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
                <div class="form-group">
                    <label for="bs3Select"class="col-lg-2 control-label">选择联系人</label>
                    <div class="col-lg-10">
                        <select id="bs3Select" class="selectpicker show-tick form-control" multiple data-live-search="true" name="select">
	                        <c:forEach  items="${messageList}"  var="item"  varStatus="status">
		                        <option value="${item.compid }">${item.compname }</option>                
	                        </c:forEach>
	                        
                        </select>
                    </div>
                    <br /><br />
                    <label for="bs3Select" class="col-lg-2 control-label">输入短信：</label>
                    <div class="col-lg-10">
                    	<textarea style="width:545px" name="content"></textarea>
                        <br /><br />
                        <input class="buttonLogin" type="button" onclick="login();" value="发送" />
                    </div>
                  </div>
            </form>

    </div>
</div>
