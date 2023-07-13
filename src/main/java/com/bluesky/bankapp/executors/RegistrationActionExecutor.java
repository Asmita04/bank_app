package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.collectors.RegistrationDataCollector;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.RegistrationRequest;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;

public class RegistrationActionExecutor implements ActionExecutor {

    private SessionContext context;
    private RegistrationDataCollector collector;
    private BankAppDataStorage dataStorage;

    public RegistrationActionExecutor(SessionContext context, RegistrationDataCollector collector, BankAppDataStorage dataStorage) {
        this.context = context;
        this.collector = collector;
        this.dataStorage = dataStorage;
    }

    public void execute() {
        RegistrationRequest request = collector.collect();

        User user = new User(request.getFirstName(),
                request.getLastName(),
                request.getBirthDate(),
                request.getMobile(),
                request.getUsername());
        user.setPin(request.getPin());

        Account account = new Account(user.getUserName() + "-1", user, request.getBalance());

        // At the time of registration, first account is always
        // primary account
        account.setPrimary(true);

        user.getAccounts().add(account);
        boolean exists = dataStorage.userExists(user);
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
