package com.sunrise.boss.business.cms.rewardreport.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardreportVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private Double piece;

    /** nullable persistent field */
    private Double star;

    /** nullable persistent field */
    private Double terminal;

    /** nullable persistent field */
    private Double cooperate;

    /** nullable persistent field */
    private Long isaffirm;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private Double sum;

    /** nullable persistent field */
    private java.util.Date sendtime;
    
    private Double paymoney;//已付酬金
    private String taccount;//收款账户
    private String paccount;//付款账户
    private String memo;//备注

    /** full constructor */
    public RewardreportVO(java.lang.Long seq, java.lang.String wayid, java.lang.String name, java.lang.Double piece, java.lang.Double star, java.lang.Double terminal, java.lang.Double cooperate, java.lang.Long isaffirm, java.lang.String calcmonth, java.lang.Double sum, java.util.Date sendtime, java.lang.Double paymoney, java.lang.String taccount, java.lang.String paccount, java.lang.String memo) {
        this.seq = seq;
        this.wayid = wayid;
        this.name = name;
        this.piece = piece;
        this.star = star;
        this.terminal = terminal;
        this.cooperate = cooperate;
        this.isaffirm = isaffirm;
        this.calcmonth = calcmonth;
        this.sum = sum;
        this.sendtime = sendtime;
        this.paymoney = paymoney;
        this.taccount = taccount;
        this.paccount = paccount;
        this.memo = memo;
    }

    /** default constructor */
    public RewardreportVO() {
    }

    /** minimal constructor */
    public RewardreportVO(java.lang.Long seq) {
        this.seq = seq;
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

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.Double getPiece() {
        return this.piece;
    }

    public void setPiece(java.lang.Double piece) {
        this.piece = piece;
    }

    public java.lang.Double getStar() {
        return this.star;
    }

    public void setStar(java.lang.Double star) {
        this.star = star;
    }

    public java.lang.Double getTerminal() {
        return this.terminal;
    }

    public void setTerminal(java.lang.Double terminal) {
        this.terminal = terminal;
    }

    public java.lang.Double getCooperate() {
        return this.cooperate;
    }

    public void setCooperate(java.lang.Double cooperate) {
        this.cooperate = cooperate;
    }

    public java.lang.Long getIsaffirm() {
        return this.isaffirm;
    }

    public void setIsaffirm(java.lang.Long isaffirm) {
        this.isaffirm = isaffirm;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.Double getSum() {
        return this.sum;
    }

    public void setSum(java.lang.Double sum) {
        this.sum = sum;
    }

    public java.util.Date getSendtime() {
        return this.sendtime;
    }

    public void setSendtime(java.util.Date sendtime) {
        this.sendtime = sendtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardreportVO) ) return false;
        RewardreportVO castOther = (RewardreportVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public Double getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}

	public String getTaccount() {
		return taccount;
	}

	public void setTaccount(String taccount) {
		this.taccount = taccount;
	}

	public String getPaccount() {
		return paccount;
	}

	public void setPaccount(String paccount) {
		this.paccount = paccount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
