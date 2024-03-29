package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.dao.TransactionDao;
import com.bluesky.bankapp.model.Transaction;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MiniStatementActionExecutor implements ActionExecutor {

   @Autowired
    private TransactionDao transactionDao ;
    @Autowired
    private SessionContext context;
    public MiniStatementActionExecutor(TransactionDao transactionDao, SessionContext context) {
        this.transactionDao = transactionDao;
        this.context = context;
    }

    @Override
    public void execute(){

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
