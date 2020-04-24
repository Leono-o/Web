package com.hotmail.ch.leon.familymedia.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hotmail.ch.leon.familymedia.dao.ResourceDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.utils.FmStringUtil;

public class ResourceDaoImpl  implements  ResourceDao {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<ResourceDTO> findList(String owner) {


		String sql = "select id, name , url, owner, gname from T_resource where owner=?";
		 
        List<ResourceDTO> query = template.query(sql, new RowMapper<ResourceDTO>() {
 
            //将每行记录封装成ResourceDTO对象
            @Override
            public ResourceDTO mapRow(ResultSet resultSet, int i) throws SQLException {
            	ResourceDTO dto = new ResourceDTO();
            	dto.setId(resultSet.getLong("id"));
            	dto.setName(resultSet.getString("name"));
            	dto.setUrl(resultSet.getString("url"));
            	dto.setOwner(resultSet.getString("owner"));
            	dto.setGname(resultSet.getString("gname"));
 
                return dto;
            }
 
        },FmStringUtil.appendSpace(owner,20));
        
        
        return query;
	}

	@Override
	public ResourceDTO find(long id) {
		String sql = "select id, name , url, owner, gname from T_resource where id=?";
		Map<String, Object> map = template.queryForMap(sql, id);

		ResourceDTO dto = new ResourceDTO();
		dto.setId(((BigDecimal) map.get("id")).longValue());
		dto.setName((String) map.get("name"));
		dto.setUrl((String) map.get("url"));
		dto.setOwner((String) map.get("owner"));
		dto.setGname((String) map.get("gname"));

		return dto;

	}
	

}
