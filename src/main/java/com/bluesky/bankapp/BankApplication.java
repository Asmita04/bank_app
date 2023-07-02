package com.bluesky.bankapp;


import com.bluesky.bankapp.collectors.DataCollectorFactory;
import com.bluesky.bankapp.collectors.MoneyTransferDataCollector;
import com.bluesky.bankapp.collectors.RegistrationDataCollector;
import com.bluesky.bankapp.executors.ActionExecutor;
import com.bluesky.bankapp.executors.ActionExecutorBuilder;
import com.bluesky.bankapp.model.MoneyTransferRequest;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.model.UserAction;
import com.bluesky.bankapp.security.SessionContext;
import com.bluesky.bankapp.ui.UserActionsMenu;
import com.bluesky.bankapp.ui.UserScreen;

import java.util.Scanner;

/**
 * Simple Bank Application
 **/

public class BankApplication {
    public static void main(String[] args) {

        int choice;
        Scanner scan = new Scanner(System.in);

        SessionContext context = new SessionContext(scan);
        BankAppDataStorage dataStorage = new BankAppDataStorage();
        DataCollectorFactory factory = new DataCollectorFactory(scan);
        UserActionsMenu userActionsMenu = new UserActionsMenu(context); //todo
        ActionExecutorBuilder executorBuilder = new ActionExecutorBuilder(context, factory, dataStorage);

        do {
            userActionsMenu.displayActions();
            choice = scan.nextInt();

            switch (choice) {
                case 1: {

                    UserAction action = UserAction.forId(choice);
                    ActionExecutor actionExecutor = executorBuilder.build(action);
                    actionExecutor.execute();


                    break;
                }

                case 2: {

                    UserAction action = UserAction.forId(choice);
                    ActionExecutor actionExecutor = executorBuilder.build(action);
                    actionExecutor.execute();
                    break;

                }
                case 3: {
                    MoneyTransferDataCollector collector = new MoneyTransferDataCollector(scan);
                    MoneyTransferRequest transferRequest = collector.collect();
                    dataStorage.transferMoney(transferRequest);
                    break;
                }
                case 4: {
                    UserAction action = UserAction.forId(choice);
                    ActionExecutor actionExecutor = executorBuilder.build(action);
                    actionExecutor.execute();
                    break;
                }

                case 5: {
                    UserAction action = UserAction.forId(choice);
                    ActionExecutor actionExecutor = executorBuilder.build(action);
                    actionExecutor.execute();
                    break;
                }
                default:
                    UserAction action = UserAction.forId(choice);
                    ActionExecutor actionExecutor = executorBuilder.build(action);
                    actionExecutor.execute();
            }


        } while (choice != -1);
    }


}