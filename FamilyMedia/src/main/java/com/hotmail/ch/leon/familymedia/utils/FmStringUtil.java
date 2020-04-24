package com.hotmail.ch.leon.familymedia.utils;

public class FmStringUtil {

	public static String appendSpace(String value, int len){

		StringBuffer sb = new StringBuffer(value);
        for (int i = value.length(); i < len; i++) {
                sb.append(" ");
        }
        return sb.substring(0, len);
		
	}
}
