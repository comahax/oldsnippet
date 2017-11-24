package com.gmcc.pboss.common.utils.tools;
/**
 * 促销方案（搭售/赠送）接口方法 返回的信息包装类
 * @author zhangsiwei
 *
 */
public class TiedComInfo {
	// 方案标识
	private long pid;
	// 规则标识
	private long ruleid;
	// (搭售/赠送)商品种类
	private String tComCategory;
	// (搭售/赠送)商品数量
	private int tQuantity;
	
	
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public long getRuleid() {
		return ruleid;
	}
	public void setRuleid(long ruleid) {
		this.ruleid = ruleid;
	}
	public String getTComCategory() {
		return tComCategory;
	}
	public void setTComCategory(String comCategory) {
		tComCategory = comCategory;
	}
	public int getTQuantity() {
		return tQuantity;
	}
	public void setTQuantity(int quantity) {
		tQuantity = quantity;
	}
	
	

}
