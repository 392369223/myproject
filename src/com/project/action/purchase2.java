package com.project.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
//实现将商品加入购物车
@WebServlet("/purchase2")
public class purchase2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer=resp.getWriter();
        //System.out.println(req.getParameter("v")+" "+req.getParameter("v2")+" "+req.getParameter("v3"));

        Integer v=Integer.parseInt(req.getParameter("v").trim());
        Integer v2=Integer.parseInt(req.getParameter("v2").trim());
        Integer v3=Integer.parseInt(req.getParameter("v3").trim());
        //System.out.println(v+"===="+v2+"===="+v3);
        if (v != null && v2 != null && v3 != null) {
        if(v3>=v) {
            if (req.getSession().getAttribute("shoplist") == null) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(v2, v);
                req.getSession().setAttribute("shoplist", map);
            } else {
                Map<Integer, Integer> map = (Map<Integer, Integer>) req.getSession().getAttribute("shoplist");
                if (map.containsKey(v2)) {
                    map.put(v2, map.get(v2) + v);
                } else {
                    map.put(v2, v);
                }
                req.getSession().setAttribute("shoplist", map);
            }
            writer.write(v+" "+v2+" success");
            writer.flush();
            writer.close();
        }else{
            writer.write("fail1");
            writer.flush();
            writer.close();
        }
        }else{
            writer.write("fail2");
            writer.flush();
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
