package com.bluesky.bankapp.model;

public class Account {

    private String accNum;
    private String username;
    private Double balance;
    private boolean isPrimary;

    public Account(String accNum, String user, Double balance, boolean isPrimary) {
        this.accNum = accNum;
        this.username = user;
        this.balance = balance;
        this.isPrimary = isPrimary;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "Account{" +
                "accNum='" + accNum + '\'' +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
