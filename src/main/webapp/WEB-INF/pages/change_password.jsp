<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
<p>
    change password
</p>
<form:form modelAttribute="passwordEditor" action="/change_password" method="post">
    <p>
        <label for="name">New Password: </label>
        <form:input type="text" id="name" path="newPassword"
                    tabindex="1"/>
        <form:errors path="newPassword" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" tabindex="2"
               value="Submit">
    </p>
</form:form>

</body>
</html>
