package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.security.SessionContext;

public class LogoutActionExecutor implements ActionExecutor {

    private SessionContext context;

    public LogoutActionExecutor(SessionContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.invalidateSession();
    }

    @Override
    public boolean validate() {
        return true;
    }
}
