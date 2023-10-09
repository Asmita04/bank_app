package com.bluesky.bankapp;

import org.springframework.context.ApplicationContext;

public class AppConfig {
    public static ApplicationContext applicationContext;// = new AnnotationConfigApplicationContext(JavaConfig.class);

    public  static ApplicationContext  getApplicationContext(){
        return applicationContext;
    }


}