package com.hs.book.config;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * @author Huasheng
 * @Date 2021/04/14/14:51
 * @Description
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql://192.168.195.129:3307/test", "root", "000000");
        PreparedStatement preparedStatement = root.prepareStatement("select * from book_info");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String book_name = resultSet.getString("book_name");
            System.out.println(book_name);
        }

    }

}
