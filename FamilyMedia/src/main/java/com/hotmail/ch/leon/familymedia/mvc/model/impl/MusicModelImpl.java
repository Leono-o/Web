package com.hotmail.ch.leon.familymedia.mvc.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.hotmail.ch.leon.familymedia.dao.FileDao;
import com.hotmail.ch.leon.familymedia.dao.GroupDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.mvc.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.mvc.bean.VideoBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.MusicModel;

public class MusicModelImpl implements MusicModel{

	public  List<MusicBean> getList(String userName, String folderid) {
		
		List<MusicBean> result = null;
		GroupDao dao = FmBeanFactory.getDao(GroupDao.class);
		if (StringUtils.isEmpty(folderid)) {
			
			List<ResourceDTO> resourceDTOList = dao.findFolderListByUserName(userName, "M");
		
			result = new ArrayList<MusicBean>();
			for (ResourceDTO dto : resourceDTOList) {
				MusicBean mb = new MusicBean();
				mb.setId(String.valueOf(dto.getId()));
				mb.setFname(dto.getName());
				mb.setFtype("DIR");
				result.add(mb);
			}
		} else {
			List<ResourceDTO> folderList = dao.findFolderListByFolderid(userName, new BigDecimal(folderid), "M");
		
			result = new ArrayList<MusicBean>();
			for (ResourceDTO dto : folderList) {
				MusicBean mb = new MusicBean();
				mb.setId(String.valueOf(dto.getId()));
				mb.setFname(dto.getName());
				mb.setFtype("DIR");
				result.add(mb);
			}
			
			FileDao fileDao = FmBeanFactory.getDao(FileDao.class);
			List<ResourceDTO> fileList = fileDao.findListByFolderId(new BigDecimal(folderid));
			for (ResourceDTO dto : fileList) {
				MusicBean mb = new MusicBean();
				mb.setId(String.valueOf(dto.getId()));
				mb.setFname(dto.getName());
				mb.setFtype(dto.getRtype());
				mb.setCmt(dto.getCmt());
				result.add(mb);
			}
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
