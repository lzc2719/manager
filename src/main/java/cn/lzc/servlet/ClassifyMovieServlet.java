package cn.lzc.servlet;

import cn.lzc.bean.Movie;
import cn.lzc.dao.MovieDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ClassifyMovieServlet")
public class ClassifyMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        String movieTypeName=(String)request.getParameter("movieTypeName");

        MovieDao movieDao=new MovieDao();

        //通过电影类型名字查找对应电影类型清单，并进行拆分
        String[] movieTypeList= new String[0];
        try {
            movieTypeList = movieDao.getMovieTypeListByMovieTypeName(movieTypeName).split("、");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Movie> moviesList=null;

        try {
            moviesList=movieDao.getMoviesByMovieTypeList(movieTypeList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("moviesList",moviesList);
        response.sendRedirect("pages/DYpage.jsp");
    }
}
