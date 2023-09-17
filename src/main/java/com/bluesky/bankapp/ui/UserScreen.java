package com.bluesky.bankapp.ui;

import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserScreen {

    public static void displayUserDetails(User user) throws SQLException {


        // Display User info
        System.out.println("\n       ================================================");
        System.out.println("       User Full Name: " + user.getFullName() + " | Mobile : " + user.getMobileNo());
        System.out.println("       ------------------------------------------------");
        System.out.println("       Account Info");
        for (Account account : user.getAccounts()) {
            System.out.println("       Account Num: " + account.getAccNum()
                    + " | Balance: " + account.getBalance()
                    + " | Is Primary: " + account.getPrimary());
        }
        System.out.println("       ================================================");
    }
}
