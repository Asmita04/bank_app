package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.User;

import java.util.Scanner;

public class RegistrationDataCollector implements DataCollector {

    private Scanner scan;

    public RegistrationDataCollector(Scanner scan) {
        this.scan = scan;
    }

    public User collect() {

        System.out.println("Enter First Name:");
        scan.nextLine();
        String firstName = scan.nextLine();

        System.out.println("Enter Last Name:");
        scan.nextLine();
        String lastName = scan.nextLine();

        System.out.println("Enter Birth Date:");
        String birthDate = scan.nextLine();

        System.out.println("Enter Mobile:");
        long mobileNo = scan.nextLong();

        System.out.println("Enter Aadhaar No:");
        scan.nextLine();
        String aadhaarNo =scan.nextLine();


        User user = new User(firstName, lastName, birthDate, mobileNo, aadhaarNo);

        System.out.println("Let's create your first Account - ");
        System.out.println("Enter Opening Balance:");
        Long balance = scan.nextLong();
        scan.nextLine();

        System.out.println("Please Enter Security PIN: ");
        String pin = scan.nextLine();

        user.setPin(pin);
        Account account = new Account(user.getAadhaar() + "-1", user, balance);
        user.getAccounts().add(account);

        return user;
    }

}
