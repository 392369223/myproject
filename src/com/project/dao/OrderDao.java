package com.project.dao;

import com.project.bean.Order;
import com.project.tools.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    Connection con=null;
    PreparedStatement sta=null;
    ResultSet st=null;
    //插入订单信息
    public int insertIntoOrder(Order order){
        String sql="insert into sale(name,buyname,salename,num,prise) values(?,?,?,?,?)";
        int i=0;
        con= JDBCUtils.getConnection();
        try {
            System.out.println();
            sta=con.prepareStatement(sql);
            sta.setString(1,order.getName());
            sta.setString(2,order.getBuyname());
            sta.setString(3,order.getSalername());
            sta.setInt(4,order.getCount());
            sta.setDouble(5,order.getPrise());
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }

    }
    //根据自己的用户名查询自己卖出过哪些书籍
    public List<Order> findOrderByName(String uname){
        List<Order> lst=new ArrayList<>();
        Order order=null;
        String sql="select * from sale where salename=?";
        con=JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,uname);
            st=sta.executeQuery();
            while(st.next()){
                order=new Order();
                order.setId(st.getInt(1));
                order.setName(st.getString(2));
                order.setSalername(uname);
                order.setBuyname(st.getString(3));
                order.setCount(st.getInt(5));
                order.setPrise(st.getDouble(6));
                lst.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return lst;
        }
    }
    //根据自己的用户名判断自己买过哪些书籍
    public List<Order> findOrder2ByName(String uname){
        List<Order> lst=new ArrayList<>();
        String sql="select * from sale where buyname=?";
        Order order=null;
        con=JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,uname);
            st=sta.executeQuery();
            while(st.next()){
                order=new Order();
                order.setId(st.getInt(1));
                order.setName(st.getString(2));
                order.setBuyname(uname);
                order.setSalername(st.getString(4));
                order.setCount(st.getInt(5));
                order.setPrise(st.getDouble(6));
                lst.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return lst;
        }
    }
}
