package cn.lzc.servlet;

import cn.lzc.bean.User;
import cn.lzc.dao.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        //获取请求参数
        String account=(String)request.getParameter("account");
        String password=(String)request.getParameter("password");


        //登录验证
        AccountDao accountDao=new AccountDao();
        int user_id = 0;
        try {
            user_id = accountDao.login(account,password);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(user_id!=0) {//用户登录成功
            User user = null;
            try {
                user = accountDao.getUserById(user_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将用户对象存入session域
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("loginFlag",true);
            response.sendRedirect("homePage.jsp");//重定向至主页
        }else{//用户登录信息错误，进行错误提示
            out.print("<script type='text/javascript'>");
            out.print("alert('账号或密码错误，请重新输入！');");
            out.print("window.location('login.jsp')");
            out.print("</script>");
        }
    }*/


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        //获取请求参数
        String account=(String)request.getParameter("account");
        String password=(String)request.getParameter("password");

        //登录验证
        AccountDao accountDao=new AccountDao();
        int user_id = 0;
        try {
            user_id = accountDao.login(account,password);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(user_id!=0) {//用户登录成功
            User user = null;
            try {
                user = accountDao.getUserById(user_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将用户对象存入session域
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("loginFlag",true);
            //response.sendRedirect("homePage.jsp");
            out.print("登陆成功！");
        }else{
            //用户登录信息错误，进行错误提示
            out.print("登录失败，账号或密码错误！");
        }
    }
}
