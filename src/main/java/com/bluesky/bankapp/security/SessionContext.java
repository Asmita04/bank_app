package com.bluesky.bankapp.security;

import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.model.User;

public class SessionContext {
    private User curr; // represents currently logged in user
    private InputReader scan;
    public SessionContext(InputReader scan) {
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

    public InputReader getScan() {
        return scan;
    }

    public void setScan(InputReader scan) {
        this.scan = scan;
    }
}
