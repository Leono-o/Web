package com.hotmail.ch.leon.familymedia.mvc.model.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.util.StringUtils;

import com.hotmail.ch.leon.familymedia.dao.FolderDao;
import com.hotmail.ch.leon.familymedia.dao.GroupDao;
import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.mvc.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.MusicModel;
import com.hotmail.ch.leon.familymedia.utils.FileUtil;

public class MusicModelImpl implements MusicModel{

	public  List<MusicBean> getList(String userName, String folderid) throws Exception {
		
		List<MusicBean> result = null;
		final Base64.Encoder encoder = Base64.getEncoder();
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
			
			FolderDao folderDao = FmBeanFactory.getDao(FolderDao.class);
			FolderDTO folderDTO = folderDao.findByid(new BigDecimal(folderid));
			
			for (String fname : FileUtil.listDirectory(folderDTO.getUrl())) {
				MusicBean mb = new MusicBean();
				String id = String.format("%s:%s", folderid, fname);
				mb.setId(encoder.encodeToString(id.getBytes("UTF-8")));
				mb.setFname(fname);
				mb.setFtype(FileUtil.getExtension(fname));
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
