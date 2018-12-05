<%--
  Created by IntelliJ IDEA.
  User: 1998g
  Date: 2018/9/22
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: #eee;
        }
        
         div{
             position:relative;
             margin:200px auto;
             width: 300px;
             height: 150px;
             background-color: #444;
             border-radius:5px;
             box-shadow: 2px 2px 2px 5px #444 ;
         }
         p{
             color:white;
             margin:10px;
         }
        button{
            background-color: #1b6d85;
            color:white;
            font-size:20px;
            border:2px solid #1b6d85;
        }
        button{
            position: absolute;
            left:50%;
            top:100px;

            width: 100px;
            height: 40px;
            transform: translateX(-50%);
        }
         button:hover{
             background-color: #1b6d85;
             border-radius:10px;

         }
        a{
            text-decoration:none;
            color:white;
        }

    </style>
    <link rel="stylesheet" href="animate.css/animate.min.css">
</head>
<body>

    <div class="animated rollIn">
        <p>抱歉您尚未登录，请先登录</p>
        <button><a href="index.jsp">确定</a></button>
    </div>



</body>
</html>
