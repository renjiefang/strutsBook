
<%@ page import="com.opensymphony.xwork2.util.ValueStack" %><%--
  Created by IntelliJ IDEA.
  User: ren
  Date: 2018/9/27
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
    <style>
       .ph{
           width: 80px;
           height: 100px;
           border:1px solid #e4b9b9;
           overflow:hidden;
       }
        span{
            display:block;
            width: 60px;
            height: 80px;
            border-radius:50%;
            border:1px solid #e4b9b9;
            background: url(images/bg.jpg) no-repeat;
            background-size:60px 80px;
        }
        div p{
            height: 40px;
            color:white;
            background-color: #bce8f1;
            line-height: 40px;
        }
    </style>
    <link rel="stylesheet" href="animate.css/animate.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div><p>${sessionScope.tip}</p></div>
<div class="animated fadeInUp">
    <table class=" table  table-bordered table-hover table-condensed">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>封皮展示</td>
            <td>操作</td>
        </tr>
        <s:iterator value="bookList" status="index">
            <s:if test="#index.odd== true">
                <tr class="success"></tr>
            </s:if>
            <s:else>
                <tr ></tr>
            </s:else>

            <td ><s:property value="bookId"/></td>
            <td  class="danger"><s:property value="bookName"/></td>
            <td  class="success"><s:property value="bookPrice"/></td>
            <td ><img src="<s:property value="bookPhoto"/>" width="60" height="80" alt="不能显示"></td>
            <td><a href='<s:url action="getBook"><s:param name="bookId" value="bookId"></s:param></s:url>'>编辑</a>
            &nbsp;&nbsp;<a href='<s:url action="delBook"><s:param name="bookId" value="bookId"></s:param></s:url>'>删除</a></td>
        </s:iterator>

        <tr><td colspan="5" align="center" border="0">
            共<s:property value="lastpage"/> 页，
            第<s:property value="p"/> 页&nbsp;&nbsp;&nbsp;
            <a href='<s:url action="stulist" namespace="/">
			<s:param name="p" value="1"></s:param>
			</s:url>'>首页
            </a>
            <a href='<s:url action="stulist" namespace="/">
			<s:param name="p" value="lastpage"></s:param>
			</s:url>'>尾页
            </a>

                <ul class="pager">
                    <li><a href="<s:url action="stulist" namespace="/">
			         <s:param name="p" value="%{p-1}"></s:param>
			         </s:url>">Previous</a></li>
                     <li><a href="<s:url action="stulist" namespace="/">
			         <s:param name="p" value="%{p+1}"></s:param>
			         </s:url>">Next</a></li>
                </ul>



        </td></tr>

    </table

</div>

</body>
</html>
