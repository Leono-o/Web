package com.hotmail.ch.leon.familymedia.logic;

import java.math.BigDecimal;

import com.hotmail.ch.leon.familymedia.dao.FileDao;
import com.hotmail.ch.leon.familymedia.dao.FolderDao;
import com.hotmail.ch.leon.familymedia.dao.dto.FileDTO;
import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;

public class ResouceLogic {
	public static FileInfoDTO getFileInfo(String id) {
		FileDao dao = FmBeanFactory.getDao(FileDao.class);
		FileDTO fileDTO = dao.findByid(new BigDecimal(id));
		
		FolderDao folderDao = FmBeanFactory.getDao(FolderDao.class);
		FolderDTO folderDTO = folderDao.findByid(fileDTO.getFolder());

		return new FileInfoDTO(folderDTO.getUrl() + "/" + fileDTO.getUrl(), fileDTO.getName(), fileDTO.getFtype());

	}

}
