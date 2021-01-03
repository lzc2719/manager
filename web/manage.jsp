<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/12/24
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理中心</title>
    <link rel="stylesheet" href="css/manage.css">
</head>
<body>
    <%@include file="top.jsp"%>
    <div class="container">
        <div class="content">
            <div class="content-left">
                <div class="menu">
                    <ul>
                        <li><a href="pages/movieMessageManage.jsp" target="display-frame">影视信息管理</a></li>
                        <li><a href="pages/movieTypeManage.jsp" target="display-frame">影视类型管理</a></li>
                    </ul>
                </div>
            </div>
            <div class="content-right">
                <iframe name="display-frame" src="pages/movieMessageManage.jsp" frameborder="0"></iframe>
            </div>
        </div>
    </div>
    <%@include file="bottom.jsp"%>
</body>
</html>
