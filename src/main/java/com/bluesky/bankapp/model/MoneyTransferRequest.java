package com.bluesky.bankapp.model;
public class MoneyTransferRequest {

    private String sourceAcc;
    private String targetAcc;
    private int amount;

    public MoneyTransferRequest(String sourceAcc, String targetAcc, int amount) {
        this.sourceAcc = sourceAcc;
        this.targetAcc = targetAcc;
        this.amount = amount;
    }

    public String getSourceAcc() {
        return sourceAcc;
    }

    public void setSourceAcc(String sourceAcc) {
        this.sourceAcc = sourceAcc;
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