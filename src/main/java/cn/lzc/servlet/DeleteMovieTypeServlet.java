package cn.lzc.servlet;

import cn.lzc.dao.MovieDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DeleteMovieTypeServlet")
public class DeleteMovieTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        //获取请求参数
        String movieTypeName=(String)request.getParameter("movieTypeName");

        MovieDao movieDao=new MovieDao();
        try {
            movieDao.deleteMovieType(movieTypeName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("pages/movieTypeManage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
