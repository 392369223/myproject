package com.project.test;

import com.project.bean.Book;
import com.project.bean.User;
import com.project.dao.BookDao;
import com.project.dao.UserDao;
import com.project.tools.JDBCUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        UserDao dao=new UserDao();
        /*User u=new User();
        u.setUname("admin");
        u.setPwd("123456");
        u.setSex("男");
        u.setPhone("15226503138");
        u.setEmail("392369223@qq.com");
        int i=dao.insertUser(u);
        if(i==0){
            System.out.println("插入失败");
        }else{
            System.out.println("插入成功");
        }*/
        /*boolean b=dao.pay("李明","123",40);
        if(b){
            System.out.println("支付成功");
        }else{
            System.out.println("支付失败");
        }*/
        BookDao dao1=new BookDao();
        int i=dao1.updateLabel(14,0);
        if(i!=0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
}
