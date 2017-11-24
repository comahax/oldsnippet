package com.gmcc.pboss.biz.info.reward.payment.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class PaymentManageQueryParameter extends QueryParameter {
	// �����򡰵��С��� ��ҵ�����͡������Թ�/��˽��������˱�ʶ����
	// ����ѡ����տλ���ơ������������롱���������ࡱ�������С�ࡱ��
	// ʱ�����������·ݡ���
	// ��������Ρ���
	// ��ť����ѯ��������ˡ�����������ˡ��������ˡ������������ˡ���

	private String cityid;
	private String optype;
	private String pubpri;
	private String checkedflag;
	private String payee;
	private String wayid;
	private String ltype;
	private String stype;
	private String paymonth;
	private String batch;

	public PaymentManageQueryParameter() {
		super();
	}

	public PaymentManageQueryParameter(String optype, String payee,
			String wayid, String stype, String paymonth, String batch) {
		super();

		this.optype = optype;
		this.payee = payee;
		this.wayid = wayid;
		this.stype = stype;
		this.paymonth = paymonth;
		this.batch = batch;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getPubpri() {
		return pubpri;
	}

	public void setPubpri(String pubpri) {
		this.pubpri = pubpri;
	}

	public String getCheckedflag() {
		return checkedflag;
	}

	public void setCheckedflag(String checkedflag) {
		this.checkedflag = checkedflag;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}
}
