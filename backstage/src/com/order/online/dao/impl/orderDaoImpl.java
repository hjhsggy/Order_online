package com.order.online.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.order.online.dao.IorderDao;
import com.order.online.domain.orderBean;
import com.order.online.util.DbUtil;

public class orderDaoImpl implements IorderDao {

	private PreparedStatement pre = null;
    private ResultSet result = null;
	@Override
	public List<orderBean> GetOrder() {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
        List<orderBean> list = new ArrayList<orderBean>();
       
        try{
            pre = connection.prepareStatement("select * from orderform");
            result = pre.executeQuery();
            while(result.next())
            { 
            	orderBean order = new orderBean();
            	order.setOID(result.getString("OID"));
            	order.setCID(result.getString("CID"));
            	order.setUsername(result.getString("username"));
            	order.setPID(result.getInt("PID"));
            	order.setAID(result.getString("AID"));
            	order.setOtime(result.getString("Otime"));
            	order.setOwish(result.getString("Owish"));
            	order.setOcount(result.getFloat("Ocount"));
            	order.setOarrival(result.getString("Oarrival"));
            	order.setOstatue(result.getString("Ostatue"));
            	order.setOinfo(result.getString("Oinfo"));
            	order.setOpingjia(result.getString("Opingjia"));
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
	public orderBean getObject(String id) {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
		orderBean order = new orderBean();
        try{
            pre = connection.prepareStatement("select * from orderform where OID=?");
            pre.setString(1,id);
            result = pre.executeQuery();
            if(result.next())
            {
            	order.setOID(result.getString("OID"));
            	order.setCID(result.getString("CID"));
            	order.setUsername(result.getString("username"));
            	order.setPID(result.getInt("PID"));
            	order.setAID(result.getString("AID"));
            	order.setOtime(result.getString("Otime"));
            	order.setOwish(result.getString("Owish"));
            	order.setOcount(result.getFloat("Ocount"));
            	order.setOarrival(result.getString("Oarrival"));
            	order.setOstatue(result.getString("Ostatue"));
            	order.setOinfo(result.getString("Oinfo"));
            	order.setOpingjia(result.getString("Opingjia"));
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
        return order;
	}

	@Override
	public int AddOrder(orderBean order) {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try
        {
            pre = connection.prepareStatement("");
            pre.setString(1,order.getCID());
            pre.setString(2,order.getUsername());
            pre.setInt(3,order.getPID());
            pre.setString(4,order.getAID());
            pre.setString(5,order.getOtime());
            pre.setString(6,order.getOwish());
            pre.setFloat(7,order.getOcount());
            pre.setString(8, order.getOarrival());
            pre.setString(9, order.getOstatue());
            pre.setString(10, order.getOinfo());
            pre.setString(11, order.getOpingjia());
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
	public int ModOrder(orderBean order) {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try
        {
            pre = connection.prepareStatement("update orderform set CID=?,username=?,PID=?,AID=?,Otime=?,Owish=?,Ocount=?,Oarrival=?,Ostatue=?,Oinfo=?,Opingjia=? where OID=?");
            pre.setString(1,order.getCID());
            pre.setString(2,order.getUsername());
            pre.setInt(3,order.getPID());
            pre.setString(4,order.getAID());
            pre.setString(5,order.getOtime());
            pre.setString(6,order.getOwish());
            pre.setFloat(7,order.getOcount());
            pre.setString(8, order.getOarrival());
            pre.setString(9, order.getOstatue());
            pre.setString(10, order.getOinfo());
            pre.setString(11, order.getOpingjia());
            pre.setString(12, order.getOID());
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
	public int DelOrder(orderBean order) {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try
        {
            pre = connection.prepareStatement("delete from orderform where OID=?");
            pre.setString(1,order.getOID());
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
	public int ModOrderStatue(orderBean order) {
		// TODO Auto-generated method stub
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try
        {
            pre = connection.prepareStatement("update orderform set Ostatue=? where OID=?");
            pre.setString(1, order.getOstatue());
            pre.setString(2, order.getOID());
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
