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
            <div class="ui form">
                <form:form modelAttribute="visitor" action="/login" method="post">
                    <div class="field">
                        <label>username</label>
                        <form:input type="text" id="username" path="username" placeholder="用户名"/>
                        <form:errors path="username" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>password</label>
                        <form:input type="password" id="password" path="password" placeholder="密码"/>
                        <form:errors path="password" cssClass="error-message"/>
                    </div>

                    <div class="submit-button">
                        <button class="ui button">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
