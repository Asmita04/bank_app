package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.security.SessionContext;
import com.bluesky.bankapp.ui.UserScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DisplayAccountsActionExecutor implements ActionExecutor {
    @Autowired
    private SessionContext context;
    public DisplayAccountsActionExecutor(SessionContext context) {
        this.context = context;
    }

    @Override
    public void execute(){
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
