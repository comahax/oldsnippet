package com.sunrise.jop.ui.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.web.common.login.LoginUtils;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;

public class PermissionFilter implements Filter {

	private static HashMap freeResource;// 不需要做权限检查的资源列表，暂时用代码的形式存放，以后可以改成数据库或配置文件的形式

	// 2008-12-10 jinbo 变更为失效后跳转到根，避免登录页面刷新在网页子框架里
	private static final String NO_LOGIN_PAGE = "/common/returnsys.html"; 

	private static final String NO_PERM_PAGE = "/errorpage/nopermission.htm"; 
	
	private static final String DENY_PERM_PAGE = "/errorpage/permission_deny.htm"; 
	
	private static Log log = LogFactory.getLog(PermissionFilter.class);
	
	public void init(FilterConfig filterConfig) throws ServletException {
		freeResource = new HashMap();
		
		if (CoreConfigInfo.LOGIN_FLAG) { // 简易开关，方便测试时使用
			freeResource.put("/", null);
			freeResource.put("/login.jsp", null);
			freeResource.put("/login.do", null);	
		}
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		try {
			HttpServletRequest hreq = (HttpServletRequest) request;
			HttpServletResponse hres = (HttpServletResponse) response;
			String contextPath = hreq.getContextPath();
			String currentURI = hreq.getRequestURI();// 当前要访问的Url
								
			if (currentURI != null) {
				currentURI = currentURI.replaceFirst(contextPath, "");
			}

			if (isProtectedResource(currentURI)) { // 判断是否是受保护资源
				if (isOtherSystemRequest(hreq)) { // 判断是否是集成环境
					if (!"/index.jsp".equals(currentURI)) { // 限制入口只能是index.jsp页面
						hres.sendRedirect(contextPath + DENY_PERM_PAGE); 
						return;
					}
					String system = hreq.getParameter("system");
					String token = hreq.getParameter("token");
					String region = hreq.getParameter("region");
					//目前只集成在从兴CRM和华为CRM
					if(!"CXNGCRM".equals(system) && !"HWNGCRM".equals(system)) {
						log.warn("Unknown request source!");
						hres.sendRedirect(contextPath + DENY_PERM_PAGE);
						return;
					}
					
					User user = (User) hreq.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
					if (user == null ||
							(user != null && (
									(user.getSystem() != null && !system.equals(user.getSystem())) || 
									(user.getToken() != null && !token.equals(user.getToken())) ||
									(user.getCityid() != null && !region.equals(user.getCityid()))
									)
							)
						) {
						user = new User();
						user.setSystem(system);
						user.setToken(token);
						user.setCityid(region);					
						
						if(!SSOCheck(user, token)){
							// 保存登录日志-登录失败
							LoginUtils.saveLoginLog(new Byte("0"), "鉴权验证不通过", user); 
							
							hres.sendRedirect(contextPath + DENY_PERM_PAGE); 
							return;
						}
						// 通过认证后才设置用户
						user.setIp(request.getRemoteHost());
						hreq.getSession().setAttribute(WebConstant.SESSION_ATTRIBUTE_USER, user);
						// 保存登录日志-登录成功
						LoginUtils.saveLoginLog(new Byte("1"), null, user); 
					}
					
				} else {
					if (hreq.getQueryString() != null) {
						currentURI = currentURI + "?" + hreq.getQueryString(); // 得到带参数的地址串
					}
					User user = (User) hreq.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
					if (user == null) {
						log.info("web请求未登录:" + currentURI );
						if (CoreConfigInfo.LOGIN_FLAG) {
							hres.sendRedirect(contextPath + NO_LOGIN_PAGE);
						} else {
							hres.sendRedirect(contextPath + DENY_PERM_PAGE);
						}
						return;
						
					} else {
						//菜单鉴权
						if (!checkPermission(currentURI, user)) {
							hres.sendRedirect(contextPath + NO_PERM_PAGE);
							return;
						}
					}
				}
								
			}
			filterChain.doFilter(request, response);
		} catch (Exception sx) {
			sx.printStackTrace();
			throw new ServletException(sx);
		}

	}

	private boolean checkPermission(String currentURI, User user) throws Exception {		
		PermissionChecker checker = (PermissionChecker) InterfaceUtils.getInstance().createImplObject(PermissionChecker.class);
		
		boolean hasPermission = checker.checkURIPermission(currentURI, user);
		log.info("检查权限:oprcode: " + user.getOprcode() + ",currentURI:" + currentURI + ", hasPermission? " + hasPermission );
		return hasPermission;
	}

	/**
	 *  判断是否是受保护资源
	 */
	private boolean isProtectedResource(String currentURI) throws Exception {
		return !freeResource.containsKey(currentURI);
	}
	/**
	 *  判断是否是集成环境
	 */
	private boolean isOtherSystemRequest(HttpServletRequest hreq) {
		String system = hreq.getParameter("system");
		String token = hreq.getParameter("token");
		String region = hreq.getParameter("region");
		
		if (system != null && token != null && region != null) {
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 反向鉴权，查询操作员是否有令牌的权限
	 * @param user
	 * @param ssotoken
	 * @return
	 */
	public boolean SSOCheck(User user, String tokenid){
		return com.sunrise.boss.common.client.sso.PublicService.validateToken(user, tokenid);
	}

}
