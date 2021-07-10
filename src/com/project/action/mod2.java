package com.project.action;

import com.project.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//调用BookDao中的方法，如果成功回到modsuccess.jsp,如果失败跳转到wrong.jsp
@WebServlet("/mod2")
public class mod2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BookDao dao=new BookDao();
        int id=Integer.parseInt(req.getSession().getAttribute("id").toString());
        int count=Integer.parseInt(req.getParameter("mod"));
        int i=dao.updateCount(id,count);
        if(i==0) {
            req.getRequestDispatcher("/wrong.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/modsuccess.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
