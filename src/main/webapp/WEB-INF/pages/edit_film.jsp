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
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
            <a href="/show_all_film" class="section">All Films</a>
            <i class="right chevron icon divider"></i>
            <div class="active section">Edit Film</div>
        </div>

        <div class="inner-form-1">
            <div class="ui form">
                <form:form modelAttribute="filmEditor" action="/edit_film" method="post">
                    <div class="disabled field">
                        <label>id</label>
                        <form:input type="text" id="id" path="id" readonly="true"/>
                    </div>

                    <div class="field">
                        <label>name</label>
                        <form:input type="text" id="name" path="name" placeholder="名字"/>
                        <form:errors path="name" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>alias</label>
                        <form:input type="text" id="alias" path="alias" placeholder="别名"/>
                        <form:errors path="alias" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>brief</label>
                        <form:input type="text" id="brief" path="brief" placeholder="简介"/>
                        <form:errors path="brief" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>language</label>
                        <form:input type="text" id="language" path="language" placeholder="语言"/>
                        <form:errors path="language" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>length</label>
                        <form:input type="text" id="length" path="length" placeholder="长度"/>
                        <form:errors path="length" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>on date</label>
                        <form:input type="text" id="onDate" path="onDate" placeholder="上映日期(yyyy-MM-dd)"/>
                        <form:errors path="onDate" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>image url</label>
                        <form:input type="text" id="imageUrl" path="imageUrl" placeholder="图片链接"/>
                        <form:errors path="imageUrl" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>category</label>
                        <form:select path="category" cssClass="ui fluid dropdown" items="${categories}"/>
                        <form:errors path="category" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>type</label>
                        <form:select path="type" cssClass="ui fluid dropdown" items="${types}"/>
                        <form:errors path="type" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>directors</label>
                        <c:forEach items="${directors}" var="director">
                            <div class="ui checkbox add-margin-right">
                                <input name="directors" class="hidden" type="checkbox" value="${director.id}">
                                <form:checkbox path="directors" value="${director.id}" cssClass="hidden"/>
                                <label>${director.name}</label>
                            </div>
                        </c:forEach>
                        <form:errors path="directors" cssClass="error-message"/>
                    </div>

                    <div class="field">
                        <label>actors</label>
                        <c:forEach items="${actors}" var="actor">
                            <div class="ui checkbox add-margin-right">
                                <form:checkbox path="actors" value="${actor.id}" cssClass="hidden"/>
                                <label>${actor.name}</label>
                            </div>
                        </c:forEach>
                        <form:errors path="actors" cssClass="error-message"/>
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
        $('.ui.checkbox').checkbox();

        $('select.dropdown').dropdown();
    });
</script>

</body>
</html>
