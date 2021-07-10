package com.project.action;

import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//将修改的用户信息上传并修改，
@WebServlet("/modify2")
public class modify2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sex=req.getParameter("sex");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String uname=req.getSession().getAttribute("uname").toString();
        UserDao dao=new UserDao();
        int i=dao.updateUserByUname(uname,sex,phone,email);
        if(i==0){
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/Main.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
