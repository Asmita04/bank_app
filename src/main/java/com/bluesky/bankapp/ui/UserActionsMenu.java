package com.bluesky.bankapp.ui;

import com.bluesky.bankapp.model.UserAction;
import com.bluesky.bankapp.security.SessionContext;

public class UserActionsMenu {

    private SessionContext context;

    public UserActionsMenu(SessionContext context) {
        this.context = context;
    }

    public void displayActions() {

        System.out.println("\n\n\n ===============================================");
        String banner = "|          Welcome to Simple Banking System      ";
        if (context.isActiveSession()) {
            banner += "|\n|          Current User: " + context.getCurr().getFullName();
        }
        banner += "|\n";

        System.out.println(banner);
        for (UserAction action : UserAction.values()) {

            if (action.displayOnLoggedin == context.isActiveSession()) {
                System.out.println("|\t          " + action.actionId + " | " + action.displayName);
            }
        }
        System.out.println("\n ===============================================");
    }
}
