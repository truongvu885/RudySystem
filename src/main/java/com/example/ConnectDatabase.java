package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/rudysystem";
            String user = "root";
            String passWord = "Truong@2102";
            return DriverManager.getConnection(url,user,passWord);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
