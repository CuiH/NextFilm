<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Detail</title>
</head>
<body>
<form:form modelAttribute="userDetailEditor" action="/edit_detail" method="post">
    <p>
        <label for="firstName">First Name: </label>
        <form:input type="text" id="firstName" path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>
    </p>

    <p>
        <label for="lastName">Last Name: </label>
        <form:input type="text" id="lastName" path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
    </p>

    <p>
        <label for="gender">Gender: </label>
        <form:radiobuttons id="gender" path="gender" items="${genders}"/>
        <form:errors path="gender" cssClass="error"/>
    </p>

    <p>
        <label for="birthday">Birthday: </label>
        <form:input type="text" id="birthday" path="birthday"/>
        (XXXX-XX-XX)
        <form:errors path="birthday" cssClass="error"/>
    </p>

    <p>
        <label for="city">City: </label>
        <form:input type="text" id="city" path="city"/>
        <form:errors path="city" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" value="Submit">
    </p>
</form:form>

</body>
</html>
