package com.sunrise.boss.business.cms.stdrewardbs.persistent;

import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;


/** @author linli */
public class V_StdrewardbsVO implements OperationLog{

 
    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;
    
    private String slv;
    
    private String slvtc;
    
    /** nullable persistent field */
    private Double citystd;

    /** nullable persistent field */
    private Double countrystd;
    
    /** nullable persistent field */
    private Double citystd2;

    /** nullable persistent field */
    private Double countrystd2;
    
    private Short acctype;
    
    // ÐÂÔö×Ö¶Î 2011.4.23
    private Double mpcitystd;
    private Double mpcountrystd;
    private Double secitystd;
    private Double secountrystd;

    //add by liuchao 20111029
    private Long citycorelimit;
    private Long countycorelimit;
    private Long cityaccountlimit;
    private Long countyaccountlimit;
    
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

	public Long getCityaccountlimit() {
		return cityaccountlimit;
	}

	public void setCityaccountlimit(Long cityaccountlimit) {
		this.cityaccountlimit = cityaccountlimit;
	}

	public Long getCountyaccountlimit() {
		return countyaccountlimit;
	}

	public void setCountyaccountlimit(Long countyaccountlimit) {
		this.countyaccountlimit = countyaccountlimit;
	}

	public Short getAcctype() {
		return acctype;
	}

	public void setAcctype(Short acctype) {
		this.acctype = acctype;
	}

	public Double getCitystd() {
		return citystd;
	}

	public void setCitystd(Double citystd) {
		this.citystd = citystd;
	}

	public Double getCitystd2() {
		return citystd2;
	}

	public void setCitystd2(Double citystd2) {
		this.citystd2 = citystd2;
	}

	public Double getCountrystd() {
		return countrystd;
	}

	public void setCountrystd(Double countrystd) {
		this.countrystd = countrystd;
	}

	public Double getCountrystd2() {
		return countrystd2;
	}

	public void setCountrystd2(Double countrystd2) {
		this.countrystd2 = countrystd2;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public String getSlv() {
		return slv;
	}

	public void setSlv(String slv) {
		this.slv = slv;
	}

	public String getSlvtc() {
		return slvtc;
	}

	public void setSlvtc(String slvtc) {
		this.slvtc = slvtc;
	}

	public Class logVOClass() {
//		 TODO Auto-generated method stub
		return StdrewardbslogVO.class;
	}

	public Double getMpcitystd() {
		return mpcitystd;
	}

	public void setMpcitystd(Double mpcitystd) {
		this.mpcitystd = mpcitystd;
	}

	public Double getMpcountrystd() {
		return mpcountrystd;
	}

	public void setMpcountrystd(Double mpcountrystd) {
		this.mpcountrystd = mpcountrystd;
	}

	public Double getSecitystd() {
		return secitystd;
	}

	public void setSecitystd(Double secitystd) {
		this.secitystd = secitystd;
	}

	public Double getSecountrystd() {
		return secountrystd;
	}

	public void setSecountrystd(Double secountrystd) {
		this.secountrystd = secountrystd;
	}

}

