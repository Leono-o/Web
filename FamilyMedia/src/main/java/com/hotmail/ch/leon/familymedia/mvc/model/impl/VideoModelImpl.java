package com.hotmail.ch.leon.familymedia.mvc.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.logic.ResourceLogic;
import com.hotmail.ch.leon.familymedia.mvc.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.mvc.bean.VideoBean;
import com.hotmail.ch.leon.familymedia.mvc.model.VideoModel;

public class VideoModelImpl implements VideoModel {

	public  ResponseBean getList(String userName, String resourceid) throws Exception {
		
ResponseBean responseBean = ResourceLogic.getMember(userName, resourceid, "V");
		
		List<ResourceDTO> resourceList = (List<ResourceDTO>)responseBean.getData();
		
		if (resourceList == null) {
			return responseBean;
		}
		List<VideoBean> result = new ArrayList<VideoBean>() ;
		for(ResourceDTO dto : resourceList) {
			VideoBean bean = new VideoBean();
			bean.setFname(dto.getName());
			bean.setFtype(dto.getRtype());
			bean.setId(dto.getId());
			
			result.add(bean);
		}
		
		return new ResponseBean("200", result);
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
