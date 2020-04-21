package com.hotmail.ch.leon.familymedia.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotmail.ch.leon.familymedia.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.dao.DaoFactory;
import com.hotmail.ch.leon.familymedia.dao.ResourceDao;
import com.hotmail.ch.leon.familymedia.facade.MusicFacade;

public class MusicFacadeImpl implements MusicFacade {

	public  List<MusicBean> getList() {
		
		ResourceDao dao = DaoFactory.getDao(ResourceDao.class);
		dao.findList();
		
		List<MusicBean> result = new ArrayList<MusicBean>();
		MusicBean mb = new MusicBean();
		mb.setId("111");
		mb.setFname("音乐1");
		mb.setFtype("mp3");
		mb.setSize(15621);
		mb.setCmt("uwav53hvu3hu6y");
		result.add(mb);
		
		for (int i=0; i<30;i++) {
		mb = new MusicBean();
		mb.setId("222");
		mb.setFname("音乐2");
		mb.setFtype("mp3");
		mb.setSize(89154);
		mb.setCmt("0y5h07q38ohtvy9bq75yyhn0");
		result.add(mb);
		}
		
		
		return result;
	}

	public  MusicBean add() {
		// TODO Auto-generated method stub
		return null;
	}

	public  MusicBean delete() {
		// TODO Auto-generated method stub
		return null;
	}

	public  MusicBean update() {
		// TODO Auto-generated method stub
		return null;
	}

}
