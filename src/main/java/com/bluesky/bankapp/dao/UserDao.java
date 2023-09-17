package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private AccountDao accountDao = new AccountDao();
    public void insertUser(User user) throws Exception {

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt= con.prepareStatement("INSERT INTO User (username,firstName , lastName,birthDate,mobileNo ) VALUES (?,?,?,?,?)");
        // SOLID
        // S - single responsibility O-Open Closed L- Liskov Substitution I- Interface segregation D- Dependency Inversion

        pstmt.setString(2,user.getFirstName());

        pstmt.setString(3,user.getLastName());

        pstmt.setString(4,user.getBirthDate());


        pstmt.setString(5,user.getMobileNo());

        pstmt.setString(1,user.getUserName());

        pstmt.executeUpdate();
        System.out.println("User Registered successfully!");
    }

    public User getUserDetails(String username) throws Exception {

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt= con.prepareStatement("SELECT * FROM User WHERE username = ? ");

        pstmt.setString(1, username);

        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            List<Account> accounts = accountDao.getAccounts(username);
            User user =  new User(
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("birthDate"),
                    resultSet.getString("mobileNo"),
                    resultSet.getString("username")
            );
            user.setAccounts(accounts);
            return user;
        }
        return null;
    }


    public boolean userExists(User user)  throws Exception {
        return userExists(user.getUserName());
    }
    public boolean userExists(String userName) throws Exception {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM User WHERE username = ?");

        pstmt.setString(1, userName);
        ResultSet resultSet = pstmt.executeQuery();



        return resultSet.next();
       // return userExists(user.getUserName());
    }



}
