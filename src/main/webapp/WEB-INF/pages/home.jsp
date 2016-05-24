<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/13
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="/res/css/layout.css" rel="stylesheet">
</head>

<body>
<!-- 外框 -->
<div class="holder1">
    <div class="ui segment">
        <!-- 导航 -->
        <h2 class="ui left floated header">NextFilm 后台管理系统</h2>
        <div class="ui clearing divider"></div>
        <div class="ui huge breadcrumb">
            <div class="active section">Home</div>
        </div>

        <div class="inner-list-1">

            <p>欢迎你，${username}，你可以：</p>
            <div style="margin-top:40px;">
                <p>
                    <a class="ui orange button my-button-2" href="/change_password">更改密码</a>
                </p>
                <p>
                    <a class="ui yellow button my-button-2" href="/edit_detail">更改资料</a>
                </p>
                <p>
                    <a class="ui olive button my-button-2" href="/show_all_actor">查看所有actor</a>
                </p>
                <p>
                    <a class="ui violet button my-button-2" href="/show_all_cinema">查看所有cinema</a>
                </p>
                <p>
                    <a class="ui brown button my-button-2" href="/show_all_film">查看所有film</a>
                </p>

                <div style="margin-top:40px;">
                    <form method="post" action="/logout">
                        <button class="ui grey button my-button-2">退出登录</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
