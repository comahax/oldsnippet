package com.gmcc.pboss.common.bean;

import com.gmcc.pboss.common.dictionary.Regex;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-4
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������˵�bean
 */
public class MenuBean implements Comparable<MenuBean>{
	
	private String name;
	private String url;
	private int clickTimes;
	
	
	/**
	 * ����Cookie��value����˵�bean
	 * PS:value�Ľṹ�����ǣ�menuName~menuURL~clickTimes
	 * @param cookieValue
	 */
	public MenuBean(String cookieValue) {
		String[]t = cookieValue.split(Regex.WAVE);
		this.name = t[0];
		this.url = t[1];
		this.clickTimes = Integer.parseInt(t[2]);
	}

	public int compareTo(MenuBean mb) {
		return ( mb.getClickTimes() - this.clickTimes);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getClickTimes() {
		return clickTimes;
	}

	public void setClickTimes(int clickTimes) {
		this.clickTimes = clickTimes;
	}
	
	
	
	
}
