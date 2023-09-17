package com.bluesky.bankapp.model;

public class UserCreds {
    private String username;
    private int pin;

    public UserCreds(String username, int pin) {
        this.username = username;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
