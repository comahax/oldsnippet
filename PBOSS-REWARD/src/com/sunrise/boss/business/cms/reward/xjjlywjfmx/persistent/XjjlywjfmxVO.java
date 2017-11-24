package com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class XjjlywjfmxVO implements Serializable {

    /** identifier field */
    private Double busivalue;

    /** identifier field */
    private String flag;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String chainhead;

    /** nullable persistent field */
    private String countycompname;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private Double creditaccount;

    /** nullable persistent field */
    private Double paysum;
    
    private String countycompid;
    
    private Double dzzd;

    /** nullable persistent field */
    private Double sr;

    /** nullable persistent field */
    private Double fsr;

    /** nullable persistent field */
    private Double czjf;

    /** nullable persistent field */
    private Double yckb;

    /** nullable persistent field */
    private Double jtdh;

    /** nullable persistent field */
    private Double dhjq;

    /** nullable persistent field */
    private Double lxw;

    /** nullable persistent field */
    private Double ajh;

    
    public String getCountycompid() {
		return countycompid;
	}

	public void setCountycompid(String countycompid) {
		this.countycompid = countycompid;
	}

	public Double getDzzd() {
		return dzzd;
	}

	public void setDzzd(Double dzzd) {
		this.dzzd = dzzd;
	}

	public Double getSr() {
		return sr;
	}

	public void setSr(Double sr) {
		this.sr = sr;
	}

	public Double getFsr() {
		return fsr;
	}

	public void setFsr(Double fsr) {
		this.fsr = fsr;
	}

	public Double getCzjf() {
		return czjf;
	}

	public void setCzjf(Double czjf) {
		this.czjf = czjf;
	}

	public Double getYckb() {
		return yckb;
	}

	public void setYckb(Double yckb) {
		this.yckb = yckb;
	}

	public Double getJtdh() {
		return jtdh;
	}

	public void setJtdh(Double jtdh) {
		this.jtdh = jtdh;
	}

	public Double getDhjq() {
		return dhjq;
	}

	public void setDhjq(Double dhjq) {
		this.dhjq = dhjq;
	}

	public Double getLxw() {
		return lxw;
	}

	public void setLxw(Double lxw) {
		this.lxw = lxw;
	}

	public Double getAjh() {
		return ajh;
	}

	public void setAjh(Double ajh) {
		this.ajh = ajh;
	}

	/** full constructor */
    public XjjlywjfmxVO(java.lang.Double busivalue, java.lang.String flag, java.lang.String wayid, java.lang.String countyid, java.lang.String wayname, java.lang.String chainhead, java.lang.String countycompname, java.lang.Short starlevel, java.lang.String calcmonth, java.lang.Double creditaccount, java.lang.Double paysum) {
        this.busivalue = busivalue;
        this.flag = flag;
        this.wayid = wayid;
        this.countyid = countyid;
        this.wayname = wayname;
        this.chainhead = chainhead;
        this.countycompname = countycompname;
        this.starlevel = starlevel;
        this.calcmonth = calcmonth;
        this.creditaccount = creditaccount;
        this.paysum = paysum;
    }

    /** default constructor */
    public XjjlywjfmxVO() {
    }

    /** minimal constructor */
    public XjjlywjfmxVO(java.lang.Double busivalue, java.lang.String flag, java.lang.String wayid) {
        this.busivalue = busivalue;
        this.flag = flag;
        this.wayid = wayid;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.String getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getChainhead() {
        return this.chainhead;
    }

    public void setChainhead(java.lang.String chainhead) {
        this.chainhead = chainhead;
    }

    public java.lang.String getCountycompname() {
        return this.countycompname;
    }

    public void setCountycompname(java.lang.String countycompname) {
        this.countycompname = countycompname;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.Double getCreditaccount() {
        return this.creditaccount;
    }

    public void setCreditaccount(java.lang.Double creditaccount) {
        this.creditaccount = creditaccount;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("busivalue", getBusivalue())
            .append("flag", getFlag())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof XjjlywjfmxVO) ) return false;
        XjjlywjfmxVO castOther = (XjjlywjfmxVO) other;
        return new EqualsBuilder()
            .append(this.getBusivalue(), castOther.getBusivalue())
            .append(this.getFlag(), castOther.getFlag())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBusivalue())
            .append(getFlag())
            .append(getWayid())
            .toHashCode();
    }

}
