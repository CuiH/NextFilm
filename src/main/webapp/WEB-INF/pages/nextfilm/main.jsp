<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/31
  Time: 18:17
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

    <script type="text/javascript" src="/res/js/nextfilm/main.js"></script>
    <link rel="stylesheet" type="text/css" href="/res/css/nextfilm/main.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid" style="width: 1270px;margin: 0 auto;">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">
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

<div id="main-container" style="min-height: 90%;">
    <div id="ad-container-bg">
        <div id="ad-container" class="row" style="padding: 10px;">
            <div id="ad-left" class="col-md-9">
                <div id="myCarousel" class="carousel slide">
                    <!-- 轮播（Carousel）指标 -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                    <!-- 轮播（Carousel）项目 -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="/res/image/1.jpg" alt="First slide">
                        </div>
                        <div class="item">
                            <img src="/res/image/2.jpg" alt="Second slide">
                        </div>
                        <div class="item">
                            <img src="/res/image/3.jpg" alt="Third slide">
                        </div>
                    </div>
                </div>
            </div>
            <div id="ad-right" class="col-md-3">
                <div id="coupon" style="background-color: white; padding: 6px;height:390px;">
                    <p>优惠信息</p>
                    <img src="/res/image/4.jpg">
                    <span class="sspan">[苏州]2016迷笛电子音乐节(预售)</span>
                    <span class="sspan">[广州]2015维纳斯音乐节(预售)</span>
                    <hr>
                    <span class="sspan">[苏州]2016迷笛电子音乐节(预售)</span>
                    <span class="sspan">[广州]2015维纳斯音乐节(预售)</span>
                </div>
            </div>
        </div>
    </div> <!-- ad-container -->

    <div id="film-new-container-bg">
        <div id="film-new-container" style="width: 1200px;margin: 0 auto;">
            <p style="font-size: 12pt;">近期热门</p>
            <hr>
            <!-- Columns are always 25% wide, on mobile and desktop -->
            <div id="film-new-list" class="row">

            </div>
        </div>
    </div> <!-- film-new-container-bg -->

    <div id="cinema-new-container-bg" style="margin-top: 45px;margin-bottom: 45px;">
        <div id="cinema-new-container" style="width: 1200px;margin: 0 auto;">
            <p style="font-size: 12pt;">推荐场馆</p>
            <hr>
            <!-- Columns are always 25% wide, on mobile and desktop -->
            <div id="cinema-new-list" class="row">
                <div class="col-md-6">
                    <div>
                        <img class="cinema-img">
                        <span class="sspan"></span>
                        <p></p>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <img class="cinema-img">
                        <span class="sspan"></span>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/html" id="template">
    <div class="col-md-3">
        <div>
            <a data-link="id" data-format="LinkFomatter"><img data-src="imageUrl" class="show-img"></a>
            <span data-content="name" class="sspan"></span>
            <p data-content="brief" class="show-p"></p>
        </div>
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
