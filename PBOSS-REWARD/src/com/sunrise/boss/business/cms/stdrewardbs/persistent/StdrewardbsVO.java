package com.sunrise.boss.business.cms.stdrewardbs.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardbsVO implements OperationLog {

    /** identifier field */
    private Short islimt;
 
    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** persistent field */
    private String slv;

    private String slvtc;
    
    /** nullable persistent field */
    private Double citystd;

    /** nullable persistent field */
    private Double countrystd;
    
    private Short acctype;
    private Long basicsalenum;
    private Long topsalenum;
    private Double citystdlow;
    private Double countrystdlow;
    private Double citystdmid;
    private Double countrystdmid;
    private Double citystdtop;
    private Double countrystdtop;
    
    private Double ttcitystd;
    private Double ttcountrystd;
    
    private Short intvmonth;
    
    private Long citycorelimit;
    private Long countycorelimit;
    private Long countyaccountlimit;
    private Long cityaccountlimit;
    
	public Long getCitycorelimit() {
		return citycorelimit;
	}

	public void setCitycorelimit(Long citycorelimit) {
		this.citycorelimit = citycorelimit;
	}

	public Long getCountycorelimit() {
		return countycorelimit;
	}

	public void setCountycorelimit(Long countycorelimit) {
		this.countycorelimit = countycorelimit;
	}

	public Long getCountyaccountlimit() {
		return countyaccountlimit;
	}

	public void setCountyaccountlimit(Long countyaccountlimit) {
		this.countyaccountlimit = countyaccountlimit;
	}

	public Long getCityaccountlimit() {
		return cityaccountlimit;
	}

	public void setCityaccountlimit(Long cityaccountlimit) {
		this.cityaccountlimit = cityaccountlimit;
	}

	/** full constructor */
    public StdrewardbsVO(java.lang.Short islimt, java.lang.String region, java.lang.Long rewardid, java.lang.String slv, java.lang.Double citystd, java.lang.Double countrystd,
    					java.lang.Short acctype, java.lang.Long basicsalenum, java.lang.Long topsalenum, 
    					java.lang.Double citystdlow, java.lang.Double countrystdlow,
    					java.lang.Double citystdmid, java.lang.Double countrystdmid,
    					java.lang.Double citystdtop, java.lang.Double countrystdtop, java.lang.Double ttcitystd, java.lang.Double ttcountrystd, java.lang.Short intvmonth){
        this.islimt = islimt;
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
        this.citystd = citystd;
        this.countrystd = countrystd;
        this.acctype = acctype;
        this.basicsalenum   = basicsalenum  ;        
        this.topsalenum     = topsalenum    ;        
        this.citystdlow     = citystdlow    ;        
        this.countrystdlow  = countrystdlow ;        
        this.citystdmid     = citystdmid    ;        
        this.countrystdmid  = countrystdmid ;        
        this.citystdtop     = citystdtop    ;        
        this.countrystdtop  = countrystdtop ;
        this.ttcitystd 		= ttcitystd		;
        this.ttcountrystd	= ttcountrystd	;
        this.intvmonth		= intvmonth		;
    }

    /** default constructor */
    public StdrewardbsVO() {
    }

    /** minimal constructor */
    public StdrewardbsVO(java.lang.Short islimt, java.lang.String region, java.lang.Long rewardid, java.lang.String slv) {
        this.islimt = islimt;
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
    }

    public java.lang.Short getIslimt() {
        return this.islimt;
    }

    public void setIslimt(java.lang.Short islimt) {
        this.islimt = islimt;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.String slv) {
        this.slv = slv;
    }

    public java.lang.Double getCitystd() {
        return this.citystd;
    }

    public void setCitystd(java.lang.Double citystd) {
        this.citystd = citystd;
    }

    public java.lang.Double getCountrystd() {
        return this.countrystd;
    }

    public void setCountrystd(java.lang.Double countrystd) {
        this.countrystd = countrystd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("islimt", getIslimt())
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbsVO) ) return false;
        StdrewardbsVO castOther = (StdrewardbsVO) other;
        return new EqualsBuilder()
            .append(this.getIslimt(), castOther.getIslimt())
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getIslimt())
            .append(getRegion())
            .append(getRewardid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return StdrewardbslogVO.class;
	}

	public String getSlvtc() {
		return slvtc;
	}

	public void setSlvtc(String slvtc) {
		this.slvtc = slvtc;
	}

	public Short getAcctype() {
		return acctype;
	}

	public void setAcctype(Short acctype) {
		this.acctype = acctype;
	}


	public Long getBasicsalenum() {
		return basicsalenum;
	}

	public void setBasicsalenum(Long basicsalenum) {
		this.basicsalenum = basicsalenum;
	}

	public Long getTopsalenum() {
		return topsalenum;
	}

	public void setTopsalenum(Long topsalenum) {
		this.topsalenum = topsalenum;
	}

	public Double getCitystdlow() {
		return citystdlow;
	}

	public void setCitystdlow(Double citystdlow) {
		this.citystdlow = citystdlow;
	}

	public Double getCountrystdlow() {
		return countrystdlow;
	}

	public void setCountrystdlow(Double countrystdlow) {
		this.countrystdlow = countrystdlow;
	}

	public Double getCitystdmid() {
		return citystdmid;
	}

	public void setCitystdmid(Double citystdmid) {
		this.citystdmid = citystdmid;
	}

	public Double getCountrystdmid() {
		return countrystdmid;
	}

	public void setCountrystdmid(Double countrystdmid) {
		this.countrystdmid = countrystdmid;
	}

	public Double getCitystdtop() {
		return citystdtop;
	}

	public void setCitystdtop(Double citystdtop) {
		this.citystdtop = citystdtop;
	}

	public Double getCountrystdtop() {
		return countrystdtop;
	}

	public void setCountrystdtop(Double countrystdtop) {
		this.countrystdtop = countrystdtop;
	}

	public Double getTtcitystd() {
		return ttcitystd;
	}

	public void setTtcitystd(Double ttcitystd) {
		this.ttcitystd = ttcitystd;
	}

	public Double getTtcountrystd() {
		return ttcountrystd;
	}

	public void setTtcountrystd(Double ttcountrystd) {
		this.ttcountrystd = ttcountrystd;
	}

	public Short getIntvmonth() {
		return intvmonth;
	}

	public void setIntvmonth(Short intvmonth) {
		this.intvmonth = intvmonth;
	}
	
}

