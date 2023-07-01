package com.bluesky.bankapp;

import com.bluesky.bankapp.model.MoneyTransferRequest;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

 class BankAppDataStorage {
     public Map<String, User> userMap;
     public HashMap<String, Integer> accountNumbers ;

    public BankAppDataStorage(){
        userMap=new HashMap<>();
        accountNumbers = new HashMap<>();
    }

    //Add user Account
    public  void addUserAccount(User user) {
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
    public void transferMoney(MoneyTransferRequest request){
        User sender =userMap.get(request.getSourceAcc());
        User receiver =userMap.get(request.getTargetAcc());

        if (sender.getBalance() >= request.getAmount()) {
            sender.setBalance(sender.getBalance() - request.getAmount());
            receiver.setBalance(receiver.getBalance() + request.getAmount());

        } else {
            System.out.println("Insufficient Balance!");
        }

        userMap.put(request.getSourceAcc(), sender);
        userMap.put(request.getTargetAcc(), receiver);


    }



}
