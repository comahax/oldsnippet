package com.sunrise.jop.ui.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;

public class LoginCheckFilter implements Filter{

	private static final String NO_SIGNON_PAGE = "/errorpage/require_login.jsp";
	
	// ����Ҫ��Ȩ�޼�����Դ�б���ʱ�ô������ʽ��ţ��Ժ�Ӧ�øĳ����ݿ����ʽ
	private static Map freeResource;
	
	public LoginCheckFilter(){
		// ���ò���Ҫ��Ȩ�޼�����Դ�б�
		freeResource = new HashMap();
		freeResource.put("/", "");
		freeResource.put("/login.jsp", "");
		freeResource.put("/login2.jsp", "");
		freeResource.put("/login.do", "");
		freeResource.put("/login2.do", "");
		freeResource.put("/logout.do", "");
		freeResource.put("/errorpage/require_login.jsp", "");
		freeResource.put("/errorpage/nopermission.jsp", "");
		freeResource.put("/cityselect.do", "");
		freeResource.put("/cityselect.jsp", "");
		freeResource.put("/loginprov.do", "");
		freeResource.put("/loginprov2.do", "");
		freeResource.put("/loginprov.jsp", "");
		freeResource.put("/resendSms.do", "");
		freeResource.put("/changecity.do", "");
		freeResource.put("/login2ngauth.jsp", "");
		freeResource.put("/login2ngauth.do", "");
		freeResource.put("/login2smscity.jsp", "");
		freeResource.put("/login2smscity.do", "");
	}
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String currentURL = request.getRequestURI();
		
		if(isProtectedResource(currentURL)){
			User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
			if (user != null) {
				
			} else {
				String contextPath = request.getContextPath();
				String errorStr = "<script>top.location.href='"+contextPath+"/errorpage/require_login.jsp';</script>";
				PrintWriter pw = response.getWriter();
				pw.write(errorStr);
				return;
			}
		}
		filterChain.doFilter(request, response);
	}
	
	private boolean isProtectedResource(String currentURL){
		return !freeResource.containsKey(currentURL);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
