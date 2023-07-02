package com.bluesky.bankapp.model;

public class LoginRequest {
    private String aadhaar;
    private String pin;

    public LoginRequest(String aadhaar, String pin) {
        this.aadhaar = aadhaar;
        this.pin = pin;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
