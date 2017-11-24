package com.gmcc.pboss.common.cookie;

import javax.servlet.http.Cookie;
import com.gmcc.pboss.common.dictionary.Regex;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-4
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class MenuCookie extends Cookie {
	
	public static final String FLAGE = "MENU";
	/**�������*/
	private int clickTimes ;
	
	/**�û�*/
	private String user;
	
	/**�˵�����*/
	private String menuName;
	
	/**�˵�URL*/
	private String menuURL;
	
	public MenuCookie(String user, String menuName, String menuURL, int clickTimes) {
		super(editName(user,menuURL), editValue(menuName, menuURL, clickTimes));
	}
	
	/**
	 * �༭Cookie�е�value
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
	 * �༭Cookie�е�name
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
