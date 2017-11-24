package com.gmcc.pboss.business.sales.disform;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class GDisformVO extends BaseVO implements Serializable {
	
	  /** identifier field */
    private Long recid;

    /** persistent field */
    private Long comid;

    private java.lang.Long num;
    
    private String memo;
    
    private java.lang.Long comprice;
    
    private java.lang.Long orincomprice;
    
    private java.lang.Double sellprice;
    
    private java.lang.Double orinsellprice;
    
    private String countyid;
    
    private String discomcode;
    

	/** full constructor */
    public GDisformVO(java.lang.Long recid, java.lang.Long comid, java.lang.Long num, java.lang.String memo, java.lang.Long comprice, java.lang.Long orincomprice, java.lang.Double sellprice, java.lang.Double orinsellprice, java.lang.String discomcode, java.lang.String countyid) {
        this.recid = recid;
        this.comid = comid;
        this.comprice = comprice;
        this.num = num;
        this.memo = memo;
        this.orincomprice = orincomprice;
        this.sellprice = sellprice;
        this.orinsellprice = orinsellprice;
        this.discomcode = discomcode;
        this.countyid = countyid;
    }

    /** default constructor */
    public GDisformVO() {
    }

    /** minimal constructor */
    public GDisformVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }


    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .append("comprice",getComprice())
            .append("sellprice",getSellprice())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof GDisformVO) ) return false;
        GDisformVO castOther = (GDisformVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .append(this.getComprice(),castOther.getComprice())
            .append(this.getSellprice(), castOther.getSellprice())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .append(getComprice())
            .append(getSellprice())
            .toHashCode();
    }

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public java.lang.Long getComprice() {
		return comprice;
	}

	public void setComprice(java.lang.Long comprice) {
		this.comprice = comprice;
	}

	public java.lang.Long getNum() {
		return num;
	}

	public void setNum(java.lang.Long num) {
		this.num = num;
	}

	public java.lang.Long getOrincomprice() {
		return orincomprice;
	}

	public void setOrincomprice(java.lang.Long orincomprice) {
		this.orincomprice = orincomprice;
	}



	public java.lang.Double getOrinsellprice() {
		return orinsellprice;
	}

	public void setOrinsellprice(java.lang.Double orinsellprice) {
		this.orinsellprice = orinsellprice;
	}

	public java.lang.Double getSellprice() {
		return sellprice;
	}

	public void setSellprice(java.lang.Double sellprice) {
		this.sellprice = sellprice;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getDiscomcode() {
		return discomcode;
	}

	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}
	
}
