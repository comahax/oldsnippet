package com.sunrise.boss.business.cms.reward.busyxplan.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BusyxplanVO implements OperationLog {

    /** identifier field */
    private String opnid;

    /** identifier field */
    private Long yxplanid;

    /** nullable persistent field */
    private Double wrapfee;

    /** nullable persistent field */
    private String cityid;
    
    private String planbusitype;
    
    private String wayid;
    
    private Long noncyc ; //客户维系酬金发放期数
    
    private String prodid;
    
    private Long seq;
    

    /** full constructor */
    public BusyxplanVO(java.lang.String opnid, java.lang.Long yxplanid, java.lang.Double wrapfee, java.lang.String cityid,java.lang.Long noncyc,java.lang.Long seq,java.lang.String prodid ) {
        this.opnid = opnid;
        this.yxplanid = yxplanid;
        this.wrapfee = wrapfee;
        this.cityid = cityid;
        this.noncyc = noncyc;
        this.seq = seq;
        this.prodid = prodid;
    }

    /** default constructor */
    public BusyxplanVO() {
    }

    /** minimal constructor */
    public BusyxplanVO(java.lang.String opnid, java.lang.Long yxplanid) {
        this.opnid = opnid;
        this.yxplanid = yxplanid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Double getWrapfee() {
        return this.wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee) {
        this.wrapfee = wrapfee;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .append("yxplanid", getYxplanid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusyxplanVO) ) return false;
        BusyxplanVO castOther = (BusyxplanVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getYxplanid(), castOther.getYxplanid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getYxplanid())
            .toHashCode();
    }

	public String getPlanbusitype() {
		return planbusitype;
	}

	public void setPlanbusitype(String planbusitype) {
		this.planbusitype = planbusitype;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return BusyxplanlogVO.class;
	}

	public Long getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Long noncyc) {
		this.noncyc = noncyc;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	} 

}
