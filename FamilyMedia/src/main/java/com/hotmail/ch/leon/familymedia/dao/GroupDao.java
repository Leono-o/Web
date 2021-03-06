package com.hotmail.ch.leon.familymedia.dao;

import java.math.BigDecimal;
import java.util.List;

import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;

public interface GroupDao  {
	public List<ResourceDTO> findFolderListByUserName(String user, String ftype) ;
	
	public FolderDTO findByid(String user, BigDecimal folderid) ;

}
