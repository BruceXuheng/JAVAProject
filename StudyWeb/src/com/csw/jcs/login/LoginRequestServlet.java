package com.csw.jcs.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "LoginRequestServlet", urlPatterns = "/loginrequestservlet")
public class LoginRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("请求方式 = " + request.getMethod());
        System.out.println("请求参数 = " + request.getQueryString());
        System.out.println("请求协议 = " + request.getProtocol());
        System.out.println("请求者IP = " + request.getRemoteAddr());
        System.out.println("请求Url = " + request.getRequestURL().toString());


        //获取演示获取请求数据
        //1.获取所有请求头名称
        Enumeration<String> headrNames = request.getHeaderNames();
        //2.遍历
        while (headrNames.hasMoreElements()) {
            String name = headrNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + "---" + value);
        }

        //获取请求头数据：user-agent
        String agent = request.getHeader("user-agent");
        if (agent.contains("Chrome")) {
            System.out.println("谷歌");
        } else if (agent.contains("firefox")) {
            System.out.println("火狐");
        }


        //演示获取请求数据：referer
        String referer = request.getHeader("referer");
        System.out.println("referer" + referer);

        if (referer != null) {
            if (referer.contains("loginrequestservlet")) {
                System.out.println("继续行驶");
            } else {
                System.out.println("当前访问页面有问题，请去Bruce官网");
            }
        }

        //设置流的编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");

        //转发
        request.getRequestDispatcher("/loging").forward(request, response);

    }

}
