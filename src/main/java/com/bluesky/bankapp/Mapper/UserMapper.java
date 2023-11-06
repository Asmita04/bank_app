package com.bluesky.bankapp.Mapper;

import com.bluesky.bankapp.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    private User user;

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new User(
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("birthDate"),
                rs.getString("mobileNo"),
                rs.getString("username")
        );
    }
}
