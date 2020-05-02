package com.hotmail.ch.leon.familymedia.consts;

import java.util.HashMap;
import java.util.Map;

public class ContentType {

	private final static Map<String,String> table = initTable(); 


	private static Map<String,String> initTable (){
		Map<String,String> table = new HashMap<String,String>();
		
		
		table.put("avi", "video/avi");
		
		table.put("m1v", "video/x-mpeg");
		
		table.put("m2v", "video/x-mpeg");
		table.put("m3u", "audio/mpegurl");
		table.put("m4e", "video/mpeg4");
		table.put("m4v", "video/mpg");
		
		table.put("movie", "video/x-sgi-movie");
		table.put("mp1", "audio/mp1");
		table.put("mp2", "audio/mp2");
		table.put("mp2v", "video/mpeg");
		table.put("mp3", "audio/mp3");
		table.put("mp4", "video/mpeg4");
		table.put("mpg", "video/mpg");
		table.put("mpv", "video/mpg");
		
		table.put("rm", "application/vnd.rn-realmedia");
		table.put("rmvb", "application/vnd.rn-realmedia-vbr");
		table.put("wma", "audio/x-ms-wma");
		table.put("wmv", "video/x-ms-wmv");
		
		
		
		
		return table;
	}


	public static String typeOf(String key) {
		if (table.containsKey(key)) {
			return  table.get(key);
        }
        
        return "application/octet-stream";
	}

}
