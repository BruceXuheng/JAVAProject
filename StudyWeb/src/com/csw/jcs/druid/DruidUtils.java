package com.csw.jcs.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {


//    public static void main(String[] args) {
//        {
//            //1. 导入jar
//
//            //2. 定义配置文件
//
//            //3. 配置文件加载
//            InputStream is = null;
//            Properties pro = null;
//            try {
//                pro = new Properties();
//                is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
//                pro.load(is);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            //4. 获取连接池对象
//            DataSource dataSource = null;
//            try {
//                dataSource = DruidDataSourceFactory.createDataSource(pro);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            //5. 获取连接
//            try {
//                assert dataSource != null;
//                Connection connection = dataSource.getConnection();
//                System.out.println(connection);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//
//
//    }

    private static DataSource mDatasource;

    static {
        try {
            Properties pro = new Properties();
            pro.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            mDatasource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //1.获取连接方法
    public static Connection createConnection() throws SQLException {
        return mDatasource.getConnection();
    }


    //释放资源
    public static void close(Statement statement,Connection connection){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //
//释放资源
    public static void close(ResultSet resultSet,Statement statement, Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
