package com.bluesky.bankapp;


import com.bluesky.bankapp.collectors.DataCollectorFactory;
import com.bluesky.bankapp.executors.ActionExecutor;
import com.bluesky.bankapp.executors.ActionExecutorFactory;
import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.io.StartupDataLoader;
import com.bluesky.bankapp.model.UserAction;
import com.bluesky.bankapp.security.SessionContext;
import com.bluesky.bankapp.ui.UserActionsMenu;

import java.io.IOException;
import java.util.Scanner;

/**
 * Simple Bank Application
 **/

public class BankApplication {
    public static void main(String[] args) throws IOException {

        int choice;
        InputReader scan = new InputReader(new Scanner(System.in));


        SessionContext context = new SessionContext(scan);
        BankAppDataStorage dataStorage = new BankAppDataStorage();
        DataCollectorFactory factory = new DataCollectorFactory(scan);
        UserActionsMenu userActionsMenu = new UserActionsMenu(context); //todo
        ActionExecutorFactory executorBuilder = new ActionExecutorFactory(context, factory, dataStorage);

        StartupDataLoader dataLoader = new StartupDataLoader(dataStorage);
        dataLoader.initDatabase();
        do {
            userActionsMenu.displayActions();
            choice = scan.readInt();
            UserAction action = UserAction.forId(choice);
            ActionExecutor actionExecutor = executorBuilder.build(action);
            actionExecutor.execute();
        } while (choice != -1);
    }


}