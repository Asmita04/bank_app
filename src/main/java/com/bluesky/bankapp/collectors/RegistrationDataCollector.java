package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.model.RegistrationRequest;

public class RegistrationDataCollector implements DataCollector {

    private final InputReader scan;

    public RegistrationDataCollector(InputReader scan) {
        this.scan = scan;
    }

    @Override
    public RegistrationRequest collect() {

        System.out.println("Enter First Name:");
        String firstName = scan.readString();

        System.out.println("Enter Last Name:");
        String lastName = scan.readString();

        System.out.println("Enter Birth Date:");
        String birthDate = scan.readString();

        System.out.println("Enter Mobile:");
        String mobileNo = scan.readString();

        System.out.println("Enter Username:");
        String aadhaarNo =scan.readString();


        System.out.println("Let's create your first Account - ");
        System.out.println("Enter Opening Balance:");
        Double balance = scan.readDouble();

        System.out.println("Please Enter Security PIN: ");
        Integer pin = scan.readInt();

        return new RegistrationRequest(aadhaarNo, firstName, lastName, mobileNo, birthDate, balance, pin);

//
//        user.getAccounts().add(account);
//
//        return user;
    }

}
