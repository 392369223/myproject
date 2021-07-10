package com.project.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/purchase")
public class purchase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String bookid=req.getParameter("bookid");
        String salename=req.getParameter("salename");
        String bookname=req.getParameter("bookname");
        String path=req.getParameter("path");
        String num=req.getParameter("num");
        req.setAttribute("salename",salename);
        req.setAttribute("bookname",bookname);
        req.setAttribute("path",path);
        req.setAttribute("num",num);
        req.setAttribute("bookid",bookid);
        req.getRequestDispatcher("purchase.jsp").forward(req,resp);
    }
}
