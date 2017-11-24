package com.sunrise.pub.filter;

import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: PBOSS
 * </p>
 * <p/>
 * <p>
 * Description:
 * </p>
 * <p/>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p/>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author hbm
 * @version 1.0
 * 
 */
public class IntegrationSessionFilter extends HttpServlet implements Filter {

	private static Logger log = Logger.getLogger(IntegrationSessionFilter.class);

	private static final String NO_SIGNON_PAGE = "/errorpage/require_login.htm";

	private static final String SECRETSTRING = "PBOSS-REWARD";

	private static final String PROVINCE_FLAG = "999";

	// 不需要做权限检查的资源列表，暂时用代码的形式存放，以后应该改成数据库的形式
	private static HashMap freeResource;

	private FilterConfig filterConfig;

	public IntegrationSessionFilter() throws Exception {
		// 设置不需要做权限检查的资源列表
		freeResource = new HashMap();
		if (SysInfo.getInstance().LOGINFLAG) {
			freeResource.put("/", "");
			freeResource.put("/login.jsp", "");
			freeResource.put("/login.jsp?flag=y", "");
			freeResource.put("/login.do", "");
			freeResource.put("/login.do?CMD=LIST", "");
			freeResource.put("/admin/logincase.do?CMD=LIST", "");
			freeResource.put("/admin/logincase.do?CMD=NEW", "");
			freeResource.put("/admin/logincase.do?CMD=DELETE", "");
		}
	}

	// Handle the passed-in FilterConfig
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
		try {
			HttpServletRequest hreq = (HttpServletRequest) request;
			HttpServletResponse hres = (HttpServletResponse) response;
			String contextPath = hreq.getContextPath();

			String currentURL = hreq.getRequestURI();
			if (hreq.getQueryString() != null) {
				currentURL = currentURL + "?" + hreq.getQueryString();
			}
			if (currentURL != null) {
				currentURL = currentURL.replaceFirst(contextPath, "");
			}

			if (isProtectedResource(currentURL)) {// 如果是受保护的资源，需要做一些判断
				boolean isOtherSystem = isOtherSystemRequest(hreq);
				if (isOtherSystem) {// 外部系统
					String secretString = hreq.getParameter("secretString");
					if (!secretString(secretString)) {
						log.info("secretString is incorrect! " + currentURL);
						hres.sendRedirect(contextPath + NO_SIGNON_PAGE);
						return;
					}

					String opercode = hreq.getParameter("opercode");
					String opername = hreq.getParameter("opername");
					String cityid = hreq.getParameter("cityid");
					String wayid = hreq.getParameter("wayid");

					if (null == opercode || null == cityid || null == wayid) {
						hres.sendRedirect(contextPath + NO_SIGNON_PAGE);
						return;
					}

					HttpSession session = hreq.getSession(true);
					if (session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER) == null) { // 首次登陆
						User user = new User();
						user.setOpercode(opercode);
						user.setOpername(opername);
						user.setWayid(wayid);
						user.setCityid(cityid);
						if (PROVINCE_FLAG.equals(cityid)) {
							user.setProvinceUser(true);
						}
						session.setAttribute(WebConstant.SESSION_ATTRIBUTE_USER, user);
						System.out.println(user); // 打印到控制台
					} else {
						User oldUser = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
						if (!opercode.equals(oldUser.getOpercode()) || !cityid.equals(oldUser.getCityid()) || !wayid.equals(oldUser.getWayid())) { // 更换用户登陆(添加了退出通知后，应该没有这个情况了)
							User user = new User();
							user.setOpercode(opercode);
							user.setOpername(opername);
							user.setWayid(wayid);
							user.setCityid(cityid);
							if (PROVINCE_FLAG.equals(cityid)) {
								user.setProvinceUser(true);
							}
							session.setAttribute(WebConstant.SESSION_ATTRIBUTE_USER, user);
							System.out.println(user); // 打印到控制台
							oldUser = null;
						}
					}
				} else {// 本系统
					HttpSession session = hreq.getSession(true);
					if (session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER) == null) {
						hres.sendRedirect(contextPath + NO_SIGNON_PAGE);
						return;
					}
				}
			}
			// 正常，继续
			filterChain.doFilter(request, response);
		} catch (Exception ex) {
			filterConfig.getServletContext().log(ex.getMessage(), ex);
		}
	}

	private boolean isOtherSystemRequest(HttpServletRequest hreq) {
		String secretString = hreq.getParameter("secretString");
		String opercode = hreq.getParameter("opercode");
		String cityid = hreq.getParameter("cityid");
		String wayid = hreq.getParameter("wayid");
		if (secretString != null && opercode != null && cityid != null && wayid != null) {
			return true;
		} else {
			return false;
		}
	}

	// Clean up resources
	public void destroy() {
		filterConfig = null;
	}

	private boolean isProtectedResource(String currentURL) throws Exception {
		return !freeResource.containsKey(currentURL);
	}

	private boolean secretString(String secretStr) {
		// 确定加密算法后再做认证

		if (secretStr != null && secretStr.equals(SECRETSTRING))
			return true;
		else
			return false;

	}
}
