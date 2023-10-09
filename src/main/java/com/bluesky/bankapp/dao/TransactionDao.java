package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.model.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionDao {



    public List<Transaction> getTransactions(String userName) {
        String sql = "SELECT * FROM TRANSACTIONS WHERE SOURCE_USERNAME = ? || TARGET_USERNAME = ?";
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, userName);

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getString("source_username"),
                        rs.getString("source_acc_num"),
                        rs.getString("target_username"),
                        rs.getString("target_acc_num"),
                        rs.getInt("amount")

                ));
            }

        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return transactions;
    }

    public void insertTransaction(Transaction transaction) {

        String sql = "INSERT INTO TRANSACTIONS (source_username, source_acc_num, target_username, " +
                "target_acc_num, amount) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, transaction.getSourceUsername());
            ps.setString(2, transaction.getSourceAccountNum());
            ps.setString(3, transaction.getTargetUsername());
            ps.setString(4, transaction.getTargetAccountNum());
            ps.setInt(5, transaction.getAmount());

            ps.executeUpdate();

        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
