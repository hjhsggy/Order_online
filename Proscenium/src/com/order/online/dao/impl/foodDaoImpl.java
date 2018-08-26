package com.order.online.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.order.online.dao.IfoodDao;
import com.order.online.domain.foodBean;
import com.order.online.domain.food_typeBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;
import com.order.online.util.DbUtil;

public class foodDaoImpl implements IfoodDao {

	// 获取菜单
	public List<foodBean> getfoodorder(int tID) {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<foodBean> list = new ArrayList<foodBean>();
		foodBean foodbean = null;
		food_typeBean food_typebean = null;
		PreparedStatement ps, ps2;
		String sql = "select FID from food_type where tID=" + tID;
		String sql2 = "select * from food where FID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				food_typebean = new food_typeBean();
				food_typebean.setFID(rs.getString("FID"));

				ps2 = con.prepareStatement(sql2);
				ps2.setString(1, food_typebean.getFID());
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {
					foodbean = new foodBean();
					foodbean.setFID(rs2.getString("FID"));
					foodbean.setFname(rs2.getString("Fname"));
					foodbean.setFinfo(rs2.getString("Finfo"));
					foodbean.setFcount(Float.parseFloat(rs2.getString("Fcount")));
					foodbean.setFpicture(rs2.getString("Fpicture"));
					foodbean.setFother(rs2.getString("Fother"));
					list.add(foodbean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	//生成订单
	public void setfoodorder(orderformBean orderform){
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "insert into orderform(OID,CID,username,AID,Otime,Owish,Ocount,Ostatue,Oinfo) values(?,?,?,?,?,?,?,?,?)";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, orderform.getOID());
			ps.setString(2, orderform.getCID());
			ps.setString(3, orderform.getUsername());
			ps.setString(4, orderform.getAID());
			ps.setString(5, orderform.getOtime());
			ps.setString(6, orderform.getOwish());
			ps.setFloat(7, orderform.getOcount());
			ps.setString(8, orderform.getOstatue());
			ps.setString(9, orderform.getOinfo());			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setfood(order_foodBean order_food){
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "insert into order_food(OID,FID,number) values(?,?,?)";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, order_food.getOID());
			ps.setString(2, order_food.getFID());
			ps.setInt(3, order_food.getNumber());		
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
