package com.bluesky.bankapp.security;

import com.bluesky.bankapp.model.User;

import java.util.Scanner;

public class SessionContext {
    private User curr; // represents currently logged in user
    private Scanner scan;
    public SessionContext(Scanner scan) {
        this.scan = scan;
    }

    public User getCurr() {
        return curr;
    }

    public void setCurr(User curr) {
        this.curr = curr;
    }

    public boolean isActiveSession() {
        return curr != null;
    }

    public void invalidateSession() {
        curr = null;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }
}
