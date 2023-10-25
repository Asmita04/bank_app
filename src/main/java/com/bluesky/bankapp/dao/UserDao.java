package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.AppConfig;
import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class  UserDao {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public UserDao(){}

    public UserDao( JdbcTemplate jdbcTemplate , AccountDao accountDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.accountDao =accountDao;
    }

    public void insertUser(User user)  {

        String query = "INSERT INTO User (username,firstName , lastName,birthDate,mobileNo ) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(query, user.getUserName(),user.getFirstName(),user.getLastName(),user.getBirthDate(),user.getMobileNo());
        System.out.println(
                "Registered successfully!"
        );


    }

    public User getUserDetails(String username)  {
//        try( Connection con = DatabaseConnection.getConnection()) {
//            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM User WHERE username = ? ");
//
//            pstmt.setString(1, username);
//
//            ResultSet resultSet = pstmt.executeQuery();
//
//            while (resultSet.next()) {
//                List<Account> accounts = accountDao.getAccounts(username);
//                User user = new User(
//                        resultSet.getString("firstName"),
//                        resultSet.getString("lastName"),
//                        resultSet.getString("birthDate"),
//                        resultSet.getString("mobileNo"),
//                        resultSet.getString("username")
//                );
//                user.setAccounts(accounts);
//                return user;
//            }
//        }catch (Exception e){throw new RuntimeException(e);}
//        return null;



        String sql = "SELECT * FROM User WHERE username = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{username}, (resultSet, rowNum) -> {
            User user = new User(
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("birthDate"),
                    resultSet.getString("mobileNo"),
                    resultSet.getString("username")
            );
            user.setAccounts(accountDao.getAccounts(username));
            return user;
        });

        return users.isEmpty() ? null : users.get(0);
    }


    public boolean userExists(User user){
        try {
            return userExists(user.getUserName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean userExists(String userName) {
        String sql = "SELECT COUNT(*) FROM User WHERE username = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{userName}, Integer.class);
        return count > 0;
    }



}
