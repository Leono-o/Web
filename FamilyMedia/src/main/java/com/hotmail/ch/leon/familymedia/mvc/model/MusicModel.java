package com.hotmail.ch.leon.familymedia.mvc.model;

import com.hotmail.ch.leon.familymedia.mvc.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.mvc.bean.ResponseBean;

public interface  MusicModel  {

	public  ResponseBean getList(String userName, String folderid) throws Exception  ;

	public  MusicBean add();

	public  MusicBean delete();

	public  MusicBean update() ;

}
