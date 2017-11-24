package com.sunrise.boss.business.fee.check.disputersn.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DisputeReasonVO implements Serializable {

    /** identifier field */
	private String rsncode;

    /** nullable persistent field */
    private Short grade;

    /** nullable persistent field */
    private String rsnattach;

    /** nullable persistent field */
    private String descrp;

    /** full constructor */
    public DisputeReasonVO(java.lang.Short grade, java.lang.String rsnattach, java.lang.String descrp) {
        this.grade = grade;
        this.rsnattach = rsnattach;
        this.descrp = descrp;
    }

    /** default constructor */
    public DisputeReasonVO() {
    }

    public String getRsncode() {
		return rsncode;
	}

	public void setRsncode(String rsncode) {
		this.rsncode = rsncode;
	}

	public java.lang.Short getGrade() {
        return this.grade;
    }

    public void setGrade(java.lang.Short grade) {
        this.grade = grade;
    }

    public java.lang.String getRsnattach() {
        return this.rsnattach;
    }

    public void setRsnattach(java.lang.String rsnattach) {
        this.rsnattach = rsnattach;
    }

    public java.lang.String getDescrp() {
        return this.descrp;
    }

    public void setDescrp(java.lang.String descrp) {
        this.descrp = descrp;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rsncode", getRsncode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisputeReasonVO) ) return false;
        DisputeReasonVO castOther = (DisputeReasonVO) other;
        return new EqualsBuilder()
            .append(this.getRsncode(), castOther.getRsncode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRsncode())
            .toHashCode();
    }

}
