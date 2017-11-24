package com.gmcc.pboss.business.reward.chcwpaymentsend;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class VChCwPaymentsendVO extends BaseVO implements Serializable {
	/** nullable persistent field */
	private String sbatch;

	public java.lang.String getSbatch() {
		return this.sbatch;
	}

	public void setSbatch(String sbatch) {
		this.sbatch = sbatch;
	}

	/** default constructor */
    public VChCwPaymentsendVO() {
    }
	
	public VChCwPaymentsendVO(String sbatch) {
		this.sbatch = sbatch;
	}

	public String toString() {
		return new ToStringBuilder(this).append("sbatch", getSbatch())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof VChCwPaymentsendVO))
			return false;
		VChCwPaymentsendVO castOther = (VChCwPaymentsendVO) other;
		return new EqualsBuilder().append(this.getSbatch(),
				castOther.getSbatch()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSbatch()).toHashCode();
	}
}
