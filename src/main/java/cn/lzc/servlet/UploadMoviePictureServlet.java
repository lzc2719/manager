package cn.lzc.servlet;

import cn.lzc.dao.MovieDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;


@WebServlet(urlPatterns = "/UploadMoviePictureServlet")
@MultipartConfig
public class UploadMoviePictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取上传文件域
        Part part = request.getPart("moviePicture");
        String movieName=request.getParameter("movieName");

        // 获取上传文件名称
        String pictureFileName = part.getSubmittedFileName();


        // 将上传的文件保存在服务器项目发布路径的applicant/images目录下
        String filepath = getServletContext().getRealPath("/imgs");
        System.out.println("头像保存路径为：" + filepath);

        File f = new File(filepath);
        if (!f.exists())
            f.mkdirs();
        //将上传的照片保存指定路径的文件夹下
        part.write(filepath + "/" + pictureFileName);

        //
        MovieDao movieDao = new MovieDao();
        try {
            movieDao.addMoviePicture(movieName,pictureFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }


        response.sendRedirect("pages/movieMessageManage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
