package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.collectors.LoginDataCollector;
import com.bluesky.bankapp.dao.AccountDao;
import com.bluesky.bankapp.dao.UserCredsDao;
import com.bluesky.bankapp.dao.UserDao;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.LoginRequest;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.model.UserCreds;
import com.bluesky.bankapp.security.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LoginActionExecutor implements ActionExecutor {
    @Autowired
    private SessionContext context;
    @Autowired
    private UserCredsDao userCredsDao ;
    @Autowired
    private UserDao userDao ;
    @Autowired
    private LoginDataCollector collector;
    @Autowired
    private AccountDao accountDao;


    public LoginActionExecutor(SessionContext context, UserCredsDao userCredsDao, UserDao userDao, LoginDataCollector collector, AccountDao accountDao) {
        this.context = context;
        this.userCredsDao = userCredsDao;
        this.userDao = userDao;
        this.collector = collector;
        this.accountDao = accountDao;
    }

    @Override
    public void execute() throws Exception {
        LoginRequest loginRequest = collector.collect();
        UserCreds userCreds = userCredsDao.getUserCreds(loginRequest);
        if (userCreds == null) {
            System.out.println("Invalid Aadhaar Number, Please enter correct Aadhaar number");
            return;
        }
        User user = userDao.getUserDetails(userCreds.getUsername());
        context.setCurr(user);

    }

    @Override
    public boolean validate() {
        return true;
    }
}
