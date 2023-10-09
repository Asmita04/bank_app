package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.model.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataCollectorFactory {

    @Autowired
    private final InputReader scan;

    public DataCollectorFactory(InputReader scan) {
        this.scan = scan;
    }

    public DataCollector build(UserAction action) {
        if (UserAction.REGISTER.equals(action)) {
            return new RegistrationDataCollector(scan);
        } else if (UserAction.LOGIN.equals(action)) {
            return new LoginDataCollector(scan);
        } else if (UserAction.MONEY_TRANSFER.equals(action)) {
            return new MoneyTransferDataCollector(scan);
        }
        return null;
    }
}
