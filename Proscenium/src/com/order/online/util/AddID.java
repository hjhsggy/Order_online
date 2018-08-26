package com.order.online.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AddID {
	public String SetID(String head,String col,String tablename){
 		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String str=null;
		String sql = "select "+col+" from "+tablename+" order by "+col+" desc limit 0,1";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			if (rs.next()) {
				
				String columnName = metaData.getColumnLabel(1);
				str=rs.getString(columnName);
			}
			if(str==null)
			{
				str=head+"00001";
			}else{
				str = str.substring(1, 6);
				int num = Integer.parseInt(str) + 1;
				int length = Integer.toString(num).length();
				String zero = "";
				for (int i = 0; i < 5 - length; i++) {
					zero += "0";
				}
				str = head + zero + num;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
 	}
}
