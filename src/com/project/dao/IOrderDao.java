package com.project.dao;

import com.project.bean.Order;

import java.util.List;

public interface IOrderDao {
    //插入单个订单信息
    public int insertIntoOrder(Order order);

    //根据用户名查看自己购买图书订单
    public List<Order> findOrderByName(String uname);

    //根据用户名查看自己卖出图书的订单
    public List<Order> findOrder2ByName(String uname);

    //实现支付功能
    public boolean pay(String buyname,String sellname,double money);

}
