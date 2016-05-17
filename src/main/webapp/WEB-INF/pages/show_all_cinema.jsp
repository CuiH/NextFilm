<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Show All Cinema</title>
    <link href="/res/css/semantic.css" rel="stylesheet">
</head>
<body>
<table class="ui celled table">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>city</th>
        <th>address</th>
        <th>phone</th>
        <th>brief</th>
        <th>imageUrl</th>
        <th>description</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cinema" items="${cinemas}">
        <tr>
            <td>${cinema.id}</td>
            <td>${cinema.name}</td>
            <td>${cinema.cityCode}</td>
            <td>${cinema.address}</td>
            <td>${cinema.phone}</td>
            <td>${cinema.brief}</td>
            <td>${cinema.imageUrl}</td>
            <td>${cinema.description}</td>
            <security:authorize access="hasRole('ROLE_ADMIN')" >
                <td><a href="/edit_cinema/${cinema.id}">edit</a></td>
                <td><a href="/delete_cinema/${cinema.id}">delete</a></td>
            </security:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>
<security:authorize access="hasRole('ROLE_ADMIN')" >
    <a href="/add_cinema">add cinema</a>
</security:authorize>

</body>
</html>
