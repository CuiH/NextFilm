<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Edit Cinema</title>
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
            <div class="active section">Edit Cinema</div>
        </div>

        <div class="inner-form-1">
            <div class="ui form">
                <form:form modelAttribute="cinemaEditor" action="/edit_cinema" method="post">
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

                    <div class="submit-button">
                        <button class="ui button my-button-2">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>

        <div style="margin-top: 25px; margin-bottom: 35px" class="ui clearing divider"></div>
        <div class="ui huge breadcrumb">
            <div class="active section">All Films（上、下架操作提交后生效）</div>
        </div>
        <div class="add-margin-top">
            <div id="film-field" class="ui special cards four column stackable grid">
                <c:forEach items="${cinemaEditor.films}" var="film">
                    <div film-id="${film.id}" class="card">
                        <div class="blurring dimmable image">
                            <div class="ui inverted dimmer">
                                <div class="content">
                                    <div class="center">
                                        <div class="ui primary button delete_film">下架影片</div>
                                        <a class="ui primary button" href="/show_all_showing?cinemaId=${cinemaEditor.id}&filmId=${film.id}">查看排片</a>
                                    </div>
                                </div>
                            </div>
                            <img src="${film.imageUrl}">
                        </div>
                        <div class="content">
                            <a class="header">${film.name}</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="my-button-group-1">
            <button id="add-film" style="float: left;" class="ui pink button">Add</button>
            <button id="submit-film" style="float: right;" class="ui teal button" cinema-id="${cinemaEditor.id}">Submit</button>
        </div>

        <div style="margin-top: 25px; margin-bottom: 35px" class="ui clearing divider"></div>
        <div class="ui huge breadcrumb">
            <div class="active section">All Halls</div>
        </div>
        <div class="inner-table-3">
            <table class="ui celled table">
                <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>type</th>
                    <th>row num</th>
                    <th>column num</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="hall" items="${cinemaEditor.halls}">
                    <tr>
                        <td>${hall.id}</td>
                        <td>${hall.name}</td>
                        <td>${hall.type}</td>
                        <td>${hall.rowNum}</td>
                        <td>${hall.columnNum}</td>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a href="/edit_hall?id=${hall.id}&cinemaId=${cinemaEditor.id}">edit</a></td>
                            <td><a href="/delete_hall?id=${hall.id}">delete</a></td>
                        </security:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class=" my-button-3">
                <a class="ui teal button my-button-2" href="/add_hall?cinemaId=${cinemaEditor.id}">add a hall</a>
            </div>
        </div>

        <%--<div style="margin-top: 25px; margin-bottom: 35px" class="ui clearing divider"></div>--%>
        <%--<div class="ui huge breadcrumb">--%>
            <%--<div class="active section">All Showings</div>--%>
        <%--</div>--%>
        <%--<div class="inner-accordion-1">--%>
            <%--<c:forEach var="fcm" items="${cinemaEditor.fcms}">--%>
                <%--<div style="width:100%;" class="ui styled accordion">--%>
                    <%--<div class="title"><i class="dropdown icon"></i>${fcm.film.name}</div>--%>
                    <%--<div class="content">--%>
                        <%--<div class="inner-table-4">--%>
                            <%----%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</c:forEach>--%>
            <%--<div class=" my-button-3">--%>
                <%--<a class="ui teal button my-button-2" href="/add_showing?cinemaId=${cinemaEditor.id}">add a showing</a>--%>
            <%--</div>--%>
        <%--</div>--%>
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
                    <input id="film_searcher" class="prompt" type="text" placeholder="输入完整or部分名字">
                    <i class="search icon"></i>
                </div>
                <div class="add-margin-top">
                    <div id="search_results" class="ui special cards four column stackable grid"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/res/js/cinema.js"></script>

</body>
</html>
