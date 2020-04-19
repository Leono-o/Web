package com.hotmail.ch.leon.familymedia.logic;

import com.hotmail.ch.leon.familymedia.consts.ContentType;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;

public class ResouceLogic {
	public static FileInfoDTO getFileInfo(String id) {
		if ("121".equals(id)) {
			//return new FileInfoDTO("S:/H/H/泳装/Blue Onepiece Swimsuit - Playing in the Pool.m4v", "aa.m4v",ContentType.M4V.value());
			return new FileInfoDTO("S:/H/H/EVN5WO327.mp4", "aa.mp4",ContentType.MP4.value());
			//
		} else {
			return new FileInfoDTO("V:/music/山口百惠/ありがとうあなた.mp3","ありがとうあなた.mp3",ContentType.MP3.value());
		}
	}
	
	public static String  getpath(String id) {
		return "D:/eclipse-workspace/Web/Resource/sample/02-花.mp3";
	}
}
