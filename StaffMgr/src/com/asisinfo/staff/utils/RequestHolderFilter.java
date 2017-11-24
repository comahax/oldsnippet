package com.asisinfo.staff.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.asisinfo.staff.utils.RequestHolder;
/**
 * 把request请求缓存到threadlocal变量中，方便在其他地方获取request
 * @author Administrator
 *
 */
public class RequestHolderFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		RequestHolder.setHttpServletRequest((HttpServletRequest)request);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
