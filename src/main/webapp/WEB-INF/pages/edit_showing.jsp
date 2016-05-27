<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/18
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Edit Showing</title>
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
            <a class="section">${showingEditor2.film.name}</a>
            <i class="right chevron icon divider"></i>
            <a href="/show_all_showing?cinemaId=${cinemaId}&filmId=${showingEditor2.film.id}" class="section">All Showings</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">Edit Showing</div>
        </div>

        <div class="inner-form-1">
            <form:form id="showing_form" modelAttribute="showingEditor2" cssClass="ui form">
                <div class="disabled field">
                    <label>id</label>
                    <form:input type="text" id="id" path="id" readonly="true"/>
                </div>

                <div class="disabled field">
                    <label>film name</label>
                    <input id="filmName" type="text" value="${showingEditor2.film.name}" readonly="true"/>
                </div>

                <div class="disabled field">
                    <label>hall name</label>
                    <form:input type="text" id="hallName" path="hallName" readonly="true"/>
                </div>

                <div class="field">
                    <label>start time</label>
                    <form:input type="text" id="startTime" path="startTime" placeholder="开始时间(yyyy-MM-dd hh:mm:ss)"/>
                    <form:errors path="startTime" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>end time</label>
                    <form:input type="text" id="endTime" path="endTime" placeholder="结束时间(yyyy-MM-dd hh:mm:ss)"/>
                    <form:errors path="endTime" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>price manual</label>
                    <form:input type="text" id="priceManual" path="priceManual" placeholder="定价"/>
                    <form:errors path="priceManual" cssClass="error-message"/>
                </div>
            </form:form>
            <div class="submit-button">
                <button id="submit_form" class="ui button my-button-2">Submit</button>
            </div>
        </div>

        <div style="margin-top:25px;" class="ui clearing divider"></div>
        <div class="ui huge breadcrumb">
            <div class="active section">All Seats</div>
        </div>
        <div class="inner-table-3">
            <table class="ui celled table">
                <thead>
                <tr>
                    <th>id</th>
                    <th>row</th>
                    <th>column</th>
                    <th>status</th>
                    <th>改状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="seat" items="${showingEditor2.seats}">
                    <tr>
                        <td>${seat.id}</td>
                        <td>${seat.rowPos}</td>
                        <td>${seat.columnPos}</td>
                        <td>${seat.status}</td>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <td><button class="ui blue button edit" seatid="${seat.id}">edit</button></td>
                        </security:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div id="model_success" class="ui small modal">
    <div class="header">修改成功</div>
    <div class="actions">
        <a href="/show_all_showing?cinemaId=${cinemaId}&filmId=${showingEditor2.film.id}" class="ui negative button">返回列表页</a>
    </div>
</div>

<div id="model_fail" class="ui small modal">
    <div class="header">修改失败</div>
    <div class="content"></div>
    <div class="actions">
        <div class="ui negative button">去修改</div>
    </div>
</div>

<script src="/res/js/edit_showing_validator.js"></script>

<script>
    $(document).ready(function(){
        $(".edit").click(function(){
            alert($(this).attr("seatid"));
        });

        $("#submit_form").click(function() {
            $('.ui.form').form('validate form');
        });
    });
</script>

</body>
</html>
