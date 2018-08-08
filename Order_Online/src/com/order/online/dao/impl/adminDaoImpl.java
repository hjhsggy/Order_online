package com.order.online.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.order.online.dao.IadminDao;
import com.order.online.domain.adminBean;
import com.order.online.util.DbUtil;

public class adminDaoImpl implements IadminDao{
	
	
	// 用户登录
	public adminBean login(adminBean admin) {

		Connection con = null;
		adminBean adminbean = null;
		PreparedStatement ps;
		String sql = "select * from admin where username= ? and password= ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, admin.getusername());
			ps.setString(2, admin.getpassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				adminbean = new adminBean();
				adminbean.setadminID(Integer.parseInt(rs.getString("adminID")));
				adminbean.setusername(rs.getString("username"));
				adminbean.setpassword(rs.getString("password"));
				adminbean.setlevel(rs.getString("level"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminbean;
	}
	
	
	
}
