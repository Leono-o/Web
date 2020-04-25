package com.hotmail.ch.leon.familymedia.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hotmail.ch.leon.familymedia.dao.FileDao;
import com.hotmail.ch.leon.familymedia.dao.dto.FileDTO;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.utils.FmStringUtil;

public class FileDaoImpl implements FileDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<ResourceDTO> findListByFolderId(BigDecimal folderid) {

		String sql = "select id, name , ftype, fsize, cmt from T_file where folder=?";

		List<ResourceDTO> query = template.query(sql, new RowMapper<ResourceDTO>() {

			// 将每行记录封装成ResourceDTO对象
			@Override
			public ResourceDTO mapRow(ResultSet resultSet, int i) throws SQLException {
				ResourceDTO dto = new ResourceDTO();
				dto.setId(resultSet.getBigDecimal("id"));
				dto.setName(FmStringUtil.trim(resultSet.getString("name")));
				dto.setRtype(FmStringUtil.trim(resultSet.getString("ftype")));
				dto.setCmt(FmStringUtil.trim(resultSet.getString("cmt")));

				return dto;
			}

		}, folderid);

		return query;
	}

	@Override
	public FileDTO findByid(BigDecimal folderid) {
		String sql = "select id,folder, name , url, ftype,fsize,cmt from T_file where id=?";
		Map<String, Object> map = template.queryForMap(sql, folderid);

		FileDTO dto = new FileDTO();
		dto.setId((BigDecimal) map.get("id"));
		dto.setFolderBigDecimal((BigDecimal) map.get("folder"));
		dto.setName(FmStringUtil.trim((String) map.get("name")));
		dto.setUrl(FmStringUtil.trim((String) map.get("url")));
		dto.setFtype(FmStringUtil.trim((String) map.get("ftype")));
		dto.setFsize((BigDecimal) map.get("fsize"));
		dto.setCmt(FmStringUtil.trim((String) map.get("cmt")));

		return dto;

	}


}
