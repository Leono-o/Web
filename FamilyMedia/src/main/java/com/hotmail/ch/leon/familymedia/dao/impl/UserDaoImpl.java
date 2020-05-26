package com.hotmail.ch.leon.familymedia.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hotmail.ch.leon.familymedia.dao.UserDao;
import com.hotmail.ch.leon.familymedia.dao.dto.UserDTO;
import com.hotmail.ch.leon.familymedia.utils.FmStringUtil;

public class UserDaoImpl extends FMDao implements UserDao  {

	@Autowired
	private JdbcTemplate template;

	@Override
	public UserDTO find(String name) {

		String sql = getSQL("UserDao.find");
		
		Map<String, Object> map = null;
		try {
			map = template.queryForMap(sql, FmStringUtil.appendSpace(name, 20));
		} catch (EmptyResultDataAccessException e ) {
			return null;
		}

		UserDTO dto = new UserDTO();
		dto.setName(FmStringUtil.trim((String) map.get("name")));
		dto.setPassword(FmStringUtil.trim((String) map.get("pswd")));		
		dto.setStatus(FmStringUtil.trim((String) map.get("status")));

		return dto;

	}

}
