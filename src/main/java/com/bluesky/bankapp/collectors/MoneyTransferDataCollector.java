package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.model.MoneyTransferRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoneyTransferDataCollector implements DataCollector {

    private final InputReader scan;

    public MoneyTransferDataCollector(InputReader scan) {
        this.scan = scan;
    }

    @Override
    public MoneyTransferRequest collect() throws SQLException {

//        Connection con = DatabaseConnection.getConnection();
//        PreparedStatement pstmt= con.prepareStatement("INSERT INTO User (username,firstName , lastName,birthDate,mobileNo,pin,balance ) VALUES (?,?,?,?,?,?,?)");

        System.out.println("Money transferring from one account to other!");
        System.out.println("Enter beneficiary username:");
        String receiverUsername = scan.readString();

        System.out.println("\nEnter Amount: ");
        int dAmount = scan.readInt();

        return new MoneyTransferRequest(receiverUsername, dAmount);
    }
}
