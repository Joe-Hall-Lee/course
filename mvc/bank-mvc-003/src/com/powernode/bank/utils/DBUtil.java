package com.powernode.bank.utils;

import java.sql.*;
import java.util.ResourceBundle;

/*
 * JDBC 工具类
 * */
public class DBUtil {

    private static ResourceBundle bundle = ResourceBundle.getBundle("resources/jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    // 不让创建对象，因为工具类中的方法都是静态的，不需要创建对象。
    // 为了防止创建对象，故将构造方法私有化。
    private DBUtil() {
    }

    // DBUtil 类加载时注册驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * 这里没有使用数据库连接池，直接创建的连接对象。
     * @return 连接对象
     * @throws SQLException
     * */
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /*
     * 关闭资源
     * @param conn 连接对象
     * @param stat 数据库操作对象
     * @param rs 结果集对象
     * */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
