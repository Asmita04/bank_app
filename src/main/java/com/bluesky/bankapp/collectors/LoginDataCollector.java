package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.model.LoginRequest;


public class LoginDataCollector implements DataCollector {

    private final InputReader scan;

    public LoginDataCollector(InputReader scan) {
        this.scan = scan;
    }

    @Override
    public LoginRequest collect() {
        System.out.println("Username: ");
        String aadhaar = scan.readString();
        System.out.println("Enter Security PIN: ");
        Integer pin = scan.readInt();
        return new LoginRequest(aadhaar, pin);
    }
}
