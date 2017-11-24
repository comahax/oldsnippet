package com.sunrise.boss.business.fee.qsmanage.fixfeesettle.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FixFeeSettleBakVO implements Serializable {


    /** identifier field */
    private Long acctid;
    
    private String prodid;

    /** identifier field */
    private String settletype;

    /** nullable persistent field */
    private String coname;

    /** nullable persistent field */
    private Double percent;

    /** nullable persistent field */
    private Integer begincyc;

    /** nullable persistent field */
    private Integer endcyc;
    
    private Integer isderated;

    private Integer getunwoff;
    private Integer step;
    private Integer region;
    private Long dataid ;



    public Long getDataid() {
		return dataid;
	}

	public void setDataid(Long dataid) {
		this.dataid = dataid;
	}

	public java.lang.String getSettletype() {
        return this.settletype;
    }

    public void setSettletype(java.lang.String settletype) {
        this.settletype = settletype;
    }

    public java.lang.String getConame() {
        return this.coname;
    }

    public void setConame(java.lang.String coname) {
        this.coname = coname;
    }


    public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public java.lang.Integer getBegincyc() {
        return this.begincyc;
    }

    public void setBegincyc(java.lang.Integer begincyc) {
        this.begincyc = begincyc;
    }

    public java.lang.Integer getEndcyc() {
        return this.endcyc;
    }

    public void setEndcyc(java.lang.Integer endcyc) {
        this.endcyc = endcyc;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.getDataid().toString()).append("~").append(this.getAcctid().toString()).append("~")
        	.append(this.getProdid()).append("~").append(this.getSettletype()).append("~")
        	.append(this.getConame()).append("~").append(this.getPercent().toString()).append("~")
        	.append(this.getBegincyc().toString()).append("~").append(this.getEndcyc().toString()).append("~")
        	.append(this.getIsderated().toString()).append("~").append(this.getGetunwoff().toString()).append("~")
        	.append(this.getStep().toString()).append("~").append(this.getregion().toString()).append("~");
        return buf.toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FixFeeSettleBakVO) ) return false;
        FixFeeSettleBakVO castOther = (FixFeeSettleBakVO) other;
        return new EqualsBuilder()
            .append(this.getAcctid(), castOther.getAcctid())
             .append(this.getProdid(), castOther.getProdid())
            .append(this.getSettletype(), castOther.getSettletype())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcctid())
             .append(getProdid())
            .append(getSettletype())
            .toHashCode();
    }

	public Long getAcctid() {
		return acctid;
	}

	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}

	public Integer getIsderated() {
		return isderated;
	}

	public void setIsderated(Integer isderated) {
		this.isderated = isderated;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public Integer getGetunwoff() {
		return getunwoff;
	}

	public void setGetunwoff(Integer getunwoff) {
		this.getunwoff = getunwoff;
	}

	public Integer getregion() {
		return region;
	}

	public void setregion(Integer region) {
		this.region = region;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

}
