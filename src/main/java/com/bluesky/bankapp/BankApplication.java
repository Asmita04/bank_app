package com.bluesky.bankapp;


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

                    System.out.println("Enter name:");
                    scan.nextLine();
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
                    System.out.println("Money transferring from one account to other!");
                    System.out.println("Enter account to which you wanted to send money:");
                    String receiverAccount = scan.nextLine();

                    System.out.println("Enter payee account number:");
                    String senderAccount = scan.nextLine();

                    System.out.println("\nEnter Amount: ");
                    int dAmount = scan.nextInt();
                    dataStorage.transferMoney(senderAccount,receiverAccount,dAmount);
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