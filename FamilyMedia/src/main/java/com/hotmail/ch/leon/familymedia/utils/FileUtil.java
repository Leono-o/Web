package com.hotmail.ch.leon.familymedia.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	
	/*
     * 列出指定目录下（不包括其子目录）的所有文件
     */
    public static List<String> listDirectory(String path)throws IOException {
    	
    	List<String> result = new ArrayList<String>();
    	File dir = new File(path);
        if(!dir.exists())
            return result;
        if(!dir.isDirectory()){
        	return result;
        }
        
		File[] files = dir.listFiles();
		if (files != null && files.length > 0) {
			for (File file : files) {
				result.add(file.getName());
			}
		}
        
        return result;
    }
    
    /**
     * 获取后缀名
     * @param path
     * @return
     * @throws IOException
     */
    public static String getExtension (String fname) {
    	return fname.substring(fname.lastIndexOf(".") + 1).toLowerCase();
    }
    
    /**
     * 获取文件名主名
     * @param path
     * @return
     * @throws IOException
     */
    public static String getMain (String fname) {
    	int n = fname.lastIndexOf(".");
    	if (n >=0) {
    		return fname.substring(0, fname.lastIndexOf("."));
    	}
    	return fname;
    }
    
}

