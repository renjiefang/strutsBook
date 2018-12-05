<%--
  Created by IntelliJ IDEA.
  User: ren
  Date: 2018/10/8
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
    <style>
        .wraper{
           height:500px;
           width:400px;
           margin:100px auto;
            background-color: #eee;
            opacity: .6;
            border-radius:10px;
            
        }
        body{
            background: url("images/3.jpg") no-repeat center;
        }
        
    </style>
    <link rel="stylesheet" href="animate.css/animate.min.css">
    
</head>
<body>
  <div  id="out">
   <div class="wraper" >
   <s:form action="updateBookAction"  id="form" method="post" class="form-inline"  namespace="/">
       <s:textfield label="编号" name="book.bookId" value="%{book.bookId}" /><br><br>
       <s:textfield label="图书名称" name="book.bookName" value="%{book.bookName}"/><br><br>
       <s:textfield label="价格" name="book.bookPrice" value="%{book.bookPrice}"/><br><br>
       <input type="button" onclick="ren()" value="提交" id="one">
   </s:form>
   </div>
  </div>
  <script>

        var Oout=document.querySelector("#out");
        var form=document.querySelector("#form");
            function ren(){
                Oout.className="animated bounceOutUp";
                setTimeout("up()",500);
            }

           function up(){
               form.submit();
           }


  </script>
</body>
</html>
