package com.order.online.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.order.online.dao.IMessegeDao;
import com.order.online.domain.customBean;
import com.order.online.domain.foodBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;
import com.order.online.util.DbUtil;

public class MessegeDaoImpl implements IMessegeDao{
	
	//获取订单
	public orderformBean getorder(orderformBean orderform) {
		DbUtil db = new DbUtil();
		Connection con = null;
		orderformBean orderformbean = null;
		PreparedStatement ps;
		String sql = "select * from orderform where OID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, orderform.getOID());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				orderformbean = new orderformBean();
				orderformbean.setOID(rs.getString("OID"));
				orderformbean.setCID(rs.getString("CID"));
				orderformbean.setUsername(rs.getString("username"));
				orderformbean.setPID(Integer.parseInt(rs.getString("PID")));
				orderformbean.setAID(rs.getString("AID"));
				orderformbean.setOtime(rs.getString("Otime"));
				orderformbean.setOwish(rs.getString("Owish"));
				orderformbean.setOcount(Float.parseFloat(rs.getString("Ocount")));
				orderformbean.setOarrival(rs.getString("Oarrival"));
				orderformbean.setOstatue(rs.getString("Ostatue"));
				orderformbean.setOinfo(rs.getString("Oinfo"));
				orderformbean.setOpingjia(rs.getString("Opingjia"));
				orderformbean.setorderfood(getorderfood(orderformbean));
				getorderpeople(orderformbean);
				getorderaddress(orderformbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderformbean;

	}
    
	//获取待确认订单
	public List<orderformBean> getorder1(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<orderformBean> list=new ArrayList<orderformBean>();
		orderformBean orderformbean = null;
		PreparedStatement ps;
		String sql = "select * from orderform where CID= ? and Ostatue= ?";

		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getCID());
			ps.setString(2, "1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderformbean = new orderformBean();
				orderformbean.setOID(rs.getString("OID"));
				orderformbean.setCID(rs.getString("CID"));
				orderformbean.setUsername(rs.getString("username"));
				orderformbean.setAID(rs.getString("AID"));
				orderformbean.setOtime(rs.getString("Otime"));
				orderformbean.setOwish(rs.getString("Owish"));
				orderformbean.setOcount(Float.parseFloat(rs.getString("Ocount")));
				orderformbean.setOstatue(rs.getString("Ostatue"));
				orderformbean.setOinfo(rs.getString("Oinfo"));
				orderformbean.setorderfood(getorderfood(orderformbean));
				getorderpeople(orderformbean);
				getorderaddress(orderformbean);
				list.add(orderformbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
    
	//获取待完成订单
	public List<orderformBean> getorder2(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<orderformBean> list=new ArrayList<orderformBean>();
		orderformBean orderformbean = null;
		PreparedStatement ps;
		String sql = "select * from orderform where CID= ? and Ostatue= ?";

		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getCID());
			ps.setString(2, "2");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderformbean = new orderformBean();
				orderformbean.setOID(rs.getString("OID"));
				orderformbean.setCID(rs.getString("CID"));
				orderformbean.setUsername(rs.getString("username"));
				orderformbean.setPID(Integer.parseInt(rs.getString("PID")));
				orderformbean.setAID(rs.getString("AID"));
				orderformbean.setOtime(rs.getString("Otime"));
				orderformbean.setOwish(rs.getString("Owish"));
				orderformbean.setOcount(Float.parseFloat(rs.getString("Ocount")));
				orderformbean.setOarrival(rs.getString("Oarrival"));
				orderformbean.setOstatue(rs.getString("Ostatue"));
				orderformbean.setOinfo(rs.getString("Oinfo"));
				orderformbean.setOpingjia(rs.getString("Opingjia"));
				orderformbean.setorderfood(getorderfood(orderformbean));
				getorderpeople(orderformbean);
				getorderaddress(orderformbean);
				list.add(orderformbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
    
	//获取待送达订单
	public List<orderformBean> getorder3(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<orderformBean> list=new ArrayList<orderformBean>();
		orderformBean orderformbean = null;
		PreparedStatement ps;
		String sql = "select * from orderform where CID= ? and Ostatue= ?";

		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getCID());
			ps.setString(2, "3");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderformbean = new orderformBean();
				orderformbean.setOID(rs.getString("OID"));
				orderformbean.setCID(rs.getString("CID"));
				orderformbean.setUsername(rs.getString("username"));
				orderformbean.setPID(Integer.parseInt(rs.getString("PID")));
				orderformbean.setAID(rs.getString("AID"));
				orderformbean.setOtime(rs.getString("Otime"));
				orderformbean.setOwish(rs.getString("Owish"));
				orderformbean.setOcount(Float.parseFloat(rs.getString("Ocount")));
				orderformbean.setOarrival(rs.getString("Oarrival"));
				orderformbean.setOstatue(rs.getString("Ostatue"));
				orderformbean.setOinfo(rs.getString("Oinfo"));
				orderformbean.setOpingjia(rs.getString("Opingjia"));
				orderformbean.setorderfood(getorderfood(orderformbean));
				getorderpeople(orderformbean);
				getorderaddress(orderformbean);
				list.add(orderformbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
    
	//获取待评价订单
	public List<orderformBean> getorder4(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<orderformBean> list=new ArrayList<orderformBean>();
		orderformBean orderformbean = null;
		PreparedStatement ps;
		String sql = "select * from orderform where CID= ? and Ostatue= ?";

		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getCID());
			ps.setString(2, "4");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderformbean = new orderformBean();
				orderformbean.setOID(rs.getString("OID"));
				orderformbean.setCID(rs.getString("CID"));
				orderformbean.setUsername(rs.getString("username"));
				orderformbean.setPID(Integer.parseInt(rs.getString("PID")));
				orderformbean.setAID(rs.getString("AID"));
				orderformbean.setOtime(rs.getString("Otime"));
				orderformbean.setOwish(rs.getString("Owish"));
				orderformbean.setOcount(Float.parseFloat(rs.getString("Ocount")));
				orderformbean.setOarrival(rs.getString("Oarrival"));
				orderformbean.setOstatue(rs.getString("Ostatue"));
				orderformbean.setOinfo(rs.getString("Oinfo"));
				orderformbean.setOpingjia(rs.getString("Opingjia"));
				orderformbean.setorderfood(getorderfood(orderformbean));
				getorderpeople(orderformbean);
				getorderaddress(orderformbean);
				list.add(orderformbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
    
	//获取已评价订单
	public List<orderformBean> getorder5(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<orderformBean> list=new ArrayList<orderformBean>();
		orderformBean orderformbean = null;
		PreparedStatement ps;
		String sql = "select * from orderform where CID= ? and Ostatue= ?";

		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getCID());
			ps.setString(2, "5");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderformbean = new orderformBean();
				orderformbean.setOID(rs.getString("OID"));
				orderformbean.setCID(rs.getString("CID"));
				orderformbean.setUsername(rs.getString("username"));
				orderformbean.setPID(Integer.parseInt(rs.getString("PID")));
				orderformbean.setAID(rs.getString("AID"));
				orderformbean.setOtime(rs.getString("Otime"));
				orderformbean.setOwish(rs.getString("Owish"));
				orderformbean.setOcount(Float.parseFloat(rs.getString("Ocount")));
				orderformbean.setOarrival(rs.getString("Oarrival"));
				orderformbean.setOstatue(rs.getString("Ostatue"));
				orderformbean.setOinfo(rs.getString("Oinfo"));
				orderformbean.setOpingjia(rs.getString("Opingjia"));
				orderformbean.setorderfood(getorderfood(orderformbean));
				getorderpeople(orderformbean);
				getorderaddress(orderformbean);
				list.add(orderformbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	//获取订单对应菜品
	public List<order_foodBean> getorderfood(orderformBean orderform) {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<order_foodBean> list=new ArrayList<order_foodBean>();
		order_foodBean order_foodbean = null;
		PreparedStatement ps,ps2;
		String sql = "select * from order_food where OID= ?";
		String sql2="select * from food where FID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, orderform.getOID());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order_foodbean = new order_foodBean();
				order_foodbean.setOID(rs.getString("OID"));
				order_foodbean.setFID(rs.getString("FID"));
				order_foodbean.setNumber(Integer.parseInt(rs.getString("number")));
				ps2=con.prepareStatement(sql2);
				ps2.setString(1, rs.getString("FID"));
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {
					order_foodbean.setFname(rs2.getString("Fname"));	
					order_foodbean.setFcount(rs2.getString("Fcount"));	
				}
				list.add(order_foodbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	//获取订单对应工作人员
	public orderformBean getorderpeople(orderformBean orderform) {
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "select * from people where PID= ?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderform.getPID());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				orderform.setPname(rs.getString("Pname"));
				orderform.setPtel(rs.getString("Ptel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderform;

	}
	
	//获取订单对应地址
	public orderformBean getorderaddress(orderformBean orderform) {
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "select * from address where AID= ?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, orderform.getAID());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				orderform.setAaddress(rs.getString("Aaddress"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderform;

	}
    
    //删除待确认订单
    public void delorder(orderformBean orderform){
    	DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql="delete from order_food where OID=?";
    	String sql2="delete from orderform where OID=?";
        try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
            ps.setString(1,orderform.getOID());
            ps.executeUpdate();
            ps = con.prepareStatement(sql2);
            ps.setString(1,orderform.getOID());
            ps.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (Exception e) {
		    e.printStackTrace();
	    }
    }
    
    //评价
    public void updorder(orderformBean orderform){
    	DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
    	String sql="update orderform set Opingjia=?,Ostatue='5' where OID=?";
        try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,orderform.getOpingjia());
			ps.setString(2,orderform.getOID());
            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (Exception e) {
		    e.printStackTrace();
	    }
    }

    //创建订单
    public orderformBean s2etorderform(orderformBean orderform){
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
    	return orderform;
    	
    }

  //添加菜品
    public orderformBean addorderform(orderformBean orderform,foodBean food){
    	DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "insert into order_food(OID,FID,number) values(?,?,?)";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, orderform.getOID());
			ps.setString(2, food.getFID());
			ps.setInt(3, food.getnumber());
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return orderform;
    	
    }
}
