package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.model.UserAction;

import java.util.Scanner;

public class DataCollectorFactory {

    private Scanner scan;

    public DataCollectorFactory(Scanner scan) {
        this.scan = scan;
    }

    public DataCollector build(UserAction action) {
        if (UserAction.REGISTER.equals(action)) {
            return new RegistrationDataCollector(scan);
        } else if (UserAction.LOGIN.equals(action)) {
            return new LoginDataCollector(scan);
        }
        return null;
    }
}
