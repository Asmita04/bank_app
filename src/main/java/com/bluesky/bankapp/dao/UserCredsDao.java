package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.model.LoginRequest;
import com.bluesky.bankapp.model.UserCreds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCredsDao {

    public void addUserCreds(UserCreds userCreds) throws  Exception {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt= con.prepareStatement("INSERT INTO LoginCredentials (username, pin ) VALUES (?,?)");


        pstmt.setString(1,userCreds.getUsername());
        pstmt.setInt(2,userCreds.getPin());
        pstmt.executeUpdate();
    }

    public UserCreds getUserCreds(LoginRequest userCreds) throws  Exception {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt= con.prepareStatement("SELECT * FROM LoginCredentials WHERE username = ? and pin = ?");


        pstmt.setString(1,userCreds.getAadhaar());
        pstmt.setInt(2,userCreds.getPin());
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            UserCreds creds = new UserCreds(
                    resultSet.getString(1),
                    resultSet.getInt(2)
            );
            return creds;
        }
        return null;
    }
}
