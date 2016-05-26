<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Actor</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="/res/css/layout.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>
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
            <a href="/show_all_actor" class="section">All Actors</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">Add Actor</div>
        </div>

        <div class="inner-form-1">
            <form:form modelAttribute="actorEditor" action="/add_actor" cssClass="ui form" method="post">
                <div class="field">
                    <label>name</label>
                    <form:input type="text" id="name" path="name" placeholder="名字"/>
                    <form:errors path="name" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>image url:</label>
                    <form:input type="text" id="imageUrl" path="imageUrl" placeholder="头像链接"/>
                    <form:errors path="imageUrl" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>brief</label>
                    <form:input type="text" id="brief" path="brief" placeholder="简介"/>
                    <form:errors path="brief" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>birthday</label>
                    <form:input type="text" id="birthday" path="birthday" placeholder="生日(yyyy-MM-dd)"/>
                    <form:errors path="birthday" cssClass="error-message"/>
                </div>

                <div class="submit-button">
                    <button class="ui button my-button-2">Submit</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script src="/res/js/actor_validator.js"></script>

</body>
</html>
