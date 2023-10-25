package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.security.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogoutActionExecutor implements ActionExecutor {
    @Autowired
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
