package com.hotmail.ch.leon.familymedia.facade;

import org.apache.log4j.chainsaw.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FacadeFactory {
	
	private static ApplicationContext _Contex = null;
	
	private static ApplicationContext getApplicationContextInstance() {
		if (_Contex == null) {
			_Contex = new ClassPathXmlApplicationContext("/facadeContext.xml", Main.class);
		}
		return _Contex;
	}
	

	public static  <T> T getFacade(Class <T> requiredType) {
		return getApplicationContextInstance().getBean(requiredType);
	}
	

}
