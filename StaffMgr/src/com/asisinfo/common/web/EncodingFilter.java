/**
 * Copyright(c)1994-2007 SRE. All rights reserved.<br>
 * Use is subject to license terms.
 */
package com.asisinfo.common.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import com.asisinfo.staff.utils.RequestHolder;*/

/**
 * @author chenhm
 * @created 2007-4-2 下午08:12:36
 * @version 1.0
 */
public class EncodingFilter implements Filter {
	private String defaultEncoding = "GBK";

	public void init(FilterConfig config) throws ServletException {
		if (config.getInitParameter("defaultEncoding") != null) {
			this.defaultEncoding = config.getInitParameter("defaultEncoding");
		}
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
	//	RequestHolder.setHttpServletRequest(request);

		String encode = request.getCharacterEncoding();
		request.setCharacterEncoding((encode != null) ? encode
				: defaultEncoding);
		response.setCharacterEncoding((encode != null) ? encode
				: defaultEncoding);
		

		// 防止IE缓存
//		response.setHeader("Pragma", "No-cache"); // HTTP 1.0
//		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setDateHeader("Expires", -1); // HTTP 1.1

		// 将通用参数放入requestScope
		request.setAttribute("base", request.getContextPath());
		request.setAttribute("pageuri", request.getRequestURI()); // 原始的请求URI
		chain.doFilter(req, res);
		
	//	RequestHolder.setHttpServletRequest(null);
	}

	private String getEncoding() {
		return defaultEncoding;
	}

	protected String getContentType() {
		return "text/html; charset=" + getEncoding();
	}

	public void destroy() {

	}
}
