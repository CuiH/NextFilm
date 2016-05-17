<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Cinema</title>
</head>
<body>
<form:form modelAttribute="cinemaEditor" action="/add_cinema" method="post">
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

</body>
</html>
