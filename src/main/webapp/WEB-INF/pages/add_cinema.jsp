<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Cinema</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
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
            <div class="active section">Add Cinema</div>
        </div>

        <div class="inner-form-1">
            <form:form id="cinema_form" modelAttribute="cinemaEditor" cssClass="ui form">
                <div class="field">
                    <label>name</label>
                    <form:input type="text" id="name" path="name" placeholder="名字"/>
                    <form:errors path="name" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>city</label>
                    <form:select path="city" cssClass="ui fluid dropdown" items="${cities}"/>
                    <form:errors path="city" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>address</label>
                    <form:input type="text" id="address" path="address" placeholder="地址"/>
                    <form:errors path="address" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>phone</label>
                    <form:input type="text" id="phone" path="phone" placeholder="电话"/>
                    <form:errors path="phone" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>brief</label>
                    <form:input type="text" id="brief" path="brief" placeholder="简介"/>
                    <form:errors path="brief" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>image url</label>
                    <form:input type="text" id="imageUrl" path="imageUrl" placeholder="图片链接"/>
                    <form:errors path="imageUrl" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>description</label>
                    <form:input type="text" id="description" path="description" placeholder="详细介绍"/>
                    <form:errors path="description" cssClass="error-message"/>
                </div>
            </form:form>
            <div class="submit-button">
                <button id="submit_form" class="ui button my-button-2">Submit</button>
            </div>
        </div>
    </div>
</div>

<div id="model_success" class="ui small modal">
    <div class="header">添加成功</div>
    <div class="actions">
        <a href="/show_all_cinema" class="ui negative button">返回列表页</a>
        <a href="/add_cinema" class="ui positive button">继续添加</a>
    </div>
</div>

<div id="model_fail" class="ui small modal">
    <div class="header">添加失败</div>
    <div class="content"></div>
    <div class="actions">
        <div class="ui negative button">去修改</div>
    </div>
</div>

<script src="/res/js/add_cinema_validator.js"></script>

<script>
    $(document).ready(function() {
        $('select.dropdown').dropdown();

        $("#submit_form").click(function() {
            $('.ui.form').form('validate form');
        });
    });
</script>

</body>
</html>
