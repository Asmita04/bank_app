package com.bluesky.bankapp;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class BankAppDataStorage {
    int sequenceNumber;

    public Map<String, User> userMap;
    public HashMap<String, Integer> accountNumbers ;

    public StoreData() {
        userMap=new HashMap<>();
        accountNumbers = new HashMap<>();
    }
    public void addUserAccount(@NotNull User user) {
        String adhaarNo = user.getAdhaarNo();
        if (!accountNumbers.containsKey(adhaarNo)) {
            accountNumbers.put(adhaarNo, 1);
        } else {
            sequenceNumber = accountNumbers.get(adhaarNo) + 1;
            accountNumbers.put(adhaarNo, sequenceNumber);
        }

        sequenceNumber = accountNumbers.get(adhaarNo);
        String accountNo = adhaarNo + "-" + sequenceNumber;
        user.setAccountNo(accountNo);
        userMap.put(accountNo, user);
    }
    public User getUserDetails(String accountNo) {
        return userMap.get(accountNo);
    }

}
