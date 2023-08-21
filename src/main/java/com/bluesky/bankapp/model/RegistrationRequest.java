package com.bluesky.bankapp.model;

public class RegistrationRequest implements ActionRequest {

    private String username;
    private String firstName;
    private String lastName;
    private String mobile;
    private String birthDate;
    private Double balance;
    private Integer pin;

    public RegistrationRequest(String username, String firstName, String lastName, String mobile, String birthDate, Double balance, Integer pin) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.birthDate = birthDate;
        this.balance = balance;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getPin() {
        return pin;
    }
}
