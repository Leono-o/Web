package com.hotmail.ch.leon.familymedia.dao;

import java.math.BigDecimal;
import java.util.List;

import com.hotmail.ch.leon.familymedia.dao.dto.FileDTO;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;

public interface FileDao  {
	public List<ResourceDTO> findListByFolderId(BigDecimal folderid) ;
	
	public FileDTO findByid(BigDecimal folderid) ;

}
