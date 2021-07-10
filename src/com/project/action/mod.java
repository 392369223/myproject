package com.project.action;

import com.project.bean.Book;
import com.project.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//根据图书id查找图书相关信息并返回
@WebServlet("/mod")
public class mod extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
       int id=Integer.parseInt(req.getParameter("id").toString());
       BookDao dao=new BookDao();
       Book book=dao.findBookById(id);
       req.setAttribute("book",book);
       req.getRequestDispatcher("mod.jsp").forward(req,resp);
    }
}
