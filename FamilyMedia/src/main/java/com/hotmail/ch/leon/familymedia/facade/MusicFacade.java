package com.hotmail.ch.leon.familymedia.facade;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.bridge.context.PinpointingMessageHandler;

import com.hotmail.ch.leon.familymedia.bean.MusicBean;

public class MusicFacade {

	public static  List<MusicBean> getList() {
		List<MusicBean> result = new ArrayList<MusicBean>();
		MusicBean mb = new MusicBean();
		mb.setId("111");
		mb.setFname("音乐1");
		mb.setFtype(".mp3");
		mb.setSize(15621);
		mb.setCmt("uwav53hvu3hu6y");
		result.add(mb);
		
		for (int i=0; i<30;i++) {
		mb = new MusicBean();
		mb.setId("222");
		mb.setFname("音乐2");
		mb.setFtype(".mp3");
		mb.setSize(89154);
		mb.setCmt("0y5h07q38ohtvy9bq75yyhn0");
		result.add(mb);
		}
		
		
		return result;
	}

	public static MusicBean add() {
		// TODO Auto-generated method stub
		return null;
	}

	public static MusicBean delete() {
		// TODO Auto-generated method stub
		return null;
	}

	public static MusicBean update() {
		// TODO Auto-generated method stub
		return null;
	}

}
