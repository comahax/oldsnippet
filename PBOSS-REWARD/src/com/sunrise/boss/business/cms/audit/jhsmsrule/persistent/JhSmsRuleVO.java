package com.sunrise.boss.business.cms.audit.jhsmsrule.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.boss.business.cms.audit.recfeeadjustrsn.persistent.RecFeeAdjustRsnVO;
import com.sunrise.boss.business.common.dblog.ManageLog;

/**
 * <p>
 * Title: CompanyDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */

public class JhSmsRuleVO implements java.io.Serializable, ManageLog {

	// Fields

	private Long ruleid;

	private Long type;

	private Long pri;

	private Long valid;

	private String smscontent;

	public Long getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}

	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getPri() {
		return this.pri;
	}

	public void setPri(Long pri) {
		this.pri = pri;
	}

	public Long getValid() {
		return this.valid;
	}

	public void setValid(Long valid) {
		this.valid = valid;
	}

	public String getSmscontent() {
		return this.smscontent;
	}

	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}

	public boolean equals(Object other) {
		if (!(other instanceof RecFeeAdjustRsnVO))
			return false;
		JhSmsRuleVO castOther = (JhSmsRuleVO) other;
		return new EqualsBuilder().append(this.getRuleid(),
				castOther.getRuleid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRuleid()).toHashCode();
	}

}