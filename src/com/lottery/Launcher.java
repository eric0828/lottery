package com.lottery;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mmzz on 2014/10/4.
 */
public class Launcher {

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        String contextPath[] = new String[]{"applicationContext.xml"};
        new ClassPathXmlApplicationContext(contextPath);

    }

}
