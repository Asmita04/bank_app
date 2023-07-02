package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.model.LoginRequest;

import java.util.Scanner;

public class LoginDataCollector implements DataCollector {

    private Scanner scan;

    public LoginDataCollector(Scanner scan) {
        this.scan = scan;
    }

    public LoginRequest collect() {
        System.out.println("Aadhaar Number: ");
        scan.nextLine();
        String aadhaar = scan.nextLine();
        System.out.println("Enter Security PIN: ");
        String pin = scan.nextLine();

        return new LoginRequest(aadhaar, pin);
    }
}
