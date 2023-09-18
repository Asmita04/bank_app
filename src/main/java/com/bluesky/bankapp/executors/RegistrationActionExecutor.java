package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.collectors.DatabaseConnection;
import com.bluesky.bankapp.collectors.RegistrationDataCollector;
import com.bluesky.bankapp.dao.AccountDao;
import com.bluesky.bankapp.dao.UserCredsDao;
import com.bluesky.bankapp.dao.UserDao;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.RegistrationRequest;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.model.UserCreds;
import com.bluesky.bankapp.security.SessionContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationActionExecutor implements ActionExecutor {
    private SessionContext context;
    private UserDao userDao = new UserDao();
    private AccountDao accountDao = new AccountDao();
    private UserCredsDao userCredsDao = new UserCredsDao();
    private RegistrationDataCollector collector;
    private BankAppDataStorage dataStorage;

    public RegistrationActionExecutor(SessionContext context, RegistrationDataCollector collector, BankAppDataStorage dataStorage) {
        this.context = context;
        this.collector = collector;
        this.dataStorage = dataStorage;
    }

    public void execute(){

        RegistrationRequest request = collector.collect();

        // add user
        // add account
        // add user creds

        User user = new User(request.getFirstName(),
                request.getLastName(),
                request.getBirthDate(),
                request.getMobile(),
                request.getUsername());

        if (userDao.userExists(user)) {
            System.out.println("User already exists");
            return;

        }

        userDao.insertUser(user);

        UserCreds creds = new UserCreds(
                request.getUsername(),
                request.getPin()
        );
        userCredsDao.addUserCreds(creds);

        Account account = new Account(user.getUserName() + "-1",
                user.getUserName(),
                request.getBalance(), true); // first account is primary
        accountDao.addAccount(account);


        // At the time of registration, first account is always
        // primary account
        account.setPrimary(true);

        user.getAccounts().add(account);


//    -------------------------------------------------------------------
        boolean exists = true; //dataStorage.userExists(user);
        if (exists) {
            System.out.println("User already exists, please login!");
        } else {
            // add user to db
            dataStorage.addUser(user);
            // Login user
            context.setCurr(user);
        }
    }


    @Override
    public boolean validate() {
        return true;
    }
}
