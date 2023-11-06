package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TransactionDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TransactionDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public List<Transaction> getTransactions(String userName) {
        String sql = "SELECT * FROM TRANSACTIONS WHERE SOURCE_USERNAME = :sourceUsername OR TARGET_USERNAME = :targetUsername";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("sourceUsername", userName)
                .addValue("targetUsername", userName);

        List<Transaction> transactions = namedParameterJdbcTemplate.query(sql, parameterSource,
                (resultSet, rowNum) -> new Transaction(
                        resultSet.getString("source_username"),
                        resultSet.getString("source_acc_num"),
                        resultSet.getString("target_username"),
                        resultSet.getString("target_acc_num"),
                        resultSet.getInt("amount")
                ));

        return transactions;
    }


    public void insertTransaction(Transaction transaction) {

        String sql = "INSERT INTO TRANSACTIONS (source_username, source_acc_num, target_username, " +
                "target_acc_num, amount) VALUES (:source_username, :source_acc_num, :target_username, :target_acc_num, :amount)";
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("source_username",transaction.getSourceUsername())
                .addValue("source_acc_num",transaction.getSourceAccountNum())
                .addValue("target_username",transaction.getTargetUsername())
                .addValue("target_acc_num",transaction.getTargetAccountNum())
                .addValue("amount",transaction.getAmount());

        namedParameterJdbcTemplate.update(sql,paramSource);
    }
}
