package com.hotmail.ch.leon.familymedia.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hotmail.ch.leon.familymedia.dao.ResourceDao;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;

public class ResourceDaoImpl  implements  ResourceDao {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<ResourceDTO> findList() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
