<%--
  Created by IntelliJ IDEA.
  User: cuihao
  Date: 2016/5/27
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Showing</title>
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="//cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>
    <link href="/res/css/layout.css" rel="stylesheet">
</head>
<body>
<div class="ui middle aligned divided list">
    <div class="item">
        <img id="cinema_image" class="ui avatar image">
        <div class="content">
            <a id="cinema_field" class="header"></a>
        </div>
    </div>
    <div class="item">
        <img id="film_image" class="ui avatar image">
        <div class="content">
            <a id="film_field" class="header"></a>
        </div>
    </div>
    <div class="item">
        <img class="ui avatar image">
        <div class="content">
            <a id="hall_field" class="header"></a>
        </div>
    </div>
</div>

<h2>seats</h2>
<div id="seats_field">
</div>


<button id="try" class="ui primary button">try</button>
<button id="try2" class="ui primary button">try</button>
</body>

<script>
    $(document).ready(function() {
        $(document).ready(function() {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/get_film?name=24",
                dataType:"jsonp",
                jsonpCallback:"ch",
                data: $("#login_form").serialize(),
                success: function(data) {
                    // 解析一下
                    console.log(data);
                    //data = JSON.parse(data);

                    // 首先判断是否成功
                    if (data["result"] == "success") {
                        alert(data["data"][0]["name"]);
                    } else {
                        alert("2");
                    }
                },
                error: function() {
                    alert("3");
                }
            });
        });

        $("#try").click(function () {
            var d = "showingId=8&seats=1T1&seats=2T2";
            $.ajax({
                type: "POST",
                dataType: "html",
                url: "/make_reservation",
                data: d,
                success: function (response) {
                    response = JSON.parse(response);
                    if (response["result"] == "success") {
                        console.log("success");
                    } else {
                        console.log(response["reason"]);
                    }
                },
                error: function () {
                    alert("error");
                }
            });
        });

        $("#try2").click(function () {
            var d = "showingId=8&seats=1T1&seats=2T3";
            $.ajax({
                type: "POST",
                dataType: "html",
                url: "/make_reservation",
                data: d,
                success: function (response) {
                    response = JSON.parse(response);
                    if (response["result"] == "success") {
                        console.log("success");
                    } else {
                        console.log(response["reason"]);
                    }
                },
                error: function () {
                    alert("error");
                }
            });
        });

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "/view_showing?id=8",
            success: function(response) {
                response = JSON.parse(response);
                if (response["result"] == "success") {
                    var data = response["data"];

                    $("#cinema_field").text("cinema id: " + data["cinema"]["id"] + ", cinema name: " + data["cinema"]["name"]);
                    $("#film_field").text("film id: " + data["film"]["id"] + ", film name: " + data["film"]["name"]);
                    $("#hall_field").text("hall name: " + data["hall"]["name"]);

                    $("#cinema_image").attr("src", data["cinema"]["imageUrl"]);
                    $("#film_image").attr("src", data["film"]["imageUrl"]);

                    var seats = data["seats"];
                    for (var i = 0; i < seats.length; i++) {
                        $("#seats_field").append("<p>" + seats[i]["rowPos"] + ", " + seats[i]["columnPos"] + ", " + seats[i]["status"] + "</p>");
                    }
                } else {
                    console.log(response["reason"]);
                }
            },
            error: function() {
                alert("error");
            }
        });
    });
</script>

</html>
