package com.gmcc.pboss.biz.basic.goods.bean;

import java.util.Date;
import java.util.List;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-17
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：套卡包
 */
public class SuitCardPackage extends Goods{
	/**包号*/
	private String packageNo;
	/**发布时间*/
	private Date publicTime;
	/**套卡列表*/
	private List suitCardList;
	
	/**包号*/
	public String getPackageNo() {
		return packageNo;
	}
	/**包号*/
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}
	
	/**发布时间*/
	public Date getPublicTime() {
		return publicTime;
	}
	/**发布时间*/
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}
	
	/**套卡列表*/
	public List getSuitCardList() {
		return suitCardList;
	}
	/**套卡列表*/
	public void setSuitCardList(List suitCardList) {
		this.suitCardList = suitCardList;
	}
	
	
}
