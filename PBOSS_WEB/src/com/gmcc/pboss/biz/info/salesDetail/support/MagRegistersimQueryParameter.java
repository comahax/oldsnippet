package com.gmcc.pboss.biz.info.salesDetail.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class MagRegistersimQueryParameter extends QueryParameter {
	//�������
	private String wayid;
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	//��Ա����-����
	private String oprcode;
	public void setOprcode(String oprcode){
		this.oprcode = oprcode;
	}
	public String getOprcode(){
		return this.oprcode;
	}
	//�ֹ�˾
	private String countyid;
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	//���۷�������
	private String svccode;
	public String getSvccode() {
		return svccode;
	}
	public void setSvccode(String svccode) {
		this.svccode = svccode;
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
	//��Ʒ����
	private String type;		
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//�ǼǷ�ʽ
	private String flag;	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	//��ʼʱ��
	private Date timeFrom;
	public void setTimeFrom(Date timeFrom){
		this.timeFrom = timeFrom;
	}
	public Date getTimeFrom(){
		return this.timeFrom;
	}
	//����ʱ��
	private Date timeTo;
	public void setTimeTo(Date timeTo){
		this.timeTo = timeTo;
	}
	public Date getTimeTo(){			
		return this.timeTo;
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
	
	//������Աid-���û���ѯδ�޶�������������£�
	//�޶�ֻ�ܲ�ѯ�����������㣬�����ѯ��Χ��Ŵ�
	private String waymagcode;
	public String getWaymagcode() {
		return waymagcode;
	}
	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}
}
