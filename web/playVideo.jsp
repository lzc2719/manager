<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/12/30
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="contextPath.jsp"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/playVideo.css"/>
</head>
<body>
    <%@ include file="top.jsp"%>
    <div class="content">
        <div class="play-area">
            <video width="100%" height="100%" controls="controls">
                <source src="${contextPath}/videos/卡特教练.mp4" type="video/mp4">
            </video>
        </div>
    </div>
    <%@ include file="bottom.jsp"%>
</body>
</html>
