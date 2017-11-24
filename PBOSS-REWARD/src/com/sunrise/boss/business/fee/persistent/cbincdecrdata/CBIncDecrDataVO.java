package com.sunrise.boss.business.fee.persistent.cbincdecrdata;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CBIncDecrDataVO implements Serializable {

    /** identifier field */
    private Long incdecrid;

    /** persistent field */
    private Long subsid;

    /** persistent field */
    private Integer validbillcyc;

    /** persistent field */
    private Long acctid;

    /** persistent field */
    private Short type;

    /** nullable persistent field */
    private Short attribute;

    /** nullable persistent field */
    private String checkercode;

    /** persistent field */
    private String opercode;

    /** persistent field */
    private Double incrdecramt;

    /** nullable persistent field */
    private Integer genbillcyc;

    /** nullable persistent field */
    private Integer outbillcyc;

    /** nullable persistent field */
    private java.util.Date inputdate;

    /** nullable persistent field */
    private Short isaward;

    /** nullable persistent field */
    private Short validflag;

    /** nullable persistent field */
    private String incrdecrreason;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String largersncode;

    /** nullable persistent field */
    private String smallrsncode;

    /** nullable persistent field */
    private Short isicp;

    /** nullable persistent field */
    private String icpid;

    /** nullable persistent field */
    private String icptype;

    /** nullable persistent field */
    private String lodge;

    /** nullable persistent field */
    private String portid;

    /** nullable persistent field */
    private String icptype2;

    /** nullable persistent field */
    private Short dealstate;

    private Short busitype;
    private Short desputetype;
    public Short getBusitype() {
		return busitype;
	}

	public void setBusitype(Short busitype) {
		this.busitype = busitype;
	}

	public Short getDesputetype() {
		return desputetype;
	}

	public void setDesputetype(Short desputetype) {
		this.desputetype = desputetype;
	}

	/** full constructor */
    public CBIncDecrDataVO(java.lang.Long subsid, java.lang.Integer validbillcyc, java.lang.Long acctid, java.lang.Short type, java.lang.Short attribute, java.lang.String checkercode, java.lang.String opercode, java.lang.Double incrdecramt, java.lang.Integer genbillcyc, java.lang.Integer outbillcyc, java.util.Date inputdate, java.lang.Short isaward, java.lang.Short validflag, java.lang.String incrdecrreason, java.lang.String memo, java.lang.String largersncode, java.lang.String smallrsncode, java.lang.Short isicp, java.lang.String icpid, java.lang.String icptype, java.lang.String lodge, java.lang.String portid, java.lang.String icptype2, java.lang.Short dealstate) {
        this.subsid = subsid;
        this.validbillcyc = validbillcyc;
        this.acctid = acctid;
        this.type = type;
        this.attribute = attribute;
        this.checkercode = checkercode;
        this.opercode = opercode;
        this.incrdecramt = incrdecramt;
        this.genbillcyc = genbillcyc;
        this.outbillcyc = outbillcyc;
        this.inputdate = inputdate;
        this.isaward = isaward;
        this.validflag = validflag;
        this.incrdecrreason = incrdecrreason;
        this.memo = memo;
        this.largersncode = largersncode;
        this.smallrsncode = smallrsncode;
        this.isicp = isicp;
        this.icpid = icpid;
        this.icptype = icptype;
        this.lodge = lodge;
        this.portid = portid;
        this.icptype2 = icptype2;
        this.dealstate = dealstate;
    }

    /** default constructor */
    public CBIncDecrDataVO() {
    }

    /** minimal constructor */
    public CBIncDecrDataVO(java.lang.Long subsid, java.lang.Integer validbillcyc, java.lang.Long acctid, java.lang.Short type, java.lang.String opercode, java.lang.Double incrdecramt) {
        this.subsid = subsid;
        this.validbillcyc = validbillcyc;
        this.acctid = acctid;
        this.type = type;
        this.opercode = opercode;
        this.incrdecramt = incrdecramt;
    }

    public java.lang.Long getIncdecrid() {
        return this.incdecrid;
    }

    public void setIncdecrid(java.lang.Long incdecrid) {
        this.incdecrid = incdecrid;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.Integer getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Integer validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Short getType() {
        return this.type;
    }

    public void setType(java.lang.Short type) {
        this.type = type;
    }

    public java.lang.Short getAttribute() {
        return this.attribute;
    }

    public void setAttribute(java.lang.Short attribute) {
        this.attribute = attribute;
    }

    public java.lang.String getCheckercode() {
        return this.checkercode;
    }

    public void setCheckercode(java.lang.String checkercode) {
        this.checkercode = checkercode;
    }

    public java.lang.String getOpercode() {
        return this.opercode;
    }

    public void setOpercode(java.lang.String opercode) {
        this.opercode = opercode;
    }

    public java.lang.Double getIncrdecramt() {
        return this.incrdecramt;
    }

    public void setIncrdecramt(java.lang.Double incrdecramt) {
        this.incrdecramt = incrdecramt;
    }

    public java.lang.Integer getGenbillcyc() {
        return this.genbillcyc;
    }

    public void setGenbillcyc(java.lang.Integer genbillcyc) {
        this.genbillcyc = genbillcyc;
    }

    public java.lang.Integer getOutbillcyc() {
        return this.outbillcyc;
    }

    public void setOutbillcyc(java.lang.Integer outbillcyc) {
        this.outbillcyc = outbillcyc;
    }

    public java.util.Date getInputdate() {
        return this.inputdate;
    }

    public void setInputdate(java.util.Date inputdate) {
        this.inputdate = inputdate;
    }

    public java.lang.Short getIsaward() {
        return this.isaward;
    }

    public void setIsaward(java.lang.Short isaward) {
        this.isaward = isaward;
    }

    public java.lang.Short getValidflag() {
        return this.validflag;
    }

    public void setValidflag(java.lang.Short validflag) {
        this.validflag = validflag;
    }

    public java.lang.String getIncrdecrreason() {
        return this.incrdecrreason;
    }

    public void setIncrdecrreason(java.lang.String incrdecrreason) {
        this.incrdecrreason = incrdecrreason;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getLargersncode() {
        return this.largersncode;
    }

    public void setLargersncode(java.lang.String largersncode) {
        this.largersncode = largersncode;
    }

    public java.lang.String getSmallrsncode() {
        return this.smallrsncode;
    }

    public void setSmallrsncode(java.lang.String smallrsncode) {
        this.smallrsncode = smallrsncode;
    }

    public java.lang.Short getIsicp() {
        return this.isicp;
    }

    public void setIsicp(java.lang.Short isicp) {
        this.isicp = isicp;
    }

    public java.lang.String getIcpid() {
        return this.icpid;
    }

    public void setIcpid(java.lang.String icpid) {
        this.icpid = icpid;
    }

    public java.lang.String getIcptype() {
        return this.icptype;
    }

    public void setIcptype(java.lang.String icptype) {
        this.icptype = icptype;
    }

    public java.lang.String getLodge() {
        return this.lodge;
    }

    public void setLodge(java.lang.String lodge) {
        this.lodge = lodge;
    }

    public java.lang.String getPortid() {
        return this.portid;
    }

    public void setPortid(java.lang.String portid) {
        this.portid = portid;
    }

    public java.lang.String getIcptype2() {
        return this.icptype2;
    }

    public void setIcptype2(java.lang.String icptype2) {
        this.icptype2 = icptype2;
    }

    public java.lang.Short getDealstate() {
        return this.dealstate;
    }

    public void setDealstate(java.lang.Short dealstate) {
        this.dealstate = dealstate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("incdecrid", getIncdecrid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CBIncDecrDataVO) ) return false;
        CBIncDecrDataVO castOther = (CBIncDecrDataVO) other;
        return new EqualsBuilder()
            .append(this.getIncdecrid(), castOther.getIncdecrid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getIncdecrid())
            .toHashCode();
    }
	private Long Servnum;


	public Long getServnum() {
		return Servnum;
	}

	public void setServnum(Long servnum) {
		Servnum = servnum;
	}
	private Long eboxid;


	public Long getEboxid() {
		return eboxid;
	}

	public void setEboxid(Long eboxid) {
		this.eboxid = eboxid;
	}
	
}
