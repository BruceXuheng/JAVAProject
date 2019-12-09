package com.csw.jcs.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContextDemo",urlPatterns = "/ServletContextDemo")
public class ServletContextDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext1 = request.getServletContext();
        ServletContext servletContext2 = this.getServletContext();
        System.out.println(servletContext1 == servletContext2);

        String file1 = "a.jpeg";
        //获取MIME
        String mime = servletContext1.getMimeType(file1);
        System.out.println(mime);


        System.out.println(this.getServletContext().getAttribute("a"));
    }
}
