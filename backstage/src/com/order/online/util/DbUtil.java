package com.order.online.util;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DbUtil {
    private static Connection con = null;
    private static String url = null;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.print("驱动加载成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            url = "jdbc:mysql://localhost:3306/cook?useUnicode=true&characterEncoding=UTF-8";
            con = DriverManager.getConnection(url, "root", "111111");
            System.out.print("数据库连接成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection()
    {
        try{
            con.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

