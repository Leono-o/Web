package com.hotmail.ch.leon.familymedia.mvc.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.hotmail.ch.leon.familymedia.dao.FileDao;
import com.hotmail.ch.leon.familymedia.dao.GroupDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.mvc.bean.VideoBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.VideoModel;

public class VideoModelImpl implements VideoModel {

	public  List<VideoBean> getList(String userName, String folderid) {
		List<VideoBean> result = null;
		GroupDao dao = FmBeanFactory.getDao(GroupDao.class);
		if (StringUtils.isEmpty(folderid)) {
			
			List<ResourceDTO> resourceDTOList = dao.findFolderListByUserName(userName, "V");
		
			result = new ArrayList<VideoBean>();
			for (ResourceDTO dto : resourceDTOList) {
				VideoBean mb = new VideoBean();
				mb.setId(String.valueOf(dto.getId()));
				mb.setFname(dto.getName());
				mb.setFtype("DIR");
				result.add(mb);
			}
		} else {
			List<ResourceDTO> folderList = dao.findFolderListByFolderid(userName, new BigDecimal(folderid), "V");
		
			result = new ArrayList<VideoBean>();
			for (ResourceDTO dto : folderList) {
				VideoBean mb = new VideoBean();
				mb.setId(String.valueOf(dto.getId()));
				mb.setFname(dto.getName());
				mb.setFtype("DIR");
				result.add(mb);
			}
			
			FileDao fileDao = FmBeanFactory.getDao(FileDao.class);
			List<ResourceDTO> fileList = fileDao.findListByFolderId(new BigDecimal(folderid));
			for (ResourceDTO dto : fileList) {
				VideoBean mb = new VideoBean();
				mb.setId(String.valueOf(dto.getId()));
				mb.setFname(dto.getName());
				mb.setFtype(dto.getRtype());
				mb.setCmt(dto.getCmt());
				result.add(mb);
			}
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
