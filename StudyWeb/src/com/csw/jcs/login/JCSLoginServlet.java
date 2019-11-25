package com.csw.jcs.login;

import com.csw.jcs.bean.UserBean;
import com.csw.jcs.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "JCSLoginServlet", urlPatterns = "/JCSLoginServlet")
public class JCSLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");

        UserBean loginUser = new UserBean()
                .setUserName(username)
                .setUserpwd(userpwd);

        UserDao dao = new UserDao();

        UserBean ResultUser = dao.login(loginUser);

        if (ResultUser != null) {
            System.out.println(ResultUser);
            request.getRequestDispatcher("/LoginSuccessServlet").forward(request, response);
        } else {
            System.out.println("登陆失败");
            request.getRequestDispatcher("/LoginFailServlet").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //1.第一种创建方式
        UserBean loginUser = new UserBean()
                .setUserName(request.getParameter("username"))
                .setUserpwd(request.getParameter("userpwd"));

        //2.第二种使用BeanUtils包
        Map<String,String[]> map = request.getParameterMap();
        UserBean loginUser2 = new UserBean();
        try {
            BeanUtils.populate(loginUser2,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        UserDao dao = new UserDao();

        UserBean ResultUser = dao.login(loginUser2);

        if (ResultUser != null) {
            request.setAttribute("user",ResultUser);
            System.out.println("登录成功");
            request.getRequestDispatcher("/LoginSuccessServlet").forward(request, response);
        } else {
            System.out.println("登陆失败");
            request.getRequestDispatcher("/LoginFailServlet").forward(request, response);

        }
    }
}
