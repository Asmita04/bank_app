package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;
import com.bluesky.bankapp.ui.UserScreen;

public class DisplayAccountsActionExecutor implements ActionExecutor {

    private SessionContext context;
    public DisplayAccountsActionExecutor(SessionContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        User user = context.getCurr();
        UserScreen.displayUserDetails(user);
        System.out.println("Press Enter to continue...");
        context.getScan().readString();
    }

    @Override
    public boolean validate() {
        return true;
    }
}
