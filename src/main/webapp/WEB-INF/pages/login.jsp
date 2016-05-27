<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/13
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="//cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>
    <link href="/res/css/layout.css" rel="stylesheet">
</head>

<body>
<!-- 外框 -->
<div class="holder2">
    <div class="ui segment">
        <!-- 导航 -->
        <h2 class="ui left floated header">NextFilm 后台管理系统</h2>
        <div class="ui clearing divider"></div>
        <div class="ui huge breadcrumb">
            <div class="active section">登录</div>
        </div>

        <div class="inner-form-2">
            <form id="login_form" class="ui form">
                <div class="field">
                    <label>username</label>
                    <input type="text" name="username" placeholder="用户名"/>
                </div>

                <div class="field">
                    <label>password</label>
                    <input type="password" name="password" placeholder="密码"/>
                </div>

                <span hidden="hidden" id="login_error" class="error-message not-show"></span>
            </form>
            <div class="submit-button">
                <button id="submit_form" class="ui button">Submit</button>
            </div>
        </div>
    </div>
</div>
</body>

<script src="/res/js/login_validator.js"> </script>

<script>
    $(document).ready(function() {
        $("#submit_form").click(function() {
            $('.ui.form').form('validate form');
        });
    });
</script>

</html>
