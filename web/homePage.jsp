<%@ page import="cn.lzc.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="contextPath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>影视信息平台</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/content.css"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/carousel.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"/>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
            text-decoration: none;
            list-style: none;
        }
    </style>
    <%
        User user=(User)request.getSession().getAttribute("user");
    %>
</head>
<body style="background-color: #232325">



    <div class="header">
        <div class="nav">
            <div class="nav-left">
                <i class="fa fa-play-circle-o" style="color: #00BE06;font-size: 28px;font-weight: bold" aria-hidden="true"></i>
                <label style="color: #00BE06;font-family: 华文彩云;font-weight:bold;font-size: 30px;">
                        <b>影视信息平台</b>
                </label>
            </div>
            <div class="nav-center">
            </div>
            <div class="nav-right">
                <div class="menu">
                    <ul class="menu-list">
                        <c:if test="${sessionScope.loginFlag}">
                            <li style="border: 0px"><label style="color: #CCCCCC">ID:${user.userName}</label></li>
                            <li style="border: 0px">
                                <c:if test="${sessionScope.user.userIdentity=='0'}">
                                    <i class="fa fa-user" style="font-size: 22px;color: #CCCCCC" aria-hidden="true">
                                        <label style="color: #CCCCCC;">普通用户</label>
                                    </i>
                                </c:if>
                                <c:if test="${sessionScope.user.userIdentity=='1'}">
                                    <i class="fa fa-user" style="font-size: 22px;color: #CCCCCC" aria-hidden="true">
                                        <label style="color: #CCCCCC;">管理员</label>
                                    </i>
                                </c:if>
                            </li>
                            <c:if test="${sessionScope.user.userIdentity=='1'}">
                                <li>
                                    <i class="fa fa-bars" style="font-size: 22px;color: #CCCCCC" aria-hidden="true">
                                        <a href="manage.jsp">管理中心</a>
                                    </i>

                                </li>
                            </c:if>
                            <li>
                                <i class="fa fa-sign-out" style="font-size: 22px;color: #CCCCCC">
                                    <a href="LogoutServlet">退出</a>
                                </i>
                            </li>
                        </c:if>
                        <c:if test="${!sessionScope.loginFlag}">
                            <li>
                                <i class="fa fa-user-circle" style="font-size: 20px;color: #CCCCCC" aria-hidden="true">
                                    <a href="login.jsp">登录</a>
                                </i>
                            </li>
                            <li>
                                <i class="fa fa-user-circle-o" style="font-size: 20px;color: #CCCCCC" aria-hidden="true">
                                    <a href="register.jsp">注册</a>
                                </i>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>



    <div class="container">
        <div class="carousel" >
            <li><img src="imgs/banner-1.webp" style="width: 1700px;height: 600px"/></li>
            <li><img src="imgs/banner-2.webp" style="width: 1700px;height: 600px"/></li>
            <li><img src="imgs/banner-3.webp" style="width: 1700px;height: 600px"/></li>
            <li><img src="imgs/banner-4.webp" style="width: 1700px;height: 600px"/></li>
            <li><img src="imgs/banner-5.webp" style="width: 1700px;height: 600px"/></li>
            <li><img src="imgs/banner-6.webp" style="width: 1700px;height: 600px"/></li>
            <li><img src="imgs/banner-7.webp" style="width: 1700px;height: 600px"/></li>
        </div>
    </div>
    <script type="text/javascript" src="${contextPath}/js/carousel.js"></script>




    <div class="content">
        <div class="nav">
            <div class="menu">
                <li><a href="OnloadMovieServlet" target="display-frame"><b>电影</b></a></li>
                <li><a href="pages/DSJpage.html" target="display-frame"><b>电视剧</b></a></li>
                <li><a href="pages/ZYpage.html" target="display-frame"><b>综艺</b></a></li>
                <li><a href="pages/DMpage.html" target="display-frame"><b>动漫</b></a></li>
                <li><a href="pages/JLPpage.html" target="display-frame"><b>纪录片</b></a></li>
            </div>
        </div>
        <div class="display-area">
            <iframe class="display-frame" src="${contextPath}/OnloadMovieServlet" name="display-frame" frameborder="0" ></iframe>
        </div>
    </div>






    <div class="footer">
        我是尾部
    </div>


</body>
</html>
