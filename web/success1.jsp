<%--
  Created by IntelliJ IDEA.
  User: 1998g
  Date: 2018/10/8
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .header{
            position: relative;
            height: 80px;
            width:auto;
            background-color: #e4b9b9;
        }
        .photo{
            position: absolute;
            top:25px;
            left:20px;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            border:1px solid #e4b9b9;
            overflow: hidden;
            background: url("images/bg.jpg") no-repeat center center;
        }
        .photo img{
            position: absolute;
            top:25px;
            left:20px;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            border:1px solid #e4b9b9;
            overflow: hidden;
            z-index:2;
        }
        p{
           position: absolute;
            top:50px;
            left:72px;
            color: white;
        }

    </style>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="jquery/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<%@ taglib prefix="s" uri="/struts-tags" %>
<body>
   <div class="header">
    <div class="top">
        <div class="photo">
            <%--<img src="<s:property value="'upload/'+uploadFileName"/>" />--%>
        </div>


         <p>${sessionScope.user}登录</p>
    </div>
   </div>

   <div class="nav">
       <span id="cloud"></span>
       <ul id="navBar">

               <li><a href="showBookAction">查询图书信息</a></li>
               <li><a href="addBook.jsp">添加图书信息</a></li>

       </ul>
   </div>


</body>
</html>
