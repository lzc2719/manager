package cn.lzc.dao;


import cn.lzc.bean.User;
import cn.lzc.utils.DBUtils;

import java.sql.*;
import java.util.Date;

public class AccountDao {



    //记录用户退出时的记录
    public void recordUserLogoutMessage(String ioUsername,String ioTime,String ioUserIdentity,String ioType) throws Exception {
        Connection conn=DBUtils.getConnection();
        PreparedStatement pstmt=null;
        String sql="insert into user_io_record(io_username,io_identity,io_time,io_type) value(?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,ioUsername);
            pstmt.setString(2,ioUserIdentity);
            pstmt.setString(3,ioTime);
            pstmt.setString(4,ioType);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeJDBC(conn);
        }
    }



    //记录用户登录时的记录
    public void recordUserLoginMessage(String ioUsername,String ioTime,String ioUserIdentity,String ioType) throws Exception {
        Connection conn=DBUtils.getConnection();
        PreparedStatement pstmt=null;
        String sql="insert into user_io_record(io_username,io_identity,io_time,io_type) value(?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,ioUsername);
            pstmt.setString(2,ioUserIdentity);
            pstmt.setString(3,ioTime);
            pstmt.setString(4,ioType);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeJDBC(conn);
        }
    }



    //用户登录判断
    public int login(String account,String password) throws Exception {
        int user_id=0;
        Connection conn=DBUtils.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select user_id from user where user_account=? and user_password=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,account);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            if(rs.next()) {
                user_id=(int)rs.getInt("user_id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeJDBC(conn);
        }
        return user_id;
    }


    //获得用户的id
    public User getUserById(int user_id) throws Exception {
        User user=new User();
        Connection conn=DBUtils.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select user_name,user_account,user_password,user_identity from user where user_id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,user_id);
            rs=pstmt.executeQuery();
            if(rs.next()) {
                user.setUserName(rs.getString("user_name"));
                user.setUserAccount(rs.getString("user_account"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserIdentity(rs.getString("user_identity"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeJDBC(conn);
        }
        return user;
    }


    //判断新注册的账号是否已经存在，存在则返回true
    public boolean isExistAccount(String account) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="SELECT * FROM user WHERE user_account=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,account);
            rs=pstmt.executeQuery();
            if(rs.next()){

                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.closeJDBC(conn);
        }
        return false;
    }



    //存储用户信息
    public void saveUser(String account,String password,String userName,String userIdentity) throws Exception {
        Connection conn=DBUtils.getConnection();
        PreparedStatement pstmt=null;
        String sql="insert into user(user_name,user_account,user_password,user_identity) value(?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,account);
            pstmt.setString(2,password);
            pstmt.setString(3,userName);
            pstmt.setString(4,userIdentity);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeJDBC(conn);
        }
    }




    //获得所有的账户信息
    public String getAllAccount() throws Exception {
        String str=null;
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="SELECT * FROM user";
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            if(rs.next()){
                str=(String)rs.getString("user_name");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.closeJDBC(conn);
        }
        return str;
    }

}
