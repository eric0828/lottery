package com.lottery;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lottery.common.SpringBeanFactory;

/**
 * Created by mmzz on 2014/10/4.
 */
public class Launcher {

	public static void main(String[] args) {

		String contextPath[] = new String[] { "applicationContext.xml" };
		SpringBeanFactory.getInstance().setApplicationContext(
				new ClassPathXmlApplicationContext(contextPath));
	}

}
