package com.bluesky.bankapp;

import com.bluesky.bankapp.model.User;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException {
         String JDBC_URL = "jdbc:mysql://localhost:3306/bank_app";
         User user = new User("Asmita","Mhetre","4/1","852963741","U000");


            String Username="root";
            String Password="Root123";
            Connection con= DriverManager.getConnection(JDBC_URL,Username,Password);

        PreparedStatement stm= con.prepareStatement("select * from User where username=?");
        stm.setString(1, user.getUserName());
        ResultSet resultSet = stm.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println("count:"+count);
        }
    }
}
