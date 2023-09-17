package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.model.LoginRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LoginDataCollector implements DataCollector {

    private final InputReader scan;

    public LoginDataCollector(InputReader scan) {
        this.scan = scan;
    }

    @Override
    public LoginRequest collect() throws SQLException {

        System.out.println("Username: ");
        String aadhaar = scan.readString();

        System.out.println("Enter Security PIN: ");
        Integer pin = scan.readInt();

        return new LoginRequest(aadhaar, pin);
    }
}