package com.bluesky.bankapp;


import com.bluesky.bankapp.model.MoneyTransferRequest;
import com.bluesky.bankapp.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAppDataStorage {
     public   Map<String, User> userMap;
     public HashMap<String, Integer> accountNumbers ;
     private List<User> users;

    public BankAppDataStorage(){
        userMap=new HashMap<>();
        accountNumbers = new HashMap<>();
        users = new ArrayList<>();
    }


    //User Details
    public User getUserDetails(String aadhaarNo) {
        for (User user : users) {
            if (user.getUserName().equals(aadhaarNo)) {
                return user;
            }
        }
        return null;
    }

    public boolean userExists(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
