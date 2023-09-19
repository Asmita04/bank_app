package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.AppConfig;
import com.bluesky.bankapp.dao.TransactionDao;
import com.bluesky.bankapp.model.Transaction;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MiniStatementActionExecutor implements ActionExecutor {

    private TransactionDao transactionDao = AppConfig.getApplicationContext().getBean(TransactionDao.class);
    private SessionContext context;

    public MiniStatementActionExecutor(SessionContext context) {
        this.context = context;
    }

    @Override
    public void execute(){

        User currentUser = context.getCurr();
        List<Transaction> transactions = transactionDao.getTransactions(currentUser.getUserName());

        for (Transaction t : transactions) {
            System.out.println(t);
            transactions.remove(t);
        }

    }

    @Override
    public boolean validate() {
        return false;
    }
}
