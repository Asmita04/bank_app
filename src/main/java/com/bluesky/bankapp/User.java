package com.bluesky.bankapp;


public class User {

    public String userName;
    public String DOB;
    public long mobileNo;
    public String adhaarNo;
    public String accountNo;
    public int balance;

    public User(){}
    public User( String userName, String DOB, long mobileNo, String adhaarNo ,int balance) {
        this.userName = userName;
        this.DOB = DOB;
        this.mobileNo = mobileNo;
        this.adhaarNo = adhaarNo;
        this.balance = balance;

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo ;
    }

    public String setAccountNo(String accountNo){
      return accountNo=accountNo;
    }

    public String getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(String adhaarNo) {
        this.adhaarNo = adhaarNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", DOB='" + DOB + '\'' +
                ", mobileNo=" + mobileNo +
                ", adhaarNo='" + adhaarNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}

