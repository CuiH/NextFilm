<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Actor</title>
</head>
<body>
<form:form modelAttribute="actorEditor" action="/edit_actor" method="post">
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
        <label for="imageUrl">image url: </label>
        <form:input type="text" id="imageUrl" path="imageUrl"
                    tabindex="3"/>
        <form:errors path="imageUrl" cssClass="error"/>
    </p>

    <p>
        <label for="brief">brief: </label>
        <form:input type="text" id="brief" path="brief"
                    tabindex="4"/>
        <form:errors path="brief" cssClass="error"/>
    </p>

    <p>
        <label for="birthday">birthday: </label>
        <form:input type="text" id="birthday" path="birthday"
                    tabindex="5"/>
        (XXXX-XX-XX)
        <form:errors path="birthday" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" tabindex="6"
               value="Submit">
    </p>
</form:form>

</body>
</html>
