package com.bluesky.bankapp.model;

public class Account {

    private String accNum;
    private User user;
    private Long balance;

    public Account(String accNum, User user, Long balance) {
        this.accNum = accNum;
        this.user = user;
        this.balance = balance;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
