<%--
  Created by IntelliJ IDEA.
  User: CuiH
  Date: 2016/5/30
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>NextFilm</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.js"></script>

    <script type="text/javascript" src="res/js/nextfilm/register.js"></script>
    <link rel="stylesheet" type="text/css" href="res/css/nextfilm/register.css">
</head>
<body style="width: 100%;height: 100%;
    background-image: url(/res/image/register_bg3.jpg);
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;">

<div id="sign" style="position: absolute;left:50%;top:50%;transform: translate(-50%, -50%);padding: 5px;">
    <div id="signCon" style="margin: 0 auto">

        <div id="title">
            <p style="color: white;margin: 40px 40px 40px 27px;font-size: 20pt;">Welcome to NextFilm</p>
        </div>

        <div style="max-width: 500px;">
            <form id="signForm" class="center-block form-horizontal" style="margin: 8px;">
                <div class="form-group">
                    <div class="col-sm-8" style="width: 95%;">
                        <input name="username" type="text" class="form-control" id="inputEmail3" placeholder="Username">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-8" style="width: 95%;">
                        <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="Password">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10" style="margin: 0 auto;">
                        <div id="signin-btn" type="button" class="btn btn-success" style="width: 90px; margin: 20px 10% 0 15%;">Sign in</div>
                        <div id="signup-btn" type="button" class="btn btn-default" style="width: 90px; margin: 20px 0 0 0;">Sign up</div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div id="mymodal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="mySmallModalLabel">result</h4>
            </div>
            <div class="modal-body">
            </div>
        </div>
    </div>
</div>
</body>
</html>
