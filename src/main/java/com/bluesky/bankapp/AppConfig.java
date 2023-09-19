package com.bluesky.bankapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConfig {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    public  static ApplicationContext  getApplicationContext(){
        return applicationContext;
    }
}
