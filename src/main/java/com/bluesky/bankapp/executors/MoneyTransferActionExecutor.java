package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.collectors.MoneyTransferDataCollector;
import com.bluesky.bankapp.dao.AccountDao;
import com.bluesky.bankapp.dao.TransactionDao;
import com.bluesky.bankapp.dao.UserDao;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.MoneyTransferRequest;
import com.bluesky.bankapp.model.Transaction;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;
import com.bluesky.bankapp.util.UserUtils;

import javax.security.auth.login.AccountException;
import java.sql.SQLException;

public class MoneyTransferActionExecutor implements ActionExecutor {

    private final BankAppDataStorage dataStorage;
    private final MoneyTransferDataCollector collector;
    private final UserDao userDao = new UserDao();
    private final AccountDao accountDao = new AccountDao();
    private final TransactionDao transactionDao = new TransactionDao();

    private final SessionContext context;


    public MoneyTransferActionExecutor(BankAppDataStorage dataStorage
            , MoneyTransferDataCollector collector
    , SessionContext context) {
        this.dataStorage = dataStorage;
        this.collector = collector;
        this.context = context;
    }

    @Override
    public void execute() throws Exception {



        // get receivers primary account
        // debit from sender primary and credit to receivers primary account
        // save into DB
        MoneyTransferRequest request = collector.collect();
        String targetUserName = request.getTargetUsername();
        int amount = request.getAmount();

        // get senders primary account
        User sourceUser = context.getCurr();
        User targetUser = userDao.getUserDetails(targetUserName);

        Account sourcePrimaryAccount = UserUtils.getPrimaryAccount(sourceUser);
        Account targetPrimaryAccount = UserUtils.getPrimaryAccount(targetUser);

        // validate if the source acc has sufficient balance
        if (sourcePrimaryAccount.getBalance() <= amount) {
            System.out.println("Insufficient amount!!!");
            return;
        }

        // Execute transaction
        sourcePrimaryAccount.setBalance(sourcePrimaryAccount.getBalance() - amount);
        targetPrimaryAccount.setBalance(targetPrimaryAccount.getBalance() + amount);

        // save/persist in DB

        accountDao.updateAccount(sourcePrimaryAccount);
        accountDao.updateAccount(targetPrimaryAccount);

        // save transaction

        Transaction transaction = new Transaction(
                sourceUser.getUserName(),
                sourcePrimaryAccount.getAccNum(),
                targetUserName,
                targetPrimaryAccount.getAccNum(),
                amount
        );
        transactionDao.insertTransaction(transaction);



    }

    @Override
    public boolean validate() {
        return false;
    }
}
