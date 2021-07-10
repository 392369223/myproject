package com.project.action;

import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recharge")
public class recharge extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String s=req.getParameter("recharge");
        String uname=req.getSession().getAttribute("uname").toString();
        //System.out.println(s+"===="+uname);
        int charge=Integer.parseInt(s);
        UserDao dao=new UserDao();
        int i=dao.recharge(charge,uname);
        if(i==0){
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
