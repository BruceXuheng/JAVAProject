package com.csw.jcs.login;

import com.csw.jcs.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginSuccessServlet", urlPatterns = "/LoginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean user = (UserBean) request.getAttribute("user");

        if (user != null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("欢迎" + user.getUserName());
        }
    }
}
