package com.project.dao;

import com.project.bean.Description;
import com.project.tools.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DescriptionDao {
    public int insertIntoDescription(Description des){
        Connection con=JDBCUtils.getConnection();
        PreparedStatement sta=null;
        String sql="insert into description(name,area) values(?,?)";
        int i=0;
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,des.getUname());
            sta.setString(2,des.getArea());
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }
    }
}
