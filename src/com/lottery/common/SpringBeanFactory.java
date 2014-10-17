package com.lottery.common;

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

	public Object getBeanById(String name) {
		if (applicationContext != null) {
			return applicationContext.getBean(name);
		}
		return null;
	}

	public static SpringBeanFactory getInstance() {
		return instance;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringBeanFactory.applicationContext = applicationContext;
	}
}
