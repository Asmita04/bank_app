package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.model.MoneyTransferRequest;

import java.util.Scanner;

public class MoneyTransferDataCollector implements DataCollector {

    private Scanner scan;

    public MoneyTransferDataCollector(Scanner scan) {
        this.scan = scan;
    }

    public MoneyTransferRequest collect() {
        System.out.println("Money transferring from one account to other!");
        System.out.println("Enter account to which you wanted to send money:");
        String receiverAccount = scan.nextLine();

        System.out.println("Enter payee account number:");
        String senderAccount = scan.nextLine();

        System.out.println("\nEnter Amount: ");
        int dAmount = scan.nextInt();

        return new MoneyTransferRequest(senderAccount, receiverAccount, dAmount);
    }
}
