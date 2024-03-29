package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.collectors.RegistrationDataCollector;
import com.bluesky.bankapp.dao.AccountDao;
import com.bluesky.bankapp.dao.UserCredsDao;
import com.bluesky.bankapp.dao.UserDao;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.RegistrationRequest;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.model.UserCreds;
import com.bluesky.bankapp.security.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RegistrationActionExecutor implements ActionExecutor {

    @Autowired
    private SessionContext context;

    @Autowired
    private  UserDao userDao;
    @Autowired
    private  AccountDao accountDao;
    @Autowired
    private UserCredsDao userCredsDao;
    @Autowired
    private RegistrationDataCollector collector;


    public RegistrationActionExecutor(SessionContext context, UserDao userDao, AccountDao accountDao, UserCredsDao userCredsDao, RegistrationDataCollector collector) {
        this.context = context;
        this.userDao = userDao;
        this.accountDao = accountDao;
        this.userCredsDao = userCredsDao;
        this.collector = collector;
    }

    public void execute(){

        RegistrationRequest request = collector.collect();

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

        user.getAccounts().add(account);
        context.setCurr(user);
    }


    @Override
    public boolean validate() {
        return true;
    }
}
