package com.project.action;

import com.project.bean.Book;
import com.project.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//根据用户名查找自己上传的图书
@WebServlet("/sale")
public class sale extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       String uname=req.getSession().getAttribute("uname").toString();
       BookDao dao=new BookDao();
       List<Book> lst=dao.findBookByName(uname);
       req.setAttribute("lst",lst);
       if(lst.size()>0) {
           req.getRequestDispatcher("/mysale.jsp").forward(req, resp);
       }else{
           req.getRequestDispatcher("/Main.jsp").forward(req,resp);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
