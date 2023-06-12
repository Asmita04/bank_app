package com.bluesky.bankapp;


<<<<<<< Updated upstream
public class User {

    public String userName;
    public String DOB;
=======
import java.util.*;
import java.util.Scanner;
class User {

    public String userName;
    public String birthDate;
>>>>>>> Stashed changes
    public long mobileNo;
    public String adhaarNo;
    public String accountNo;
    public int balance;

<<<<<<< Updated upstream
    public User(){}
    public User( String userName, String DOB, long mobileNo, String adhaarNo ,int balance) {
        this.userName = userName;
        this.DOB = DOB;
        this.mobileNo = mobileNo;
        this.adhaarNo = adhaarNo;
=======
    public User( String userName, String birthDate, long mobileNo, String adhaarNo ,int balance) {
        this.userName = userName;
        this.birthDate = birthDate;
        this.mobileNo = mobileNo;
        this.adhaarNo= adhaarNo;
>>>>>>> Stashed changes
        this.balance = balance;

    }

<<<<<<< Updated upstream
=======
    public String getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(String adhaarNo) {
        this.adhaarNo = adhaarNo;
    }

>>>>>>> Stashed changes
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
<<<<<<< Updated upstream
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
=======
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
>>>>>>> Stashed changes
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
<<<<<<< Updated upstream
                ", DOB='" + DOB + '\'' +
                ", mobileNo=" + mobileNo +
                ", adhaarNo='" + adhaarNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}

=======
                ", Birth Date='" + birthDate + '\'' +
                ", mobileNo=" + mobileNo +
                ", adhaarNo=" + adhaarNo +
                ", accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                '}'+'\n';
    }
}
>>>>>>> Stashed changes
