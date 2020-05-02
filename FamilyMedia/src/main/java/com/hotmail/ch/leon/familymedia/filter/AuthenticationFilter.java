package com.hotmail.ch.leon.familymedia.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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

		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
