package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addAccount(Account account)  {


        String sql = "INSERT INTO Accounts (AccNo, balance, username, is_primary) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, account.getAccNum(), account.getBalance(), account.getUsername(), account.getPrimary());

    }

    public List<Account> getAccounts(String userName)  {


        String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME = ?";
        return jdbcTemplate.query(sql, new Object[]{userName}, (resultSet, rowNum) -> new Account(
                resultSet.getString("AccNo"),
                resultSet.getString("username"),
                resultSet.getDouble("balance"),
                resultSet.getBoolean("is_primary")
        ));
    }

    public void updateAccount(Account account)  {

        String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCNO = ?";
        jdbcTemplate.update(sql, account.getBalance(), account.getAccNum());
        }

}
