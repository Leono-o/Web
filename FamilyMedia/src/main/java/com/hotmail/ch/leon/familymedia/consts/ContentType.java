package com.hotmail.ch.leon.familymedia.consts;

import java.util.HashMap;
import java.util.Map;

public enum ContentType {

	MP3("mp3"),
	MP4("mp4"),
	MPG("mpg"),
	M4V("m4v"),
	;

	private final static Map<String,String> table = initTable(); 

	private final String value;


	private static Map<String,String> initTable (){
		Map<String,String> table = new HashMap<String,String>();
		
		table.put("mp3", "audio/mp3");
		table.put("mpg", "video/mpg");
		table.put("mp4", "video/mpeg4");
		table.put("m4v", "video/mpg");
		
		return table;
	}

	private ContentType(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}


	public static String typeOf(String value) {
        for (ContentType tp : ContentType.values()) {
            if (tp.value().contentEquals(value)) {
                return table.get(tp.value());
            }
        }
        
		throw new IllegalArgumentException("No matching constant for [" + value + "]");
	}

}
