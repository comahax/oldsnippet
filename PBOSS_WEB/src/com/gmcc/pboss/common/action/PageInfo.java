package com.gmcc.pboss.common.action;

import com.gmcc.pboss.common.dictionary.PageLoction;

/**
 * PageLoction 页面位置统一类
 * @author yuwenjun
 * @date Jun 18, 2009
 * 所属项目：PBOSS
 * 所属模块：门户
 * 描述：页面配置信息类，记录
 */
public class PageInfo {
	/**
	 * 主菜单标识
	 */
	private String menuIndex;
	/**
	 * 二级菜单标识
	 */
	private String subMenuIndex;

	/**
	 * 三级菜单标识
	 */
	private String subMenu2Index;
	
	/**
	 * 默认构造函数（指向首页）
	 */
	public PageInfo() {
		this.menuIndex = PageLoction.INDEX;
		this.subMenuIndex = "";
		this.subMenu2Index = "";
	}

	/**
	 * 构造函数
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
