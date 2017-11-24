package com.gmcc.pboss.common.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.FilterDispatcher;

public class Struts2Filter extends FilterDispatcher{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		if( null != request.getRequestURI() && request.getRequestURI().contains("js/fckeditor/editor/filemanager/connectors/"))
			chain.doFilter(req, res);
		else
		super.doFilter(req, res, chain);
	}

}
