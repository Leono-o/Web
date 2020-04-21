package com.hotmail.ch.leon.familymedia.dao;

import org.apache.log4j.chainsaw.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoFactory {
	
	private static ApplicationContext _Contex = null;
	
	
	private static ApplicationContext getApplicationContextInstance() {
		if (_Contex == null) {
			_Contex = new ClassPathXmlApplicationContext("/daoContext.xml", Main.class);
		}
		return _Contex;
	}
	
	public static  <T> T getDao(Class <T> requiredType)  {
		T dao =  getApplicationContextInstance().getBean(requiredType);
		return dao;
	}

}
