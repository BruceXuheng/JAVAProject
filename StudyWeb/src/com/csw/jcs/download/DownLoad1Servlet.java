package com.csw.jcs.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "DownLoad1Servlet",urlPatterns = "/DownLoad1Servlet")
public class DownLoad1Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        System.out.println(fileName);
        ServletContext sc = this.getServletContext();
        String realPath = sc.getRealPath("/img/"+fileName);

        FileInputStream fileInputStream = new FileInputStream(realPath);

        String mimeType = sc.getMimeType(fileName);
        response.setHeader("content-type",mimeType);

        response.setHeader("content-disposition","attachment;filename"+fileName);

        ServletOutputStream sos = response.getOutputStream();

        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while((len = fileInputStream.read(bytes))!=-1){
            sos.write(bytes,0,len);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------------doGet");
    }
}
