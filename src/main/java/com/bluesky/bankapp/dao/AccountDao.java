package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.bluesky.bankapp.Mapper.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AccountDao( NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void addAccount(Account account)  {

        String sql = "INSERT INTO Accounts (AccNo, balance, username, is_primary) VALUES (:AccNo, :balance, :username, :is_primary)";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("AccNo",account.getAccNum())
                .addValue("balance",account.getBalance())
                .addValue("username",account.getUsername())
                .addValue("is_primary",account.getPrimary());

        namedParameterJdbcTemplate.update(sql,parameterSource);
    }

    public List<Account> getAccounts(String username)  {

        String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME = :username";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                                        .addValue("username", username);
        List<Account> accountList = namedParameterJdbcTemplate.query(sql, parameterSource ,new AccountRowMapper());
        accountList.forEach(System.out::println);
        return accountList;

    }

    public void updateAccount(Account account) {
        String sql = "UPDATE ACCOUNTS SET BALANCE = :balance WHERE ACCNO = :accNo";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("balance", account.getBalance())
                .addValue("accNo", account.getAccNum());

        namedParameterJdbcTemplate.update(sql, parameterSource);
    }
}
