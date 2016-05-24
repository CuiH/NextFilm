<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/18
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Edit Showing</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
</head>
<body>
<form:form modelAttribute="showingEditor2" action="/edit_showing" method="post">
    <p>
        <label for="id">showing id: </label>
        <form:input type="text" id="id" path="id" readonly="true"/>
        <form:errors path="id" cssClass="error"/>
    </p>

    <p>
        <label for="filmName">film name: </label>
        <form:input type="text" id="filmName" path="filmName" readonly="true"/>
        <form:errors path="filmName" cssClass="error"/>
    </p>

    <p>
        <label for="hallName">hall name: </label>
        <form:input type="text" id="hallName" path="hallName" readonly="true"/>
        <form:errors path="hallName" cssClass="error"/>
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

<table class="ui celled table">
    <thead>
    <tr>
        <th>id</th>
        <th>row</th>
        <th>column</th>
        <th>status</th>
        <th>改状态</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="seat" items="${showingEditor2.seats}">
        <tr>
            <td>${seat.id}</td>
            <td>${seat.rowPos}</td>
            <td>${seat.columnPos}</td>
            <td>${seat.status}</td>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <td><button class="edit" seatid="${seat.id}">edit</button></td>
            </security:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $(".edit").click(function(){
            alert($(this).attr("seatid"));
        });
    });
</script>

</body>
</html>
