<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/15
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Detail</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>
    <link href="/res/css/layout.css" rel="stylesheet">
</head>
<body>
<!-- 外框 -->
<div class="holder1">
    <div class="ui segment">
        <!-- 导航 -->
        <h2 class="ui left floated header">NextFilm 后台管理系统</h2>
        <div class="ui clearing divider"></div>
        <div class="ui huge breadcrumb">
            <a href="/home" class="section">Home</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">Edit Detail</div>
        </div>

        <div class="inner-form-1">
            <div class="ui form">
                <form:form modelAttribute="userDetailEditor" action="/edit_detail" method="post">
                    <div class="field">
                        <label>first name</label>
                        <form:input type="text" id="firstName" path="firstName" placeholder="名"/>
                        <form:errors path="firstName" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>last name</label>
                        <form:input type="text" id="lastName" path="lastName" placeholder="姓"/>
                        <form:errors path="lastName" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>gender</label>
                        <c:forEach items="${genders}" var="gender">
                            <div class="ui radio checkbox">
                                <form:radiobutton path="gender" value="${gender}" cssClass="hidden"/>
                                <label>${gender}</label>
                            </div>
                        </c:forEach>
                        <form:errors path="gender" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>birthday</label>
                        <form:input type="text" id="birthday" path="birthday" placeholder="生日(yyyy-MM-dd)"/>
                        <form:errors path="birthday" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>city</label>
                        <form:select path="city" cssClass="ui fluid dropdown" items="${cities}"/>
                        <form:errors path="city" cssClass="error-message"/>
                    </div>

                    <div class="submit-button">
                        <button class="ui button my-button-2">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $('.ui.radio.checkbox').checkbox();

        $('select.dropdown').dropdown();
    });
</script>

</body>
</html>
