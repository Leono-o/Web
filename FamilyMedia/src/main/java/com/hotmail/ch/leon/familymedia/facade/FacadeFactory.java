package com.hotmail.ch.leon.familymedia.facade;

import org.apache.log4j.chainsaw.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FacadeFactory {
	
	private static ApplicationContext _contex = null;
	
	private static ApplicationContext getApplicationContextInstance() {
		if (_contex == null) {

			_contex = (ApplicationContext)new ClassPathXmlApplicationContext("/beanRefContext.xml", Main.class).getBean("context");
		}
		return _contex;
	}
	

	public static  <T> T getFacade(Class <T> requiredType) {
		//return getApplicationContextInstance().getBean(requiredType);
		return (T)getApplicationContextInstance().getBean("facade.MusicFacade");
		
	}
	

}
