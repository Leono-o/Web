package com.hotmail.ch.leon.familymedia.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.hotmail.ch.leon.familymedia.dao.UserDao;
import com.hotmail.ch.leon.familymedia.dao.dto.UserDTO;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;

public class AuthenticationFilter implements Filter {

	private boolean bSkip = false;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
		String skipString = filterConfig.getInitParameter("skip");
		if ("true".equals(skipString)) {
			bSkip = true;
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (bSkip) {
			chain.doFilter(request, response);
			return;
		}

		if (checkAuthentication((HttpServletRequest)request, (HttpServletResponse)response)) {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	private boolean checkAuthentication(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			session = request.getSession(true);
			session.setAttribute("user", "-");
		}
		
		String sessionUser = (String)session.getAttribute("user");
		String newUser = request.getParameter("user");
		
		if (sessionUser.equals(newUser)) {
			return true;
		}
		
		if ("-".equals(newUser)) {
			session.setAttribute("user", newUser);
			return true;
		}
		
		if (StringUtils.isEmpty(newUser)) {
			return true;
		}
		
		String token = request.getParameter("token");
		
		if (StringUtils.isEmpty(token)) {
			//401
			response.setStatus(401);
			return false;
		} else {
			UserDao dao = FmBeanFactory.getDao(UserDao.class);
			UserDTO result = dao.find(newUser);
				
			if (result != null && token.equals(result.getPassword())) {
				session.setAttribute("user", newUser);
				return true;
			}
		}
		
		response.setStatus(401);
		return false;
	}
}
