package com.gmcc.pboss.common.cookie;

import javax.servlet.http.Cookie;
import com.gmcc.pboss.common.dictionary.Regex;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-11-4
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class MenuCookie extends Cookie {
	
	public static final String FLAGE = "MENU";
	/**点击次数*/
	private int clickTimes ;
	
	/**用户*/
	private String user;
	
	/**菜单名称*/
	private String menuName;
	
	/**菜单URL*/
	private String menuURL;
	
	public MenuCookie(String user, String menuName, String menuURL, int clickTimes) {
		super(editName(user,menuURL), editValue(menuName, menuURL, clickTimes));
	}
	
	/**
	 * 编辑Cookie中的value
	 * @param menuName
	 * @param menuURL
	 * @param clickTimes
	 * @return
	 */
	public static String editValue(String menuName, String menuURL, int clickTimes){
		String value = "";
		
		StringBuffer sb = new StringBuffer();
		sb.append(menuName).append(Regex.WAVE)
		  .append(menuURL).append(Regex.WAVE)
		  .append(clickTimes);
		
		value = CookieUtil.encodeValue(sb.toString());
		
		//return sb.toString();
		return value;

	}
	
	/**
	 * 编辑Cookie中的name
	 * @param user
	 * @param menuURL
	 * @return
	 */
	public static String editName(String user, String menuURL){
		StringBuffer sb = new StringBuffer();
		sb.append(user).append(Regex.WAVE)
		  .append(FLAGE).append(Regex.WAVE)
		  .append(menuURL);
		return sb.toString();
	}
	/****************************Getter And Setter************************************/
	public int getClickTimes() {
		return clickTimes;
	}

	public void setClickTimes(int clickTimes) {
		this.clickTimes = clickTimes;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
}
