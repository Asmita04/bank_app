package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.BankAppDataStorage;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatabaseConnection {
    private BankAppDataStorage dataStorage;
    public DatabaseConnection(BankAppDataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

   // private static final String JDBC_URL = "jdbc:sqlite:E://projects//sqlite//bank_app.db";

      static String JDBC_URL = "jdbc:mysql://localhost:3306/bank_app";

    public static Connection getConnection()  {
        String Username="root";
        String Password="Root123";
        try {
            return DriverManager.getConnection(JDBC_URL,Username,Password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    List<String> names = new ArrayList<>();
    List<String> names1 = new LinkedList<>();


}
