package com.hotmail.ch.leon.familymedia.factory;

import org.apache.log4j.chainsaw.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FmBeanFactory {
	
	private static ApplicationContext _contex = null;
	
	private static ApplicationContext getApplicationContextInstance() {
		if (_contex == null) {

			_contex = (ApplicationContext)new ClassPathXmlApplicationContext("/beanRefContext.xml", Main.class).getBean("context");
		}
		return _contex;
	}
	

	public static  <T> T getModel(Class <T> requiredType) {
		return (T)getApplicationContextInstance().getBean("facade."+ requiredType.getSimpleName());
		
	}
	

	public static  <T> T getDao(Class <T> requiredType)  {
		return (T)getApplicationContextInstance().getBean("dao."+ requiredType.getSimpleName());
	}
}
