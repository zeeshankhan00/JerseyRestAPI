package com.telusko.RestAPIUsingDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/RestAPIUsers";
        String user = "root";
        String password = "Zeeshan@135";

        return DriverManager.getConnection(url,user,password);
    }

    public static void closeConncetion(Connection connect, Statement statement) throws SQLException {
        statement.close();
        connect.close();
    }
}
