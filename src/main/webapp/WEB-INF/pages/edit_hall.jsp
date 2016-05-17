<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/17
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit hall</title>
</head>
<body>
<form:form modelAttribute="hallEditor" action="/edit_hall" method="post">
    <p>
        <label for="cinemaId">cinema id: </label>
        <form:input type="text" id="cinemaId" path="cinemaId" readonly="true"/>
        <form:errors path="cinemaId" cssClass="error"/>
    </p>

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
        <label for="type">type: </label>
        <form:input type="text" id="type" path="type"/>
        <form:errors path="type" cssClass="error"/>
    </p>

    <p>
        <label for="rowNum">row num: </label>
        <form:input type="text" id="rowNum" path="rowNum"/>
        <form:errors path="rowNum" cssClass="error"/>
    </p>

    <p>
        <label for="columnNum">column num: </label>
        <form:input type="text" id="columnNum" path="columnNum"/>
        <form:errors path="columnNum" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" value="Submit">
    </p>
</form:form>

</body>
</html>
