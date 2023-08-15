package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class TestDataBase {

    //声明了静态属性
    private static Connection conn=null;

    /**
     * 返回一个唯一的数据库连接对象
     * @return
     */
    public static Connection getConnection(){
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 数据库链接URL及数据库名称
            String host = System.getenv().get("172.16.32.102");
            String user = System.getenv().get("root");
            String passwd = System.getenv().get("fIBeblhf");
            String port = System.getenv().get("49653");
            String url = String.format("jdbc:mysql://%s:%s/mydatabase?useUnicode=true&characterEncoding=utf8", host, port);

            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("连接成功!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 关闭数据库连接对象的方法
     */
    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //定义一个测试的main方法
    public static void main(String[] args) {
        TestDataBase.getConnection();
    }
}
