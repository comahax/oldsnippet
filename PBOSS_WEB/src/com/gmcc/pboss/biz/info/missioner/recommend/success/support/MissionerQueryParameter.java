package com.gmcc.pboss.biz.info.missioner.recommend.success.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class MissionerQueryParameter extends QueryParameter{
	
	//���������̱���
	private String wayid;
	
	//��������������
	private String wayname;
	
	//ҵ�����
	private String opnid;
	
	//ҵ������
	private String opnname;
	
	
	//ҵ����ʱ��>=
	private Date oprtimeFrom;
	
	//ҵ����ʱ��<=
	private Date oprtimeTo;
	
	//��ϵ�绰��רԱ��ѯʱ���޶���רԱ��Ӧ�����ݣ���ҳ��������
	private String telephone;
	
	//���������������̲�ѯʱ���޶������̶�Ӧ�����ݣ���ҳ��������
	private String wayidAgency;
	
	//רԱ����
	private String oprcode;
	
	//��Ա����
	private String empattr2;

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public Date getOprtimeFrom() {
		return oprtimeFrom;
	}

	public void setOprtimeFrom(Date oprtimeFrom) {
		this.oprtimeFrom = oprtimeFrom;
	}

	public Date getOprtimeTo() {
		return oprtimeTo;
	}

	public void setOprtimeTo(Date oprtimeTo) {
		this.oprtimeTo = oprtimeTo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getWayidAgency() {
		return wayidAgency;
	}

	public void setWayidAgency(String wayidAgency) {
		this.wayidAgency = wayidAgency;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getEmpattr2() {
		return empattr2;
	}

	public void setEmpattr2(String empattr2) {
		this.empattr2 = empattr2;
	}
}
