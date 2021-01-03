<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/12/24
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>影视类型管理</title>
    <link rel="stylesheet" href="../css/movieTypeManage.css">
</head>
<body>
    <div class="container">
        <div class="content">
            <div class="movie-type">
                <div class="movie-type-add">
                    <form action="/myproject/AddMovieTypeServlet" method="post">
                        <li>
                            <input type="text" class="text-area-size" name="movieTypeName" placeholder="请输入要添加的电影类型">
                        </li>
                        <li><input type="submit" class="text-area-size" value="添加"></li>
                    </form>
                </div>
                <div class="movie-type-update">
                    <form action="/myproject/UpdateMovieTypeServlet" method="post">
                        <li><input type="text" class="text-area-size" name="movieTypeName" placeholder="请输入要修改的类型"></li>
                        <li><input type="text" class="text-area-size" name="" placeholder="请输入你要修改成的类型"></li>
                        <li><input type="submit" class="text-area-size" value="修改"></li>
                    </form>
                </div>
                <div class="movie-type-delete">
                    <form action="/myproject/DeleteMovieTypeServlet" method="post">
                        <li><input type="text" class="text-area-size" name="movieTypeName" placeholder="请输入要删除的类型"></li>
                        <li><input type="submit" class="text-area-size" value="删除"></li>
                    </form>
                </div>
            </div>
            <div class="movie-year">
            </div>
            <div class="movie-nation"></div>
        </div>
    </div>
</body>
</html>
