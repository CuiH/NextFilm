<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Show All Actor</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
</head>
<body>
<table class="ui celled table">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>image url</th>
        <th>brief</th>
        <th>birthday</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="actor" items="${actors}">
        <tr>
            <td>${actor.id}</td>
            <td>${actor.name}</td>
            <td>${actor.imageUrl}</td>
            <td>${actor.brief}</td>
            <td>${actor.birthday}</td>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <td><a href="/edit_actor?id=${actor.id}">edit</a></td>
                <td><a href="/delete_actor?id=${actor.id}">delete</a></td>
            </security:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>
<security:authorize access="hasRole('ROLE_ADMIN')" >
    <a href="/add_actor">add actor</a>
</security:authorize>
</body>
</html>
