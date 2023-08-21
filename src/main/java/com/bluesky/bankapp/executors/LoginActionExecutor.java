package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.collectors.LoginDataCollector;
import com.bluesky.bankapp.model.LoginRequest;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;

public class LoginActionExecutor implements ActionExecutor {
    private SessionContext context;
    private BankAppDataStorage storage;
    private LoginDataCollector collector;


    public LoginActionExecutor(SessionContext context, BankAppDataStorage storage, LoginDataCollector collector) {
        this.context = context;
        this.storage = storage;
        this.collector = collector;
    }

    @Override
    public void execute() {
        LoginRequest loginRequest = collector.collect();
        User user = storage.getUserDetails(loginRequest.getAadhaar());

        if (user == null) {
            System.out.println("Invalid Aadhaar Number, Please enter correct Aadhaar number");
            return;
        }

        if (user.getPin().equals(loginRequest.getPin())) {
            context.setCurr(user);
        } else {
            System.out.println("Invalid Aadhar and PIN combo.");
        }

    }

    @Override
    public boolean validate() {
        return true;
    }
}
