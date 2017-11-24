package com.sunrise.boss.ui.cms.commons;

/**
 * 申请资源（商品、sim卡、积分卡）
 * @author gy
 *
 */
public class ApplyResBean {
	
	private String resname; // 申请资源名称

	private String resid; // 申请资源标识

	private String price; // 申请资源单价

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getResid() {
		return resid;
	}

	public void setResid(String resid) {
		this.resid = resid;
	}

	public String getResname() {
		return resname;
	}

	public void setResname(String resname) {
		this.resname = resname;
	}
}
