package com.project.action;

import com.project.bean.Book;
import com.project.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//计算总价格，然后跳转到付款界面
@WebServlet("/shop")
public class shop extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Map<Integer,Integer> shoplist=(Map<Integer,Integer>)req.getSession().getAttribute("shoplist");
       if(shoplist!=null) {
           BookDao dao = new BookDao();
           ArrayList<Integer> lst = new ArrayList<>(shoplist.keySet());
           List<Integer> nums = new ArrayList<>();
           for (Integer l : lst) {
               nums.add(shoplist.get(l));
           }
           List<Book> shopbooks = dao.findBookByIdList(lst);
           double totalPrice = 0;
           for (int i = 0; i < shopbooks.size(); i++) {
               totalPrice = totalPrice + shopbooks.get(i).getPrise() * nums.get(i);
           }
           //System.out.println("totalPrice====" + totalPrice);
           req.getSession().setAttribute("shopbooks", shopbooks);
           req.getSession().setAttribute("nums", nums);
           req.getSession().setAttribute("totalPrice", totalPrice);
           req.getRequestDispatcher("shop.jsp").forward(req, resp);
       }else{
           resp.sendRedirect("/myproject/page.jsp");
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
