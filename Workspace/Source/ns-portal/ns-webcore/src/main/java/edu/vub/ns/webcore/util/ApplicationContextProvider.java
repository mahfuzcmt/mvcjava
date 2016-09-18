package edu.vub.ns.webcore.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ApplicationContextProvider implements ApplicationContextAware {
	
	private static ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ctx = context;		
	}
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
	public static DriverManagerDataSource getDataSource() {
		return (DriverManagerDataSource)ctx.getBean("dataSource");
	}
	
}
