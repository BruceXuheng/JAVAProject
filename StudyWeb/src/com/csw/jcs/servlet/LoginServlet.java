package com.csw.jcs.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/log")
public class LoginServlet implements Servlet {

    /**
     * 初始化
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("LoginServlet init");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("LoginServlet getServletConfig");

        return null;
    }


    /**
     * 使用方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("LoginServlet service");

    }

    @Override
    public String getServletInfo() {
        System.out.println("LoginServlet getServletInfo");

        return null;
    }

    /**
     * 销毁
     */

    @Override
    public void destroy() {
        System.out.println("LoginServlet destroy");

    }
}
