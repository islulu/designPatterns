package com.luluya.designPatterns.controller.reflection;

import java.sql.*;

/**
 * @author jairy
 * @date 2019/5/15
 */
public class JDBCDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 通过DriverManager获取数据库连接
        String url = "jdbc:mysql://192.168.1.150/test";
        String user = "teamtalk";
        String password = "123456";
        Connection connection = DriverManager.getConnection(
                url, user, password);

        //组装sql
        PreparedStatement statement = connection.prepareStatement(
                "insert persion (name, age) value (?, ?)");
        statement.setString(1, "hdu");
        statement.setInt(2, 21);
        statement.executeUpdate();

        //执行sql
        ResultSet resultSet = statement.executeQuery("select * from persion");

        // 操作ResultSet结果集
        while (resultSet.next()) {
            // 第一种获取字段方式
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString(2) + " " + resultSet.getString(3));
        }

        // 关闭数据库连接
        resultSet.close();
        statement.close();
        connection.close();
    }

}
