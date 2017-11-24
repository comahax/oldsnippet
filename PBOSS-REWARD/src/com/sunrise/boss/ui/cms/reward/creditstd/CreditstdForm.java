/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.creditstd;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdVO;

/**
 * <p>Title: CreditstdForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CreditstdForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.Short cityid;
    private java.lang.Long slv;
    private java.lang.Double creditstd;
    private java.lang.Double cardstd;
    private java.lang.Long adtypecode;
    private java.lang.String rewardtype;
    private java.lang.String sslv;
    
    //星级档次
    private Long slvlev;
    //长期激励
//    private Double coreward;
//    //门店补贴
//    private Double subsidy;
//    //积分奖励
//    private Double accoutreward;
    //星级奖励标准上限
    private Double rewardstd;
    
    private Double rewardstd11;

    private String _ne_cityid;
    private String _ne_slv;
    private String _ne_adtypecode;
    private String _ne_slvlev;
    
    // add by liuchao 20111022,用于接收在页面提交的数据,一次提交很多条,所以试数组的形式]
    private String cardstds[];
    private String creditstds[];
    private String rewardstds[];
    private String ruleids[];
    private String intvmonths[];
//    private String subsidys[];
    private String ruleid;
    private Long intvmonth;
    private Long rewardid;
    private String rewardname;
    
    //20111217 是否关联星级 true,false
    private String isstar;
    
	public String getIsstar() {
		return isstar;
	}

	public void setIsstar(String isstar) {
		this.isstar = isstar;
	}

	public String getRewardname() {
		return rewardname;
	}

	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}

	public Double getRewardstd11() {
		return rewardstd11;
	}

	public void setRewardstd11(Double rewardstd11) {
		this.rewardstd11 = rewardstd11;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public Long getIntvmonth() {
		return intvmonth;
	}

	public void setIntvmonth(Long intvmonth) {
		this.intvmonth = intvmonth;
	}

	public java.lang.String getSslv() {
		return sslv;
	}

	public void setSslv(java.lang.String sslv) {
		this.sslv = sslv;
	}

//	public String[] getSubsidys() {
//		return subsidys;
//	}
//
//	public void setSubsidys(String[] subsidys) {
//		this.subsidys = subsidys;
//	}

	public String[] getCardstds() {
		return cardstds;
	}

	public void setCardstds(String[] cardstds) {
		this.cardstds = cardstds;
	}

	public String[] getCreditstds() {
		return creditstds;
	}

	public void setCreditstds(String[] creditstds) {
		this.creditstds = creditstds;
	}

	public String[] getRewardstds() {
		return rewardstds;
	}

	public void setRewardstds(String[] rewardstds) {
		this.rewardstds = rewardstds;
	}

	public String[] getRuleids() {
		return ruleids;
	}

	public void setRuleids(String[] ruleids) {
		this.ruleids = ruleids;
	}

	public String[] getIntvmonths() {
		return intvmonths;
	}

	public void setIntvmonths(String[] intvmonths) {
		this.intvmonths = intvmonths;
	}

	public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.Short getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.Short cityid){
        this.cityid = cityid;
    }
    public java.lang.Long getSlv(){
        return slv;
    }

    public void setSlv(java.lang.Long slv){
        this.slv = slv;
    }
    public java.lang.Double getCreditstd(){
        return creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd){
        this.creditstd = creditstd;
    }
    public java.lang.Double getCardstd(){
        return cardstd;
    }

    public void setCardstd(java.lang.Double cardstd){
        this.cardstd = cardstd;
    }

    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_ne_slv(){
        return _ne_slv;
    }

    public void set_ne_slv(String _ne_slv){
        this._ne_slv = _ne_slv;
    }

	public java.lang.Long getAdtypecode() {
		return adtypecode;
	}

	public void setAdtypecode(java.lang.Long adtypecode) {
		this.adtypecode = adtypecode;
	}

	public String get_ne_adtypecode() {
		return _ne_adtypecode;
	}

	public void set_ne_adtypecode(String _ne_adtypecode) {
		this._ne_adtypecode = _ne_adtypecode;
	}

	public Long getSlvlev() {
		return slvlev;
	}

	public void setSlvlev(Long slvlev) {
		this.slvlev = slvlev;
	}

//	public Double getCoreward() {
//		return coreward;
//	}
//
//	public void setCoreward(Double coreward) {
//		this.coreward = coreward;
//	}
//
//	public Double getSubsidy() {
//		return subsidy;
//	}
//
//	public void setSubsidy(Double subsidy) {
//		this.subsidy = subsidy;
//	}
//
//	public Double getAccoutreward() {
//		return accoutreward;
//	}
//
//	public void setAccoutreward(Double accoutreward) {
//		this.accoutreward = accoutreward;
//	}

	public Double getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public String get_ne_slvlev() {
		return _ne_slvlev;
	}

	public void set_ne_slvlev(String _ne_slvlev) {
		this._ne_slvlev = _ne_slvlev;
	}

	public java.lang.String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(java.lang.String rewardtype) {
		this.rewardtype = rewardtype;
	}

}
