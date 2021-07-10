package com.project.action;

import com.project.bean.Description;
import com.project.dao.DescriptionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/question")
public class question extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String ss=req.getParameter("ss");
        String area=req.getParameter("area");
        //System.out.println(ss+"---"+area);
        DescriptionDao dao=new DescriptionDao();
        Description des=new Description();
        des.setUname(ss);
        des.setArea(area);
        int i=dao.insertIntoDescription(des);
        if(i==0){
            //System.out.println("失败");
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }else{
            //System.out.println("成功");
            req.getRequestDispatcher("/Judge.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
