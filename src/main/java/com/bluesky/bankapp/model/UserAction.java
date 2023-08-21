package com.bluesky.bankapp.model;

public enum UserAction {

    REGISTER("Register New User", 1, false),
    LOGIN("Login", 2, false),
    MONEY_TRANSFER("Transfer Money", 3, true),
    OPEN_NEW_ACCOUNT("Open New Account", 8, true),
    DISPLAY_ACCOUNTS("Display Account Details", 4, true),
    LOGOUT("Logout", 5, true),
    PRINT_MINI_STATEMENT("Mini Statement", 6, true),
    EXIT("Exit", 7, false);

    public String displayName;
    public int actionId;
    public boolean displayOnLoggedin;

    UserAction(String displayName, int actionId, boolean displayOnLoggedin) {
        this.displayName = displayName;
        this.actionId = actionId;
        this.displayOnLoggedin = displayOnLoggedin;
    }

    public static UserAction forId(int id) {
        for (UserAction action : values()) {
            if (action.actionId == id) return action;
        }
        return null;
    }
}
