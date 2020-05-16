package com.hotmail.ch.leon.familymedia.filter;

public interface FMFileFilter {
	public String getSymbol();
	
	public boolean check(String fileExtension);
}
