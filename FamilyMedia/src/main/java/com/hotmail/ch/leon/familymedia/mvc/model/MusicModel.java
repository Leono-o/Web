package com.hotmail.ch.leon.familymedia.mvc.model;

import java.util.List;

import com.hotmail.ch.leon.familymedia.mvc.bean.MusicBean;

public interface  MusicModel  {

	public  List<MusicBean> getList() ;

	public  MusicBean add();

	public  MusicBean delete();

	public  MusicBean update() ;

}
