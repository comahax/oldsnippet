package com.gmcc.pboss.business.resource.numtyperule;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;


public class NumtyperuleVO extends BaseVO implements Serializable {

	private Long rownumber;
	/** identifier field */
    private Long typeid;

    /** persistent field */
    private String typecode;

    /** persistent field */
    private String typename;

    /** nullable persistent field */
    private String typedesc;

    /** persistent field */
    private Short prilevel;

    /** persistent field */
    private Short effective;

    /** persistent field */
    private Short isdefault;
    
    /** identifier field */
    private Long ruleid;

    /** persistent field */
    private String ruleexp;

	public Long getRownumber() {
		return rownumber;
	}

	public void setRownumber(Long rownumber) {
		this.rownumber = rownumber;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTypedesc() {
		return typedesc;
	}

	public void setTypedesc(String typedesc) {
		this.typedesc = typedesc;
	}

	public Short getPrilevel() {
		return prilevel;
	}

	public void setPrilevel(Short prilevel) {
		this.prilevel = prilevel;
	}

	public Short getEffective() {
		return effective;
	}

	public void setEffective(Short effective) {
		this.effective = effective;
	}

	public Short getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(Short isdefault) {
		this.isdefault = isdefault;
	}

	public Long getRuleid() {
		return ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}

	public String getRuleexp() {
		return ruleexp;
	}

	public void setRuleexp(String ruleexp) {
		this.ruleexp = ruleexp;
	}

	
	 public boolean equals(Object other) {
	        if ( !(other instanceof NumtyperuleVO) ) return false;
	        NumtyperuleVO castOther = (NumtyperuleVO) other;
	        return new EqualsBuilder()
	            .append(this.rownumber, castOther.getRownumber())
	            .isEquals();
	    }

	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getRownumber())
	            .toHashCode();
	    }
}
