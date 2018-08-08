package com.order.online.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.order.online.dao.ImemberDao;
import com.order.online.domain.memberBean;
import com.order.online.domain.orderBean;
import com.order.online.util.DbUtil;

public class memberDaoImpl implements ImemberDao {

	private PreparedStatement pre = null;
    private ResultSet result = null;
	@Override
	public List<memberBean> GetMember() {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
        List<memberBean> list = new ArrayList<memberBean>();
        
        try{
            pre = connection.prepareStatement("select * from custom");
            result = pre.executeQuery();
            while(result.next())
            { 
            	memberBean order = new memberBean();
            	order.setCID(result.getString("CID"));
            	order.setUsername(result.getString("username"));
            	order.setqID(result.getInt("qID"));
            	order.setPassword(result.getString("password"));
            	order.setName(result.getString("name"));
            	order.setSex(result.getString("sex"));
            	order.setAnswer(result.getString("answer"));
            	order.setVIP(result.getInt("VIP"));
            	list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            pre.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        DbUtil.closeConnection();
        return list;
	}
	@Override
	public memberBean getObject(String id) {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
		memberBean member = new memberBean();
        try{
            pre = connection.prepareStatement("select * from custom where CID=?");
            pre.setString(1,id);
            result = pre.executeQuery();
            if(result.next())
            {
            	member.setCID(result.getString("CID"));
            	member.setUsername(result.getString("username"));
            	member.setqID(result.getInt("qID"));
            	member.setPassword(result.getString("password"));
            	member.setName(result.getString("name"));
            	member.setSex(result.getString("sex"));
            	member.setAnswer(result.getString("answer"));
            	member.setVIP(result.getInt("vIP"));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        try
        {
            pre.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        DbUtil.closeConnection();
        return member;
	}
	@Override
	public int AddMember(memberBean member) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int ModMember(memberBean member) {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try
        {
            pre = connection.prepareStatement("update custom set username=?,qID=?,password=?,name=?,sex=?,answer=?,VIP=? where CID=?");
            pre.setString(1,member.getUsername());
            pre.setInt(2,member.getqID());
            pre.setString(3,member.getPassword());
            pre.setString(4,member.getName());
            pre.setString(5,member.getSex());
            pre.setString(6,member.getAnswer());
            pre.setInt(7,member.getVIP());
            pre.setString(8,member.getCID());
            count = pre.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        try {
            pre.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        DbUtil.closeConnection();
        return count;
	}
	@Override
	public int DelMember(memberBean member) {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try
        {
            pre = connection.prepareStatement("delete from custom where CID=?");
            pre.setString(1,member.getCID());
            count = pre.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        try {
            pre.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        DbUtil.closeConnection();
        return count;
	}
	

}
