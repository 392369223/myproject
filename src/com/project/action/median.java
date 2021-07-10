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

//查找用户买的图书信息并显示
@WebServlet("/median")
public class median extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname=req.getSession().getAttribute("uname").toString();
        OrderDao dao=new OrderDao();
        List<Order> lst=dao.findOrder2ByName(uname);
        //寻找用户买的书籍
        if(lst.size()>0){
            req.setAttribute("lst",lst);
            req.getRequestDispatcher("/myorder.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/Main.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
