package com.order.online.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.order.online.dao.IcustomDao;
import com.order.online.domain.addressBean;
import com.order.online.domain.customBean;
import com.order.online.domain.leave_feedbackBean;
import com.order.online.domain.questionBean;
import com.order.online.util.DbUtil;

public class customDaoImpl implements IcustomDao {

	// 后台登陆
	public customBean login(customBean custom) {

		DbUtil db = new DbUtil();
		Connection con = null;
		customBean custombean = null;
		PreparedStatement ps, ps2;
		String sql = "select * from custom where username= ? and password= ?";
		String sql2 = "select * from question where qID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getusername());
			ps.setString(2, custom.getpassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				custombean = new customBean();
				custombean.setCID(rs.getString("CID"));
				custombean.setusername(rs.getString("username"));
				custombean.setpassword(rs.getString("password"));
				custombean.setname(rs.getString("name"));
				custombean.setsex(rs.getString("sex"));
				custombean.setqID(Integer.parseInt(rs.getString("qID")));
				custombean.setanswer(rs.getString("answer"));
				custombean.setVIP(Integer.parseInt(rs.getString("VIP")));
				ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, custombean.getqID());
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {
					custombean.setquestion(rs2.getString("question"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return custombean;

	}

	// 获取question表的值
	public List<questionBean> getquestionid() {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<questionBean> list = new ArrayList<questionBean>();
		questionBean questionbean = null;
		PreparedStatement ps;
		String sql = "select * from question";

		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				questionbean = new questionBean();
				questionbean.setqID(Integer.parseInt(rs.getString("qID")));
				questionbean.setquestion(rs.getString("question"));
				list.add(questionbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// 验证账号是否存在
	public customBean confirmation(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		customBean custombean = null;
		PreparedStatement ps;
		String sql = "select * from custom where username= ? ";

		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getusername());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				custombean = new customBean();
				custombean.setusername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return custombean;

	}

	// 账号注册
	public int register(customBean custom, addressBean address) {
		int count = 0;
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "insert into custom(CID,username,qID,password,name,sex,answer,VIP) values(?,?,?,?,?,?,?,?)";
		String sql2 = "insert into address(AID,CID,username,Aaddress,Atel) values(?,?,?,?,?)";
		try {
			con = db.getCon();

			// 添加custom表
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getCID());
			ps.setString(2, custom.getusername());
			ps.setInt(3, custom.getqID());
			ps.setString(4, custom.getpassword());
			ps.setString(5, custom.getname());
			ps.setString(6, custom.getsex());
			ps.setString(7, custom.getanswer());
			ps.setInt(8, 1);
			ps.executeUpdate();
			// 添加address表
			ps = con.prepareStatement(sql2);
			ps.setString(1, address.getAID());
			ps.setString(2, address.getCID());
			ps.setString(3, address.getusername());
			ps.setString(4, address.getAaddress());
			ps.setString(5, address.getAtel());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;

	}

	// 修改资料
	public void updatename(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "update custom set name=?,sex=? where CID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getname());
			ps.setString(2, custom.getsex());
			ps.setString(3, custom.getCID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 修改密码
	public void updatepassword(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "update custom set password=? where CID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getpassword());
			ps.setString(2, custom.getCID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取地址
		public List<addressBean> getaddress(String a) {
			DbUtil db = new DbUtil();
			Connection con = null;
			List<addressBean> list = new ArrayList<addressBean>();
			addressBean addressbean = null;
			PreparedStatement ps;
			String sql = "select * from address where CID=?";

			try {
				con = db.getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1, a);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					addressbean = new addressBean();
					addressbean.setAID(rs.getString("AID"));
					addressbean.setCID(rs.getString("CID"));
					addressbean.setusername(rs.getString("username"));
					addressbean.setAaddress(rs.getString("Aaddress"));
					addressbean.setAtel(rs.getString("Atel"));
					list.add(addressbean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		// 获取1地址
		public addressBean getaddress1(String a) {
			DbUtil db = new DbUtil();
			Connection con = null;
			addressBean addressbean = null;
			PreparedStatement ps;
			String sql = "select * from address where AID=?";

			try {
				con = db.getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1, a);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					addressbean = new addressBean();
					addressbean.setAID(rs.getString("AID"));
					addressbean.setCID(rs.getString("CID"));
					addressbean.setusername(rs.getString("username"));
					addressbean.setAaddress(rs.getString("Aaddress"));
					addressbean.setAtel(rs.getString("Atel"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return addressbean;
		}

	// 增加地址
	public void addaddress(addressBean address) {
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "insert into address(AID,CID,username,Aaddress,Atel) values(?,?,?,?,?)";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, address.getAID());
			ps.setString(2, address.getCID());
			ps.setString(3, address.getusername());
			ps.setString(4, address.getAaddress());
			ps.setString(5, address.getAtel());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 修改地址
	public void updateaddress(addressBean address) {
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "update address set Aaddress=?,Atel=? where AID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, address.getAaddress());
			ps.setString(2, address.getAtel());
			ps.setString(3, address.getAID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除地址
	public void deladdress(addressBean address) {
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "delete from address where AID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, address.getAID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 留言
	public void liuyan(leave_feedbackBean leave) {
		DbUtil db = new DbUtil();
		Connection con = null;
		PreparedStatement ps;
		String sql = "insert into leave_feedback(LID,CID,username,LTime,L,flag) values(?,?,?,?,?,?)";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, leave.getLID());
			ps.setString(2, leave.getCID());
			ps.setString(3, leave.getUsername());
			ps.setString(4, leave.getLTime());
			ps.setString(5, leave.getL());
			ps.setInt(6, leave.getFlag());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 显示留言
	public List<leave_feedbackBean> getliuyan(customBean custom) {
		DbUtil db = new DbUtil();
		Connection con = null;
		List<leave_feedbackBean> list = new ArrayList<leave_feedbackBean>();
		leave_feedbackBean leave = null;
		PreparedStatement ps;
		String sql = "select * from leave_feedback where CID=?";
		try {
			con = db.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, custom.getCID());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				leave = new leave_feedbackBean();
				leave.setFlag(Integer.parseInt(rs.getString("flag")));
				leave.setLID(rs.getString("LID"));
				leave.setCID(rs.getString("CID"));
				leave.setUsername(rs.getString("username"));
				leave.setLTime(rs.getString("LTime"));
				leave.setL(rs.getString("L"));
				leave.setHTime(rs.getString("HTime"));
				leave.setH(rs.getString("H"));
				list.add(leave);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
