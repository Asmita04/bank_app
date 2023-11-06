package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.Mapper.UserMapper;
import com.bluesky.bankapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class  UserDao {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public UserDao(){}
    public UserDao(AccountDao accountDao, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.accountDao = accountDao;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insertUser(User user)  {

        String query = "INSERT INTO User (username,firstName , lastName,birthDate,mobileNo ) VALUES (:username, :firstName, :lastName, :birthDate, :mobileNo)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("username",user.getUserName())
                .addValue("firstName",user.getFirstName())
                .addValue("lastName",user.getLastName())
                .addValue("birthDate",user.getBirthDate())
                .addValue("mobileNo",user.getMobileNo());

        namedParameterJdbcTemplate.update(query,parameterSource);
        System.out.println(
                "Registered successfully!"
        );
    }

    public User getUserDetails(String username)  {
        String sql = "SELECT * FROM USER WHERE USERNAME = :username";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("username",username);

        RowMapper<User> rowMapper = new UserMapper();
        User user = this.namedParameterJdbcTemplate.queryForObject(sql,parameterSource,rowMapper);
        user.setAccounts(accountDao.getAccounts(username));

        return user;
    }



    public boolean userExists(User user){
        try {
            return userExists(user.getUserName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean userExists(String userName) {
        String sql = "SELECT COUNT(*) FROM User WHERE username = :username";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("username",userName);

        int count = namedParameterJdbcTemplate.queryForObject(sql,parameterSource,Integer.class);
        return count > 0;
    }



}
