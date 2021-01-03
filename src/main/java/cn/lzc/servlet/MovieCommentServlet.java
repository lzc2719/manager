package cn.lzc.servlet;

import cn.lzc.dao.MovieDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/MovieCommentServlet")
public class MovieCommentServlet extends HttpServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();

        //获取请求参数
        String commentText=(String)request.getParameter("commentText");
        String movieId=(String)request.getParameter("movieId");
        String commentUser=(String)request.getParameter("commentUser");
        String commentTime=(String)request.getParameter("commentTime");

        MovieDao movieDao=new MovieDao();
        try {
            movieDao.increaseMovieComment(movieId,commentUser,commentTime,commentText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        //获取请求参数
        String movieId=(String)request.getParameter("movieId");
        String commentUser=(String)request.getParameter("commentUser");
        String commentDate=(String)request.getParameter("commentDate");
        String commentText=(String)request.getParameter("commentText");

        MovieDao movieDao=new MovieDao();
        try {
            movieDao.increaseMovieComment(movieId,commentUser,commentDate,commentText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print("评论成功！");
    }
}
