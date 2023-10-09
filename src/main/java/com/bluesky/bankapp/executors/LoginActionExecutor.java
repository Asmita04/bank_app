package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.AppConfig;
import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.collectors.LoginDataCollector;
import com.bluesky.bankapp.dao.AccountDao;
import com.bluesky.bankapp.dao.TransactionDao;
import com.bluesky.bankapp.dao.UserCredsDao;
import com.bluesky.bankapp.dao.UserDao;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.LoginRequest;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.model.UserCreds;
import com.bluesky.bankapp.security.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@Component
public class LoginActionExecutor implements ActionExecutor {
    @Autowired
    private SessionContext context;
    @Autowired
    private BankAppDataStorage storage;
    @Autowired
    private UserCredsDao userCredsDao ;
    @Autowired
    private UserDao userDao ;
    @Autowired
    private LoginDataCollector collector;


    public LoginActionExecutor(SessionContext context, BankAppDataStorage storage, UserCredsDao userCredsDao, UserDao userDao, LoginDataCollector collector) {
        this.context = context;
        this.storage = storage;
        this.userCredsDao = userCredsDao;
        this.userDao = userDao;
        this.collector = collector;
    }

    @Override
    public void execute() throws Exception {
        LoginRequest loginRequest = collector.collect();
        UserCreds userCreds = userCredsDao.getUserCreds(loginRequest);
        User user = userDao.getUserDetails(loginRequest.getAadhaar());
        List<Account> accounts = new AccountDao().getAccounts(user.getUserName());
        user.setAccounts(accounts);
        //Connection con = DatabaseConnection.getConnection();
//        PreparedStatement stm= con.prepareStatement("select * from ");


        if (userCreds == null) {
            System.out.println("Invalid Aadhaar Number, Please enter correct Aadhaar number");

        } else {
            context.setCurr(user);
        }

    }

    @Override
    public boolean validate() {
        return true;
    }
}
