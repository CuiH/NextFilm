<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/17
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Hall</title>
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
            <a href="/edit_cinema?id=${hallEditor.cinemaId}" class="section">影院详情</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">Add Hall</div>
        </div>

        <div class="inner-form-1">
            <form:form id="hall_form" modelAttribute="hallEditor" cssClass="ui form">
                <div class="disabled field">
                    <label for="cinemaId">cinema_id: </label>
                    <form:input type="text" id="cinemaId" path="cinemaId" readonly="true"/>
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
        <a href="/edit_cinema?id=${hallEditor.cinemaId}" class="ui negative button">返回列表页</a>
        <a href="/add_hall?cinemaId=${hallEditor.cinemaId}" class="ui positive button">继续添加</a>
    </div>
</div>

<div id="model_fail" class="ui small modal">
    <div class="header">添加失败</div>
    <div class="content"></div>
    <div class="actions">
        <div class="ui negative button">去修改</div>
    </div>
</div>

<script src="/res/js/add_hall_validator.js"></script>

<script>
    $(document).ready(function() {
        $('select.dropdown').dropdown();

        $("#submit_form").click(function() {
            $('.ui.form').form('validate form');
        })
    });
</script>

</body>
</html>
