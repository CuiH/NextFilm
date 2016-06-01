<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/1
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新一代电影网</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.js"></script>

    <script type="text/javascript" src="/res/js/nextfilm/jquery.loadTemplate-1.5.7.min.js"></script>

    <script type="text/javascript" src="/res/js/nextfilm/view_film.js"></script>


    <link rel="stylesheet" type="text/css" href="/res/css/nextfilm/view_film.css">
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的账号 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li id="user-name"><a href="#">Action</a></li>
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
    <div id="film-container-bg">
        <div id="film-container"></div>

        <div style="margin-top: 35px;" id="show-container">
            <div>
                <h1>场次信息</h1>
                <hr>
            </div>

            <div id="show-container-bg" style="margin-bottom: 30px;">
                <div class="row" id="show-container-header">
                    <div class="col-md-6"><p>影片</p></div>
                    <div class="col-md-2"><p>时间</p></div>
                    <div class="col-md-1" style="text-indent: 10px;"><p>类型</p> </div>
                    <div class="col-md-1" style="text-indent: 10px;"><p>价格</p> </div>
                    <div class="col-md-2"></div>
                </div>

                <div id="show-main-container">

                </div>
            </div>
        </div>

    </div> <!-- ad-container -->
</div>

<script type="text/html" id="show-t1">
    <div class="row" style="margin-top: 25px;">
        <div data-content="cinema" data-format="nestedTemplateFormatter" data-format-options="#show-t2"></div>
        <div data-content="showings" data-format="nestedTemplateFormatter" data-format-options="#show-t3"></div>
    </div>
</script>

<script type="text/html" id="show-t4">
    <p data-content="type"></p>
</script>

<script type="text/html" id="show-t3">
    <div class="col-md-2"><p data-content="startTime"></p></div>
    <div class="col-md-1" data-content="hall" data-format="nestedTemplateFormatter" data-format-options="#show-t4"></div>
    <div class="col-md-1"><p data-content="priceManual"></p></div>
    <div class="col-md-2"><button>购买</button></div>
</script>


<script type="text/html" id="show-t2">
    <div class="col-md-6">
        <img data-src="imageUrl" style="width: 160px; height: 100px;margin-right: 20px;margin-left: 20px;">
        <div style="display: inline-block;">
            <p data-content="name"></p>
            <p data-content="address"></p>
        </div>
    </div>
</script>

<script type="text/html" id="t2">
    <div style="display: inline-block;margin-right: 25px;">
        <img class="avatar" data-src="imageUrl">
        <p data-content="name">linxux</p>
    </div>
</script>

<script type="text/html" id="template">
    <div>
        <h1 data-content="name"></h1>
        <p data-content="alias"></p>
        <hr>
    </div>

    <div class="row" style="padding: 10px;">
        <div id="film-left" class="col-md-3">
            <img class="show-img" data-src="imageUrl">
        </div>

        <div class="col-md-8" style="margin-top:25px;">
        <div id="film-directors">
            <p style="margin-right: 20px;display: inline-block;vertical-align: 45px;">导演:</p>
            <div style="display: inline-block; margin-right: 20px;" id="director">
                <div style="display: inline-block;" data-content="directors" data-format="nestedTemplateFormatter" data-format-options="#t2">

                </div>
            </div>
            <hr>
        </div>

        <div id="film-actors">
            <p style="margin-right: 20px;display: inline-block;vertical-align: 45px;">演员:</p>
            <div style="display: inline-block; margin-right: 20px;">
                <div data-content="actors" data-format="nestedTemplateFormatter" data-format-options="#t2"></div>

            </div>
            <hr>

            <div id="film-brief">
                <p style="display: inline-block;">剧情:</p>
                <span style="display: block; margin-left: 40px;text-indent: 25px;width: 600px;" data-content="brief"></span>
            </div>

            <hr>
            <div>
                <p style="margin-right: 20px;display: inline-block;">分类:</p>
                <span data-content="category" class="sspan">美国</span>
                <span data-content="type" class="sspan">美国</span>
                <span data-content="onDate" class="sspan">美国</span>
                <span data-content="language" class="sspan">美国</span>
                <span data-content="length" class="sspan">美国</span>
            </div>
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
