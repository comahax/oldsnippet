package com.gmcc.pboss.member.support;

import com.gmcc.pboss.common.support.QueryParameter;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-8-3
 * ������Ŀ��
 * ����ģ�飺
 * ������
 */
public class MemberQueryParameter extends QueryParameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1829747877277450008L;
	/**
	 * ���������
	 */
	private String officeTel;
	/**
	 * ������֤��
	 */
	private String inputCode;
	/**
	 * ����ҳ��
	 */
	private String backURL;
	
	/**��Ա����*/
	private String employeeid;
	
	/**
	 * ����ID
	 */
	private String wayId;
	
	/** �̶����� */
	private String fixedPW;
	
	/**
	 * ��¼��ʽ-���������SecAuth or �̶�����SimpAuth
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
	 * ��½��ʽ
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
