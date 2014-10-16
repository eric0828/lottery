package com.lottery.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Created by houyi on 2014/10/16.
 */
public class SpringBeanFactory extends SpringBeanAutowiringSupport {
    private static SpringBeanFactory instance;
    private static ApplicationContext applicationContext;

    static {
        instance = new SpringBeanFactory();
    }

    public static Object getBeanById(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    public static SpringBeanFactory getInstance() {
        return instance;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringBeanFactory.applicationContext = applicationContext;
    }
}
