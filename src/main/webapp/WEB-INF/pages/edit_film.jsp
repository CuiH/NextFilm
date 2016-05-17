<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/16
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Film</title>
</head>
<body>
<form:form modelAttribute="filmEditor" action="/edit_film" method="post">
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
        <label for="alias">alias: </label>
        <form:input type="text" id="alias" path="alias"/>
        <form:errors path="alias" cssClass="error"/>
    </p>

    <p>
        <label for="brief">brief: </label>
        <form:input type="text" id="brief" path="brief"/>
        <form:errors path="brief" cssClass="error"/>
    </p>

    <p>
        <label for="language">language: </label>
        <form:input type="text" id="language" path="language"/>
        <form:errors path="language" cssClass="error"/>
    </p>

    <p>
        <label for="length">length: </label>
        <form:input type="text" id="length" path="length"/>
        <form:errors path="length" cssClass="error"/>
    </p>

    <p>
        <label for="onDate">onDate: </label>
        <form:input type="text" id="onDate" path="onDate"/>
        <form:errors path="onDate" cssClass="error"/>
        (XXXX-XX-XX)
    </p>

    <p>
        <label for="imageUrl">imageUrl: </label>
        <form:input type="text" id="imageUrl" path="imageUrl"/>
        <form:errors path="imageUrl" cssClass="error"/>
    </p>

    <p>
        <label for="category">category: </label>
        <form:input type="text" id="category" path="category"/>
        <form:errors path="category" cssClass="error"/>
    </p>

    <p>
        <label for="type">type: </label>
        <form:input type="text" id="type" path="type"/>
        <form:errors path="type" cssClass="error"/>
    </p>

    <p>
        <label for="directors">directors: </label>
        <%--<c:forEach items="${directorsMap}" var="director">--%>
            <%--<form:checkbox path="directors" value="${director.key}" />${director.value}--%>
        <%--</c:forEach>--%>
        <c:forEach items="${directors}" var="director">
            <form:checkbox path="directors" value="${director.key}"/>${director.value}
        </c:forEach>
        <form:errors path="directors" cssClass="error"/>
    </p>

    <p>
        <label for="actors">actors: </label>
        <c:forEach items="${actors}" var="actor">
            <form:checkbox path="actors" value="${actor.key}"/>${actor.value}
        </c:forEach>
        <form:errors path="actors" cssClass="error"/>
    </p>

    <p>
        <input id="submit" type="submit" value="Submit">
    </p>
</form:form>
</body>
</html>
