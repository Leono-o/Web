package com.hotmail.ch.leon.familymedia.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FMDao {
	
	static Properties pro =loadProperties("sql.properties");
	
	private static Properties loadProperties(String propertiesFile) {
		Properties pro = null;
		InputStream in = null;
		try {
			in = FMDao.class.getClassLoader().getResourceAsStream(propertiesFile);
			pro = new Properties();
			pro.load(in);
			
		} catch (Exception e) {
			pro=null;
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		
		return pro;		
	}
	
	public static String getSQL(String sqlId) {
		
		return pro.getProperty(sqlId);
		
	}
}
