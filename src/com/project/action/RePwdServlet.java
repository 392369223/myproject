package com.project.action;

import com.project.bean.User;
import com.project.dao.UserDao;
import com.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "RePwdServlet",urlPatterns = "/rePwdServlet")
public class RePwdServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 获取session中的验证码
        String sessionCode = (String) req.getSession().getAttribute("code");
        System.out.println(sessionCode);

        if (sessionCode != null) {
            //  获取页面提交的验证码
            String inputCode = req.getParameter("code");
            System.out.println("页面提交的验证码:" + inputCode);
            if (sessionCode.toLowerCase().equals(inputCode.toLowerCase())) {
                String username = req.getParameter("uname");
                String password = req.getParameter("pwd");
                String email=req.getParameter("email");
                System.out.println("页面提交:" + username + password+email);
                //  验证成功，跳转成功页面
                UserDao dao = new UserDao();
                Map<String, String> map = new HashMap<String, String>();
                map.put("uname", username);
                map.put("email", email);
//                req.setAttribute("uname", username);
                List<User> u = dao.findUserInfoByArgs(map);
                if (u != null && u.size() != 0) {
                    System.out.println(u.toString());
                    req.getSession().setAttribute("correct", "1");
                    req.getSession().setAttribute("nn", username);
                    dao.updateUserByPwd(username,password);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else {
                    System.out.println("进入error界面");
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                }
//                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                //  验证失败
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            //  验证失败
            req.getRequestDispatcher("fail.jsp").forward(req, resp);
        }
        //  移除session中的验证码
        req.removeAttribute("code");
    }
}
