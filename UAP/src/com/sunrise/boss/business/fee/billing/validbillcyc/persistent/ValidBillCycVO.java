/**
 * 
 */
package com.sunrise.boss.business.fee.billing.validbillcyc.persistent;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.ManageLog;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
public class ValidBillCycVO extends BaseVO implements ManageLog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6258814991930414910L;

	private Long validbillcyc;

	private Long billmodeid;

	private Long state;

	private Timestamp begindate;

	private Timestamp enddate;

	private String descinfo;

	private String billcyccode;
	
	private Integer region;

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public Timestamp getBegindate() {
		return begindate;
	}

	public void setBegindate(Timestamp begindate) {
		this.begindate = begindate;
	}

	public String getBillcyccode() {
		return billcyccode;
	}

	public void setBillcyccode(String billcyccode) {
		this.billcyccode = billcyccode;
	}

	public Long getBillmodeid() {
		return billmodeid;
	}

	public void setBillmodeid(Long billmodeid) {
		this.billmodeid = billmodeid;
	}

	public String getDescinfo() {
		return descinfo;
	}

	public void setDescinfo(String descinfo) {
		this.descinfo = descinfo;
	}

	public Timestamp getEnddate() {
		return enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getValidbillcyc() {
		return validbillcyc;
	}

	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}

	public boolean equals(Object other) {
		if (!(other instanceof ValidBillCycVO))
			return false;
		ValidBillCycVO castOther = (ValidBillCycVO) other;
		return new EqualsBuilder().append(this.getValidbillcyc(),
				castOther.getValidbillcyc()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getValidbillcyc()).toHashCode();
	}

}
