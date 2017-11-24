package com.asisinfo.common.web;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asisinfo.common.jdbc.PageJdbcTemplate;
import com.asisinfo.common.jdbc.RowMapperFactory;
import com.asisinfo.common.utils.SystemPropertiesUtils;
import com.asisinfo.staff.WebConstant;
import com.asisinfo.staff.bean.Bill;
import com.asisinfo.staff.bean.EmployeesNumber;
import com.asisinfo.staff.service.EmployeesService;
import com.skywin.webserviceclients.uip.AuthResult;
import com.skywin.webserviceclients.uip.UIPServiceIF;
import com.skywin.webserviceclients.uip.UIPService_Impl;
import com.skywin.webserviceclients.uip.UimUserInfo;
import com.skywin.webserviceclients.uip.UserInfo;

/**
by langx
 * 
 */
public class IntegrationSessionFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 4855557396025542297L;
	
	private static Logger log = Logger
			.getLogger(IntegrationSessionFilter.class);
	private static final String NO_PERMISSION_PAGE = "/login.jsp";  //无权限访问

	private static final String COOKIES_NAME = "iPlanetDirectoryPro";  //无权限访问
	
	private PageJdbcTemplate jdbcTemplate;
	// 不需要做权限检查的资源列表，暂时用代码的形式存放，以后应该改成数据库的形式
	private static HashMap freeResource;

	private FilterConfig filterConfig;
	
	private EmployeesService employeesService ;
	
	private String  UIMuser;
	
	private String fullName;
	
	public PageJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(PageJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public EmployeesService getEmployeesService() {
		return employeesService;
	}

	public void setEmployeesService(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}

	public IntegrationSessionFilter() throws Exception {
		// 设置不需要做权限检查的资源列表
		freeResource = new HashMap();

		freeResource.put("/", "");
		freeResource.put("/login.jsp", "");
	}
	
	{
		UIMuser="";
	}
	// Handle the passed-in FilterConfig
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) {
		
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hres = (HttpServletResponse) response;
		
		HttpSession session = hreq.getSession(true);
		String contextPath = hreq.getContextPath();
		/*WebApplicationContext  context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
		employeesService = (EmployeesService) context.getBean("employeesService"); 
		PageJdbcTemplate jdbct = (PageJdbcTemplate)context.getBean("jdbcTemplate");
		employeesService.setJdbcTemplate(jdbct); */
		String  message = ""; //用于保存登陆失败的信息并在登陆界面提示
		int istest = SystemPropertiesUtils.getSystemPropertiesIntValue("test_flag",0);//是否测试登陆
		if (istest == 1) log.info("testtest!!"); //测试日志
		
		try {
			//判断已经登录直接跳过
			EmployeesNumber loginauth = (EmployeesNumber) session.getAttribute(WebConstant.USER_IN_SESSION) ;
			if( loginauth != null ) {
				filterChain.doFilter(request, response);
				return;
			}
			String currentURL = hreq.getRequestURI();
			if (hreq.getQueryString() != null) {
				currentURL = currentURL + "?" + hreq.getQueryString();
			}
			if (currentURL != null) {
				currentURL = currentURL.replaceFirst(contextPath, "");
			}
			
			//判断是可通行URL直接跳过
			if( freeResource.containsKey(currentURL)) {
				filterChain.doFilter(request, response);
				return;
			}
			
			//生产系统获取token
			String token = null;
			try{
				Cookie[] cookies = hreq.getCookies();
				if(null != cookies || istest != 1){  // 找不到cookie 或者是测试就不用本方法
					for(Cookie cookie : cookies ){
						if( cookie.getName().equals(COOKIES_NAME) ){
							token = cookie.getValue();
						}					
					}
					if( token == null ) {
						log.info("URL :\"" +  currentURL  + "\" haven`t  token ");
						hres.sendRedirect(contextPath + NO_PERMISSION_PAGE);
					}
					log.info("token: " +  token );
				}else{
					log.info("cookie is null! ");
					hres.sendRedirect(contextPath + NO_PERMISSION_PAGE);
				}
			}
			catch(Exception ex ) {
				hres.sendRedirect(contextPath + NO_PERMISSION_PAGE);
				log.error("get token is error!!" + ex);
			}
			
			
			if ( istest != 1  ) {
				UimUserInfo info = getUserInfo(token);   // protal验证token，并且获取员工工号
				if( info != null ) {
					//EmployeesNumber loginEmp = new EmployeesNumber();
					String employeeid=info.getEmployee();
					String employee="";
					if(employeeid != null){
						employee = employeeid.substring(2,10);
						log.info("employee: " +  employee );
					}else{
						hres.sendRedirect(contextPath + NO_PERMISSION_PAGE);
						return;
					}
				
					EmployeesNumber emp1 = findStaff(employee, request);
				  	if(null == emp1) {hres.sendRedirect(contextPath + NO_PERMISSION_PAGE);}
				  	
				}else{
					hres.sendRedirect(contextPath + NO_PERMISSION_PAGE);
				}
			}
			filterChain.doFilter(request, response);
		}catch( Exception ex ) {
			ex.printStackTrace();
			log.error(ex);
		} 
	}
	
	public EmployeesNumber findStaff(String employee,ServletRequest request ){
		EmployeesNumber emp =  employeesService.getEmployeesByID(employee);
		
		//SET LOGIN USER
		if(emp != null){
			//log.info("emp is not null!!!");
			log.info("emp is not null,phone:"+ emp.getSvrnum());
			log.info("emp is not null,name:"+ emp.getStaffname());
			((HttpServletRequest)request).getSession().setAttribute(WebConstant.USER_IN_SESSION, emp);
			//SET LOGIN PERMIT	
			((HttpServletRequest)request).getSession().setAttribute("names", emp.getStaffname());
			((HttpServletRequest)request).getSession().setAttribute("attrs", emp.getStaffattr());
			//((HttpServletRequest)request).getSession().setAttribute("loginperm",employeesService.getPermit(loginEmp.getStaffid()));
			((HttpServletRequest)request).getSession().setAttribute("loginperm",employeesService.getPermit(emp.getStaffid()));
			return emp;
		}else{
			return null; //  登陆用到
		}	
	} 
	
	
	private boolean getTestUserInfo( String token ) {
		return true;
	}
	
	private UimUserInfo getUserInfo( String token ){
		//以下是测试帐号的验证操作
		//如果要访问生成请提接入申请后，把UIPServiceIF_Stub.java上把测试地址注释掉，再把以下的systemId,loginId,loginPwd都改为分配的参数
		UIPService_Impl impl = new UIPService_Impl();
		UIPServiceIF uip = impl.getUIPServiceIFPort();
		List<UimUserInfo> info = null;
		//参数1 当前登录PORTAL用户的令牌,该值可以从彩信的request.getCookie()上遍历到，该值的名字为：iPlanetDirectoryPro
		//String token = "AQIC5wM2LY4Sfcy7UB5CvbckB7TqgDF22YB3Mad+9Vclp+k=@AAJTSQACMDU=#";//
		//参数2 为portal分配的系统ID，该值需要提接入申请单给PORTAL进行备案
		//String systemId = "UIPTEST_ACCESSRIGHT";
		
		String systemId = SystemPropertiesUtils.getSystemPropertiesStringValue("sso_systemid");
		try {
			AuthResult result = uip.validateToken(token, systemId);//验证portal令牌
			log.info("result.isAuthResult()："+result.isAuthResult()); //验证结果
			if(result.isAuthResult()){ //令牌验证成功
				String queryUser = result.getAccount();
				log.info("queryUser："+queryUser);
				info = getEmployeesService().getUserInfoUserID(queryUser);
				
				for(int t=0;t<info.size();t++){
					UimUserInfo infos=(UimUserInfo) info.get(0);					
					log.info("TelePhone："+infos.getTelePhone());
					log.info("Employee："+infos.getEmployee());
				}
				
			}else{
				log.info("令牌验证失败.因原是："+result.getAuthMsg());
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return  info.get(0);
	}
	
	
}
