package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.model.MoneyTransferRequest;

public class MoneyTransferDataCollector implements DataCollector {

    private final InputReader scan;

    public MoneyTransferDataCollector(InputReader scan) {
        this.scan = scan;
    }

    @Override
    public MoneyTransferRequest collect() {
        System.out.println("Money transferring from one account to other!");
        System.out.println("Enter beneficiary username:");
        String receiverAccount = scan.readString();

        System.out.println("\nEnter Amount: ");
        int dAmount = scan.readInt();

        return new MoneyTransferRequest(receiverAccount, dAmount);
    }
}
