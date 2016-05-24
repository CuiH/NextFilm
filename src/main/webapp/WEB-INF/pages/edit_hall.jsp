<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/17
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit hall</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
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
            <div class="active section">Edit Hall</div>
        </div>

        <div class="inner-form-1">
            <div class="ui form">
                <form:form modelAttribute="hallEditor" action="/edit_hall" method="post">
                    <div class="disabled field">
                        <label>id</label>
                        <form:input type="text" id="id" path="id" readonly="true"/>
                    </div>

                    <div class="field">
                        <label>name</label>
                        <form:input type="text" id="name" path="name" placeholder="名字"/>
                        <form:errors path="name" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>type</label>
                        <form:select path="type" cssClass="ui fluid dropdown" items="${types}"/>
                        <form:errors path="type" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>row num</label>
                        <form:input type="text" id="rowNum" path="rowNum" placeholder="行数"/>
                        <form:errors path="rowNum" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>column num</label>
                        <form:input type="text" id="columnNum" path="columnNum" placeholder="列数"/>
                        <form:errors path="columnNum" cssClass="error-message"/>
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
        $('select.dropdown').dropdown();
    });
</script>

</body>
</html>
