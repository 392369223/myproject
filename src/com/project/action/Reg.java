package com.project.action;

import com.project.bean.User;
import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

//注册
//用户名，手机号，邮箱都不能重复，否则注册失败
@WebServlet("/Reg")
public class Reg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address(req,resp);
    }
    public void Address(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        UserDao dao=new UserDao();
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        String sex=req.getParameter("sex");
        String tel=req.getParameter("phone");
        String email=req.getParameter("email");
        String s1="select * from user where uname=?";
        String s2 = "select * from user where phone=?";
        String s3="select * from user where email=?";
        if(dao.queryByAttrs(s1,uname)) {
            req.setAttribute("error","name");
            //System.out.println("error1");
            try {
                req.getRequestDispatcher("/Reg.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(dao.queryByAttrs(s2,pwd)){
            req.setAttribute("error","password");
            //System.out.println("error2");
            try {
                req.getRequestDispatcher("/Reg.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(dao.queryByAttrs(s3,email)) {
            req.setAttribute("error", "email");
            //System.out.println("error3");
            try {
                req.getRequestDispatcher("/Reg.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            User u=new User();
            u.setUname(uname);
            u.setPwd(pwd);
            u.setSex(sex);
            u.setPhone(tel);
            u.setEmail(email);
            int i=dao.insertUser(u);
            if(i==0){
                //System.out.println("error");
                req.setAttribute("error", "email");
                try {
                    req.getRequestDispatcher("/Reg.jsp").forward(req,resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    req.getSession().setAttribute("uname",uname);
                    req.getSession().setAttribute("pwd",pwd);
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
