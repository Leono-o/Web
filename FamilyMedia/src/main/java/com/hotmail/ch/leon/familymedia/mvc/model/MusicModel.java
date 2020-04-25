package com.hotmail.ch.leon.familymedia.model;

import java.util.List;

import com.hotmail.ch.leon.familymedia.bean.MusicBean;

public interface  MusicModel  {

	public  List<MusicBean> getList() ;

	public  MusicBean add();

	public  MusicBean delete();

	public  MusicBean update() ;

}
