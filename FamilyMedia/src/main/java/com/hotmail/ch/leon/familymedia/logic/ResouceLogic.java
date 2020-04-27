package com.hotmail.ch.leon.familymedia.logic;

import java.math.BigDecimal;
import java.util.Base64;

import com.hotmail.ch.leon.familymedia.dao.FolderDao;
import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.utils.FileUtil;

public class ResouceLogic {
	public static FileInfoDTO getFileInfo(String user, String resourceid) throws Exception {
		
		Base64.Decoder decoder = Base64.getDecoder();
		String[] resource = new String(decoder.decode(resourceid), "UTF-8").split(":");
		BigDecimal folderid =new BigDecimal(resource[0]); 
		String fileName =resource[1];
		
		FolderDao folderDao = FmBeanFactory.getDao(FolderDao.class);
		FolderDTO folderDTO = folderDao.findByid(folderid);

		
		return new FileInfoDTO(folderDTO.getUrl() + "/" + fileName, fileName,
				FileUtil.getExtension(fileName));

	}

}
