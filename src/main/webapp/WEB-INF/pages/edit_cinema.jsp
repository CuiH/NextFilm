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
    <link href="/res/css/semantic.css" rel="stylesheet">
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
        <label for="films">films: </label>
        <c:forEach items="${films}" var="film">
            <form:checkbox path="films" value="${film.key}"/>${film.value}
        </c:forEach>
        <form:errors path="films" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" value="Submit">
    </p>
</form:form>

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
                <td><a href="/edit_cinema/${cinemaEditor.id}/edit_hall/${hall.id}">edit</a></td>
                <td><a href="/delete_hall/${hall.id}">delete</a></td>
            </security:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/edit_cinema/${cinemaEditor.id}/add_hall">add hall</a>

</body>
</html>
