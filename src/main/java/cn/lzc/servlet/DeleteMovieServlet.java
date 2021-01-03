package cn.lzc.servlet;

import cn.lzc.dao.MovieDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DeleteMovieServlet")
public class DeleteMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        //获取请求参数
        String movieName=(String)request.getParameter("movieName");

        MovieDao movieDao=new MovieDao();
        try {
            movieDao.deleteMovie(movieName);
            movieDao.reduceMovieTypeList(movieName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("pages/movieMessageManage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
