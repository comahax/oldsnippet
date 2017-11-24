package com.sunrise.boss.business.fee.billing.checkplanresult.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class CheckPlanResultVO extends BaseVO implements Serializable {

    /** persistent field */
    private Long logid;

    /** nullable persistent field */
    private Integer validbillcyc;

    /** persistent field */
    private Long batch;

    /** nullable persistent field */
    private String prodid;

    /** nullable persistent field */
    private String prodname;

    /** nullable persistent field */
    private String servnumber;

    /** nullable persistent field */
    private Long subsid;

    /** nullable persistent field */
    private String status;

    /** nullable persistent field */
    private Short useddays;

    /** nullable persistent field */
    private String tariffitemid;

    /** nullable persistent field */
    private Long acctid;

    /** nullable persistent field */
    private Double prodfee;

    /** nullable persistent field */
    private Double paiclup;

    /** nullable persistent field */
    private Double adjust;

    /** nullable persistent field */
    private Double receivable;

    /** nullable persistent field */
    private String planlist;

    /** nullable persistent field */
    private String rulelist;

    /** nullable persistent field */
    private String paicluplist;

    /** nullable persistent field */
    private String checkresult;

    /** nullable persistent field */
    private Integer resulttype;
    
    private Integer region;

    /** default constructor */
    public CheckPlanResultVO() {
    }


    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Integer getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Integer validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Long getBatch() {
        return this.batch;
    }

    public void setBatch(java.lang.Long batch) {
        this.batch = batch;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getProdname() {
        return this.prodname;
    }

    public void setProdname(java.lang.String prodname) {
        this.prodname = prodname;
    }

    public java.lang.String getServnumber() {
        return this.servnumber;
    }

    public void setServnumber(java.lang.String servnumber) {
        this.servnumber = servnumber;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.Short getUseddays() {
        return this.useddays;
    }

    public void setUseddays(java.lang.Short useddays) {
        this.useddays = useddays;
    }

    public java.lang.String getTariffitemid() {
        return this.tariffitemid;
    }

    public void setTariffitemid(java.lang.String tariffitemid) {
        this.tariffitemid = tariffitemid;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Double getProdfee() {
        return this.prodfee;
    }

    public void setProdfee(java.lang.Double prodfee) {
        this.prodfee = prodfee;
    }

    public java.lang.Double getPaiclup() {
        return this.paiclup;
    }

    public void setPaiclup(java.lang.Double paiclup) {
        this.paiclup = paiclup;
    }

    public java.lang.Double getAdjust() {
        return this.adjust;
    }

    public void setAdjust(java.lang.Double adjust) {
        this.adjust = adjust;
    }

    public java.lang.Double getReceivable() {
        return this.receivable;
    }

    public void setReceivable(java.lang.Double receivable) {
        this.receivable = receivable;
    }

    public java.lang.String getPlanlist() {
        return this.planlist;
    }

    public void setPlanlist(java.lang.String planlist) {
        this.planlist = planlist;
    }

    public java.lang.String getRulelist() {
        return this.rulelist;
    }

    public void setRulelist(java.lang.String rulelist) {
        this.rulelist = rulelist;
    }

    public java.lang.String getPaicluplist() {
        return this.paicluplist;
    }

    public void setPaicluplist(java.lang.String paicluplist) {
        this.paicluplist = paicluplist;
    }

    public java.lang.String getCheckresult() {
        return this.checkresult;
    }

    public void setCheckresult(java.lang.String checkresult) {
        this.checkresult = checkresult;
    }

    public java.lang.Integer getResulttype() {
        return this.resulttype;
    }

    public void setResulttype(java.lang.Integer resulttype) {
        this.resulttype = resulttype;
    }


	public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }


	public Integer getRegion() {
		return region;
	}


	public void setRegion(Integer region) {
		this.region = region;
	}

}
