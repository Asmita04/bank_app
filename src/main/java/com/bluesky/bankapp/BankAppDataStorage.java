package com.bluesky.bankapp;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class BankAppDataStorage {
    static public Map<String, User> userMap;
    public BankAppDataStorage(){
        userMap=new HashMap<>();
    }



}
