package com.sunrise.boss.business.fee.billing.bltouchrule.persistent;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;



public class BlTouchRuleVO implements java.io.Serializable {

	// Fields

	private Long ruleid;

	private Timestamp settime;

	private Long rulepri;

	private Long rulestate;

	private Long validbillcyc;

	private Long fixstate;

	private Timestamp fixstime;

	private Timestamp fixetime;

	private Long usrbillstate;

	private Timestamp usrbillstime;

	private Timestamp usrbilletime;

	private Long accbillstate;

	private Timestamp accbillstime;

	private Timestamp accbilletime;

	private Long cfmbillstate;

	private Timestamp cfmbillstime;

	private Timestamp cfmbilletime;

	private Long isincrdecr;

	private Long confirmway;

	private String region;

	private String batchnum;

	private String rulesource;

	private String rulecontent;
	
	private Long woffstate; 
	
	private Timestamp wofftime;

	private Timestamp woffetime;
	
	private Long prmcfmstate; 
	
	private Timestamp prmcfmtime;
	
	private Long fixcfmstate; 
	
	private Timestamp fixcfmtime;
	
	
	private Long reducestate; 
	
	private Timestamp reducestime;

	private Timestamp reduceetime;
	
	private String startstep;    //写出帐启动日志用,出帐步骤 101,102,103,104,105
	
	private String startrsn; 	//写出帐启动日志用,出帐原因
	
	private Long nullrecstate; 
	
	private Timestamp nullrecstime;

	private Timestamp nullrecetime;
	
	private Long dgfixfeestate; 
	
	private Timestamp dgfixfeestime;

	private Timestamp dgfixfeeetime;

	// Constructors

	public Timestamp getWoffetime() {
		return woffetime;
	}

	public void setWoffetime(Timestamp woffetime) {
		this.woffetime = woffetime;
	}

	public Long getWoffstate() {
		return woffstate;
	}

	public void setWoffstate(Long woffstate) {
		this.woffstate = woffstate;
	}

	public Timestamp getWofftime() {
		return wofftime;
	}

	public void setWofftime(Timestamp wofftime) {
		this.wofftime = wofftime;
	}

	/** default constructor */
	public BlTouchRuleVO() {
	}

	// Property accessors

	public Long getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}

	public Timestamp getSettime() {
		return this.settime;
	}

	public void setSettime(Timestamp settime) {
		this.settime = settime;
	}

	public Long getRulepri() {
		return this.rulepri;
	}

	public void setRulepri(Long rulepri) {
		this.rulepri = rulepri;
	}

	public Long getRulestate() {
		return this.rulestate;
	}

	public void setRulestate(Long rulestate) {
		this.rulestate = rulestate;
	}

	public Long getValidbillcyc() {
		return this.validbillcyc;
	}

	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}

	public Long getFixstate() {
		return this.fixstate;
	}

	public void setFixstate(Long fixstate) {
		this.fixstate = fixstate;
	}

	public Timestamp getFixstime() {
		return this.fixstime;
	}

	public void setFixstime(Timestamp fixstime) {
		this.fixstime = fixstime;
	}

	public Timestamp getFixetime() {
		return this.fixetime;
	}

	public void setFixetime(Timestamp fixetime) {
		this.fixetime = fixetime;
	}

	public Long getUsrbillstate() {
		return this.usrbillstate;
	}

	public void setUsrbillstate(Long usrbillstate) {
		this.usrbillstate = usrbillstate;
	}

	public Timestamp getUsrbillstime() {
		return this.usrbillstime;
	}

	public void setUsrbillstime(Timestamp usrbillstime) {
		this.usrbillstime = usrbillstime;
	}

	public Timestamp getUsrbilletime() {
		return this.usrbilletime;
	}

	public void setUsrbilletime(Timestamp usrbilletime) {
		this.usrbilletime = usrbilletime;
	}

	public Long getAccbillstate() {
		return this.accbillstate;
	}

	public void setAccbillstate(Long accbillstate) {
		this.accbillstate = accbillstate;
	}

	public Timestamp getAccbillstime() {
		return this.accbillstime;
	}

	public void setAccbillstime(Timestamp accbillstime) {
		this.accbillstime = accbillstime;
	}

	public Timestamp getAccbilletime() {
		return this.accbilletime;
	}

	public void setAccbilletime(Timestamp accbilletime) {
		this.accbilletime = accbilletime;
	}

	public Long getCfmbillstate() {
		return this.cfmbillstate;
	}

	public void setCfmbillstate(Long cfmbillstate) {
		this.cfmbillstate = cfmbillstate;
	}

	public Timestamp getCfmbillstime() {
		return this.cfmbillstime;
	}

	public void setCfmbillstime(Timestamp cfmbillstime) {
		this.cfmbillstime = cfmbillstime;
	}

	public Timestamp getCfmbilletime() {
		return this.cfmbilletime;
	}

	public void setCfmbilletime(Timestamp cfmbilletime) {
		this.cfmbilletime = cfmbilletime;
	}

	public Long getIsincrdecr() {
		return this.isincrdecr;
	}

	public void setIsincrdecr(Long isincrdecr) {
		this.isincrdecr = isincrdecr;
	}

	public Long getConfirmway() {
		return this.confirmway;
	}

	public void setConfirmway(Long confirmway) {
		this.confirmway = confirmway;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBatchnum() {
		return this.batchnum;
	}

	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}

	public String getRulesource() {
		return this.rulesource;
	}

	public void setRulesource(String rulesource) {
		this.rulesource = rulesource;
	}

	public String getRulecontent() {
		return this.rulecontent;
	}

	public void setRulecontent(String rulecontent) {
		this.rulecontent = rulecontent;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BlTouchRuleVO))
			return false;
		BlTouchRuleVO castOther = (BlTouchRuleVO) other;
		return new EqualsBuilder().append(this.getRuleid(),
				castOther.getRuleid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRuleid()).toHashCode();
	}

	public String getStartstep() {
		return startstep;
	}

	public void setStartstep(String startstep) {
		this.startstep = startstep;
	}

	public String getStartrsn() {
		return startrsn;
	}

	public void setStartrsn(String startrsn) {
		this.startrsn = startrsn;
	}

	public Long getFixcfmstate() {
		return fixcfmstate;
	}

	public void setFixcfmstate(Long fixcfmstate) {
		this.fixcfmstate = fixcfmstate;
	}

	public Timestamp getFixcfmtime() {
		return fixcfmtime;
	}

	public void setFixcfmtime(Timestamp fixcfmtime) {
		this.fixcfmtime = fixcfmtime;
	}

	public Long getPrmcfmstate() {
		return prmcfmstate;
	}

	public void setPrmcfmstate(Long prmcfmstate) {
		this.prmcfmstate = prmcfmstate;
	}

	public Timestamp getPrmcfmtime() {
		return prmcfmtime;
	}

	public void setPrmcfmtime(Timestamp prmcfmtime) {
		this.prmcfmtime = prmcfmtime;
	}

	public Long getReducestate() {
		return reducestate;
	}

	public void setReducestate(Long reducestate) {
		this.reducestate = reducestate;
	}

	public Timestamp getReducestime() {
		return reducestime;
	}

	public void setReducestime(Timestamp reducestime) {
		this.reducestime = reducestime;
	}

	public Timestamp getReduceetime() {
		return reduceetime;
	}

	public void setReduceetime(Timestamp reduceetime) {
		this.reduceetime = reduceetime;
	}

	public Long getNullrecstate() {
		return nullrecstate;
	}

	public void setNullrecstate(Long nullrecstate) {
		this.nullrecstate = nullrecstate;
	}

	public Timestamp getNullrecstime() {
		return nullrecstime;
	}

	public void setNullrecstime(Timestamp nullrecstime) {
		this.nullrecstime = nullrecstime;
	}

	public Timestamp getNullrecetime() {
		return nullrecetime;
	}

	public void setNullrecetime(Timestamp nullrecetime) {
		this.nullrecetime = nullrecetime;
	}

	public Long getDgfixfeestate() {
		return dgfixfeestate;
	}

	public void setDgfixfeestate(Long dgfixfeestate) {
		this.dgfixfeestate = dgfixfeestate;
	}

	public Timestamp getDgfixfeestime() {
		return dgfixfeestime;
	}

	public void setDgfixfeestime(Timestamp dgfixfeestime) {
		this.dgfixfeestime = dgfixfeestime;
	}

	public Timestamp getDgfixfeeetime() {
		return dgfixfeeetime;
	}

	public void setDgfixfeeetime(Timestamp dgfixfeeetime) {
		this.dgfixfeeetime = dgfixfeeetime;
	}

}