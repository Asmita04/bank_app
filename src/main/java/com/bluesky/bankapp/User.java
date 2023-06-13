package com.bluesky.bankapp;

public class User {
        public String userName;
        public String birthDate;
        public long mobileNo;
        public String adhaarNo;
        public String accountNo;
        public int balance;

        public User(){}
        public User( String userName, String birthDate, long mobileNo, String adhaarNo ,int balance) {
                this.userName = userName;
                this.birthDate = birthDate;
                this.mobileNo = mobileNo;
                this.adhaarNo= adhaarNo;
                this.balance = balance;
            }
            public String getAdhaarNo() {
                return adhaarNo;
            }
            public void setAdhaarNo(String adhaarNo) {
                this.adhaarNo = adhaarNo;
            }


            public int getBalance() {
                return balance;
            }

            public void setBalance(int balance) {
                this.balance = balance;
            }

            public String getAccountNo() {
                return accountNo;
            }

            public void setAccountNo(String accountNo) {
                this.accountNo = accountNo;
            }



}
