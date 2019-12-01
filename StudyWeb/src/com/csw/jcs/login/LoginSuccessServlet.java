package com.csw.jcs.login;

import com.csw.jcs.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginSuccessServlet", urlPatterns = "/LoginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------重定向数据到达--------");

        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("您好！！");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------重定向数据到达---111-----");

        response.setCharacterEncoding("utf-8");

        //输出文字
        response.setHeader("content-type","text/html;charset=utf-8");
//
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("您好！！");

        //输出字节流
        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write("您好".getBytes("utf-8"));


        UserBean user = (UserBean) request.getAttribute("user");

        if (user != null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("欢迎" + user.getUserName());
        }


    }
}
