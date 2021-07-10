package com.project.test;

import com.project.bean.User;
import com.project.dao.BookDao;
import com.project.dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        /*UserDao dao=new UserDao();
        String uname="admin";
        String pwd="123456";
        Map<String,String> map=new HashMap<String,String>();
        map.put("uname",uname);
        map.put("pwd",pwd);
        List<User> lst=dao.findUserInfoByArgs(map);
        System.out.println(lst);*/
        BookDao dao=new BookDao();
        int i=dao.updateCount(15,2);
        if(i!=0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
}
