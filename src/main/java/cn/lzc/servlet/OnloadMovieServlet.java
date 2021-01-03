package cn.lzc.servlet;

import cn.lzc.bean.Movie;
import cn.lzc.bean.MovieType;
import cn.lzc.dao.MovieDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/OnloadMovieServlet")
public class OnloadMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        MovieDao movieDao=new MovieDao();

        List<Movie> moviesList=null;
        List<MovieType> movieTypeList=null;

        try {
            moviesList=movieDao.getAllMovies();
            movieTypeList=movieDao.getAllMovieType();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("moviesList",moviesList);
        request.getSession().setAttribute("movieTypeList",movieTypeList);
        response.sendRedirect("pages/DYpage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
