package com.hotmail.ch.leon.familymedia.facade;

import java.util.List;

import com.hotmail.ch.leon.familymedia.bean.MusicBean;

public interface MusicFacade {
	
	public  List<MusicBean> getList();

	public  MusicBean add();
	
	public  MusicBean delete();
	
	public  MusicBean update();
}
