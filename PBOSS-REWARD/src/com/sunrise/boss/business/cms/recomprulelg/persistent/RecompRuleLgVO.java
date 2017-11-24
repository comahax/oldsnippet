package com.sunrise.boss.business.cms.recomprulelg.persistent;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RecompRuleLgVO implements Serializable {
	
	private static final long serialVersionUID = 509805471619614336L;

	/** identifier field */
    private Long logid;

    /** persistent field */
    private java.sql.Timestamp optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Integer recid;

    /** nullable persistent field */
    private Long target;

    /** nullable persistent field */
    private Double quotiety;

    /** nullable persistent field */
    private String balanceterm;

    /** nullable persistent field */
    private Double standard;

    /** nullable persistent field */
    private String comtype;

    /** nullable persistent field */
    private String bchlevel;

    /** nullable persistent field */
    private Double integral;

    /** nullable persistent field */
    private String businesstype;

    /** nullable persistent field */
    private Integer prodid;

    /** nullable persistent field */
    private String prosalecode;

    /** nullable persistent field */
    private Integer salseprodid;

    /** nullable persistent field */
    private Long inyxplanid;

    /** nullable persistent field */
    private java.sql.Timestamp intime;

    /** nullable persistent field */
    private Short custstate;

    /** nullable persistent field */
    private Short chargetype;

    /** nullable persistent field */
    private Short moment;

    /** nullable persistent field */
    private Short fitstation;

    /** nullable persistent field */
    private String fitopr;

    /** persistent field */
    private String bossarea;

    /** nullable persistent field */
    private String calculatemode;
    
    /** nullable persistent field */
    private java.sql.Timestamp starttime;

    /** nullable persistent field */
    private java.sql.Timestamp stoptime;

    /** nullable persistent field */
    private Short pri;

	/** default constructor */
    public RecompRuleLgVO() {
    }

    public RecompRuleLgVO(String balanceterm, String bchlevel, String bossarea, String businesstype, String calculatemode, Short chargetype, String comtype, Short custstate, String fitopr, Short fitstation, Double integral, Timestamp intime, Long inyxplanid, Long logid, Short moment, String oprcode, String oprtype, Timestamp optime, Short pri, Integer prodid, String prosalecode, Double quotiety, Integer recid, Integer salseprodid, Double standard, Timestamp starttime, Timestamp stoptime, String success, Long target) {
		super();
		// TODO Auto-generated constructor stub
		this.balanceterm = balanceterm;
		this.bchlevel = bchlevel;
		this.bossarea = bossarea;
		this.businesstype = businesstype;
		this.calculatemode = calculatemode;
		this.chargetype = chargetype;
		this.comtype = comtype;
		this.custstate = custstate;
		this.fitopr = fitopr;
		this.fitstation = fitstation;
		this.integral = integral;
		this.intime = intime;
		this.inyxplanid = inyxplanid;
		this.logid = logid;
		this.moment = moment;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.optime = optime;
		this.pri = pri;
		this.prodid = prodid;
		this.prosalecode = prosalecode;
		this.quotiety = quotiety;
		this.recid = recid;
		this.salseprodid = salseprodid;
		this.standard = standard;
		this.starttime = starttime;
		this.stoptime = stoptime;
		this.success = success;
		this.target = target;
	}

	public RecompRuleLgVO(Timestamp optime, String oprcode, String oprtype, String bossarea) {
		super();
		// TODO 自动生成构造函数存根
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.bossarea = bossarea;
	}

	public Short getPri() {
		return pri;
	}

	public void setPri(Short pri) {
		this.pri = pri;
	}

	public java.sql.Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(java.sql.Timestamp starttime) {
		this.starttime = starttime;
	}

	public java.sql.Timestamp getStoptime() {
		return stoptime;
	}

	public void setStoptime(java.sql.Timestamp stoptime) {
		this.stoptime = stoptime;
	}

	public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

 

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
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

    public java.lang.Integer getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Integer recid) {
        this.recid = recid;
    }

    public java.lang.Long getTarget() {
        return this.target;
    }

    public void setTarget(java.lang.Long target) {
        this.target = target;
    }

    public java.lang.Double getQuotiety() {
        return this.quotiety;
    }

    public void setQuotiety(java.lang.Double quotiety) {
        this.quotiety = quotiety;
    }

    public java.lang.String getBalanceterm() {
        return this.balanceterm;
    }

    public void setBalanceterm(java.lang.String balanceterm) {
        this.balanceterm = balanceterm;
    }

    public java.lang.Double getStandard() {
        return this.standard;
    }

    public void setStandard(java.lang.Double standard) {
        this.standard = standard;
    }

    public java.lang.String getComtype() {
        return this.comtype;
    }

    public void setComtype(java.lang.String comtype) {
        this.comtype = comtype;
    }

    public java.lang.String getBchlevel() {
        return this.bchlevel;
    }

    public void setBchlevel(java.lang.String bchlevel) {
        this.bchlevel = bchlevel;
    }

    public java.lang.Double getIntegral() {
        return this.integral;
    }

    public void setIntegral(java.lang.Double integral) {
        this.integral = integral;
    }

    public java.lang.String getBusinesstype() {
        return this.businesstype;
    }

    public void setBusinesstype(java.lang.String businesstype) {
        this.businesstype = businesstype;
    }

    public java.lang.Integer getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.Integer prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getProsalecode() {
        return this.prosalecode;
    }

    public void setProsalecode(java.lang.String prosalecode) {
        this.prosalecode = prosalecode;
    }

    public java.lang.Integer getSalseprodid() {
        return this.salseprodid;
    }

    public void setSalseprodid(java.lang.Integer salseprodid) {
        this.salseprodid = salseprodid;
    }

    public java.lang.Long getInyxplanid() {
        return this.inyxplanid;
    }

    public void setInyxplanid(java.lang.Long inyxplanid) {
        this.inyxplanid = inyxplanid;
    }

    

    public java.sql.Timestamp getIntime() {
		return intime;
	}

	public void setIntime(java.sql.Timestamp intime) {
		this.intime = intime;
	}

	public java.sql.Timestamp getOptime() {
		return optime;
	}

	public void setOptime(java.sql.Timestamp optime) {
		this.optime = optime;
	}

	public java.lang.Short getCuststate() {
        return this.custstate;
    }

    public void setCuststate(java.lang.Short custstate) {
        this.custstate = custstate;
    }

    public java.lang.Short getChargetype() {
        return this.chargetype;
    }

    public void setChargetype(java.lang.Short chargetype) {
        this.chargetype = chargetype;
    }

    public java.lang.Short getMoment() {
        return this.moment;
    }

    public void setMoment(java.lang.Short moment) {
        this.moment = moment;
    }

    public java.lang.Short getFitstation() {
        return this.fitstation;
    }

    public void setFitstation(java.lang.Short fitstation) {
        this.fitstation = fitstation;
    }

    public java.lang.String getFitopr() {
        return this.fitopr;
    }

    public void setFitopr(java.lang.String fitopr) {
        this.fitopr = fitopr;
    }

    public java.lang.String getBossarea() {
        return this.bossarea;
    }

    public void setBossarea(java.lang.String bossarea) {
        this.bossarea = bossarea;
    }

    public java.lang.String getCalculatemode() {
        return this.calculatemode;
    }

    public void setCalculatemode(java.lang.String calculatemode) {
        this.calculatemode = calculatemode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RecompRuleLgVO) ) return false;
        RecompRuleLgVO castOther = (RecompRuleLgVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
