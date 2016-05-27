<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Film</title>
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
            <a href="/show_all_film" class="section">All Films</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">Add Film</div>
        </div>

        <div class="inner-form-1">
            <form:form id="film_form" cssClass="ui form" modelAttribute="filmEditor">
                <div class="field">
                    <label>name</label>
                    <form:input type="text" id="name" path="name" placeholder="名字"/>
                    <form:errors path="name" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>alias</label>
                    <form:input type="text" id="alias" path="alias" placeholder="别名"/>
                    <form:errors path="alias" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>brief</label>
                    <form:input type="text" id="brief" path="brief" placeholder="简介"/>
                    <form:errors path="brief" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>language</label>
                    <form:input type="text" id="language" path="language" placeholder="语言"/>
                    <form:errors path="language" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>length</label>
                    <form:input type="text" id="length" path="length" placeholder="长度"/>
                    <form:errors path="length" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>on date</label>
                    <form:input type="date" id="onDate" path="onDate" placeholder="上映日期(yyyy-MM-dd)"/>
                    <form:errors path="onDate" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>image url</label>
                    <form:input type="text" id="imageUrl" path="imageUrl" placeholder="图片链接"/>
                    <form:errors path="imageUrl" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>category</label>
                    <form:select path="category" cssClass="ui fluid dropdown" items="${categories}"/>
                    <form:errors path="category" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>type</label>
                    <form:select path="type" cssClass="ui fluid dropdown" items="${types}"/>
                    <form:errors path="type" cssClass="error-message"/>
                </div>

                <div class="field">
                    <label>directors</label>
                    <div style="margin-bottom: 10px;" id="director-field"></div>
                    <a id="add_director" class="ui button blue">add a director</a>
                    <span hidden="hidden" id="directors_error" class="error-message not-show"></span>
                </div>

                <div class="field">
                    <label>actors</label>
                    <div style="margin-bottom: 10px;" id="actor-field"></div>
                    <a id="add_actor" class="ui button blue">add a actor</a>
                    <span hidden="hidden" id="actors_error" class="error-message not-show"></span>
                </div>
            </form:form>
            <div class="submit-button">
                <button id="submit_form" class="ui button my-button-2">Submit</button>
            </div>
        </div>
    </div>
</div>

<div id="model_search" class="ui modal">
    <div class="header">
        Add
    </div>
    <div class="content">
        <div class="description">
            <div id="searcher-div" class="ui search">
                <div class="ui icon input">
                    <input id="actor_searcher" class="prompt" type="text" placeholder="输入完整or部分名字">
                    <i class="search icon"></i>
                </div>
                <div class="add-margin-top">
                    <div id="search_results" class="ui special cards four column stackable grid"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="model_success" class="ui small modal">
    <div class="header">添加成功</div>
    <div class="actions">
        <a href="/show_all_film" class="ui negative button">返回列表页</a>
        <a href="/add_film" class="ui positive button">继续添加</a>
    </div>
</div>

<div id="model_fail" class="ui small modal">
    <div class="header">添加失败</div>
    <div class="content"></div>
    <div class="actions">
        <div class="ui negative button">去修改</div>
    </div>
</div>


<script src="/res/js/film.js"></script>

<script src="/res/js/add_film_validator.js"></script>

<script>
    $(document).ready(function() {
//        // 禁止回车提交
//        $(window).keydown(function(event){
//            if(event.keyCode == 13) {
//                event.preventDefault();
//                return false;
//            }
//        });

        $("#submit_form").click(function() {
            var d_list = $("#director-field").children("a");
            if (d_list.length == 0) {
                $("#directors_error").text("Please select at least 1 director.");
                $("#directors_error").removeClass("not-show");
                return;
            } else {
                $("#directors_error").addClass("not-show");
            }

            var a_list = $("#actor-field").children("a");
            if (a_list.length == 0) {
                $("#actors_error").text("Please select at least 1 actor.");
                $("#actors_error").removeClass("not-show");
                return;
            } else {
                $("#actors_error").addClass("not-show");
            }

            $('.ui.form').form('validate form');
        });
    });
</script>

</body>
</html>
