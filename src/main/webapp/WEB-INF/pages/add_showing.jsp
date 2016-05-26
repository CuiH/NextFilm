
<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/18
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Showing</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>
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
            <a href="/edit_cinema?id=${showingEditor1.cinemaId}" class="section">影院详情</a>
            <i class="right chevron icon divider"></i>
            <a class="section">${showingEditor1.film.name}</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">Add Showing</div>
        </div>

        <div class="inner-form-1">
            <div class="ui form">
                <form:form modelAttribute="showingEditor1" action="/add_showing" method="post">
                    <div class="disabled field">
                        <label>cinema id: </label>
                        <form:input type="text" id="cinemaId" path="cinemaId" readonly="true"/>
                    </div>

                    <div class="disabled field">
                        <label>film id: </label>
                        <input name="filmId" type="text" readonly="readonly" value="${showingEditor1.film.id}">
                    </div>

                    <div class="field">
                        <label>hall</label>
                        <c:forEach items="${halls}" var="hall">
                            <div class="ui radio checkbox">
                                <form:radiobutton path="hallId" value="${hall.id}" cssClass="hidden"/>
                                <label>${hall.name}</label>
                            </div>
                        </c:forEach>
                        <form:errors path="hallId" cssClass="error-message"/>
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

                    <div class="submit-button">
                        <button class="ui button my-button-2">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $('.ui.radio.checkbox').checkbox();
    });
</script>

</body>
</html>
