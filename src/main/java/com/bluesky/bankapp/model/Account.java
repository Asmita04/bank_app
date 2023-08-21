package com.bluesky.bankapp.model;

public class Account {

    private String accNum;
    private User user;
    private Double balance;
    private boolean isPrimary;

    public Account(String accNum, User user, Double balance) {
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }
}
