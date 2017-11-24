/**
 * 
 */
package com.sunrise.boss.business.cms.audit.recfeeadjustrsn.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.boss.business.common.dblog.ManageLog;

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
public class RecFeeAdjustRsnVO implements java.io.Serializable, ManageLog {
	private Long rsnid;

	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getRsnid() {
		return rsnid;
	}

	public void setRsnid(Long rsnid) {
		this.rsnid = rsnid;
	}

	public boolean equals(Object other) {
		if (!(other instanceof RecFeeAdjustRsnVO))
			return false;
		RecFeeAdjustRsnVO castOther = (RecFeeAdjustRsnVO) other;
		return new EqualsBuilder()
				.append(this.getRsnid(), castOther.getRsnid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRsnid()).toHashCode();
	}

}
