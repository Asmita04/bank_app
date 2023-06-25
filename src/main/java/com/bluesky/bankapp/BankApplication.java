package com.bluesky.bankapp;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Simple Bank Application
 *
 **/

public class BankApplication {
    public HashMap<String, Integer> accountNumbers ;

    public BankApplication() {
        accountNumbers = new HashMap<>();
    }
    public void addUserAccount(@NotNull User user) {
        int sequenceNumber;
        String adhaarNo = user.getAdhaarNo();
        if (!accountNumbers.containsKey(adhaarNo)) {
            accountNumbers.put(adhaarNo, 1);
        } else {
            sequenceNumber = accountNumbers.get(adhaarNo) + 1;
            System.out.println("Sequence no."+sequenceNumber);
            accountNumbers.put(adhaarNo, sequenceNumber);
        }

        sequenceNumber = accountNumbers.get(adhaarNo);
        String accountNo = adhaarNo + "-" + sequenceNumber;
        user.setAccountNo(accountNo);

        BankAppDataStorage.userMap.put(adhaarNo, user);

    }
    public User getUserDetails(String adhaarNo) {
        return BankAppDataStorage.userMap.get(adhaarNo);
    }

    public static void main(String[] args) {

        int choice;
        String userName;
        String birthDate;
        long mobileNo ;
        String adhaarNo;
        String accountNo;
        int balance;

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to MHETRE's Bank Pvt Ltd!!");
        BankApplication account = new BankApplication();

        BankAppDataStorage userData = new BankAppDataStorage();

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
                    userName = scan.nextLine();

                    System.out.println("Enter Birth Date:");
                    birthDate = scan.nextLine();

                    System.out.println("Enter Mobile:");
                    mobileNo = scan.nextLong();

                    System.out.println("Enter Adhaar No:");
                    scan.nextLine();
                    adhaarNo = new String(scan.nextLine());

                    System.out.println("Enter Balance:");
                    balance = scan.nextInt();

                    User user = new User(userName, birthDate, mobileNo, adhaarNo, balance);
                    account.addUserAccount(user);

                    break;
                }

                case 2: {

                    System.out.println("Enter Account number to remove from list");
                    scan.nextLine();
                    accountNo = new String(scan.nextLine());

                    if (BankAppDataStorage.userMap.containsKey(accountNo)) {
                        BankAppDataStorage.userMap.remove(accountNo);
                        System.out.println("1 Account Deleted!");
                    }
                    else {
                        System.out.println("Account is not present!");
                    }
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

                    User sender =BankAppDataStorage. userMap.get(senderAccount);
                    User receiver = BankAppDataStorage.userMap.get(receiverAccount);

                    if (sender.getBalance() >= dAmount) {
                        sender.setBalance(sender.getBalance() - dAmount);
                        receiver.setBalance(receiver.getBalance() + dAmount);

                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    BankAppDataStorage.userMap.put(senderAccount, sender);
                    BankAppDataStorage.userMap.put(receiverAccount, receiver);
                    break;
                }
                case 4: {
                    System.out.println("Display record");
                    System.out.println("Enter Adhaar number:");
                    scan.nextLine();
                    adhaarNo = scan.nextLine();
                    User userdetails= account.getUserDetails(adhaarNo);

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