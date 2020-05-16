package com.hotmail.ch.leon.familymedia.filter.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotmail.ch.leon.familymedia.filter.FMFileFilter;

public class VideoFileFilter implements FMFileFilter {

	private final static List<String> list = init();  
	
	@Override
	public String getSymbol() {
		
		return "V";
	}

	private static  List<String> init() {
		List<String> l = new ArrayList<String>();
		l.add("m4v");
		l.add("mp4");
		l.add("flv");
		l.add("avi");
		l.add("rm");
		l.add("rmvb");
		l.add("mkv");
		l.add("wmv");
		return l;
	}
	
	@Override
	public boolean check(String fileExtension) {

		return list.contains(fileExtension);
	}

}
