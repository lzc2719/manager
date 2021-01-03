<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/12/22
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link rel="stylesheet" href="css/register.css">
    <style>
        *{
            margin: 0px;
            padding: 0px;
            list-style: none;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <%@include file="top.jsp"%>
    <div class="container">
        <div class="content">
            <form action="RegisterServlet" method="post">
                <ul>
                    <li><label style="font-size: 20px"><b>账号：</b></label><input class="account-text" type="text" id="account" name="account" placeholder="请输入账号"></li>
                    <li><label style="font-size: 20px"><b>密码：</b></label><input class="password-text" type="password" id="password" name="password" placeholder="请输入密码"></li>
                    <li><label style="font-size: 20px"><b>用户名：</b></label><input type="text" class="username-text" id="userName" name="userName" placeholder="请输入用户名"></li>
                    <li><label style="font-size: 20px"><b>注册身份：</b></label>&nbsp;
                        <label style="font-size: 18px">&nbsp;普通用户&nbsp;</label><input style="width: 15px;height: 15px" type="radio" name="userIdentity" value="0">&nbsp;&nbsp;&nbsp;
                        <label style="font-size: 18px">管理员&nbsp;</label><input style="width: 15px;height: 15px" type="radio" name="userIdentity" value="1"></li>
                    <li><input style="width: 160px" type="submit" value="注册"></li>
                </ul>
            </form>
        </div>
    </div>
    <%@include file="bottom.jsp"%>
</body>
</html>
