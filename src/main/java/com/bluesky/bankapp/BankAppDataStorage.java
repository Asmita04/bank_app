package com.bluesky.bankapp;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class BankAppDataStorage {
     public   Map<String, User> userMap;
     public HashMap<String, Integer> accountNumbers ;

    public BankAppDataStorage(){
        userMap=new HashMap<>();
        accountNumbers = new HashMap<>();
    }

    //Add user Account
    public   void addUserAccount( User user) {
        int sequenceNumber;
        String adhaarNo = user.getAdhaarNo();
        if (!accountNumbers.containsKey(adhaarNo)) {
            accountNumbers.put(adhaarNo, 1);
        } else {
            sequenceNumber = accountNumbers.get(adhaarNo) + 1;
            System.out.println("Sequence no."+sequenceNumber);
            accountNumbers.put(adhaarNo, sequenceNumber);
        }

        sequenceNumber = accountNumbers.get(adhaarNo);
        String accountNo = adhaarNo + "-" + sequenceNumber;
        user.setAccountNo(accountNo);

        userMap.put(adhaarNo, user);

    }

    //User Details
    public User getUserDetails(String adhaarNo) {
        return userMap.get(adhaarNo);
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

    public void transferMoney(String senderAccount,String receiverAccount, int dAmount){
        User sender =userMap.get(senderAccount);
        User receiver =userMap.get(receiverAccount);

        if (sender.getBalance() >= dAmount) {
            sender.setBalance(sender.getBalance() - dAmount);
            receiver.setBalance(receiver.getBalance() + dAmount);

        } else {
            System.out.println("Insufficient Balance!");
        }

        userMap.put(senderAccount, sender);
        userMap.put(receiverAccount, receiver);


    }



}
