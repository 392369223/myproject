package com.project.dao;

import com.project.bean.User;
import com.project.tools.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {
    Connection con=null;
    PreparedStatement sta=null;
    ResultSet st=null;

    //更新信息
    public int updateUserByUname(String uname,String sex,String phone,String email){
        String sql="update user set sex=?,phone=?,email=? where uname=?";
        int i=0;
        con= JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,sex);
            sta.setString(2,phone);
            sta.setString(3,email);
            sta.setString(4,uname);
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }
    }
    public boolean queryByAttrs(String sql,String o){
        con=JDBCUtils.getConnection();
        boolean ret=false;
        if(con!=null){
            try {
                sta=con.prepareStatement(sql);
                sta.setString(1,o);
                st=sta.executeQuery();
                //st=sta.executeQuery(sql);
                if(st.next()){
                    ret=true;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(con,sta,st);
                return  ret;
            }
        }else{
            return false;
        }
    }
    public int insertUser(User userInfo){
        String sql="insert into user(uname,pwd,sex,phone,email) values(?,?,?,?,?)";
        int i=0;
        con=JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,userInfo.getUname());
            sta.setString(2,userInfo.getPwd());
            sta.setString(3, userInfo.getSex());
            sta.setString(4,userInfo.getPhone());
            sta.setString(5,userInfo.getEmail());
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,sta,st);
            return i;
        }
    }
    public List<User> findUserInfoAll(){
        con=JDBCUtils.getConnection();
        String sql="select * from user";
        List<User> users=new ArrayList<>();
        User u=null;
        try {
            sta=con.prepareStatement(sql);
            st=sta.executeQuery();
            while(st.next()){
                u=new User();
                u.setUid(st.getInt(1));
                u.setUname(st.getString(2));
                u.setPwd(st.getString(3));
                u.setSex(st.getString(4));
                u.setPhone(st.getString(5));
                u.setEmail(st.getString(6));
                u.setMoney(st.getInt(7));
                users.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return users;
        }
    }
    public int findUserInfoByUname(String uname){
        con=JDBCUtils.getConnection();
        User u=null;
        int i=0;
        String sql="select * from user where uname=?";
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,uname);
            st=sta.executeQuery();
            if(st.next()){
                i=st.getInt(7);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,sta,st);
            return i;
        }
    }
    public User findUserInfoByID(int id){
        con=JDBCUtils.getConnection();
        User u=null;
        String sql="select * from user where uid=?";
        try {
            sta=con.prepareStatement(sql);
            sta.setInt(1,id);
            st=sta.executeQuery();
            if(st.next()){
                u=new User();
                u.setUid(id);
                u.setUname(st.getString(2));
                u.setPwd(st.getString(3));
                u.setSex(st.getString(4));
                u.setPhone(st.getString(5));
                u.setEmail(st.getString(6));
                u.setMoney(st.getInt(7));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,sta,st);
            return u;
        }
    }
    public int updateUserByPwd(String uname,String pwd){
        int i=0;
        con=JDBCUtils.getConnection();
        String sql="update user set pwd=? where uname=?";
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,pwd);
            sta.setString(2,uname);
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }
    }
    public List<User> findUserInfoByArgs(Map map){
        con=JDBCUtils.getConnection();
        String sql="select * from user where ";
        List<User> users=new ArrayList<>();
        ArrayList s=new ArrayList(map.keySet());
        User u=null;
        for(Object s1:s){
            sql=sql+s1+"=? and ";
        }
        sql=sql.substring(0,sql.length()-4);
        try {
            sta=con.prepareStatement(sql);
            int i=1;
            for(Object s1:s){
                sta.setString(i,map.get(s1).toString());
                //System.out.println(map.get(s1).toString());
                i++;
            }
            //System.out.println(sql);
            st=sta.executeQuery();
            while(st.next()){
                u=new User();
                u.setUid(st.getInt(1));
                u.setUname(st.getString(2));
                u.setPwd(st.getString(3));
                u.setSex(st.getString(4));
                u.setPhone(st.getString(5));
                u.setEmail(st.getString(6));
                u.setMoney(st.getInt(7));
                users.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,sta,st);
            return users;
        }
    }
    public List<User> findUserInfoByPageIndex(int pageIndex,int pageSize){
        List<User> users=new ArrayList<>();
        User u=null;
        con=JDBCUtils.getConnection();
        String sql="select * from user limit ?,?";
        try {
            sta=con.prepareStatement(sql);
            sta.setInt(1,(pageIndex-1)*pageSize);
            sta.setInt(2,pageSize);
            st=sta.executeQuery();
            while(st.next()){
                u=new User();
                u.setUid(st.getInt(1));
                u.setUname(st.getString(2));
                u.setPwd(st.getString(3));
                u.setSex(st.getString(4));
                u.setPhone(st.getString(5));
                u.setEmail(st.getString(6));
                u.setMoney(st.getInt(7));
                users.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return users;
        }
    }
    public int delUserInfoByID(int id){
        int i=0;
        con=JDBCUtils.getConnection();
        String sql="delete from user where uid=?";
        try {
            sta=con.prepareStatement(sql);
            sta.setInt(1,id);
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return i;
        }
    }
    public int updateUserInfo(User userInfo){
        int i=0;
        con=JDBCUtils.getConnection();
        String sql="update user set uname=?,pwd=?,sex=?,phone=?,email=?,money=? where uid=?";
        int id=userInfo.getUid();
        try {
           sta= con.prepareStatement(sql);
           sta.setString(1,userInfo.getUname());
           sta.setString(2,userInfo.getPwd());
           sta.setString(3,userInfo.getSex());
           sta.setString(4,userInfo.getPhone());
           sta.setString(5,userInfo.getEmail());
           sta.setDouble(6,userInfo.getMoney());
           sta.setInt(7,id);
           i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return i;
        }
    }
    public int findAllCount(){
        con=JDBCUtils.getConnection();
        int num=0;
        String sql="select count(*) from user";
        try {
            sta=con.prepareStatement(sql);
            st=sta.executeQuery();
            if(st.next()) {
                num=st.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return num;
        }
    }
    //为用户充值的方法
    public int recharge(int charge,String uname){
        String sql="update user set money=money+? where uname=?";
        int i=0;
        con=JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setInt(1,charge);
            sta.setString(2,uname);
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }
    }
    public boolean pay(String buyname,String sellname,double money){
        con=JDBCUtils.getConnection();
        String sql1="update user set money=money-? where uname=?";
        String sql2="update user set money=money+? where uname=?";
        boolean ret=false;
        int i=0;
        int j=0;
        try {
            sta=con.prepareStatement(sql1);
            sta.setDouble(1,money);
            sta.setString(2,buyname);
            i=sta.executeUpdate();
            sta=con.prepareStatement(sql2);
            sta.setDouble(1,money);
            sta.setString(2,sellname);
            j=sta.executeUpdate();
            if(i!=0&&j!=0){
                ret=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return ret;
        }
    }
}
