<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/16
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Show All Film</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
</head>
<body>
<table class="ui celled table">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>alias</th>
        <th>brief</th>
        <th>language</th>
        <th>length</th>
        <th>on_date</th>
        <th>image_url</th>
        <th>category</th>
        <th>type</th>
        <th>director</th>
        <th>actor</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="film" items="${films}">
        <tr>
            <td>${film.id}</td>
            <td>${film.name}</td>
            <td>${film.alias}</td>
            <td>${film.brief}</td>
            <td>${film.language}</td>
            <td>${film.length}</td>
            <td>${film.onDate}</td>
            <td>${film.imageUrl}</td>
            <td>${film.category}</td>
            <td>${film.type}</td>
            <td>
                <c:forEach items="${film.directors}" var="director">
                    ${director.name};
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${film.actors}" var="actor">
                    ${actor.name};
                </c:forEach>
            </td>
            <security:authorize access="hasRole('ROLE_ADMIN')" >
                <td><a href="/edit_film?id=${film.id}">edit</a></td>
                <td><a href="/delete_film?id=${film.id}">delete</a></td>
            </security:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>
<security:authorize access="hasRole('ROLE_ADMIN')" >
    <a href="/add_film">add film</a>
</security:authorize>

</body>
</html>
