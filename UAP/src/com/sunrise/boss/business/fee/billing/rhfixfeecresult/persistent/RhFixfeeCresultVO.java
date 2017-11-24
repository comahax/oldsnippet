package com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class RhFixfeeCresultVO extends BaseVO implements Serializable {

	private Long logid;   
	
	private Integer validbillcyc;  
	
	private Long batch;            
	
	private Integer resulttype;    
	
	private String servnumber;     
	
	private Long subsid;           
	
	private Long acctid;           
	
	private Double paiclup;        
	
	private Double adjust;         
	
	private Double receivable;    
	
	private Byte isaccount;            
	
	private String planlist;     
	
	private String rulelist;     
	
	private String paicluplist;   
	
	private Integer region;        


    /** default constructor */
    public RhFixfeeCresultVO() {
    }

    public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Integer getValidbillcyc() {
		return validbillcyc;
	}

	public void setValidbillcyc(Integer validbillcyc) {
		this.validbillcyc = validbillcyc;
	}

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public Integer getResulttype() {
		return resulttype;
	}

	public void setResulttype(Integer resulttype) {
		this.resulttype = resulttype;
	}

	public String getServnumber() {
		return servnumber;
	}

	public void setServnumber(String servnumber) {
		this.servnumber = servnumber;
	}

	public Long getSubsid() {
		return subsid;
	}

	public void setSubsid(Long subsid) {
		this.subsid = subsid;
	}

	public Long getAcctid() {
		return acctid;
	}

	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}

	public Double getPaiclup() {
		return paiclup;
	}

	public void setPaiclup(Double paiclup) {
		this.paiclup = paiclup;
	}

	public Double getAdjust() {
		return adjust;
	}

	public void setAdjust(Double adjust) {
		this.adjust = adjust;
	}

	public Double getReceivable() {
		return receivable;
	}

	public void setReceivable(Double receivable) {
		this.receivable = receivable;
	}

	public Byte getIsaccount() {
		return isaccount;
	}

	public void setIsaccount(Byte isaccount) {
		this.isaccount = isaccount;
	}

	public String getPlanlist() {
		return planlist;
	}

	public void setPlanlist(String planlist) {
		this.planlist = planlist;
	}

	public String getRulelist() {
		return rulelist;
	}

	public void setRulelist(String rulelist) {
		this.rulelist = rulelist;
	}

	public String getPaicluplist() {
		return paicluplist;
	}

	public void setPaicluplist(String paicluplist) {
		this.paicluplist = paicluplist;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
