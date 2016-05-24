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
                <div class=" my-button-1">
                    <button id="increase_film" class="ui teal button my-button-2" cinema-id="${cinemaEditor.id}">edit film</button>
                </div>
            </div>
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

        <div style="margin-top: 25px; margin-bottom: 35px" class="ui clearing divider"></div>
        <div class="ui huge breadcrumb">
            <div class="active section">All Showings</div>
        </div>
        <div class="inner-accordion-1">
            <c:forEach var="fcm" items="${cinemaEditor.fcms}">
                <div style="width:100%;" class="ui styled accordion">
                    <div class="title"><i class="dropdown icon"></i>${fcm.film.name}</div>
                    <div class="content">
                        <div class="inner-table-4">
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
                                <c:forEach var="showing" items="${fcm.showings}">
                                    <tr>
                                        <td>${showing.id}</td>
                                        <td>${showing.startTime}</td>
                                        <td>${showing.endTime}</td>
                                        <td>${showing.priceManual}</td>
                                        <td>${showing.hall.name}</td>
                                        <security:authorize access="hasRole('ROLE_ADMIN')">
                                            <td><a href="/edit_showing?id=${showing.id}&cinemaId=${cinemaEditor.id}">edit</a></td>
                                            <td><a href="/delete_showing?id=${showing.id}">delete</a></td>
                                        </security:authorize>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class=" my-button-3">
                <a class="ui teal button my-button-2" href="/add_showing?cinemaId=${cinemaEditor.id}">add a showing</a>
            </div>
        </div>
    </div>
</div>


<div class="ui modal">
    <div class="header">
        Edit Film
    </div>
    <div class="content">
        <div class="description">
            <div class="ui header">选择上映的电影</div>
            <div class="ui form">
                <form id="increase_film_form">
                    <div class="disabled field">
                        <label>cinema id</label>
                        <input type="text" name="cinemaId" value="${cinemaEditor.id}" readonly="readonly"/>
                    </div>
                    <div id="edit_film_field" class="field">
                        <label>films</label>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
    <div class="actions">
        <div class="ui black deny button">
            Cancel
        </div>
        <div id="increase_ok" class="ui positive right labeled icon button">
            Ok
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>

<script>
$(document).ready(function() {
    $('select.dropdown').dropdown();

    $('.ui.accordion').accordion();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "/increase_film?cinemaId="+$("#increase_film").attr("cinema-id"),
        success: function(data) {
            console.log(data);
            data = JSON.parse(data);
            if (data["result"] == "success") {
                var films = data["films"];
                for (var i = 0; i < films.length; i++) {
                    var str = "<div class='ui checkbox add-margin-right'>";
                    str += "<input name='filmIds' class='hidden' type='checkbox' value=" + films[i]["id"];
                    if (films[i]["selected"] == true) {
                        str += ' checked=checked'
                    }
                    str += "><label>" +films[i]["name"] + "</label></div>";
                    $("#edit_film_field").append(str);
                }
            }

            $('.ui.checkbox').checkbox();
        },
        error: function() {
            alert("error");
        }
    });

    $("#increase_film").click(function() {
        $('.ui.modal').modal('show');
    });

    $("#increase_ok").click(function() {
        $.ajax({
            type: "POST",
            dataType: "html",
            url: "/increase_film",
            data: $('#increase_film_form').serialize(),
            success: function(result) {
                console.log(result);
            },
            error: function() {
                alert("error");
            }
        });
    })
});
</script>

</body>
</html>
