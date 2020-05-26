package com.hotmail.ch.leon.familymedia.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hotmail.ch.leon.familymedia.dao.GroupDao;
import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.utils.FmStringUtil;

public class GroupDaoImpl extends FMDao implements GroupDao  {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<ResourceDTO> findFolderListByUserName(String userName, String ftype) {

		String sql = getSQL("GroupDao.findFolderListByUserName");

		List<ResourceDTO> query = template.query(sql, new RowMapper<ResourceDTO>() {
			// 将每行记录封装成ResourceDTO对象
			@Override
			public ResourceDTO mapRow(ResultSet resultSet, int i) throws SQLException {
				ResourceDTO dto = new ResourceDTO();
				dto.setId(resultSet.getBigDecimal("id").toPlainString());
				dto.setName(FmStringUtil.trim(resultSet.getString("name")));
				return dto;
			}

		}, 
				FmStringUtil.appendSpace(userName, 20), 
				FmStringUtil.appendSpace(ftype, 1));

		return query;
	}

		
	@Override
	public FolderDTO findByid(String userName, BigDecimal folderid) {
		String sql = getSQL("GroupDao.findByid");
		
		Map<String, Object> map = null;
		try {
			map = template.queryForMap(sql, FmStringUtil.appendSpace(userName, 20), folderid);
		} catch (EmptyResultDataAccessException e ) {
			return null;
		}
		
		FolderDTO dto = new FolderDTO();
		dto.setId((BigDecimal) map.get("id"));
		dto.setUrl(FmStringUtil.trim((String) map.get("url")));
		dto.setName(FmStringUtil.trim((String) map.get("name")));		
		dto.setGname(FmStringUtil.trim((String) map.get("gname")));
		dto.setFtype(FmStringUtil.trim((String) map.get("ftype")));		

		return dto;

	}

}
