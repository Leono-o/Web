package com.hotmail.ch.leon.familymedia.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.util.StringUtils;

import com.hotmail.ch.leon.familymedia.consts.Consts;

public class FMDao {
	
	static Properties pro =loadProperties("sql.properties");
	static Properties pro_dev = loadProperties("sql_dev.properties");
	
	private static Properties loadProperties(String propertiesFile) {
		Properties pro = null;
		InputStream in = null;
		try {
			in = FMDao.class.getResourceAsStream(propertiesFile);
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
		
		if (Consts.DEV_MODE) {
			String value = pro_dev.getProperty(sqlId);
			if (!StringUtils.isEmpty(value)) {
				return value;
			}
		}
		
		return pro.getProperty(sqlId);
		
	}
}
