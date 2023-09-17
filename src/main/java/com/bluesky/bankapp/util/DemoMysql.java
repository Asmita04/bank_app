package com.bluesky.bankapp.util;

import java.sql.*;

public class DemoMysql {
    public static void main(String[] args) throws SQLException {

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_app","root","Root123");
        Statement stmt= con.createStatement();
        String s= "INSERT INTO User values( 'Asmita','Mhetre','U001','4/1/1','8275493146' )";
        stmt.execute(s);
        con.close();
        System.out.println("executed!");

    }
}