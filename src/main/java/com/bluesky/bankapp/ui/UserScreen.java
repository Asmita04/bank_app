package com.bluesky.bankapp.ui;

import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.User;

public class UserScreen {

    public static void displayUserDetails(User user) {
        // Display User info
        System.out.println("\n       ====================================");
        System.out.println("       User Name: " + user.getFullName() + " | Aadhaar: " + user.getAadhaar());
        System.out.println("       ------------------------------------");
        System.out.println("       Account Info");
        for (Account account : user.getAccounts()) {
            System.out.println("       Account Num: " + account.getAccNum()
                    + " | Balance: " + account.getBalance());
        }
        System.out.println("       ====================================");
    }
}
