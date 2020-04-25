package com.hotmail.ch.leon.familymedia.mvc.model;

import java.util.List;

import com.hotmail.ch.leon.familymedia.mvc.bean.VideoBean;

public interface VideoModel {

	public  List<VideoBean> getList() ;

	public VideoBean add() ;

	public VideoBean delete();

	public VideoBean update();

}
