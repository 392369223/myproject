package com.project.action;

import com.project.bean.User;
import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/validate")
public class validate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
       String uname=req.getParameter("uname");
       String email=req.getParameter("email");
       String sex=req.getParameter("gen");
        //System.out.println(uname+"==="+email+"==="+sex);
        UserDao dao=new UserDao();
        Map<String,String> map=new HashMap<String,String>();
        map.put("uname",uname);
        map.put("email",email);
        map.put("sex",sex);
        List<User> u=dao.findUserInfoByArgs(map);
        if(u!=null&&u.size()!=0){
            req.getSession().setAttribute("correct","1");
            req.getSession().setAttribute("nn",uname);
            req.getRequestDispatcher("/correct.jsp").forward(req,resp);
        }else{
            //System.out.println("进入error界面");
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
