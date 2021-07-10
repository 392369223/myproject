package com.project.action;

import com.project.bean.Book;
import com.project.bean.Order;
import com.project.bean.User;
import com.project.dao.BookDao;
import com.project.dao.OrderDao;
import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//进行支付
//计算总和，如果钱包不够跳转到unenough.jsp界面
@WebServlet("/pay")
public class pay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao=new UserDao();
        BookDao dao1=new BookDao();
        OrderDao dao2=new OrderDao();
        Order order=null;
        double total=Double.parseDouble(req.getSession().getAttribute("totalPrice").toString());
        //购物车的图书id
        List<Book> lst=(List<Book>)req.getSession().getAttribute("shopbooks");
        //记录了图书的购买各种图书的数量
        List<Integer> nums=(List<Integer>)req.getSession().getAttribute("nums");
        double save=dao.findUserInfoByUname(req.getSession().getAttribute("uname").toString());
        String uname=req.getSession().getAttribute("uname").toString();
        if(save<total){
            resp.sendRedirect("/myproject/unenough.jsp");
        }else{
           for(int i=0;i<nums.size();i++){
              dao.pay(uname,lst.get(i).getSaler(),nums.get(i)*lst.get(i).getPrise());
              int a=dao1.update(lst.get(i).getSaler(),lst.get(i).getName(),nums.get(i));
              order=new Order();
              order.setName(lst.get(i).getName());
              order.setBuyname(uname);
              order.setSalername(lst.get(i).getSaler());
              order.setCount(nums.get(i));
              order.setPrise(lst.get(i).getPrise());
              int b=dao2.insertIntoOrder(order);
           }
            req.getSession().setAttribute("nums",null);
            req.getSession().setAttribute("shopbooks",null);
            req.getSession().setAttribute("shoplist",null);
            resp.sendRedirect("pay.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
