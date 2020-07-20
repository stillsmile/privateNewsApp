package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDaoImpl {
//    private static final String DRIVER="org.sqlite.JDBC";
//    private static final String URL="jdbc:sqlite:resources/LMS.db";
    private static final String URL="jdbc:mysql://139.129.109.29:3306/devdb?characterEncoding=utf-8";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    
    static {
        try {
            Class.forName(DRIVER); // 加载sqlite的驱动类
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // 获得数据库连接
    public static Connection getConn(){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(URL); // 创建连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
