package com.gmcc.pboss.common.bean;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-2
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：URL权限
 */
public class URLAuthority {

	public String unLoginJSP;
	public String unLoginAction;
	public String shopMaster;
	public String shopAssistant;
	public String deliveryMan;
	public String manager;
	public String missioner;
	public String gdmanager;
	public String citymanager;
	
	public String getUnLoginJSP() {
		return unLoginJSP;
	}
	public void setUnLoginJSP(String unLoginJSP) {
		this.unLoginJSP = unLoginJSP;
	}
	public String getUnLoginAction() {
		return unLoginAction;
	}
	public void setUnLoginAction(String unLoginAction) {
		this.unLoginAction = unLoginAction;
	}
	public String getShopMaster() {
		return shopMaster;
	}
	public void setShopMaster(String shopMaster) {
		this.shopMaster = shopMaster;
	}
	public String getShopAssistant() {
		return shopAssistant;
	}
	public void setShopAssistant(String shopAssistant) {
		this.shopAssistant = shopAssistant;
	}
	public String getDeliveryMan() {
		return deliveryMan;
	}
	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
	public String getManager(){
		return this.manager;
	}
	public void setManager(String manager){
		this.manager = manager;
	}
	public String getMissioner() {
		return missioner;
	}
	public void setMissioner(String missioner) {
		this.missioner = missioner;
	}
	public String getGdmanager() {
		return gdmanager;
	}
	public void setGdmanager(String gdmanager) {
		this.gdmanager = gdmanager;
	}
	public String getCitymanager() {
		return citymanager;
	}
	public void setCitymanager(String citymanager) {
		this.citymanager = citymanager;
	}
	
}
