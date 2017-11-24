package com.sunrise.boss.business.cms.reward.creditstd.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VCreditstdVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Long slv;

    /** nullable persistent field */
    private Double creditstd;

    /** nullable persistent field */
    private Double cardstd;
    
    /** nullable persistent field */
    private Long adtypecode;
    
    //星级档次
    private Long slvlev;
    //星级奖励标准上限
    private Double rewardstd;
    
    private Short rewardtype;
    
    private String nums;
    
    private Long rewardid;
    
    private Short rewardtype1;
    
    private String nums1;
    
	public Short getRewardtype1() {
		return rewardtype1;
	}

	public void setRewardtype1(Short rewardtype1) {
		this.rewardtype1 = rewardtype1;
	}

	public String getNums1() {
		return nums1;
	}

	public void setNums1(String nums1) {
		this.nums1 = nums1;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	/** full constructor */
    public VCreditstdVO(java.lang.Long seq, java.lang.Short cityid, java.lang.Long slv, java.lang.Double creditstd, java.lang.Double cardstd, java.lang.Long adtypecode, java.lang.Long slvlev) {
        this.seq = seq;
        this.cityid = cityid;
        this.slv = slv;
        this.creditstd = creditstd;
        this.cardstd = cardstd;
        this.adtypecode = adtypecode;
        
        this.slvlev = slvlev;
    }

    /** default constructor */
    public VCreditstdVO() {
    }

    /** minimal constructor */
    public VCreditstdVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.Long slv) {
        this.slv = slv;
    }

    public java.lang.Double getCreditstd() {
        return this.creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd) {
        this.creditstd = creditstd;
    }

    public java.lang.Double getCardstd() {
        return this.cardstd;
    }

    public void setCardstd(java.lang.Double cardstd) {
        this.cardstd = cardstd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VCreditstdVO) ) return false;
        VCreditstdVO castOther = (VCreditstdVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public Long getAdtypecode() {
		return adtypecode;
	}

	public void setAdtypecode(Long adtypecode) {
		this.adtypecode = adtypecode;
	}

	public Long getSlvlev() {
		return slvlev;
	}

	public void setSlvlev(Long slvlev) {
		this.slvlev = slvlev;
	}


	public Double getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}

}
