package com.hotmail.ch.leon.familymedia.filter.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotmail.ch.leon.familymedia.filter.FMFileFilter;

public class MusicFileFilter implements FMFileFilter {

	private final static List<String> list = init();  
	
	@Override
	public String getSymbol() {
		
		return "M";
	}

	private static  List<String> init() {
		List<String> l = new ArrayList<String>();
		l.add("mp3");
		l.add("wma");
		return l;
	}
	
	@Override
	public boolean check(String fileExtension) {

		return list.contains(fileExtension);
	}

}
