<%--
  Created by IntelliJ IDEA.
  User: 1998g
  Date: 2018/9/8
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/crowd.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <style>
          .role{
              margin-top: 15px;
              padding-left: 50px;
          }
          .username{
              position:relative;

          }
         span{
             position:absolute;
             top:26px;
             left:16px;
             color:green;
             font-size:14px;
         }
        span::before{
            content:" ";
            position: absolute;
            background-color:green;
            top:12px;
            left:-13px;
            width: 10px;
            height: 10px;
            border-radius:50%;
        }

    </style>
    <script src="jquery/jquery-1.12.4.js"></script>
    <script>

        $(function () {

            // 表单验证
            $(".username input").blur(function () {
                var $parent = $(this).parent();
                $parent.find(".errorTip").remove();
                $parent.find(".successTip").remove();
                if($(this).val() == ""){
                    var error = "用户名不能为空";
                    $('<span class="errorTip">'+error+'</span>')
                        .appendTo($parent);
                    return false;
                }else {
                    var success = "填写正确";
                    $('<span class="successTip">'+success+'</span>')
                        .appendTo($parent);
                }
            });
            $(".password input").blur(function () {
                var $parent = $(this).parent();
                $parent.find(".errorTip").remove();
                $parent.find(".successTip").remove();
                if($(this).val() == ""){
                    var error = "密码不能为空";
                    $('<span class="errorTip">'+error+'</span>')
                        .appendTo($parent);
                    return false;
                }else {
                    var success = "填写正确";
                    $('<span class="successTip">'+success+'</span>')
                        .appendTo($parent);
                }
            });
        });
    </script>
    <script>
        function regist() {
            var targetForm = document.forms[1];
            targetForm.action = "registAction1";
            targetForm.submit();
        }
        function login(){
            var target = document.forms[0];
            var role = target.role;
            for(var i = 0; i<role.length;i++){
                if(role[0].checked){
                    target.action="LoginAction";
                    target.submit();
                }else{
                    target.action="adminAction1";
                    target.submit();
                }
            }
        }

    </script>
</head>
<body>
<header>
    <div class="bg">
        <canvas id="display" ></canvas>
        <div id="blachole"></div>
        <div class="content content-login">
            <h3 class="title">图书管理系统</h3>
            <div class="form">
                <form action="action!methodName"  method="post">
                    <div class="form-control username" >
                        <label for="username" class="normal"><i class="fa fa-user "></i></label>
                        <input type="text" name="username" id="username" required placeholder="用户名">
                    </div>
                    <div class="form-control password">
                        <label for="password" class="normal"><i class="fa fa-lock "></i></label>
                        <input type="password" name="password" id="password" required placeholder="请输入密码">
                    </div>
                    <div class="role">
                        <input type="radio" name="role" value="用户">用户
                        <input type="radio" name="role" value="管理员">管理员
                    </div>
                    <input type="submit" class="btn" value="登录" onclick="login()">
                    <button class="btn" id="register">注册</button>
                </form>
            </div>
        </div>
        <div class="content content-register">
            <h3 class="title">注册界面</h3>
            <div class="form">
                <form action="action!methodName">
                    <div class="form-control username">
                        <label for="r-username" class="normal"><i class="fa fa-user "></i></label>
                        <input type="text" name="username" id="r-username" required placeholder="请输入用户名">
                    </div>
                    <div class="form-control password">
                        <label for="r-password" class="normal"><i class="fa fa-lock "></i></label>
                        <input type="password" name="password" id="r-password" required placeholder="请输入密码">
                    </div>
                    <div class="role" >
                        <input type="radio" name="role" value="用户">用户
                        <input type="radio" name="role" value="管理员">管理员
                    </div>

                    <input type="submit" class="btn" value="注册" onclick="regist()">
                    <button class="btn" id="login" >登陆</button>
                </form>
            </div>
        </div>
    </div>

</header>


<script type="text/javascript" src="js/constellation.js"></script>
<script src="js/button.js"></script>
</body>
</html>