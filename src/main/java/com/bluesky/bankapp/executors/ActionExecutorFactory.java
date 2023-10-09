package com.bluesky.bankapp.executors;

import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.collectors.DataCollectorFactory;
import com.bluesky.bankapp.collectors.LoginDataCollector;
import com.bluesky.bankapp.collectors.MoneyTransferDataCollector;
import com.bluesky.bankapp.collectors.RegistrationDataCollector;
import com.bluesky.bankapp.model.UserAction;
import com.bluesky.bankapp.security.SessionContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component

public class ActionExecutorFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public ActionExecutor build(UserAction action) {
        if (action.equals(UserAction.REGISTER)) {
            return applicationContext.getBean(RegistrationActionExecutor.class);
        } else if (action.equals(UserAction.DISPLAY_ACCOUNTS)) {
            return applicationContext.getBean(DisplayAccountsActionExecutor.class);
        } else if (UserAction.LOGOUT.equals(action)) {
            return applicationContext.getBean(LogoutActionExecutor.class);
        } else if (UserAction.OPEN_NEW_ACCOUNT.equals(action)) {
            return applicationContext.getBean(OpenNewAccountActionExecutor.class);
        } else if (UserAction.LOGIN.equals(action)) {
            return applicationContext.getBean(LoginActionExecutor.class);
        } else if (UserAction.MONEY_TRANSFER.equals(action)) {
            return applicationContext.getBean(MoneyTransferActionExecutor.class);
        } else if (UserAction.PRINT_MINI_STATEMENT.equals(action)) {
            return applicationContext.getBean(MiniStatementActionExecutor.class);
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
