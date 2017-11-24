package com.gmcc.pboss.business.reward.chcwpaymentsend;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChCwPaymentsendVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long sseq;

    /** nullable persistent field */
    private String optype;

    /** nullable persistent field */
    private String paymonth;

    /** nullable persistent field */
    private String stype;

    /** nullable persistent field */
    private String payee;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private String rewardstd;

    /** nullable persistent field */
    private String rule;

    /** nullable persistent field */
    private String deduction;

    /** nullable persistent field */
    private String batch;

    /** nullable persistent field */
    private String note;

    /** nullable persistent field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String bank;

    /** nullable persistent field */
    private String depositbank;

    /** nullable persistent field */
    private String account;

    /** nullable persistent field */
    private String billnumber;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String pubpri;

    /** nullable persistent field */
    private Float rate;

    /** nullable persistent field */
    private String sbatch;

    /** nullable persistent field */
    private Byte state;

    /** nullable persistent field */
    private String employeeNum;

    /** nullable persistent field */
    private String employeeName;

    /** nullable persistent field */
    private Long deptId;

    /** nullable persistent field */
    private String cityid;

    /** full constructor */
    public ChCwPaymentsendVO(java.lang.Long sseq, java.lang.String optype, java.lang.String paymonth, java.lang.String stype, java.lang.String payee, java.lang.Double paysum, java.lang.String rewardstd, java.lang.String rule, java.lang.String deduction, java.lang.String batch, java.lang.String note, java.lang.Long seq, java.lang.String wayid, java.lang.String bank, java.lang.String depositbank, java.lang.String account, java.lang.String billnumber, java.lang.String countyid, java.lang.String pubpri, java.lang.Float rate, java.lang.String sbatch, java.lang.Byte state, java.lang.String employeeNum, java.lang.String employeeName, java.lang.Long deptId, java.lang.String cityid) {
        this.sseq = sseq;
        this.optype = optype;
        this.paymonth = paymonth;
        this.stype = stype;
        this.payee = payee;
        this.paysum = paysum;
        this.rewardstd = rewardstd;
        this.rule = rule;
        this.deduction = deduction;
        this.batch = batch;
        this.note = note;
        this.seq = seq;
        this.wayid = wayid;
        this.bank = bank;
        this.depositbank = depositbank;
        this.account = account;
        this.billnumber = billnumber;
        this.countyid = countyid;
        this.pubpri = pubpri;
        this.rate = rate;
        this.sbatch = sbatch;
        this.state = state;
        this.employeeNum = employeeNum;
        this.employeeName = employeeName;
        this.deptId = deptId;
        this.cityid = cityid;
    }

    /** default constructor */
    public ChCwPaymentsendVO() {
    }

    /** minimal constructor */
	public ChCwPaymentsendVO(String sbatch) {
		this.sbatch = sbatch;
	}
    
    /** minimal constructor */
    public ChCwPaymentsendVO(java.lang.Long sseq) {
        this.sseq = sseq;
    }

    public java.lang.Long getSseq() {
        return this.sseq;
    }

    public void setSseq(java.lang.Long sseq) {
        this.sseq = sseq;
    }

    public java.lang.String getOptype() {
        return this.optype;
    }

    public void setOptype(java.lang.String optype) {
        this.optype = optype;
    }

    public java.lang.String getPaymonth() {
        return this.paymonth;
    }

    public void setPaymonth(java.lang.String paymonth) {
        this.paymonth = paymonth;
    }

    public java.lang.String getStype() {
        return this.stype;
    }

    public void setStype(java.lang.String stype) {
        this.stype = stype;
    }

    public java.lang.String getPayee() {
        return this.payee;
    }

    public void setPayee(java.lang.String payee) {
        this.payee = payee;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public java.lang.String getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.String rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.String getRule() {
        return this.rule;
    }

    public void setRule(java.lang.String rule) {
        this.rule = rule;
    }

    public java.lang.String getDeduction() {
        return this.deduction;
    }

    public void setDeduction(java.lang.String deduction) {
        this.deduction = deduction;
    }

    public java.lang.String getBatch() {
        return this.batch;
    }

    public void setBatch(java.lang.String batch) {
        this.batch = batch;
    }

    public java.lang.String getNote() {
        return this.note;
    }

    public void setNote(java.lang.String note) {
        this.note = note;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getBank() {
        return this.bank;
    }

    public void setBank(java.lang.String bank) {
        this.bank = bank;
    }

    public java.lang.String getDepositbank() {
        return this.depositbank;
    }

    public void setDepositbank(java.lang.String depositbank) {
        this.depositbank = depositbank;
    }

    public java.lang.String getAccount() {
        return this.account;
    }

    public void setAccount(java.lang.String account) {
        this.account = account;
    }

    public java.lang.String getBillnumber() {
        return this.billnumber;
    }

    public void setBillnumber(java.lang.String billnumber) {
        this.billnumber = billnumber;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getPubpri() {
        return this.pubpri;
    }

    public void setPubpri(java.lang.String pubpri) {
        this.pubpri = pubpri;
    }

    public java.lang.Float getRate() {
        return this.rate;
    }

    public void setRate(java.lang.Float rate) {
        this.rate = rate;
    }

    public java.lang.String getSbatch() {
        return this.sbatch;
    }

    public void setSbatch(java.lang.String sbatch) {
        this.sbatch = sbatch;
    }

    public java.lang.Byte getState() {
        return this.state;
    }

    public void setState(java.lang.Byte state) {
        this.state = state;
    }

    public java.lang.String getEmployeeNum() {
        return this.employeeNum;
    }

    public void setEmployeeNum(java.lang.String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public java.lang.String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(java.lang.String employeeName) {
        this.employeeName = employeeName;
    }

    public java.lang.Long getDeptId() {
        return this.deptId;
    }

    public void setDeptId(java.lang.Long deptId) {
        this.deptId = deptId;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sseq", getSseq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChCwPaymentsendVO) ) return false;
        ChCwPaymentsendVO castOther = (ChCwPaymentsendVO) other;
        return new EqualsBuilder()
            .append(this.getSseq(), castOther.getSseq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSseq())
            .toHashCode();
    }

}
