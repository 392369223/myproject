package com.project.action;

import com.project.bean.Book;
import com.project.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
//进行模糊搜素
@WebServlet("/search2")
public class search2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.setCharacterEncoding("utf-8");
          resp.setCharacterEncoding("utf-8");
          String name=req.getParameter("name1");
        BookDao dao = new BookDao();
        System.out.println(name);
          if(name!=null&&name!="") {
              List<Book> books = dao.findBooksByFuzzyname(name);
              req.getSession().setAttribute("books", books);
              req.getRequestDispatcher("/Main.jsp").forward(req, resp);
          }else{
              List<Book> books= dao.findBookByTag("生活");
              req.getSession().setAttribute("books", books);
              req.getRequestDispatcher("/Main.jsp").forward(req, resp);
          }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
