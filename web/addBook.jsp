<%--
  Created by IntelliJ IDEA.
  User: 1998g
  Date: 2018/10/8
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="animate.css/animate.min.css">
<body>
<s:fielderror/>

<form action="addBookAction" id="form" method="post" enctype="multipart/form-data" >
    编号：<input type="text" name="book.bookId"></br>
    书名：<input type="text" name="book.bookName"></br>
    价格：<input type="text" name="book.bookPrice"></br>
    封皮展示： <input type="file" name="photo" label="选择"/>
    <input type="submit"   value="提交">
</form>


</body>
</html>
