<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Cinema</title>
</head>
<body>
<form:form modelAttribute="cinemaEditor" action="/edit_cinema" method="post">
    <p>
        <label for="id">id: </label>
        <form:input type="text" id="id" path="id"
                    tabindex="1" readonly="true"/>
        <form:errors path="id" cssClass="error"/>
    </p>

    <p>
        <label for="name">name: </label>
        <form:input type="text" id="name" path="name"
                    tabindex="2"/>
        <form:errors path="name" cssClass="error"/>
    </p>

    <p>
        <label for="city">city: </label>
        <form:input type="text" id="city" path="city"
                    tabindex="3"/>
        <form:errors path="city" cssClass="error"/>
    </p>

    <p>
        <label for="address">address: </label>
        <form:input type="text" id="address" path="address"
                    tabindex="4"/>
        <form:errors path="address" cssClass="error"/>
    </p>

    <p>
        <label for="phone">phone: </label>
        <form:input type="text" id="phone" path="phone"
                    tabindex="5"/>
        <form:errors path="phone" cssClass="error"/>
    </p>

    <p>
        <label for="brief">brief: </label>
        <form:input type="text" id="brief" path="brief"
                    tabindex="6"/>
        <form:errors path="brief" cssClass="error"/>
    </p>

    <p>
        <label for="imageUrl">image url: </label>
        <form:input type="text" id="imageUrl" path="imageUrl"
                    tabindex="7"/>
        <form:errors path="imageUrl" cssClass="error"/>
    </p>

    <p>
        <label for="description">description: </label>
        <form:input type="text" id="description" path="description"
                    tabindex="8"/>
        <form:errors path="description" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" tabindex="9"
               value="Submit">
    </p>
</form:form>

</body>
</html>
