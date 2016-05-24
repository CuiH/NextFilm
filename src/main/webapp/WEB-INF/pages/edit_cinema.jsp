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
</head>
<body>
<form:form modelAttribute="cinemaEditor" action="/edit_cinema" method="post">
    <p>
        <label for="id">id: </label>
        <form:input type="text" id="id" path="id" readonly="true"/>
        <form:errors path="id" cssClass="error"/>
    </p>

    <p>
        <label for="name">name: </label>
        <form:input type="text" id="name" path="name"/>
        <form:errors path="name" cssClass="error"/>
    </p>

    <p>
        <label for="city">city: </label>
        <form:input type="text" id="city" path="city"/>
        <form:errors path="city" cssClass="error"/>
    </p>

    <p>
        <label for="address">address: </label>
        <form:input type="text" id="address" path="address"/>
        <form:errors path="address" cssClass="error"/>
    </p>

    <p>
        <label for="phone">phone: </label>
        <form:input type="text" id="phone" path="phone"/>
        <form:errors path="phone" cssClass="error"/>
    </p>

    <p>
        <label for="brief">brief: </label>
        <form:input type="text" id="brief" path="brief"/>
        <form:errors path="brief" cssClass="error"/>
    </p>

    <p>
        <label for="imageUrl">image url: </label>
        <form:input type="text" id="imageUrl" path="imageUrl"/>
        <form:errors path="imageUrl" cssClass="error"/>
    </p>

    <p>
        <label for="description">description: </label>
        <form:input type="text" id="description" path="description"/>
        <form:errors path="description" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" value="Submit">
    </p>
</form:form>

<button id="increase_film" cinema-id="${cinemaEditor.id}">edit film</button>

<br/>
<p>Halls:</p>
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
                <td><a href="/edit_hall?id=${hall.id}">edit</a></td>
                <td><a href="/delete_hall?id=${hall.id}">delete</a></td>
            </security:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/add_hall?cinemaId=${cinemaEditor.id}">add hall</a>

<br/><br/><br/>
<p>Showings:</p>
<c:forEach var="fcm" items="${cinemaEditor.fcms}">
    filmname: ${fcm.film.name}
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
                    <td><a href="/edit_showing?id=${showing.id}">edit</a></td>
                    <td><a href="/delete_showing?id=${showing.id}">delete</a></td>
                </security:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
</c:forEach>
<a href="/add_showing?cinemaId=${cinemaEditor.id}">add showing</a>


<div class="ui modal">
    <div class="header">
        选择电影
    </div>
    <div class="content">
        <div class="description">
            <div class="ui header">选择上映的电影</div>
            <form id="increase_film_form">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
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




<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>

<script>
$(document).ready(function() {
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
                    var str = "<input name='filmIds' type='checkbox' value=" + films[i]["id"];
                    if (films[i]["selected"] == true) {
                        str += ' checked=checked'
                    }
                    str += '>'+ films[i]["name"];
                    $("#increase_film_form").append(str);
                }
            }
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
            url: "/increase_film?cinemaId="+$("#increase_film").attr("cinema-id"),
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
