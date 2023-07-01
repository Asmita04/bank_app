package com.bluesky.bankapp.collectors;


import com.bluesky.bankapp.model.MoneyTransferRequest;

import java.util.Scanner;



public class MoneyTransferDataCollector {

    private Scanner scan;

    public MoneyTransferDataCollector(Scanner scan){
        this.scan=scan;
    }

    public  MoneyTransferRequest collect() {

        System.out.println("Money transferring from one account to other!");
    
        System.out.println("Enter account to which you wanted to send money:");
        scan.nextLine();
        String receiverAccount = scan.nextLine();


        System.out.println("Enter payee account number:");
        String senderAccount = scan.nextLine();

        System.out.println("\nEnter Amount: ");
        int dAmount = scan.nextInt();

        return new MoneyTransferRequest(senderAccount,receiverAccount,dAmount);
    }
}
