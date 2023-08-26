package com.bluesky.bankapp;


import com.bluesky.bankapp.collectors.DataCollectorFactory;
import com.bluesky.bankapp.executors.ActionExecutor;
import com.bluesky.bankapp.executors.ActionExecutorFactory;
import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.io.StartupDataLoader;
import com.bluesky.bankapp.model.User;
import com.bluesky.bankapp.model.UserAction;
import com.bluesky.bankapp.security.SessionContext;
import com.bluesky.bankapp.ui.UserActionsMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

/**
 * Simple Bank Application
 **/

public class BankApplication {
    public static void main(String[] args) throws IOException {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        int choice;
        InputReader scan = new InputReader();

//        SessionContext context = applicationContext.getBean(SessionContext.class);
//        BankAppDataStorage dataStorage = applicationContext.getBean(BankAppDataStorage.class);
//        DataCollectorFactory factory = applicationContext.getBean(DataCollectorFactory.class);
        UserActionsMenu userActionsMenu= applicationContext.getBean(UserActionsMenu.class);
        ActionExecutorFactory executorBuilder = applicationContext.getBean(ActionExecutorFactory.class);
        StartupDataLoader dataLoader = applicationContext.getBean(StartupDataLoader.class);

        System.out.println("Done");
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