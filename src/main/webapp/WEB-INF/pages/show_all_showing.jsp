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
                            <td><a href="/edit_showing?id=${showing.id}&cinemaId=${cinemaId}">edit</a></td>
                            <td><a href="/delete_showing?id=${showing.id}">delete</a></td>
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

</body>
</html>
