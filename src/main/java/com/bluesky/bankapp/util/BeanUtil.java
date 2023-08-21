package com.bluesky.bankapp.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtil<T> {
    private static  BeanUtil INSTANCE;

    private BeanUtil () {

    }

    public static BeanUtil getInstance() {
        if(INSTANCE == null ){
            INSTANCE = new BeanUtil();
        }
        return INSTANCE;
    }

//    public static T getBean()
}
