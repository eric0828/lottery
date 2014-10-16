package com.lottery;

import com.lottery.common.SpringBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mmzz on 2014/10/4.
 */
public class Launcher {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        String contextPath[] = new String[]{"applicationContext.xml"};
        SpringBeanFactory.getInstance().setApplicationContext(new ClassPathXmlApplicationContext(contextPath));
    }

}
