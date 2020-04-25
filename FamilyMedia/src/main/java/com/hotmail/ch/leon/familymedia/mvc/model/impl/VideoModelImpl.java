package com.hotmail.ch.leon.familymedia.mvc.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotmail.ch.leon.familymedia.dao.ResourceDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.mvc.bean.VideoBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.VideoModel;

public class VideoModelImpl implements VideoModel {

	public  List<VideoBean> getList() {
		ResourceDao dao = FmBeanFactory.getDao(ResourceDao.class);
		List<ResourceDTO> resourceDTOList = dao.findList("leon ");
		
		List<VideoBean> result = new ArrayList<VideoBean>();
		for (ResourceDTO dto : resourceDTOList) {
			VideoBean mb = new VideoBean();
			mb.setId(String.valueOf(dto.getId()));
			mb.setFname(dto.getName());
			mb.setFtype("mp4");
			mb.setSize(89154);
			mb.setCmt("0y5h07q38ohtvy9bq75yyhn0");
			result.add(mb);
		}
		
		return result;
	}

	public  VideoBean add() {
		// TODO Auto-generated method stub
		return null;
	}

	public  VideoBean delete() {
		// TODO Auto-generated method stub
		return null;
	}

	public  VideoBean update() {
		// TODO Auto-generated method stub
		return null;
	}

}
