package com.hotmail.ch.leon.familymedia.dao.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hotmail.ch.leon.familymedia.dao.FolderDao;
import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;
import com.hotmail.ch.leon.familymedia.utils.FmStringUtil;

public class FolderDaoImpl implements FolderDao {

	@Autowired
	private JdbcTemplate template;

	
	@Override
	public FolderDTO findByid(BigDecimal folderid) {
		String sql = "select id,parent,url, gname, ftype,name from T_folder where id=?";
		Map<String, Object> map = template.queryForMap(sql, folderid);

		FolderDTO dto = new FolderDTO();
		dto.setId((BigDecimal) map.get("id"));
		dto.setParent((BigDecimal) map.get("parent"));
		dto.setUrl(FmStringUtil.trim((String) map.get("url")));
		dto.setName(FmStringUtil.trim((String) map.get("name")));		
		dto.setGname(FmStringUtil.trim((String) map.get("gname")));
		dto.setFtype(FmStringUtil.trim((String) map.get("ftype")));		

		return dto;

	}


}
