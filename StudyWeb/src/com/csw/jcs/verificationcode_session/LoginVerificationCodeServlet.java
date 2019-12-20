package com.csw.jcs.verificationcode_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginVerificationCodeServlet",urlPatterns = "/LoginVerificationCodeServlet")
public class LoginVerificationCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8"); //2
        response.setCharacterEncoding("utf-8"); //3

        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String userVCode = request.getParameter("verificationcode");
        PrintWriter pw = response.getWriter();
        String verificationCode = request.getSession().getAttribute("verificationCode").toString();
        System.out.println(username+userpwd+userVCode+verificationCode);
        if(username.equals("123")){

            if(userVCode.equalsIgnoreCase(verificationCode)){
                pw.write("验证码通过"+username+"登录成功");
                System.out.println("\"验证码通过\"+username+\"登录成功\"");
            }else{
                pw.write("验证码错误");
            }

        }else{
            pw.write("用户名错误");
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
