package com.gmcc.pboss.common.action;

import com.gmcc.pboss.common.dictionary.PageLoction;

/**
 * PageLoction ҳ��λ��ͳһ��
 * @author yuwenjun
 * @date Jun 18, 2009
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż�
 * ������ҳ��������Ϣ�࣬��¼
 */
public class PageInfo {
	/**
	 * ���˵���ʶ
	 */
	private String menuIndex;
	/**
	 * �����˵���ʶ
	 */
	private String subMenuIndex;

	/**
	 * �����˵���ʶ
	 */
	private String subMenu2Index;
	
	/**
	 * Ĭ�Ϲ��캯����ָ����ҳ��
	 */
	public PageInfo() {
		this.menuIndex = PageLoction.INDEX;
		this.subMenuIndex = "";
		this.subMenu2Index = "";
	}

	/**
	 * ���캯��
	 * @param menuIndex
	 * @param subMenuIndex
	 * @param subMenu2Index
	 */
	public PageInfo(String menuIndex, String subMenuIndex, String subMenu2Index) {
		super();
		this.menuIndex = menuIndex;
		this.subMenuIndex = subMenuIndex;
		this.subMenu2Index = subMenu2Index;
	}

	/**
	 * @return the menuIndex
	 */
	public String getMenuIndex() {
		return menuIndex;
	}

	/**
	 * @param menuIndex the menuIndex to set
	 */
	public void setMenuIndex(String menuIndex) {
		this.menuIndex = menuIndex;
	}

	/**
	 * @return the subMenuIndex
	 */
	public String getSubMenuIndex() {
		return subMenuIndex;
	}

	/**
	 * @param subMenuIndex the subMenuIndex to set
	 */
	public void setSubMenuIndex(String subMenuIndex) {
		this.subMenuIndex = subMenuIndex;
	}

	/**
	 * @return the subMenu2Index
	 */
	public String getSubMenu2Index() {
		return subMenu2Index;
	}

	/**
	 * @param subMenu2Index the subMenu2Index to set
	 */
	public void setSubMenu2Index(String subMenu2Index) {
		this.subMenu2Index = subMenu2Index;
	}
	
	
}
