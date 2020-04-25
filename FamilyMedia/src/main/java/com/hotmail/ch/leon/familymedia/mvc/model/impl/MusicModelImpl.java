package com.hotmail.ch.leon.familymedia.mvc.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotmail.ch.leon.familymedia.dao.ResourceDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.mvc.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.MusicModel;

public class MusicModelImpl implements MusicModel{

	public  List<MusicBean> getList() {
		
		ResourceDao dao = FmBeanFactory.getDao(ResourceDao.class);
		List<ResourceDTO> resourceDTOList = dao.findList("leon");
		
		List<MusicBean> result = new ArrayList<MusicBean>();
		for (ResourceDTO dto : resourceDTOList) {
			MusicBean mb = new MusicBean();
			mb.setId(String.valueOf(dto.getId()));
			mb.setFname(dto.getName());
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
