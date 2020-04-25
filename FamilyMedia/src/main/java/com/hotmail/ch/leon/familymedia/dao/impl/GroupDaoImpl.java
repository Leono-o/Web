package com.hotmail.ch.leon.familymedia.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hotmail.ch.leon.familymedia.dao.GroupDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.utils.FmStringUtil;

public class GroupDaoImpl implements GroupDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<ResourceDTO> findFolderListByUserName(String userName, String ftype) {

		String sql = "select t_group.gname, t_folder.name, t_folder.id from t_group, t_folder where t_group.name=? and t_group.gname=t_folder.gname and t_folder.ftype=? and t_folder.parent='0'";

		List<ResourceDTO> query = template.query(sql, new RowMapper<ResourceDTO>() {

			// 将每行记录封装成ResourceDTO对象
			@Override
			public ResourceDTO mapRow(ResultSet resultSet, int i) throws SQLException {
				ResourceDTO dto = new ResourceDTO();
				dto.setId(resultSet.getBigDecimal("id"));
				dto.setName(FmStringUtil.trim(resultSet.getString("name")));
				return dto;
			}

		}, 
				FmStringUtil.appendSpace(userName, 20), 
				FmStringUtil.appendSpace(ftype, 1));

		return query;
	}

	@Override
	public List<ResourceDTO> findFolderListByFolderid(String userName, BigDecimal folderid, String ftype) {
		
		String sql = "select t_group.gname, t_folder.name, t_folder.id from t_group, t_folder where t_group.name=? and t_group.gname=t_folder.gname and t_folder.parent=? and t_folder.ftype=?";

		List<ResourceDTO> query = template.query(sql, new RowMapper<ResourceDTO>() {

			// 将每行记录封装成ResourceDTO对象
			@Override
			public ResourceDTO mapRow(ResultSet resultSet, int i) throws SQLException {
				ResourceDTO dto = new ResourceDTO();
				dto.setId(resultSet.getBigDecimal("id"));
				dto.setName(FmStringUtil.trim(resultSet.getString("name")));
				return dto;
			}

		}, 
				FmStringUtil.appendSpace(userName, 20), 
				folderid, 
				FmStringUtil.appendSpace(ftype, 1));

		return query;
	}


}
