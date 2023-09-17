package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.dao.TransactionDao;
import com.bluesky.bankapp.model.Transaction;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;

import java.util.List;

public class MiniStatementActionExecutor implements ActionExecutor {

    private TransactionDao transactionDao = new TransactionDao();
    private SessionContext context;

    public MiniStatementActionExecutor(SessionContext context) {
        this.context = context;
    }

    @Override
    public void execute() throws Exception {

        User currentUser = context.getCurr();
        List<Transaction> transactions = transactionDao.getTransactions(currentUser.getUserName());

        for (Transaction t : transactions) {
            System.out.println(t);
        }

    }

    @Override
    public boolean validate() {
        return false;
    }
}
