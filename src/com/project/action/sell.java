package com.project.action;

import com.project.bean.Order;
import com.project.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//根据用户名进行订单的查找，就是自己图书的销售
@WebServlet("/sell")
public class sell extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        OrderDao dao=new OrderDao();
        List<Order> lst=dao.findOrderByName(req.getSession().getAttribute("uname").toString());
        if(lst.size()>0){
            req.setAttribute("lst",lst);
            req.getRequestDispatcher("sell.jsp").forward(req,resp);
        }else{
           req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
