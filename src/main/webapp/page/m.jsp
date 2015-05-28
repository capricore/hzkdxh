<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<script type="text/javascript" src="http://www.daimajiayuan.com/download/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/hzkdxh/javascript/bootstrap-select.js"></script>
<link rel="stylesheet" type="text/css" href="/hzkdxh/css/bootstrap-select.css">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(window).on('load', function () {

        $('.selectpicker').selectpicker({
            'selectedText': 'cat'
        });

        // $('.selectpicker').selectpicker('hide');
    });
</script>
<div class="M_Col2Right">
<p class="C_Crumbs"><em>当前位置:</em> <a href="/hzkdxh">首页</a> &gt; <strong>短信群发</strong> </p>
<!-- 内容左边开始 -->
    <div class="caption_content_780"><h3>短信群发</h3></div>
    <div class="content_780">

            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="bs3Select" class="col-lg-2 control-label">选择联系人</label>
                    <div class="col-lg-10">
                        <select id="bs3Select" class="selectpicker show-tick form-control" multiple data-live-search="true">
                            <option>cow</option>
                            <option>bull</option>
                            <option>ASD</option>
                            <option>Bla</option>
                            <option>Ble</option>
                        </select>
                    </div>
                    <br /><br />
                    <label for="bs3Select" class="col-lg-2 control-label">输入短信：</label>
                    <div class="col-lg-10">
                    	<textarea style="width:545px"></textarea>
                        <br /><br />
                        <input class="buttonLogin" type="submit" value="发送" />
                    </div>
                  </div>
            </form>

    </div>
</div>
