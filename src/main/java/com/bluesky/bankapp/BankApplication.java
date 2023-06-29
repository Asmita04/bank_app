package com.bluesky.bankapp;


import com.bluesky.bankapp.collectors.MoneyTransferDataCollector;
import com.bluesky.bankapp.collectors.RegistrationDataCollector;
import com.bluesky.bankapp.model.MoneyTransferRequest;

import java.util.Scanner;

/**
 * Simple Bank Application
 *
 **/

public class BankApplication {
     public static void main(String[] args) {

        int choice;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to MHETRE's Bank Pvt Ltd!!");

        BankAppDataStorage dataStorage = new BankAppDataStorage();

        do {
            System.out.println("1.Register User");
            System.out.println("2.Remove Account");
            System.out.println("3.Transfer Money");
            System.out.println("4.Display Record");
            System.out.println("5.Exit");
            System.out.println("Enter Your Choice:");
            choice = scan.nextInt();

            switch (choice) {
                case 1: {

                    RegistrationDataCollector collector = new RegistrationDataCollector(scan);
                    User user = collector.collect();
                    dataStorage.addUserAccount(user);

                    break;
                }

                case 2: {

                    System.out.println("Enter Account number to remove from list");
                    scan.nextLine();
                    String accountNo = scan.nextLine();
                    dataStorage.removeAccount(accountNo);
                    break;

                }
                case 3: {
                    MoneyTransferDataCollector collector = new MoneyTransferDataCollector(scan);
                    MoneyTransferRequest transferRequest = collector.collect();
                    dataStorage.transferMoney(transferRequest);
                    break;
                }
                case 4: {
                    System.out.println("Display record");
                    System.out.println("Enter Adhaar number:");
                    scan.nextLine();
                    String adhaarNo = scan.nextLine();
                    User userdetails= dataStorage.getUserDetails(adhaarNo);

                    if(userdetails!=null){
                        System.out.println("Account No: \t\t" + "User Name: \t\t" + "Birth Date\t\t" + "Mobile No:\t\t" + "Adhaar No\t\t" + "Balance\t\n");
                        System.out.println(userdetails.accountNo + " \t\t\t \t" + userdetails.userName + "  \t  " + userdetails.birthDate + "  \t " + userdetails.mobileNo + "  \t" + userdetails.adhaarNo + "  \t" + userdetails.balance + "  \t\n");
                    }
                    else {
                        System.out.println("User not found!");
                        break;
                    }
                }

                case 5: {
                    System.out.println("Exit!");
                    break;
                }
                default:
                    throw new IllegalStateException(" Thank You , Have a Nice Day!" );
            }


        } while (choice != 5);
    }


}