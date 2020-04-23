package com.hotmail.ch.leon.familymedia.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hotmail.ch.leon.familymedia.dao.ResourceDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;

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
 
        },owner);
        
        
        return query;
	}

	@Override
	public ResourceDTO find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
