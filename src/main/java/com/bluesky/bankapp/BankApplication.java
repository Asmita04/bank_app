package com.bluesky.bankapp;


import com.bluesky.bankapp.executors.ActionExecutor;
import com.bluesky.bankapp.executors.ActionExecutorFactory;
import com.bluesky.bankapp.model.UserAction;
import com.bluesky.bankapp.ui.UserActionsMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Simple Bank Application
 **/

public class BankApplication {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        ApplicationContext applicationContext = AppConfig.getApplicationContext();
        int choice;
       // InputReader scan = new InputReader();
        UserActionsMenu userActionsMenu= applicationContext.getBean(UserActionsMenu.class);
        ActionExecutorFactory executorBuilder = applicationContext.getBean(ActionExecutorFactory.class);
     //  StartupDataLoader dataLoader = applicationContext.getBean(StartupDataLoader.class);

//        dataLoader.initDatabase();
        do {
            userActionsMenu.displayActions();
            choice = sc.nextInt();
            UserAction action = UserAction.forId(choice);
            ActionExecutor actionExecutor = executorBuilder.build(action);
            try {
                actionExecutor.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (choice != -1);
    }



}