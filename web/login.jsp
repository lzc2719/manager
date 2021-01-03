<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="css/login.css"/>
    <script type="text/javascript" src="js/isUserExistAjax.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
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
                <ul>
                    <li><label style="font-size: 20px"><b>账号：</b></label><input type="text" id="account-text" placeholder="请输入账号"></li>
                    <li><label style="font-size: 20px"><b>密码：</b></label><input type="password" id="password-text" placeholder="请输入密码"></li>
                    <li><input style="width: 160px;" type="submit" id="login-button" onclick="ajaxProcess3()" value="登录"></li>
                </ul>
            <%--<form action="LoginServlet" method="post">
                <ul>
                    <li><label style="font-size: 20px"><b>账号：</b></label><input type="text" id="account-text" name="account" placeholder="请输入账号"></li>
                    <li><label style="font-size: 20px"><b>密码：</b></label><input type="password" id="password-text" name="password" placeholder="请输入密码"></li>
                    <li><input style="width: 160px;" type="submit" value="登录"></li>
                </ul>
            </form>--%>
        </div>
    </div>
    <%@include file="bottom.jsp"%>
</body>
</html>
