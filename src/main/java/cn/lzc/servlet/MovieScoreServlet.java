package cn.lzc.servlet;

import cn.lzc.dao.MovieDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/MovieScoreServlet")
public class MovieScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        ServletContext servletContext = request.getServletContext();
        HttpSession session = request.getSession();



        //获取请求参数
        String movieName=(String)request.getParameter("movieName");
        String movieScore=(String)request.getParameter("movieScore");

        MovieDao movieDao=new MovieDao();
        try {
            movieDao.updateMovieScoreByMovieName(movieName,movieScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*response.sendRedirect("OnloadMovieServlet");*/
        out.print("打分成功！");
    }
}
