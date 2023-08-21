package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.collectors.DataCollectorFactory;
import com.bluesky.bankapp.collectors.LoginDataCollector;
import com.bluesky.bankapp.collectors.MoneyTransferDataCollector;
import com.bluesky.bankapp.collectors.RegistrationDataCollector;
import com.bluesky.bankapp.model.UserAction;
import com.bluesky.bankapp.security.SessionContext;

public class ActionExecutorFactory {
    private final SessionContext context;
    private final DataCollectorFactory collector;
    private final BankAppDataStorage dataStorage;

    public ActionExecutorFactory(SessionContext context, DataCollectorFactory collector, BankAppDataStorage dataStorage) {
        this.context = context;
        this.collector = collector;
        this.dataStorage = dataStorage;
    }

    public ActionExecutor build(UserAction action) {
        if (action.equals(UserAction.REGISTER)) {
            return new RegistrationActionExecutor(context,
                    (RegistrationDataCollector) collector.build(action), dataStorage);
        } else if (action.equals(UserAction.DISPLAY_ACCOUNTS)) {
            return new DisplayAccountsActionExecutor(context);
        } else if (UserAction.LOGOUT.equals(action)) {
            return new LogoutActionExecutor(context);
        } else if (UserAction.OPEN_NEW_ACCOUNT.equals(action)) {
            return new OpenNewAccountActionExecutor(context);
        } else if (UserAction.LOGIN.equals(action)) {
            return new LoginActionExecutor(context, dataStorage,
                    (LoginDataCollector) collector.build(action));
        } else if (UserAction.MONEY_TRANSFER.equals(action)) {
            return new MoneyTransferActionExecutor(dataStorage,
                    (MoneyTransferDataCollector) collector.build(action), context);
        }
        return null;
    }
}
