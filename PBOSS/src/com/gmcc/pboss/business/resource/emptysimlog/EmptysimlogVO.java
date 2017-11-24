package com.gmcc.pboss.business.resource.emptysimlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EmptysimlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode2;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private String emptyno;

    /** nullable persistent field */
    private Integer cardmill;

    /** nullable persistent field */
    private String iccid;

    /** nullable persistent field */
    private String pukno;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date stoptime;

    /** nullable persistent field */
    private java.util.Date intime;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private Integer simtype;

    /** nullable persistent field */
    private Short usestate;

    /** nullable persistent field */
    private Short backup;

    /** nullable persistent field */
    private java.util.Date entertime;
    
    
    private java.util.Date applytime; //申请时间
    
    private java.util.Date bosssaletime; //boss销售时间
    
    private String countyid;
    
    /** identifier field */
    private Long comid;
    
    /** full constructor */
    public EmptysimlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode2, java.lang.String oprtype, java.lang.String success, java.lang.String emptyno, java.lang.Integer cardmill, java.lang.String iccid, java.lang.String pukno, java.util.Date begintime, java.util.Date stoptime, java.util.Date intime, java.lang.String wayid, java.lang.String oprcode, java.lang.Integer simtype, java.lang.Short usestate, java.lang.Short backup, java.util.Date entertime,java.util.Date applytime,java.util.Date bosssaletime,String countyid,Long comid) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode2 = oprcode2;
        this.oprtype = oprtype;
        this.success = success;
        this.emptyno = emptyno;
        this.cardmill = cardmill;
        this.iccid = iccid;
        this.pukno = pukno;
        this.begintime = begintime;
        this.stoptime = stoptime;
        this.intime = intime;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.simtype = simtype;
        this.usestate = usestate;
        this.backup = backup;
        this.entertime = entertime;
        this.applytime = applytime;
        this.bosssaletime = bosssaletime;
        this.countyid = countyid;
        this.comid = comid;
    }

    /** default constructor */
    public EmptysimlogVO() {
    }

    /** minimal constructor */
    public EmptysimlogVO(java.lang.Long logid, java.lang.String emptyno) {
        this.logid = logid;
        this.emptyno = emptyno;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode2() {
        return this.oprcode2;
    }

    public void setOprcode2(java.lang.String oprcode2) {
        this.oprcode2 = oprcode2;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getEmptyno() {
        return this.emptyno;
    }

    public void setEmptyno(java.lang.String emptyno) {
        this.emptyno = emptyno;
    }

    public java.lang.Integer getCardmill() {
        return this.cardmill;
    }

    public void setCardmill(java.lang.Integer cardmill) {
        this.cardmill = cardmill;
    }

    public java.lang.String getIccid() {
        return this.iccid;
    }

    public void setIccid(java.lang.String iccid) {
        this.iccid = iccid;
    }

    public java.lang.String getPukno() {
        return this.pukno;
    }

    public void setPukno(java.lang.String pukno) {
        this.pukno = pukno;
    }

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getStoptime() {
        return this.stoptime;
    }

    public void setStoptime(java.util.Date stoptime) {
        this.stoptime = stoptime;
    }

    public java.util.Date getIntime() {
        return this.intime;
    }

    public void setIntime(java.util.Date intime) {
        this.intime = intime;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.Integer getSimtype() {
        return this.simtype;
    }

    public void setSimtype(java.lang.Integer simtype) {
        this.simtype = simtype;
    }

    public java.lang.Short getUsestate() {
        return this.usestate;
    }

    public void setUsestate(java.lang.Short usestate) {
        this.usestate = usestate;
    }

    public java.lang.Short getBackup() {
        return this.backup;
    }

    public void setBackup(java.lang.Short backup) {
        this.backup = backup;
    }

    public java.util.Date getEntertime() {
        return this.entertime;
    }

    public void setEntertime(java.util.Date entertime) {
        this.entertime = entertime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmptysimlogVO) ) return false;
        EmptysimlogVO castOther = (EmptysimlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public java.util.Date getApplytime() {
		return applytime;
	}

	public void setApplytime(java.util.Date applytime) {
		this.applytime = applytime;
	}

	public java.util.Date getBosssaletime() {
		return bosssaletime;
	}

	public void setBosssaletime(java.util.Date bosssaletime) {
		this.bosssaletime = bosssaletime;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

}
