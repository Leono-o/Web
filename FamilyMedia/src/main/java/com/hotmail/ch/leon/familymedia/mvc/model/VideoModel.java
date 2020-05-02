package com.hotmail.ch.leon.familymedia.mvc.model;

import com.hotmail.ch.leon.familymedia.mvc.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.mvc.bean.VideoBean;

public interface VideoModel {

	public  ResponseBean getList(String userName, String resourceid) throws Exception ;

	public VideoBean add() ;

	public VideoBean delete();

	public VideoBean update();

}
