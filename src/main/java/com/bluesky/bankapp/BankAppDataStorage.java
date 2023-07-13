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

    //Removing Account
    public void removeAccount(String accountNo){
        if (userMap.containsKey(accountNo)) {
            userMap.remove(accountNo);
            System.out.println("1 Account Deleted!");
        }
        else {
            System.out.println("Account is not present!");
        }
    }

    public void transferMoney(MoneyTransferRequest request){
//        User sender =userMap.get(request.getSourceAcc());
//        User receiver =userMap.get(request.getTargetAcc());
//
//        if (sender.getBalance() >= request.getAmount()) {
//            sender.setBalance(sender.getBalance() - request.getAmount());
//            receiver.setBalance(receiver.getBalance() + request.getAmount());
//
//        } else {
//            System.out.println("Insufficient Balance!");
//        }
//
//        userMap.put(request.getSourceAcc(), sender);
//        userMap.put(request.getTargetAcc(), receiver);


    }


    public boolean userExists(User user) {
        return userExists(user.getUserName());
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
