package com.bluesky.bankapp.Mapper;

import com.bluesky.bankapp.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(
                rs.getString("AccNo"),
                rs.getString("username"),
                rs.getDouble("balance"),
                rs.getBoolean("is_primary")
        );
    }
}
