package com.gmcc.pboss.biz.info.salesDetail.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

/**
 * �׿�������ϸ��ѯ����CH_PW_REGISTERSIM
 * @author Administrator
 *
 */
public class RegistersimQueryParameter extends QueryParameter {
	//�������
	private String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	
	//��Ա-����
	private String oprcode;
	public void setOprcode(String oprcode){
		this.oprcode = oprcode;
	}
	public String getOprcode(){
		return this.oprcode;
	}
	
	//�ֹ�˾
	private String countyid;
	public void setCountyid(String id){
		this.countyid = id;
	}
	public String getCountyid(){
		return this.countyid;
	}
	
	//���۷�����
	private String svccode;
	public void setSvccode(String svc){
		this.svccode = svc;
	}
	public String getSvccode(){
		return this.svccode;
	}
	
	//�׿�����
	private String mobile;	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	//Ʒ��
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
	}
	
	//�ǼǷ�ʽ
	private String flag;	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	//��Ʒ����
	private String type;		
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//�Ǽ���ʼʱ��
	private Date startDate;
	public void setStartDate(Date s){
		this.startDate = s;
	}
	public Date getStartDate(){
		return this.startDate;
	}
	
	//�Ǽǽ���ʱ��
	private Date endDate;
	public void setEndDate(Date e){
		this.endDate = e;
	}
	public Date getEndDate(){
		return this.endDate;
	}
	
	//������ʼʱ��
	private Date activeFrom;
	public Date getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}

	//�������ʱ��
	private Date activeTo;
	public Date getActiveTo() {
		return activeTo;
	}
	public void setActiveTo(Date activeTo) {
		this.activeTo = activeTo;
	}
	
	//����id
	private String cityid;
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
}
