<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新一代电影网</title>
    <link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
    <link href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.css" rel="stylesheet">
    <script src="bootstrap-3.3.5-dist/js/jquery-1.11.3.min.js"></script>
    <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.js"></script>

    <script type="text/javascript" src="js/films.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid" style="width: 1270px;margin: 0 auto;">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img class="img-circle" alt="Brand" src="image/social_19.png" style="display: inline-block;position: relative;top: -105%;left: 5%;">
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
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" id='search_fuck' style="color: red;"  placeholder="搜索电影、艺人">
                    <span class="glyphicon glyphicon-search" id='search_btn'  aria-hidden="true" style="position: relative;left: -13%; color: #999;"></span>
                </div>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="register.html">登录|注册</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的账号 <span class="caret"></span></a>
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
<div id="main-container" >
    <div class="type_list clearfix">
        <!-- <ul class="type_tab clearfix">
            <li class="on">按演出时间</li>
            <li style="display: none">按门票价格</li>
        </ul> -->
        <div class="type_list_box" id = 'fuck'>
            <div class="showList">
                搜索 <strong class="film_name"></strong> 获得约 <b class = "film_number"></b> 条结果<br/><hr/>
            </div>
            <dl class="ui_abeam search_channel" hidden>
                <dt class="uipic">
                    <a target="_blank" href="/movie/155903443?fyrq=" title="">
                        <img width="96" height="128" src="http://img5.gewara.com/cw96h128/images/movie/201605/s_6e62e7d_1549f7abdfd__7d7c.jpg">
                    </a>
                </dt>
                <dd class="uiText">
                    <h2><em class="ffst">[电影]</em><a target="_blank" href="/movie/155903443"><span class="dd_film" style="background-color: #2ed2c1;font-weight: bold;"></span></a></h2><br>
                    <span class="ihalf"><em >上映时间：</em><span class="dd_time"></span></span>
                    <span class="ihalf"><em>电影类型：</em><span class="dd_type"></span></span><br>
                    <span><em>导演/主演：</em><span class="dd_actors"></span></span><br>
                    <span><em>简介：</em><span class="dd_brief"></span></span><br>
                </dd>
            </dl>

        </div>
    </div>
</div>
<div id="footer">
    <div id="footer-container">
        <div class="row">
            <div class="col-md-4" style="border-right: outset;">
                <div style="margin: 0 auto; width: 200px;">
                    <img src="image/social_19.png">
                    <p style="font-size: 18pt;">NextFilm</p>
                </div>
            </div>
            <div class="col-md-4" style="border-right: outset;height: 64px;">
                <div style="margin: 0 auto;width: 240px;">
                    <img style="width: 50px;height:50px;margin-bottom: 14px;" src="image/social_47.png">
                    <p style="font-size: 18pt;display: inline-block;">4001-100-100</p>
                </div>
            </div>
            <div class="col-md-4" style="height: 64px;">
                <div style="margin: 0 auto;width: 340px;">
                    <img style="width: 50px;height:50px;margin-bottom: 14px;" src="image/social_01.png">
                    <img style="width: 50px;height:50px;margin-bottom: 14px;" src="image/social_54.png">
                    <img style="width: 50px;height:50px;margin-bottom: 14px;" src="image/social_37.png">
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