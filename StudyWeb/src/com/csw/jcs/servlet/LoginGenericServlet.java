package com.csw.jcs.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/loging")
public class LoginGenericServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("LoginGenericServlet init ");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("LoginGenericServlet .... ");
    }
}
