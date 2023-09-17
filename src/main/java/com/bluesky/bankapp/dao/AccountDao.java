package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    public void addAccount(Account account) throws Exception {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt= con.prepareStatement("INSERT INTO Accounts VALUES (?, ?, ?, ?)");


        pstmt.setString(1, account.getAccNum());
        pstmt.setInt(2, account.getBalance().intValue());
        pstmt.setString(3, account.getUsername());
        pstmt.setBoolean(4, account.getPrimary());
        pstmt.executeUpdate();
    }

    public List<Account> getAccounts(String userName) throws Exception {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt= con.prepareStatement("SELECT * FROM ACCOUNTS WHERE USERNAME = ? ");



        pstmt.setString(1, userName);
        ResultSet rs = pstmt.executeQuery();
        List<Account> accounts = new ArrayList<>();
        while(rs.next()) {
            accounts.add(new Account(
                    rs.getString("AccNo"),
                    rs.getString("username"),
                    rs.getDouble("balance"),
                    rs.getBoolean("is_primary")
            ));

        }
        return accounts;
    }

    public void updateAccount(Account account) throws Exception {
        String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCNO = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, account.getBalance().intValue());
        ps.setString(2, account.getAccNum());
        ps.executeUpdate();
    }
}
