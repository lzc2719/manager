package cn.lzc.listener;

import cn.lzc.bean.User;
import cn.lzc.dao.AccountDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener
public class UserLogoutListener implements HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public UserLogoutListener() {
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();

        if(se.getName().equals("user")){
            User user=(User)se.getValue();
            Date date = new Date();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ioTime = sdf.format(date);
            String ioUsername=user.getUserName();
            String ioUserIdentity=user.getUserIdentity().equals("0")?"普通用户":"管理员";
            String ioType="退出";

            AccountDao accountDao=new AccountDao();
            try {
                accountDao.recordUserLogoutMessage(ioUsername,ioTime,ioUserIdentity,ioType);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
