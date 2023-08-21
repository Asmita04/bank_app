package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.collectors.MoneyTransferDataCollector;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.MoneyTransferRequest;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;
import com.bluesky.bankapp.util.UserUtils;

public class MoneyTransferActionExecutor implements ActionExecutor {

    private final BankAppDataStorage dataStorage;
    private final MoneyTransferDataCollector collector;
    private final SessionContext context;


    public MoneyTransferActionExecutor(BankAppDataStorage dataStorage
            , MoneyTransferDataCollector collector
    , SessionContext context) {
        this.dataStorage = dataStorage;
        this.collector = collector;
        this.context = context;
    }

    @Override
    public void execute() {
        MoneyTransferRequest request = collector.collect();
        if (dataStorage.userExists(request.getTargetAcc())) {
            User sourceUser = context.getCurr();
            User targetUSer = dataStorage.getUserDetails(request.getTargetAcc());

            Account sourceAccount = UserUtils.getPrimaryAccount(sourceUser);
            Account targetAccount = UserUtils.getPrimaryAccount(targetUSer);

            // check if source account has enough balance

            if (sourceAccount.getBalance() >= request.getAmount()) {
                sourceAccount.setBalance(sourceAccount.getBalance() - request.getAmount());
                targetAccount.setBalance(targetAccount.getBalance() + request.getAmount());
            } else {
                System.out.println("Source account does not have enough balance.");
            }

        } else {
            System.out.printf("User with username %s does not exists.\n", request.getTargetAcc());
        }
    }

    @Override
    public boolean validate() {
        return false;
    }
}
