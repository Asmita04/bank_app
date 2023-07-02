package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;

public class OpenNewAccountActionExecutor implements ActionExecutor {

    private SessionContext context;

    public OpenNewAccountActionExecutor(SessionContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        System.out.println("Enter Opening balance for new account: ");
        long balance = context.getScan().nextLong();
        User user = context.getCurr();
        Account account = new Account(user.getAadhaar() + "-" + (user.getAccounts().size() + 1)
                , context.getCurr(), balance);
        user.getAccounts().add(account);
    }
}
