package com.hotmail.ch.leon.familymedia.logic;

import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;

public class ResouceLogic {
	public static FileInfoDTO getFileInfo(String id) {
		return new FileInfoDTO("D:/eclipse-workspace/Web/Resource/sample/02-花.mp3","02-花.mp3");
	}
	
	public static String  getpath(String id) {
		return "D:/eclipse-workspace/Web/Resource/sample/02-花.mp3";
	}
}
