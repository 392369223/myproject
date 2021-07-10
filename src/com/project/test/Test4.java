package com.project.test;

import com.project.bean.User;
import com.project.dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 {
    public static void main(String[] args) {
        UserDao dao=new UserDao();
        Map<String,String> map=new HashMap<String,String>();
        map.put("uname","aa");
        map.put("email","135242");
        map.put("sex","男");
        List<User> u=dao.findUserInfoByArgs(map);
    }
}
