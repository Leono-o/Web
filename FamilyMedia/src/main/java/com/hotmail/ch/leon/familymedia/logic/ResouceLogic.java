package com.hotmail.ch.leon.familymedia.logic;

import com.hotmail.ch.leon.familymedia.consts.ContentType;
import com.hotmail.ch.leon.familymedia.dao.ResourceDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;
import com.hotmail.ch.leon.familymedia.factory.FmBeanFactory;

public class ResouceLogic {
	public static FileInfoDTO getFileInfo(String id) {


		ResourceDao dao = FmBeanFactory.getDao(ResourceDao.class);
		ResourceDTO resourceDTO = dao.find(Long.valueOf(id));

		return new FileInfoDTO("V:/music/山口百惠/ありがとうあなた.mp3","ありがとうあなた.mp3",ContentType.MP3.value());

	}

}
