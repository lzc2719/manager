package cn.lzc.servlet;

import cn.lzc.dao.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        //获取请求参数
        String account=(String)request.getParameter("account");
        String password=(String)request.getParameter("password");
        String userName=(String)request.getParameter("userName");
        String userIdentity=(String)request.getParameter("userIdentity");




        AccountDao accountDao=new AccountDao();

        boolean flag=false;
        try {
            flag=accountDao.isExistAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(flag){//新注册的账号已经存在
            out.print("<script type='text/javascript'>");
            out.print("alert('注册失败！该账号已经存在');");
            out.print("window.location='register.jsp';");
            out.print("</script>");
        }else{//新注册的账号没重复，可以继续注册
            try {
                //保存新注册的用户信息
                accountDao.saveUser(account,password,userName,userIdentity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("login.jsp");//重定向至登录界面
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
