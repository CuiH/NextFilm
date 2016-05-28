<%--
  Created by IntelliJ IDEA.
  User: cuihao
  Date: 2016/5/28
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Reservations</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="//cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>
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
            <a href="/home" class="section">Home</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">All Reservations</div>
        </div>

        <div class="inner-table-1">
            <div id="search_div" class="ui search">
                <div class="ui icon input">
                    <input id="user_searcher" class="prompt" type="text" placeholder="输入完整username">
                    <i class="search icon"></i>
                </div>
                <div class="add-margin-top">
                    <div id="search_results" class="ui special cards four column stackable grid"></div>
                </div>
            </div>

            <table class="ui celled table">
                <thead>
                <tr>
                    <th>id</th>
                    <th>create time</th>
                    <th>film name</th>
                    <th>cinema name</th>
                    <th>start time</th>
                    <th>seat num</th>
                    <th>total price</th>
                    <th>status</th>
                    <th>查看详情</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody id="reservation_table">
                </tbody>
            </table>
        </div>
    </div>
</div>

<div id="model_success" class="ui small modal">
    <div class="header">删除成功</div>
    <div class="content">
        <p>请刷新页面</p>
    </div>
    <div class="actions">
        <button id="refresh_page" class="ui positive button">刷新页面</button>
    </div>
</div>

<div id="model_fail" class="ui small modal">
    <div class="header">删除失败</div>
    <div class="content"></div>
    <div class="actions">
        <div class="ui negative button">返回</div>
    </div>
</div>

<div id="model_detail" class="ui small modal">
    <i class="close icon"></i>
    <div class="header">
        订单详情
    </div>
    <div class="image content">
        <div id="detail_field"class="description">
            <p>电影：</p>
            <p>影院：</p>
            <p>影厅：</p>
            <p>开始时间：</p>
            <p>预定时间：</p>
            <p>总价：</p>
            <p>折扣：</p>
            <p>订单状态：</p>
            <br/>
            <p>座位：</p>
        </div>
    </div>
    <div class="actions">
        <div class="ui positive button">
            返回
        </div>
    </div>
</div>

<script src="/res/js/reservation.js"></script>

<script>
    $(document).ready(function() {
        $("#refresh_page").click(function() {
            window.location.reload();
        });
    });
</script>

</body>
</html>
