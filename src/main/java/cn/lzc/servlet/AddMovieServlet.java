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


@WebServlet(urlPatterns = "/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        //获取请求参数
        String movieName=(String)request.getParameter("movieName");
        String movieYear=(String)request.getParameter("movieYear");
        String movieNation=(String)request.getParameter("movieNation");
        String movieDirector=(String)request.getParameter("movieDirector");
        String movieActor=(String)request.getParameter("movieActor");
        String movieType=(String)request.getParameter("movieType");
        String movieBrief=(String)request.getParameter("movieBrief");
        String movieLink=(String)request.getParameter("movieLink");
        String movieTime=(String)request.getParameter("movieTime");

        Movie movie=new Movie(movieName,movieYear,movieNation,movieDirector,movieActor,movieType,movieBrief,movieLink,movieTime);

        String[] movieTypeList=movieType.split("、");

        MovieDao movieDao=new MovieDao();
        try {
            movieDao.addMovie(movie);
            movieDao.increaseMovieTypeList(movieName,movieTypeList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("pages/movieMessageManage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
