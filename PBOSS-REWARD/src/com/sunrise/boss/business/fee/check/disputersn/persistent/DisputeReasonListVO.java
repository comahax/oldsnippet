/**
* auto-generated code
* Wed Aug 16 16:27:53 CST 2006
*/
package com.sunrise.boss.business.fee.check.disputersn.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: DisputeReasonListVO</p>
 * <p>Description: Query Params Object for DisputeReasonDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public class DisputeReasonListVO extends BaseListVO {

	private String _se_rsncode;
	private String _ne_grade;
	private String _se_rsnattach;
	private String _sk_descrp;
	public String get_ne_grade() {
		return _ne_grade;
	}
	public void set_ne_grade(String _se_grade) {
		this._ne_grade = _se_grade;
	}
	public String get_se_rsnattach() {
		return _se_rsnattach;
	}
	public void set_se_rsnattach(String _se_rsnattach) {
		this._se_rsnattach = _se_rsnattach;
	}
	public String get_se_rsncode() {
		return _se_rsncode;
	}
	public void set_se_rsncode(String _se_rsncode) {
		this._se_rsncode = _se_rsncode;
	}

    public String get_sk_descrp() {
		return _sk_descrp;
	}
	public void set_sk_descrp(String _sk_descrp) {
		this._sk_descrp = _sk_descrp;
	}
	public String toString() {
        return new ToStringBuilder(this)
            .append("_se_rsncode", get_se_rsncode())
            .append("_se_grade", get_ne_grade())
            .append("_se_rsnattach", get_se_rsnattach())
            .append("_sk_descrp", get_sk_descrp())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisputeReasonListVO) ) return false;
        DisputeReasonListVO castOther = (DisputeReasonListVO) other;
        return new EqualsBuilder()
            .append(this.get_se_rsncode(), castOther.get_se_rsncode())
            .append(this.get_ne_grade(), castOther.get_ne_grade())
            .append(this.get_se_rsnattach(), castOther.get_se_rsnattach())
            .append(this.get_sk_descrp(), castOther.get_sk_descrp())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(get_se_rsncode())
            .append(get_ne_grade())
            .append(get_se_rsnattach())
            .append(get_sk_descrp())
            .toHashCode();
    }
}
