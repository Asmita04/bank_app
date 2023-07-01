package com.bluesky.bankapp.collectors;


import com.bluesky.bankapp.User;

import java.util.Scanner;

public class RegistrationDataCollector {
    private Scanner scan;
    public RegistrationDataCollector(Scanner scan){
        this.scan=scan;
    }


    public User getUserData() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter name:");

        String userName = scan.nextLine();

        System.out.println("Enter Birth Date:");
        String birthDate = scan.nextLine();

        System.out.println("Enter Mobile:");
        long mobileNo = scan.nextLong();

        System.out.println("Enter Adhaar No:");
        scan.nextLine();
        String adhaarNo =scan.nextLine();

        System.out.println("Enter Balance:");
        int balance = scan.nextInt();

        User user = new User(userName, birthDate, mobileNo, adhaarNo, balance);

        return user;



    }
}
