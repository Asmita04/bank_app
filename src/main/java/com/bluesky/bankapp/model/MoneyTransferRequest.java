package com.bluesky.bankapp.model;

public class MoneyTransferRequest implements ActionRequest {

    private String targetAcc;
    private int amount;

    public MoneyTransferRequest(String targetAcc, int amount) {
        this.targetAcc = targetAcc;
        this.amount = amount;
    }

    public String getTargetAcc() {
        return targetAcc;
    }

    public void setTargetAcc(String targetAcc) {
        this.targetAcc = targetAcc;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
