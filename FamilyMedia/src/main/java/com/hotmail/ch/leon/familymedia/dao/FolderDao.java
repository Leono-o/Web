package com.hotmail.ch.leon.familymedia.dao;

import java.math.BigDecimal;

import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;

public interface FolderDao  {
	
	public FolderDTO findByid(BigDecimal folderid) ;

}
