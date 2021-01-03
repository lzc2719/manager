<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/12/24
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>影视信息管理</title>
    <link rel="stylesheet" href="../css/movieMessageManage.css">
</head>
<body>
    <div class="container">
        <div class="content">
            <div class="movie-add">
                <form action="/myproject/AddMovieServlet" method="post">
                    <li><input class="text-area-size" type="text" name="movieName" placeholder="电影名"></li>
                    <li><input class="text-area-size" type="text" name="movieYear" placeholder="上映时间"></li>
                    <li><input class="text-area-size" type="text" name="movieNation" placeholder="产自国"></li>
                    <li><input class="text-area-size" type="text" name="movieDirector" placeholder="导演"></li>
                    <li><input class="text-area-size" type="text" name="movieActor" placeholder="演员"></li>
                    <li><input class="text-area-size" type="text" name="movieType" placeholder="电影类型"></li>
                    <li><input class="text-area-size" type="text" name="movieTime" placeholder="电影时长"></li>
                    <li><input class="text-area-size" type="text" name="movieLink" placeholder="电影链接"></li>
                    <li><input class="text-area-size" type="text" name="movieBrief" placeholder="电影简介"></li>
                    <li><input class="text-area-size" type="submit" value="添加"></li>
                </form>
                <form action="/myproject/UploadMoviePictureServlet" method="post" enctype="multipart/form-data">
                    <li>
                        <input type="text" class="text-area-size" name="movieName" placeholder="请输入你要上传图片的电影名"><br>
                        <input class="text-area-size" type="file" name="moviePicture"><br>
                        <input class="text-area-size" type="submit" value="确定上传">
                    </li>
                </form>
            </div>
            <div class="movie-update">
                <form action="/myproject/UpdateMovieServlet" method="post">
                    <li><input class="text-area-size" type="text" name="movieName" placeholder="请输入你要修改的电影名"></li>
                    <li>
                        <select class="text-area-size" name="updateType" id="">
                            <option value="" selected>&nbsp;</option>
                            <option value="movie_year">上映时间</option>
                            <option value="movie_nation">产自国</option>
                            <option value="movie_director">导演</option>
                            <option value="movie_actor">演员</option>
                            <option value="movie_type">电影类型</option>
                            <option value="movie_time">电影时长</option>
                            <option value="movie_link">电影链接</option>
                            <option value="movi_brief">电影简介</option>
                        </select>
                    </li>
                    <li><input class="text-area-size" type="text" name="updateContent" placeholder="修改内容"></li>
                    <li><input class="text-area-size" type="submit" value="修改"></li>
                </form>
            </div>
            <div class="movie-delete">
                <form action="/myproject/DeleteMovieServlet" method="post">
                    <li><input class="text-area-size" type="text" name="movieName" placeholder="请输入你要删除的电影名"></li>
                    <li><input class="text-area-size" type="submit" value="删除"></li>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
