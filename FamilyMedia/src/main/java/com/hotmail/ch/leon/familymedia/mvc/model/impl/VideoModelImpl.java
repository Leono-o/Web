package com.hotmail.ch.leon.familymedia.mvc.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.util.StringUtils;

import com.hotmail.ch.leon.familymedia.dao.FolderDao;
import com.hotmail.ch.leon.familymedia.dao.GroupDao;
import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.mvc.bean.VideoBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.VideoModel;
import com.hotmail.ch.leon.familymedia.utils.FileUtil;

public class VideoModelImpl implements VideoModel {

	public  List<VideoBean> getList(String userName, String resourceid) throws Exception {
		List<VideoBean> result = null;
		GroupDao dao = FmBeanFactory.getDao(GroupDao.class);
		final Base64.Encoder encoder = Base64.getEncoder();
		
		if (StringUtils.isEmpty(resourceid)) {
			
			List<ResourceDTO> resourceDTOList = dao.findFolderListByUserName(userName, "V");
		
			result = new ArrayList<VideoBean>();
			for (ResourceDTO dto : resourceDTOList) {
				VideoBean mb = new VideoBean();
				String id = String.format("%d:", dto.getId().longValue());
				mb.setId(encoder.encodeToString(id.getBytes("UTF-8")));
				mb.setFname(dto.getName());
				mb.setFtype("DIR");
				result.add(mb);
			}
		} else {
			Base64.Decoder decoder = Base64.getDecoder();
			String folderid = new String(decoder.decode(resourceid), "UTF-8").split(":")[0];
			
			List<ResourceDTO> folderList = dao.findFolderListByFolderid(userName, new BigDecimal(folderid), "V");
		
			result = new ArrayList<VideoBean>();
			for (ResourceDTO dto : folderList) {
				VideoBean mb = new VideoBean();
				String id = String.format("%d:", dto.getId().longValue());
				mb.setId(encoder.encodeToString(id.getBytes("UTF-8")));
				mb.setFname(dto.getName());
				mb.setFtype("DIR");
				result.add(mb);
			}
			
			FolderDao folderDao = FmBeanFactory.getDao(FolderDao.class);
			FolderDTO folderDTO = folderDao.findByid(new BigDecimal(folderid));
			
			for (String fname : FileUtil.listDirectory(folderDTO.getUrl())) {
				VideoBean mb = new VideoBean();
				String id = String.format("%s:%s", folderid, fname);
				mb.setId(encoder.encodeToString(id.getBytes("UTF-8")));
				mb.setFname(fname);
				mb.setFtype(FileUtil.getExtension(fname));
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
