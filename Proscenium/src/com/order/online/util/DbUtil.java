package com.order.online.util;

import java.sql.*;

public class DbUtil {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/webcook?useUnicode=true&characterEncoding=UTF-8";
	private String username="root";
	private String password="00008181";
	
	public Connection getCon() throws Exception{
		Class.forName(driver);
		Connection con = java.sql.DriverManager.getConnection(url,username,password);
		return con;
	}
	
	public static void getClose(Connection con) throws SQLException{
		if(con!=null){
			con.close();	
		}
	}
	
	
	
}
