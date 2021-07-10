package com.project.action;

import com.project.bean.Book;
import com.project.bean.User;
import com.project.dao.BookDao;
import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//登陆
@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Login(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Login(req,resp);
    }
    public void Login(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        UserDao dao=new UserDao();
        String tag=req.getParameter("tag");
        if(tag==null||tag==""){
            tag="生活";
        }
        String uname=req.getParameter("user_name");
        String pwd=req.getParameter("pwd");
        Map<String,String> map=new HashMap<String,String>();
        map.put("uname",uname);
        map.put("pwd",pwd);
        List<User> lst=dao.findUserInfoByArgs(map);
        if(lst!=null&&lst.size()!=0){
           // System.out.println("1");
            req.getSession().setAttribute("uname",uname);
            req.getSession().setAttribute("pwd",pwd);
            try {
                List<Book> books=new BookDao().findBookByTag(tag);
                req.getSession().setAttribute("books",books);
                req.getSession().setAttribute("purchase",0);
                req.getRequestDispatcher("/Main.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                try {
                    req.setAttribute("error","error");
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
