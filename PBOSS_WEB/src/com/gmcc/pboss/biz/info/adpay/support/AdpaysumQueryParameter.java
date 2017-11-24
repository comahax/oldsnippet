package com.gmcc.pboss.biz.info.adpay.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class AdpaysumQueryParameter extends QueryParameter {

	public AdpaysumQueryParameter() {
		setAction(QueryAction.SECTION);
	}

	/**
	 * ���ܺ�
	 */
	private Long sumid;
	/**
	 * ״̬
	 */
	private String state;
	/**
	 * 
	 */
	private String discomcode;
	/**
	 * �ύʱ���
	 */
	private Date createTimeFrom;

	/**
	 * �ύʱ�䵽
	 */
	private Date createTimeTo;

	public Long getSumid() {
		return sumid;
	}

	public void setSumid(Long sumid) {
		this.sumid = sumid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getDiscomcode() {
		return discomcode;
	}

	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}

	/**
	 * @return the createTimeFrom
	 */
	public Date getCreateTimeFrom() {
		return createTimeFrom;
	}

	/**
	 * @param createTimeFrom the createTimeFrom to set
	 */
	public void setCreateTimeFrom(Date createTimeFrom) {
		this.createTimeFrom = createTimeFrom;
	}

	/**
	 * @return the createTimeTo
	 */
	public Date getCreateTimeTo() {
		return createTimeTo;
	}

	/**
	 * @param createTimeTo the createTimeTo to set
	 */
	public void setCreateTimeTo(Date createTimeTo) {
		this.createTimeTo = createTimeTo;
	}

}
