package com.sunrise.boss.business.cms.reward.terminalsucc.persistent;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class TerminalsuccComVO implements Serializable {

    private String cityid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Long busivalue;

    private String calcmonth;

    /** nullable persistent field */
    private String comid;

    /** full constructor */
    public TerminalsuccComVO(java.lang.String cityid, java.lang.String opnid, java.lang.String wayid, java.lang.String oprcode, java.util.Date oprtime, java.lang.String mobile, java.lang.Long busivalue, java.lang.Byte brand, java.util.Date creattime, java.util.Date adtttime, java.lang.String src, java.lang.String calcopnid, java.lang.String calcmonth, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.Short adtflag, java.lang.String adtcode, java.lang.String adtremark, java.lang.Long oid, java.lang.Short rewardflag, java.lang.String repairmonth, java.lang.String batchno, java.lang.Short noncyc, java.lang.String imei, java.lang.String comid) {
        this.cityid = cityid;
        this.opnid = opnid;
        this.wayid = wayid;
        this.busivalue = busivalue;
        this.calcmonth = calcmonth;
        this.comid = comid;
    }

    /** default constructor */
    public TerminalsuccComVO() {
    }

	public Long getBusivalue() {
		return busivalue;
	}

	public void setBusivalue(Long busivalue) {
		this.busivalue = busivalue;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}


//    public String toString() {
//        return new ToStringBuilder(this)
//            .append("seq", getSeq())
//            .toString();
//    }
//
//    public boolean equals(Object other) {
//        if ( !(other instanceof TerminalsuccVO) ) return false;
//        TerminalsuccVO castOther = (TerminalsuccVO) other;
//        return new EqualsBuilder()
//            .append(this.getSeq(), castOther.getSeq())
//            .isEquals();
//    }
//
//    public int hashCode() {
//        return new HashCodeBuilder()
//            .append(getSeq())
//            .toHashCode();
//    }

}
