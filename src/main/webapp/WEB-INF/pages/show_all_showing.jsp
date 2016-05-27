<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/26
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Showings</title>
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
            <a href="/show_all_cinema" class="section">All Cinemas</a>
            <i class="right chevron icon divider"></i>
            <a href="/edit_cinema?id=${cinemaId}" class="section">影院详情</a>
            <i class="right chevron icon divider"></i>
            <a class="section">${filmName}</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">All Showings</div>
        </div>

        <div class="inner-table-1">
            <table class="ui celled table">
                <thead>
                <tr>
                    <th>id</th>
                    <th>start time</th>
                    <th>end time</th>
                    <th>price</th>
                    <th>hall</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="showing" items="${showings}">
                    <tr>
                        <td>${showing.id}</td>
                        <td>${showing.startTime}</td>
                        <td>${showing.endTime}</td>
                        <td>${showing.priceManual}</td>
                        <td>${showing.hall.name}</td>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a class="ui button blue" href="/edit_showing?id=${showing.id}&cinemaId=${cinemaId}">edit</a></td>
                            <td><div class="delete_showing ui button red" showing-id="${showing.id}">delete</div></td>
                        </security:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <security:authorize access="hasRole('ROLE_ADMIN')" >
                <div class=" my-button-1">
                    <a class="ui teal button my-button-2" href="/add_showing?cinemaId=${cinemaId}&filmId=${filmId}">add a showing</a>
                </div>
            </security:authorize>
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

<script>
    $(document).ready(function() {
        $("#refresh_page").click(function() {
            window.location.reload();
        });

        $(".delete_showing").click(function() {
            $.ajax({
                type: "GET",
                dataType: "html",
                url: "/delete_showing?id=" + $(this).attr("showing-id"),
                success: function(data) {
                    data = JSON.parse(data);
                    if (data["result"] == "success") {
                        $("#model_success").modal('show');
                    } else {
                        $("#model_fail .content").html("<p>" + data["reason"] + "</p>");
                        $("#model_fail").modal('show');
                    }
                },
                error: function() {
                    alert("error");
                }
            });
        });
    });
</script>

</body>
</html>
