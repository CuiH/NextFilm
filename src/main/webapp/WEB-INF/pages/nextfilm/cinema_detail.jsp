<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/31
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新一代电影网</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>NextFilm</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.js"></script>

    <script type="text/javascript" src="js/cinema_details.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/other_css/common_detail.css">
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


<div id="main-container" >
    <div id="fuck_you" class="failed" hidden>
        <h3>failed</h3>
    </div>
    <div id="fuck_you" class="show_ci" hidden>
        <div class="ciname_name_titile">
            <h1 class="left">广州飞扬影城-正佳店</h1>
        </div>
        <div class="details_left_right">
            <div class="ui_pic left_img">
                <div class="ui_movieBigType">
                    <img  width="280" class ="cinema_image"height="210" src="./广州飞扬影城-正佳店【正在售票】_排片表_票价_影讯 - 格瓦拉生活网_files/blank.gif" style="background:url(http://img5.gewara.com/cw280h210/images/cinema/201408/s7c804801_1481c2ee7a9__7fef.jpg) center center no-repeat #e7e7e7;">

                </div>
            </div>
            <div class="ui_text left_text">
                <div class="detail_head_text">
                    <dl class="clear">
                        <dt>地 址：</dt>
                        <dd class="cinema_address">天河路228号正佳广场7楼</dd>
                    </dl>
                    <hr>
                    <dl class="clear">
                        <dt>电 话：</dt>
                        <dd class="cinema_phone">
                            020-85590911 85598266
                        </dd>
                    </dl>
                    <hr>
                    <dl class="ui_hide">
                        <dt>影 院 简 介：</dt>
                        <dd class="cinama_brief">bibliblidfalfkjdfiauflafladfoaidfuo</dd>
                    </dl>
                    <hr>
                    <dl class="clear">
                        <dt>特 色：</dt>
                        <dd class="ffst">“５号天幕厅：中国巨幕ｘ杜比全景声，震撼视听新感受。”</dd>
                    </dl>

                </div>
            </div>
        </div>
        <div class="container">

            <div class="date_container ">
                <span class="glyphicon glyphicon-tag"  style="font-size: 20px;color: rgb(212, 106, 64);" aria-hidden="true">选择日期</span>
                <button type="button" id ='btn_0' class="btn date_btn btn-default" >5月30日</button>

                <button type="button" id ='btn_1' class="btn date_btn btn-default ">6月1日</button>

                <button type="button" id ='btn_2'class="btn date_btn btn-default ">6月1日</button>

                <!--<button type="button" id ='btn_3'class="btn date_btn btn-default ">6月1日</button>

               <button type="button" id ='btn_4'class="btn date_btn btn-default ">6月1日</button>
               Indicates a dangerous or potentially negative action
               <button type="button" id ='btn_5'class="btn date_btn btn-default">6月1日</button>
               <button type="button" id ='btn_6'class="btn date_btn btn-default ">6月1日</button>-->
            </div>
            <div class="films_container">
                <span  class="tag_span glyphicon glyphicon-tag"  style="font-size: 20px;color: rgb(212, 106, 64);" aria-hidden="true">选择影片</span>
                <div class='films_list'>
                    <ul id='ul_par'>
                        <li hidden  class='select panel '><img width="120px"  alt="爱丽丝梦游仙境2：镜中奇遇记" src="http://img5.gewara.com/cw96h128/images/movie/201604/s54cfd1ea_1544d51e139__7f47.jpg"><br><em>爱丽丝梦游仙</em></li>


                    </ul>
                </div>
            </div>
            <div class='time_list'>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>放映时间</th>
                        <th>结束时间</th>
                        <th>票价</th>
                        <th>放映厅</th>
                        <th>选座购票</th>
                    </tr>
                    </thead>
                    <tbody id='tbody_par'>
                    <tr hidden class="tr_row">
                        <th scope="row">1</th>
                        <td class="endTime">Mark</td>
                        <td class ="price">Otto</td>
                        <td class ="hall">@mdo</td>
                        <td><button class='btn btn-success'>选座购票</button></td>
                    </tr>


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
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
