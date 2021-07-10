package com.project.test;

import com.project.bean.User;
import com.project.dao.UserDao;
import com.project.tools.JDBCUtils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserDao dao=new UserDao();
        for(int i=0;i<100;i++) {
            User u = new User();
            u.setUname("李子浩");
            u.setPwd("123");
            u.setSex("男");
            u.setPhone("17367980826");
            u.setEmail("392369223@qq.com");
            int r = dao.insertUser(u);
            if (r == 0) {
                System.out.println("插入失败");
            } else {
                System.out.println("插入成功");
            }
        }
        /*List<User> lst=dao.findUserInfoAll();
        for(User u:lst){
            System.out.println(u);
        }*/
          /*User u=dao.findUserInfoByID(1);
        System.out.println(u);*/
        /*HashMap<String,String> map=new HashMap<>();
        map.put("uname","李子浩");
        map.put("pwd","123");
        List<User> lst=dao.findUserInfoByArgs(map);
        System.out.println(lst);*/
       /* User u=new User();
        u.setUid(1);
        u.setUname("123");
        u.setPwd("222");
        u.setSex("男");
        u.setPhone("111");
        u.setEmail("111");
        u.setAddress("111");
        int i=dao.updateUserInfo(u);
        if(i==0){
            System.out.println("更新失败");
        }else{
            System.out.println("更新成功");
        }*/
        /*int i=1;
        for(;i<4;i++){
            if(dao.delUserInfoByID(i)==0){
                System.out.println("失败");
            }else{
                System.out.println("成功");
            }
        }*/
       /*List<User> lst=dao.findUserInfoByPageIndex(2,10);
        for (User u:lst) {
            System.out.println(u);
        }*/
        /*String sql="select * from user where uname=?";
        boolean b=dao.queryByAttrs(sql,"admin");
        System.out.println(b);*/
    }
}
