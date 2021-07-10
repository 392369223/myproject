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
//实现上架
@WebServlet("/rack")
public class rack extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
       int id=Integer.parseInt(req.getParameter("id"));
       String s=req.getParameter("s");
        //System.out.println(id+"====="+s);
       BookDao dao=new BookDao();
       if(s.equals("up")){
         dao.updateLabel(id,1);
       }else{
          dao.updateLabel(id,0);
       }
       List<Book> lst=dao.findBookByName(req.getSession().getAttribute("uname").toString());
       // System.out.println(lst);
       req.setAttribute("lst",lst);
       req.getRequestDispatcher("/mysale.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
