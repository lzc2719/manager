package cn.lzc.servlet;

import cn.lzc.bean.Movie;
import cn.lzc.dao.MovieDao;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        //获取请求参数
        String searchContent=(String)request.getParameter("searchContent");

        List<Movie> moviesList=null;

        MovieDao movieDao=new MovieDao();
        try {
            moviesList=movieDao.getMovieListBySearchContent(searchContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("moviesList",moviesList);
        response.sendRedirect("pages/DYpage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
