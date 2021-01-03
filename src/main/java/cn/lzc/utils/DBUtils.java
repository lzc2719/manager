package cn.lzc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;



public class DBUtils {


    public static Connection getConnection() throws Exception {

        InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(in);
        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }


    public static void closeJDBC(Connection conn){
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
