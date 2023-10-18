package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TransactionDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public  TransactionDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    public List<Transaction> getTransactions(String userName) {
        String sql = "SELECT * FROM TRANSACTIONS WHERE SOURCE_USERNAME = ? OR TARGET_USERNAME = ?";
        return jdbcTemplate.query(sql, new Object[]{userName, userName},
                (resultSet, rowNum) -> new Transaction(
                        resultSet.getString("source_username"),
                        resultSet.getString("source_acc_num"),
                        resultSet.getString("target_username"),
                        resultSet.getString("target_acc_num"),
                        resultSet.getInt("amount")
                ));
    }

    public void insertTransaction(Transaction transaction) {

        String sql = "INSERT INTO TRANSACTIONS (source_username, source_acc_num, target_username, " +
                "target_acc_num, amount) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, transaction.getSourceUsername(), transaction.getSourceAccountNum(),
                transaction.getTargetUsername(), transaction.getTargetAccountNum(), transaction.getAmount());
    }
}
