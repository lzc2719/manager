<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../contextPath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>电影</title>
    <link rel="stylesheet" type="text/css" href="../css/DYcss.css"/>
    <%--<link rel="stylesheet" href="../css/bootstrap.min.css">--%>
    <script type="text/javascript" src="${contextPath}/js/updateScoreAjax.js"></script>
    <script type="text/javascript" src="${contextPath}/js/updateCommentAjax.js"></script>
    <script type="text/javascript" src="${contextPath}/js/jquery-1.11.3.min.js"></script>
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
    <div class="container">
        <div class="nav">
            <div class="menu">
                <div class="menu-list-1">
                    <ul>
                        <li><label style="color: #BBBBBB;font-size: 18px"><b>类型</b></label></li>
                        <c:if test="${not empty sessionScope.movieTypeList}">
                            <c:forEach items="${sessionScope.movieTypeList}" var="movieType">
                                <li><a href="../ClassifyMovieServlet?movieTypeName=${movieType.movieTypeName}">
                                            ${movieType.movieTypeName}
                                </a></li>
                            </c:forEach>
                        </c:if>
                    </ul>
                </div>
                <div class="menu-list-2">
                    <ul>
                        <li><label style="color: #BBBBBB;font-size: 18px"><b>区域</b></label></li>
                        <li><a href="#">内地</a></li>
                        <li><a href="#">中国香港</a></li>
                        <li><a href="#">中国台湾</a></li>
                        <li><a href="#">美国</a></li>
                        <li><a href="#">欧洲</a></li>
                        <li><a href="#">日本</a></li>
                        <li><a href="#">韩国</a></li>
                        <li><a href="#">泰国</a></li>
                        <li><a href="#">印度</a></li>
                    </ul>
                </div>
                <div class="menu-list-3">
                    <ul>
                        <li><label style="color: #BBBBBB;font-size: 18px"><b>年份</b></label></li>
                        <li><a href="#">2020</a></li>
                        <li><a href="#">2019</a></li>
                        <li><a href="#">2018</a></li>
                        <li><a href="#">2017</a></li>
                        <li><a href="#">2016</a></li>
                        <li><a href="#">2015</a></li>
                        <li><a href="#">2014</a></li>
                        <li><a href="#">更早</a></li>
                    </ul>
                </div>
                <div class="menu-list-4">
                    <form action="../SearchServlet" method="post">
                        <input type="text" class="search-box" name="searchContent" placeholder="请输入您要搜索的内容"/>
                        <input type="submit" class="search-button" value="搜索">
                        <%--<input class="btn btn-default" style="position: absolute;left: 250px;"  type="submit" value="Submit">--%>
                    </form>
                </div>
            </div>
        </div>
        <div class="content">
            <div class="display-area">
                <c:if test="${not empty sessionScope.moviesList}">
                    <c:forEach items="${sessionScope.moviesList}" var="movie" varStatus="vst">
                        <div class="movie-list">
                            <div class="movie-list-left">
                                <img width="270px" height="365px" src="${contextPath}/imgs/${movie.moviePicture}" alt="">
                            </div>
                            <div class="movie-list-right">
                                <div class="right-top">
                                    <div class="right-top-left">
                                        <label style="font-size: 20px">&nbsp;&nbsp;<b>电影名：《${movie.movieName}》</b></label><br><br>
                                        <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时长：${movie.movieTime}分钟</label><br>
                                        <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;导演：${movie.movieDirector}</label><br>
                                        <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;演员：${movie.movieActor}</label><br>
                                        <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;国家：${movie.movieNation}</label><br>
                                        <label>上映时间：${movie.movieYear}年</label><br>
                                        <label>电影类型：${movie.movieType}</label><br>
                                        <label>播放地址：<a href="${movie.movieLink}" target="_blank">${movie.movieLink}</a></label><br>
                                    </div>
                                    </div>
                                    <div class="right-top-right">
                                        <div class="movie-score-posi" >
                                            <label id="score${vst.index+1}" style="font-size: 20px">${movie.movieScore}分</label>
                                        </div>
                                        <div class="score-area">
                                                <%--<form action="../MovieScoreServlet?movieName=${movie.movieName}" method="get">
                                                    <input type="text" class="score-text" name="movieScore">
                                                    <input type="hidden" name="movieName" value="${movie.movieName}">
                                                    <input type="submit" class="score-submit" value="打分">
                                                </form>--%>
                                            <input type="text" class="score-text" id="score-text${vst.index+1}">
                                            <input type="submit" class="score-submit" onclick="updateScore(
                                                    '${sessionScope.loginFlag}',
                                                    '${movie.movieName}',
                                                    '${vst.index+1}')" value="打分">

                                        </div>
                                        <div class="comment-area">
                                            <input type="text" class="comment-text" id="comment-text${vst.index+1}">
                                            <input type="submit" class="comment-submit" onclick="updateComment(
                                                    '${sessionScope.loginFlag}',
                                                    '${movie.movieId}',
                                                    '${sessionScope.user.userName}',
                                                    '<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm:ss"/>',
                                                    '${vst.index+1}')" value="评论"/>

                                            <%--<form action="../MovieCommentServlet">
                                                <input type="text" class="comment-text" name="commentText" id="comment">
                                                <input type="hidden" name="movieId" value="${movie.movieId}">
                                                <input type="hidden" name="commentUser" value="${sessionScope.user.userName}">
                                                <input type="hidden" name="commentTime" value="<fmt:formatDate
                                                value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                                                <input type="submit" class="comment-submit" value="评论">
                                            </form>--%>
                                        </div>
                                    </div>
                                <div class="right-bottom">
                                    <span style="font-size: 13px">简介：${movie.movieBrief}</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
