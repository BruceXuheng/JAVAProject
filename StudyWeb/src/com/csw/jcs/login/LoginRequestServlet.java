package com.csw.jcs.login;

import com.csw.jcs.druid.DruidUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/login")
public class LoginRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------doGet--------------------");
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DruidUtils.createConnection();
            String sqlStr = "insert into user values(?,?,?,?)";
            pstmt = connection.prepareStatement(sqlStr);
            pstmt.setString(1, "2");
            pstmt.setString(2, "chenxhheng");
            pstmt.setString(3, "123321");
            pstmt.setString(4, "1");

            int count = pstmt.executeUpdate();

            System.out.println(count + "数据");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(pstmt, connection);
        }


    }

}
