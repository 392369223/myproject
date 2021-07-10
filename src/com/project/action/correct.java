package com.project.action;

import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/correct")
public class correct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uname=req.getSession().getAttribute("nn").toString();
        String pwd=req.getParameter("passwd");
        UserDao dao=new UserDao();
       int i= dao.updateUserByPwd(uname,pwd);
       if(i==0){
           req.getRequestDispatcher("/error.jsp").forward(req,resp);
       }else{
           req.getSession().setAttribute("uname",uname);
           req.getRequestDispatcher("/Main.jsp").forward(req,resp);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
