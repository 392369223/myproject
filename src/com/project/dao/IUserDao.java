package com.project.dao;

import com.project.bean.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    //更新用户隐私信息
    public int updateUserByUname(String uname,String sex,String phone,String email);
    public boolean queryByAttrs(String sql,String o);
    //插入用户
    public int insertUser(User userInfo);
    public List<User> findUserInfoAll();
    //根据用户名查找用户信息
    public int findUserInfoByUname(String uname);
    public User findUserInfoByID(int id);
    //更新密码，实现密码的重置
    public int updateUserByPwd(String uname,String pwd);
    public List<User> findUserInfoByArgs(Map map);
    public int delUserInfoByID(int id);
    public int updateUserInfo(User userInfo);
    //实现用户钱包的充值
    public int recharge(int charge,String uname);

}
