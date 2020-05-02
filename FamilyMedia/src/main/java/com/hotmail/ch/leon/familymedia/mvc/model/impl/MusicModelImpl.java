package com.hotmail.ch.leon.familymedia.mvc.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.logic.ResourceLogic;
import com.hotmail.ch.leon.familymedia.mvc.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.mvc.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.mvc.model.MusicModel;

public class MusicModelImpl implements MusicModel{

	public  ResponseBean getList(String userName, String resourceid) throws Exception {
		
		ResponseBean responseBean = ResourceLogic.getMember(userName, resourceid, "M");
		
		List<ResourceDTO> resourceList = (List<ResourceDTO>)responseBean.getData();
		
		if (resourceList == null) {
			return responseBean;
		}
		List<MusicBean> result = new ArrayList<MusicBean>() ;
		for(ResourceDTO dto : resourceList) {
			MusicBean bean = new MusicBean();
			bean.setFname(dto.getName());
			bean.setFtype(dto.getRtype());
			bean.setId(dto.getId());
			
			result.add(bean);
		}
		
		return new ResponseBean("200", result);
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
