package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VCityrecord2VO implements Serializable {

    /** identifier field */
    private Long seqid;
//    private Double sumbusivalue;
    private Double sumpaymoney;
    private Double sumconfirmmoney;
    private Double sumnotconfirmmoney;
    
    private String sumbusivalue;
    private String opnid1;
    private String opnid2;
    private String dictname;
    private String oprmonth;
    private String rewardtype;
    
	public String getSumbusivalue() {
		return sumbusivalue;
	}

	public void setSumbusivalue(String sumbusivalue) {
		this.sumbusivalue = sumbusivalue;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getOpnid1() {
		return opnid1;
	}

	public void setOpnid1(String opnid1) {
		this.opnid1 = opnid1;
	}

	public String getOpnid2() {
		return opnid2;
	}

	public void setOpnid2(String opnid2) {
		this.opnid2 = opnid2;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public String getOprmonth() {
		return oprmonth;
	}

	public void setOprmonth(String oprmonth) {
		this.oprmonth = oprmonth;
	}

	public Long getSeqid() {
		return seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

//	public Double getSumbusivalue() {
//		return sumbusivalue;
//	}
//
//	public void setSumbusivalue(Double sumbusivalue) {
//		this.sumbusivalue = sumbusivalue;
//	}

	public Double getSumpaymoney() {
		return sumpaymoney;
	}

	public void setSumpaymoney(Double sumpaymoney) {
		this.sumpaymoney = sumpaymoney;
	}

	public Double getSumconfirmmoney() {
		return sumconfirmmoney;
	}

	public void setSumconfirmmoney(Double sumconfirmmoney) {
		this.sumconfirmmoney = sumconfirmmoney;
	}

	public Double getSumnotconfirmmoney() {
		return sumnotconfirmmoney;
	}

	public void setSumnotconfirmmoney(Double sumnotconfirmmoney) {
		this.sumnotconfirmmoney = sumnotconfirmmoney;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VCityrecord2VO) ) return false;
        VCityrecord2VO castOther = (VCityrecord2VO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
