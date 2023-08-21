package com.bluesky.bankapp.model;

public class LoginRequest implements ActionRequest {
    private String aadhaar;
    private Integer pin;

    public LoginRequest(String aadhaar, Integer pin) {
        this.aadhaar = aadhaar;
        this.pin = pin;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
