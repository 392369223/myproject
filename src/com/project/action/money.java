package com.project.action;

import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/money")
public class money extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname=req.getSession().getAttribute("uname").toString();
        UserDao dao=new UserDao();
        int i=dao.findUserInfoByUname(uname);
        if(i==0){
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }else{
            req.setAttribute("money",i);
            req.getRequestDispatcher("/recharge.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
