package com.gmcc.pboss.biz.info.salesDetail.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class MagRegisternewQueryParameter extends QueryParameter {

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
	//ҵ�����
	private String opnid;
	public void setOpnid(String opnid){
		this.opnid = opnid;
	}
	public String getOpnid(){
		return this.opnid;
	}
	//Ʒ��
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
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
