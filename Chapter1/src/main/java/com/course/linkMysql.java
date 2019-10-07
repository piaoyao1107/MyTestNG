package com.course;

import org.testng.annotations.Test;

import java.sql.*;

public class linkMysql {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String dbUrl = "jdbc:mysql://localhost:3306/school";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String user = "root";
    static final String password = "Passw0rd";


    public static String mysqlSelect(){

        System.out.println("testSelect方法开始执行……");
        String token = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(jdbcDriver);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(dbUrl,user,password);

            // 执行查询
            // System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "select id,token,updateBy from testng where id = 1";
            //查询
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                // 通过字段检索
                  token = rs.getString("token");
                  System.out.println("查询mysql时返回的token >>> "+token);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("testSelect方法结束执行……");
        return token;
    }


    public static  void mysqlUpdate(String token){
        System.out.println("mysqlUpdate方法开始执行……");
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(jdbcDriver);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(dbUrl,user,password);

            // 执行查询
//            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "update testng set token = '"+token+"' where id=1";

            //update
            int rs = stmt.executeUpdate(sql);
            System.out.println("调用返回结果是 >>> "+rs);

            // 完成后关闭
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("mysqlUpdate方法结束执行……");
    }

}

