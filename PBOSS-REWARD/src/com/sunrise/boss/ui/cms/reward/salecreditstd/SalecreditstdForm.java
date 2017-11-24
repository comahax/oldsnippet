/**
* auto-generated code
* Wed May 18 10:32:19 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.salecreditstd;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdVO;

/**
 * <p>Title: SalecreditstdForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SalecreditstdForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.Short cityid;
    private java.lang.Long busitype;
    private java.lang.Double creditstd;
    private java.lang.Double limited;
    private java.util.Date updatetime;

    private String _ne_cityid;
    private String _ne_busitype;
    
    private String ruleitemids[];
    private String paramervalues[];
    
    private String ruleitemids0[];
    private String paramervalues0[];
    
    private String linkid[];
    
    
	public String[] getLinkid() {
		return linkid;
	}

	public void setLinkid(String[] linkid) {
		this.linkid = linkid;
	}

	public String[] getParamervalues0() {
		return paramervalues0;
	}

	public void setParamervalues0(String[] paramervalues0) {
		this.paramervalues0 = paramervalues0;
	}

	public String[] getRuleitemids0() {
		return ruleitemids0;
	}

	public void setRuleitemids0(String[] ruleitemids0) {
		this.ruleitemids0 = ruleitemids0;
	}

	public String[] getParamervalues() {
		return paramervalues;
	}

	public void setParamervalues(String[] paramervalues) {
		this.paramervalues = paramervalues;
	}

	public String[] getRuleitemids() {
		return ruleitemids;
	}

	public void setRuleitemids(String[] ruleitemids) {
		this.ruleitemids = ruleitemids;
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
    public java.lang.Long getBusitype(){
        return busitype;
    }

    public void setBusitype(java.lang.Long busitype){
        this.busitype = busitype;
    }
    public java.lang.Double getCreditstd(){
        return creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd){
        this.creditstd = creditstd;
    }
    public java.lang.Double getLimited(){
        return limited;
    }

    public void setLimited(java.lang.Double limited){
        this.limited = limited;
    }
    public java.util.Date getUpdatetime(){
        return updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime){
        this.updatetime = updatetime;
    }

    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_ne_busitype(){
        return _ne_busitype;
    }

    public void set_ne_busitype(String _ne_busitype){
        this._ne_busitype = _ne_busitype;
    }

}
