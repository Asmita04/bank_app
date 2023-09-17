package com.bluesky.bankapp.model;

public class MoneyTransferRequest implements ActionRequest {

    private String targetUser;
    private int amount;

    public MoneyTransferRequest(String targetUser, int amount) {
        this.targetUser = targetUser;
        this.amount = amount;
    }

    public String getTargetUsername() {
        return targetUser;
    }

    public void setTargetUsername(String targetAcc) {
        this.targetUser = targetUser;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
