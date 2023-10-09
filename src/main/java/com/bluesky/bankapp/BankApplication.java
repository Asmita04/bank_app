package com.bluesky.bankapp;
import com.bluesky.bankapp.dao.UserDao;
import com.bluesky.bankapp.executors.ActionExecutor;
import com.bluesky.bankapp.executors.ActionExecutorFactory;
import com.bluesky.bankapp.io.InputReader;
import com.bluesky.bankapp.model.UserAction;
import com.bluesky.bankapp.ui.UserActionsMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Simple Bank Application
 **/

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(BankApplication.class, args);
        runBankApplication();

    }

    private static void runBankApplication() {


        ApplicationContext applicationContext = AppConfig.getApplicationContext() ;
        int choice;
        InputReader scan = new InputReader();

        UserActionsMenu userActionsMenu= applicationContext.getBean(UserActionsMenu.class);
        ActionExecutorFactory executorBuilder = applicationContext.getBean(ActionExecutorFactory.class);
        //  StartupDataLoader dataLoader = applicationContext.getBean(StartupDataLoader.class);

//        dataLoader.initDatabase();
        do {
            userActionsMenu.displayActions();
            choice = scan.readInt();
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