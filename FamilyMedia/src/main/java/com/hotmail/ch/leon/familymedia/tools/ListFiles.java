package com.hotmail.ch.leon.familymedia.tools;

import java.io.File;
import java.io.IOException;

public class ListFiles {

	public static void main(String[] args) {
		
		try {
			String folder= "S:/H/3g";
			System.out.println("list files in " + folder);
			listDirectory(new File(folder), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/*
     * 列出指定目录下（包括其子目录）的所有文件
     */
    public static void listDirectory(File dir, int num)throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }
        /*String[] filenames=dir.list();//返回的是字符串数组 直接子的名称 不包含子目录
        for(String string:filenames){
            System.out.println(dir+"\\"+string);
        }*/
        //如果要遍历子目录下的内容就需要构造File对象做递归操作，File提供了直接返回File对象的API
        File[] files=dir.listFiles();
        //for(File file:files){
            //System.out.println(file);
        if(files!=null&&files.length>0){
            for(File file:files){
                if(file.isDirectory()) {
                    //递归
                    listDirectory(file, num);
                } else {
                	
                    //System.out.println(String.format("insert into T_RESOURCE (name,URL,OWNER,GNAME) values('%s','%s','leon',' ');", file.getName(),file));
                	
//                	System.out.println("mb = new VideoBean();");
//					System.out.println(String.format("mb.setId(\"%d\");",num++));
//					System.out.println(String.format("mb.setFname(\"%s\");", file.getName()));
//					System.out.println("mb.setFtype(\"mp4\");");
//					System.out.println("mb.setSize(15621);");
//					System.out.println("mb.setCmt(\"uwav53hvu3hu6y\");");
//					System.out.println("result.add(mb);");
                	
                	System.out.println(String.format("if (\"%d\".equals(id)) {",num++));
                	System.out.println(String.format("return new FileInfoDTO(\"%s\", \"%s\",ContentType.MP4.value());",file, file.getName()));
                	System.out.println("}");
                }
            }
        }
    }
    
}

