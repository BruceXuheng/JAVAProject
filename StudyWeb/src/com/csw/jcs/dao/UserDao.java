package com.csw.jcs.dao;

import com.csw.jcs.bean.UserBean;
import com.csw.jcs.druid.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDao {

    private JdbcTemplate mJdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

    /**
     * 登录方法
     */
    public UserBean login(UserBean loginUser) {
        try{
            String sql = "select * from user where username = ? and userpwd = ?";
            return mJdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<UserBean>(UserBean.class),
                    loginUser.getUserName(), loginUser.getUserpwd());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

}
