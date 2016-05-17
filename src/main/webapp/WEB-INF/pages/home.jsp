<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/13
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
</head>

<body>
<p>welcome, ${username}</p>
<form method="post" action="/logout">
    <button>log out</button>
</form>

<br/>
<p>
    <a href="/change_password">change password</a>
</p>
<p>
    <a href="/edit_detail">edit detail</a>
</p>
<p>
    <a href="/show_all_actor">show all actor</a>
</p>
<p>
    <a href="/show_all_cinema">show all cinema</a>
</p>
<p>
    <a href="/show_all_film">show all film</a>
</p>
</body>
</html>
