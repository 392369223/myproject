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
//根据用户名查看用户详细信息并打印
@WebServlet("/modify")
public class modify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserDao dao=new UserDao();
        Map<String,String> map=new HashMap<String,String>();
        map.put("uname",req.getSession().getAttribute("uname").toString());
        List<User> lst=dao.findUserInfoByArgs(map);
        User u1=lst.get(0);
        req.setAttribute("sex",u1.getSex());
        req.setAttribute("phone",u1.getPhone());
        req.setAttribute("email",u1.getEmail());
        if(lst.size()>0){
            req.getRequestDispatcher("/modify.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
