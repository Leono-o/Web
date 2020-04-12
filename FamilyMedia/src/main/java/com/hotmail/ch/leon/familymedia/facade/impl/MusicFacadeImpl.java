package com.hotmail.ch.leon.familymedia.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotmail.ch.leon.familymedia.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.facade.MusicFacade;

public class MusicFacadeImpl implements MusicFacade {

	@Override
	public List<MusicBean> getList() {
		List<MusicBean> result = new ArrayList<MusicBean>();
		MusicBean mb = new MusicBean();
		mb.setId("111");
		mb.setFname("音乐1");
		mb.setFtype(".mp3");
		result.add(mb);
		
		mb = new MusicBean();
		mb.setId("222");
		mb.setFname("音乐2");
		mb.setFtype(".mp3");
		result.add(mb);
		
		
		return result;
	}

	@Override
	public MusicBean add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MusicBean delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MusicBean update() {
		// TODO Auto-generated method stub
		return null;
	}

}
