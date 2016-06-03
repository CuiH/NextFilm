<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/3
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新一代电影网</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.js"></script>

    <script type="text/javascript" src="/res/js/nextfilm/jquery.loadTemplate-1.5.7.min.js"></script>

    <script type="text/javascript" src="/res/js/nextfilm/orders.js"></script>


    <link rel="stylesheet" type="text/css" href="/res/css/nextfilm/orders.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid" style="width: 1270px;margin: 0 auto;">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img class="img-circle" alt="Brand" src="/res/image/social_19.png" style="display: inline-block;position: relative;top: -105%;left: 5%;">
                <p style="display: inline-block;position: relative;top: -105%;">NextFilm</p>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav">

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">城市 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>

                <li><a href="#">电影</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="register.html">登录|注册</a></li>
                <li class="dropdown">
                    <a  id="user-name" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的账号 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->

    </div> <!-- container fluid -->
</nav>

<div id="main-container" style="min-height: 80%;">
    <div id="film-container-bg">
        <div id="film-container"></div>

        <div id="show-container">
            <div>
                <h1>订单信息</h1>
                <hr>
            </div>

            <div id="show-container-bg" style="margin-bottom: 30px;">
                <div class="row" id="show-container-header">
                    <div class="col-md-4"><p>影片</p></div>
                    <div class="col-md-2"><p>订票时间</p></div>
                    <div class="col-md-2"><p>开始时间</p></div>
                    <div class="col-md-1" style="text-indent: 10px;"><p>座位数</p> </div>
                    <div class="col-md-1" style="text-indent: 10px;"><p>价格</p> </div>
                    <div class="col-md-1" style="text-indent: 10px;"><p>状态</p></div>
                    <div class="col-md-1"></div>
                </div>

                <div id="show-main-container">

                </div>
            </div>
        </div>

    </div> <!-- ad-container -->
</div>

<script type="text/html" id="show-t1">
    <div class="row" style="margin-top: 15px;">
        <div class="col-md-4">
            <img data-src="filmImageUrl" style="width: 160px; height: 200px;margin-right: 20px;margin-left: 20px;">
            <div style="display: inline-block;">
                <p data-content="filmName"></p>
                <p data-content="cinemaName"></p>
            </div>
        </div>
        <div class="col-md-2"><p style="margin-top: 50%" data-content="createTime"></p></div>
        <div class="col-md-2"><p style="margin-top: 50%" data-content="startTime"></p></div>
        <div class="col-md-1"><p style="margin-top: 115%" data-content="seatNum"></p> </div>
        <div class="col-md-1"><p style="margin-top: 115%" data-content="totalPrice"></p> </div>
        <div class="col-md-1"><p style="margin-top: 115%" data-content="status"></p></div>
        <div class="col-md-1"></div>
    </div>
</script>

<div id="footer">
    <div id="footer-container">
        <div class="row">
            <div class="col-md-4" style="border-right: outset;">
                <div style="margin: 0 auto; width: 200px;">
                    <img src="/res/image/social_19.png">
                    <p style="font-size: 18pt;">NextFilm</p>
                </div>
            </div>
            <div class="col-md-4" style="border-right: outset;height: 64px;">
                <div style="margin: 0 auto;width: 240px;">
                    <img style="width: 50px;height:50px;margin-bottom: 14px;" src="/res/image/social_47.png">
                    <p style="font-size: 18pt;display: inline-block;">4001-100-100</p>
                </div>
            </div>
            <div class="col-md-4" style="height: 64px;">
                <div style="margin: 0 auto;width: 340px;">
                    <img style="width: 50px;height:50px;margin-bottom: 14px;" src="/res/image/social_01.png">
                    <img style="width: 50px;height:50px;margin-bottom: 14px;" src="/res/image/social_54.png">
                    <img style="width: 50px;height:50px;margin-bottom: 14px;" src="/res/image/social_37.png">
                    <p style="font-size: 18pt;display: inline-block;">关注我们</p>
                </div>
            </div>
        </div>
        <div style="width: 700px; margin: 0 auto;margin-top: 15px;">
            <div class="row">
                <div class="col-md-6">
                    <p style="float: right;font-size: 12pt;">@系统分析与设计小组TeamXX</p>
                </div>
                <div class="col-md-6">
                    <p style="font-size: 12pt;">@开源框架Bootstrap</p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
