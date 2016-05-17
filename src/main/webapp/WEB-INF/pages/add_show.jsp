
<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/18
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Show</title>
</head>
<body>
<form:form modelAttribute="showingEditor" action="/add_show" method="post">
    <p>
        <label for="filmId">films: </label>
        <c:forEach items="${films}" var="film">
            <form:radiobutton path="filmId" value="${film.id}"/>${film.name}
        </c:forEach>
        <form:errors path="filmId" cssClass="error"/>
    </p>

    <p>
        <label for="hallId">halls: </label>
        <c:forEach items="${halls}" var="hall">
            <form:radiobutton path="hallId" value="${hall.id}"/>${hall.name}
        </c:forEach>
        <form:errors path="hallId" cssClass="error"/>
    </p>

    <p>
        <label for="cinemaId">cinema_id: </label>
        <form:input type="text" id="cinemaId" path="cinemaId" readonly="true"/>
        <form:errors path="cinemaId" cssClass="error"/>
    </p>

    <p>
        <label for="startTime">start time: </label>
        <form:input type="text" id="startTime" path="startTime"/>(XXXX-XX-XX)
        <form:errors path="startTime" cssClass="error"/>
    </p>

    <p>
        <label for="endTime">end time: </label>
        <form:input type="text" id="endTime" path="endTime"/>(XXXX-XX-XX)
        <form:errors path="endTime" cssClass="error"/>
    </p>

    <p>
        <label for="priceManual">price manual: </label>
        <form:input type="text" id="priceManual" path="priceManual"/>
        <form:errors path="priceManual" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" value="Submit">
    </p>
</form:form>


</body>
</html>
