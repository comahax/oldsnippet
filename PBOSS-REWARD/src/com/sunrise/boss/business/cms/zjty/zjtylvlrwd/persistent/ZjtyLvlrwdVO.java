package com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyLvlrwdVO implements Serializable {

    /** identifier field */
    private Integer citylevel;

    /** identifier field */
    private Double checkcoef;
    
    private Double fixedrwd;
    
    private Double prize;

    /** full constructor */
    public ZjtyLvlrwdVO(Integer citylevel, Double checkcoef, Double fixedrwd, Double prize){
        this.citylevel = citylevel;
        this.checkcoef = checkcoef;
        this.fixedrwd = fixedrwd;
        this.prize = prize;
    }

    /** default constructor */
    public ZjtyLvlrwdVO() {
    }

    /** minimal constructor */
    public ZjtyLvlrwdVO(Integer citylevel) {
        this.citylevel = citylevel;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("citylevel", getCitylevel())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyLvlrwdVO) ) return false;
        ZjtyLvlrwdVO castOther = (ZjtyLvlrwdVO) other;
        return new EqualsBuilder()
            .append(this.getCitylevel(), castOther.getCitylevel())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCitylevel())
            .toHashCode();
    }

	public Integer getCitylevel() {
		return citylevel;
	}

	public void setCitylevel(Integer citylevel) {
		this.citylevel = citylevel;
	}

	public Double getCheckcoef() {
		return checkcoef;
	}

	public void setCheckcoef(Double checkcoef) {
		this.checkcoef = checkcoef;
	}

	public Double getFixedrwd() {
		return fixedrwd;
	}

	public void setFixedrwd(Double fixedrwd) {
		this.fixedrwd = fixedrwd;
	}

	public Double getPrize() {
		return prize;
	}

	public void setPrize(Double prize) {
		this.prize = prize;
	}

}
