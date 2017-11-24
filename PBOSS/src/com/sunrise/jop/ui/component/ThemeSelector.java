/**
 * 
 */
package com.sunrise.jop.ui.component;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.jop.common.spring.SpringContextManager;

/**
 * ���淽��ѡ������֧���û��ڽ���ѡ����ʾ������ һ����������Ӧһ��cssĿ¼�µ���Ŀ¼
 * @author He Kun
 *
 */
public class ThemeSelector {
	
	private String[] themes;
	
	private String defaultTheme = "default"; //dir: css/default/
	
	public String[] getThemes() {
		return themes;
	}

	public void setThemes(String[] themes) {
		this.themes = themes;
	}

	public String getDefaultTheme() {
		return defaultTheme;
	}

	public void setDefaultTheme(String defaultTheme) {
		this.defaultTheme = defaultTheme;
	}
	
	public static String getCurrentTheme(HttpServletRequest request) {
		String currentTheme = "default";
		try {
			ThemeSelector themeSelector = (ThemeSelector)SpringContextManager.getBean("ThemeSelector");
			currentTheme = themeSelector.getDefaultTheme();
		}catch(Exception e) {
			
		}
		
		if( request.getParameter("theme")!=null)  {
			currentTheme = request.getParameter("theme");
			//Cookie[] cookies = request. ���õ�cookie
			
			request.getSession().setAttribute("theme",currentTheme);
			
		}else if(request.getSession().getAttribute("theme")!=null) {
			currentTheme = (String)request.getSession().getAttribute("theme");
		}
		return currentTheme;
	}
}
