package com.hotmail.ch.leon.familymedia.facade;

import java.util.List;

import com.hotmail.ch.leon.familymedia.bean.VideoBean;

public interface VideoFacade {

	public  List<VideoBean> getList() ;

	public VideoBean add() ;

	public VideoBean delete();

	public VideoBean update();

}
