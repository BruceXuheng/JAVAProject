package com.csw.jcs.test;

import com.csw.jcs.bean.UserBean;
import com.csw.jcs.dao.UserDao;
import com.csw.jcs.druid.DruidUtils;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest {

    @Test
    public void testLogin(){
        UserBean userBean = new UserBean().setUserName("chenxh")
                .setUserpwd("123456");

        UserDao dao = new UserDao();
        UserBean user = dao.login(userBean);
        System.out.println(user.toString());

    }

}
