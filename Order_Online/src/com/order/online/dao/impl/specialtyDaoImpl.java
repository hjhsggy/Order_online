package com.order.online.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.order.online.util.*;
import com.order.online.dao.IspecialtyDao;
import com.order.online.domain.specialtyBean;

public class specialtyDaoImpl implements IspecialtyDao {

	private PreparedStatement pre = null;
    private ResultSet result = null;
    
	@Override
	public List<specialtyBean> GetSpecialty() {
		
		Connection connection = DbUtil.getConnection();
        List<specialtyBean> list = new ArrayList<specialtyBean>();
        
        try{
            pre = connection.prepareStatement("select * from food");
            result = pre.executeQuery();
            while(result.next())
            { 
            	specialtyBean specialty = new specialtyBean();
            	specialty.setFID(result.getString("FID"));
            	specialty.setFname(result.getString("Fname"));
            	specialty.setFinfo(result.getString("Finfo"));
            	specialty.setFcount(result.getFloat("Fcount"));
            	specialty.setFpicture(result.getString("Fpicture"));
            	specialty.setFother(result.getString("Fother"));
                list.add(specialty);
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
	public specialtyBean getObject(String id) {
		Connection connection = DbUtil.getConnection();
		specialtyBean specialty = new specialtyBean();
		
        try{
            pre = connection.prepareStatement("select * from food where FID=?");
            pre.setString(1,id);
            result = pre.executeQuery();
            if(result.next())
            {
            	specialty.setFID(result.getString("FID"));
            	specialty.setFname(result.getString("Fname"));
            	specialty.setFinfo(result.getString("Finfo"));
            	specialty.setFcount(result.getInt("Fcount"));
            	specialty.setFpicture(result.getString("Fpicture"));
            	specialty.setFother(result.getString("Fother"));
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
        return specialty;
	}

	@Override
	public int AddSpecialty(specialtyBean specialty) {
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try{
            pre = connection.prepareStatement("insert into food(FID,Fname,Finfo,Fcount,Fpicture,Fother) values(?,?,?,?,?,?)");
            pre.setString(1,specialty.getFID());
            pre.setString(2,specialty.getFname());
            pre.setString(3,specialty.getFinfo());
            pre.setFloat(4,specialty.getFcount());
            pre.setString(5,specialty.getFpicture());
            pre.setString(6,specialty.getFother());
            count = pre.executeUpdate();
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
        return count;
	}

	@Override
	public int ModSpecialty(specialtyBean specialty) {
		
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try
        {
            pre = connection.prepareStatement("update food set Fname=?,Finfo=?,Fcount=?,Fpicture=?,Fother=? where FID=?");
            pre.setString(1,specialty.getFname());
            pre.setString(2,specialty.getFinfo());
            pre.setFloat(3,specialty.getFcount());
            pre.setString(4,specialty.getFpicture());
            pre.setString(5,specialty.getFother());
            pre.setString(6,specialty.getFID());
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
	public int DelSpecialty(specialtyBean specialty) {
		
		Connection connection = DbUtil.getConnection();
        int count = 0;
        try {
            pre = connection.prepareStatement("delete from food where FID=?");
            pre.setString(1,specialty.getFID());
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
