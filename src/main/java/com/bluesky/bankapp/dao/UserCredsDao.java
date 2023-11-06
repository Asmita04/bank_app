package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.model.LoginRequest;
import com.bluesky.bankapp.model.UserCreds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserCredsDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void addUserCreds(UserCreds userCreds){

        String sql = "INSERT INTO LoginCredentials (username, pin) VALUES (:username, :pin)";
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("username",userCreds.getUsername())
                .addValue("pin",userCreds.getPin());
        namedParameterJdbcTemplate.update(sql,paramSource);
    }


    public UserCreds getUserCreds(LoginRequest userCreds)  {

        String sql = "SELECT * FROM LoginCredentials WHERE username = :username and pin = :pin ";
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("username",userCreds.getAadhaar())
                .addValue("pin",userCreds.getPin());
        List<UserCreds> credsList = namedParameterJdbcTemplate.query(sql, paramSource,  (resultSet, rowNum) -> new UserCreds(
                        resultSet.getString("username"),
                        resultSet.getInt("pin")
                ));
        return credsList.isEmpty() ? null : credsList.get(0);


  }
}
