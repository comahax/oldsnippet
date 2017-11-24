/**
* auto-generated code
* Sat Jan 05 17:17:55 CST 2013
*/
package com.sunrise.boss.ui.cms.terminalrewardstd;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdVO;

/**
 * <p>Title: TerminalrewardstdForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public class TerminalrewardstdForm extends BaseActionForm {

    private java.lang.String comid;
    private java.lang.Double rewardstd; 
    private java.lang.Short rewardtype;
    private java.lang.Short acctype;
    private java.lang.String adtremark;
    private java.util.Date createtime;
    private java.lang.Short citycode;
    private java.lang.Double standardprice;

    private String _ne_rewardtype;
    private String _ne_citycode;
    private String region;


	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String get_ne_citycode() {
		return _ne_citycode;
	}

	public void set_ne_citycode(String _ne_citycode) {
		this._ne_citycode = _ne_citycode;
	}

	public java.lang.String getComid(){
        return comid;
    }

    public void setComid(java.lang.String comid){
        this.comid = comid;
    }
    public java.lang.Double getRewardstd(){
        return rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd){
        this.rewardstd = rewardstd;
    }
    public java.lang.Short getRewardtype(){
        return rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype){
        this.rewardtype = rewardtype;
    }
    public java.lang.Short getAcctype(){
        return acctype;
    }

    public void setAcctype(java.lang.Short acctype){
        this.acctype = acctype;
    }
    public java.lang.String getAdtremark(){
        return adtremark;
    }

    public void setAdtremark(java.lang.String adtremark){
        this.adtremark = adtremark;
    } 

	public java.util.Date getCreatetime(){
        return createtime;
    }

    public void setCreatetime(java.util.Date createtime){
        this.createtime = createtime;
    }
    public java.lang.Short getCitycode(){
        return citycode;
    }

    public void setCitycode(java.lang.Short citycode){
        this.citycode = citycode;
    }

    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }

	public java.lang.Double getStandardprice() {
		return standardprice;
	}

	public void setStandardprice(java.lang.Double standardprice) {
		this.standardprice = standardprice;
	}

}
