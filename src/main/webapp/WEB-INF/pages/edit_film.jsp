<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/16
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Film</title>
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
            <a href="/show_all_film" class="section">All Films</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">Edit Film</div>
        </div>

        <div class="inner-form-1">
            <div class="ui form">
                <form:form id="film-form" modelAttribute="filmEditor">
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
                        <form:input type="text" id="onDate" path="onDate" placeholder="上映日期(yyyy-MM-dd)"/>
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
                        <div style="margin-bottom: 10px;" id="director-field">
                            <c:forEach items="${filmEditor.ownedDirectors}" var="director">
                                <a director-id="${director.id}" class="ui label"> ${director.name}
                                    <i id="director${director.id}" class="delete icon"></i>
                                </a>
                            </c:forEach>
                        </div>
                        <a id="add_director" class="ui button blue">add a director</a>
                            <%--<form:errors path="directors" cssClass="error-message"/>--%>
                    </div>

                    <div class="field">
                        <label>actors</label>
                        <div style="margin-bottom: 10px;" id="actor-field">
                            <c:forEach items="${filmEditor.ownedActors}" var="actor">
                                <a actor-id="${actor.id}" class="ui label"> ${actor.name}
                                    <i id="actor${actor.id}" class="delete icon"></i>
                                </a>
                            </c:forEach>
                        </div>
                        <a id="add_actor" class="ui button blue">add a actor</a>
                            <%--<form:errors path="directors" cssClass="error-message"/>--%>
                    </div>
                </form:form>
                <div class="submit-button">
                    <button id="submit_form" class="ui button my-button-2">Submit</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="ui modal">
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
                    <div id="search_results" class="ui four column stackable grid "></div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/res/js/film.js"></script>

<script>
    $(document).ready(function() {
        $('i.delete').click(function () {
            $(this).parent().remove();
        });

        $("#submit_form").click(function() {
            var str = "";

            var d_list = $("#director-field").children("a");
            for (var i = 0; i < d_list.length; i++) {
                str += '&directors=' + $(d_list[i]).attr("director-id");
            }

            var a_list = $("#actor-field").children("a");
            for (var i = 0; i < a_list.length; i++) {
                str += '&actors=' + $(a_list[i]).attr("actor-id");
            }

            $.ajax({
                type: "POST",
                dataType: "html",
                url: "/edit_film",
                data: $('#film-form').serialize() + str,
                success: function(result) {
                    console.log(result);
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
