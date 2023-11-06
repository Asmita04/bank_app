package com.bluesky.bankapp.executors;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoneyTransferActionExecutor implements ActionExecutor {
    @Autowired
    private  MoneyTransferDataCollector collector;
    @Autowired
    private  UserDao userDao;
    @Autowired
    private  AccountDao accountDao;
    @Autowired
    private TransactionDao transactionDao ;
    @Autowired
    private  SessionContext context;

    public MoneyTransferActionExecutor(MoneyTransferDataCollector collector, UserDao userDao, AccountDao accountDao, TransactionDao transactionDao, SessionContext context) {
        this.collector = collector;
        this.userDao = userDao;
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
        this.context = context;
    }

    @Override
    public void execute(){

        MoneyTransferRequest request = collector.collect();
        String targetUserName = request.getTargetUsername();
        int amount = request.getAmount();

        // get senders primary account
        User sourceUser = context.getCurr();
        User targetUser = userDao.getUserDetails(targetUserName);

        if ( targetUser == null) {
            System.out.println("Account doesn't exist");
            return;
        }

        Account sourcePrimaryAccount = UserUtils.getPrimaryAccount(sourceUser);
        Account targetPrimaryAccount = UserUtils.getPrimaryAccount(targetUser);


        if (sourcePrimaryAccount == null) {
            System.out.println("Source primary account is null");
            return;
        }

        if (targetPrimaryAccount == null) {
            System.out.println("Target primary account is null");
            return;
        }

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
