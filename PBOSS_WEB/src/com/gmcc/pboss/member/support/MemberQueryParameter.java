package com.gmcc.pboss.member.support;

import com.gmcc.pboss.common.support.QueryParameter;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-3
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public class MemberQueryParameter extends QueryParameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1829747877277450008L;
	/**
	 * 公务机号码
	 */
	private String officeTel;
	/**
	 * 输入验证码
	 */
	private String inputCode;
	/**
	 * 返回页面
	 */
	private String backURL;
	
	/**人员编码*/
	private String employeeid;
	
	/**
	 * 渠道ID
	 */
	private String wayId;
	
	/** 固定密码 */
	private String fixedPW;
	
	/**
	 * 登录方式-随机短信码SecAuth or 固定密码SimpAuth
	 */
	private String chosenAuthType;
	
	private String isnet;
	
	private boolean step2 = false;
	
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	public String getInputCode() {
		return inputCode;
	}
	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	public String getWayId() {
		return wayId;
	}
	public void setWayId(String wayId) {
		this.wayId = wayId;
	}
	public String getBackURL() {
		return backURL;
	}
	public void setBackURL(String backURL) {
		this.backURL = backURL;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}	
	
	public void setFixedPW(String fixedPW){
		this.fixedPW= fixedPW;
	}
	
	public String getFixedPW(){
		return this.fixedPW;
	}
	
	/**
	 * 登陆方式
	 */
	public void setChosenAuthType(String chosenAuthType){
		this.chosenAuthType = chosenAuthType;
	}
	public String getChosenAuthType(){
		return this.chosenAuthType;
	}
	
	public String getIsnet() {
		return isnet;
	}
	public void setIsnet(String isnet) {
		this.isnet = isnet;
	}
	
	public boolean isStep2() {
		return step2;
	}
	
	public void setStep2(boolean step2) {
		this.step2 = step2;
	}
}
