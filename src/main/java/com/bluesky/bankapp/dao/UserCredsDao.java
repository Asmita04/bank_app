package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.model.LoginRequest;
import com.bluesky.bankapp.model.UserCreds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserCredsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUserCreds(UserCreds userCreds){

        String sql = "INSERT INTO LoginCredentials (username, pin) VALUES (?, ?)";
        jdbcTemplate.update(sql, userCreds.getUsername(), userCreds.getPin());
    }

    public UserCreds getUserCreds(LoginRequest userCreds)  {

        String sql = "SELECT * FROM LoginCredentials WHERE username = ? and pin = ?";
        List<UserCreds> credsList = jdbcTemplate.query(sql, new Object[]{userCreds.getAadhaar(), userCreds.getPin()},
                (resultSet, rowNum) -> new UserCreds(
                        resultSet.getString("username"),
                        resultSet.getInt("pin")
                ));
        return credsList.isEmpty() ? null : credsList.get(0);


  }
}
