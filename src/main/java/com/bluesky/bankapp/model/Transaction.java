package com.bluesky.bankapp.model;

public class Transaction {

    private int id;
    private String sourceUsername;
    private String  sourceAccountNum;
    private String targetUsername;
    private String targetAccountNum;
    private int amount;

    public Transaction(String sourceUsername, String sourceAccountNum, String targetUsername, String targetAccountNum, int amount) {
        this.sourceUsername = sourceUsername;
        this.sourceAccountNum = sourceAccountNum;
        this.targetUsername = targetUsername;
        this.targetAccountNum = targetAccountNum;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourceUsername() {
        return sourceUsername;
    }

    public void setSourceUsername(String sourceUsername) {
        this.sourceUsername = sourceUsername;
    }

    public String getSourceAccountNum() {
        return sourceAccountNum;
    }

    public void setSourceAccountNum(String sourceAccountNum) {
        this.sourceAccountNum = sourceAccountNum;
    }

    public String getTargetUsername() {
        return targetUsername;
    }

    public void setTargetUsername(String targetUsername) {
        this.targetUsername = targetUsername;
    }

    public String getTargetAccountNum() {
        return targetAccountNum;
    }

    public void setTargetAccountNum(String targetAccountNum) {
        this.targetAccountNum = targetAccountNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sourceUsername='" + sourceUsername + '\'' +
                ", sourceAccountNum='" + sourceAccountNum + '\'' +
                ", targetUsername='" + targetUsername + '\'' +
                ", targetAccountNum='" + targetAccountNum + '\'' +
                ", amount=" + amount +
                '}';
    }
}
