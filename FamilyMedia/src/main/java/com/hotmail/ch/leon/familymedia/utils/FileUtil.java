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
    	File dir = new File(path);
        if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }
        
        List<String> result = new ArrayList<String>();
        File[] files=dir.listFiles();
        if(files!=null&&files.length>0){
            for(File file:files){
                if(!file.isDirectory()) {
                	result.add( file.getName());
                }
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
    	return fname.substring(fname.lastIndexOf(".") + 1);
    }
    
}

