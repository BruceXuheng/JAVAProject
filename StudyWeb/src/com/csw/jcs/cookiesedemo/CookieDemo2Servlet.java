package com.csw.jcs.cookiesedemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieDemo2Servlet",urlPatterns = "/CookieDemo2Servlet")
public class CookieDemo2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getValue()+"--"+cookie.getName());
                if("lasttime".equals(cookie.getName())){
                    String lastTImeValue = cookie.getValue();
                    response.getWriter().write("欢迎回来，您上次访问时间"+lastTImeValue);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
