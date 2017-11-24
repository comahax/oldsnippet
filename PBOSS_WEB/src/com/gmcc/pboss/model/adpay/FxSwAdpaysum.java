package com.gmcc.pboss.model.adpay;

import java.util.Date;

/**
 * FxSwDisform entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class FxSwAdpaysum extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6035788716170196912L;
	private Long sumid;
	private String discomcode;
	private Date beginTime;
	private Date endTime;
	private String state;
	private String strState;
	private Double orderAmt;
	private Double cancelAmt;
	private Double recAmt;
	private String submitCode;
	private Date submitTime;
	private String confirmCode;
	private Date confirmTime;
	private Date createTime;
	private String paymentcode;
    private java.util.Date paymenttime;
    private String paymentmode;
    private Double prepaidlamt;

	public Long getSumid() {
		return sumid;
	}

	public void setSumid(Long sumid) {
		this.sumid = sumid;
	}

	public String getDiscomcode() {
		return discomcode;
	}

	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getOrderAmt() {
		return orderAmt;
	}

	public void setOrderAmt(Double orderAmt) {
		this.orderAmt = orderAmt;
	}

	public Double getCancelAmt() {
		return cancelAmt;
	}

	public void setCancelAmt(Double cancelAmt) {
		this.cancelAmt = cancelAmt;
	}

	public Double getRecAmt() {
		return recAmt;
	}

	public void setRecAmt(Double recAmt) {
		this.recAmt = recAmt;
	}

	public String getSubmitCode() {
		return submitCode;
	}

	public void setSubmitCode(String submitCode) {
		this.submitCode = submitCode;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getConfirmCode() {
		return confirmCode;
	}

	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStrState() {
		return strState;
	}

	public void setStrState(String strState) {
		this.strState = strState;
	}

	public String getPaymentcode() {
		return paymentcode;
	}

	public void setPaymentcode(String paymentcode) {
		this.paymentcode = paymentcode;
	}

	public java.util.Date getPaymenttime() {
		return paymenttime;
	}

	public void setPaymenttime(java.util.Date paymenttime) {
		this.paymenttime = paymenttime;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public Double getPrepaidlamt() {
		return prepaidlamt;
	}

	public void setPrepaidlamt(Double prepaidlamt) {
		this.prepaidlamt = prepaidlamt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sumid == null) ? 0 : sumid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final FxSwAdpaysum other = (FxSwAdpaysum) obj;
		if (sumid == null) {
			if (other.sumid != null)
				return false;
		} else if (!sumid.equals(other.sumid))
			return false;
		return true;
	}

}