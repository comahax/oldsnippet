/**
* auto-generated code
* Fri Jul 08 09:50:15 CST 2011
*/
package com.sunrise.boss.ui.cms.salereward;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardVO;

/**
 * <p>Title: SalerewardForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class SalerewardForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.Long slv;
    private java.lang.Short cityid;
    private java.lang.Double rewardstd;
    private java.lang.String remark;
    private java.lang.String opercode;
    private java.lang.String opertype;
    private java.util.Date opertime;

    private String ruleitemids[];
    private String paramervalues[];
    
    
    
    public String[] getRuleitemids() {
		return ruleitemids;
	}

	public void setRuleitemids(String[] ruleitemids) {
		this.ruleitemids = ruleitemids;
	}

	public String[] getParamervalues() {
		return paramervalues;
	}

	public void setParamervalues(String[] paramervalues) {
		this.paramervalues = paramervalues;
	}

	public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.Long getSlv(){
        return slv;
    }

    public void setSlv(java.lang.Long slv){
        this.slv = slv;
    }
    public java.lang.Short getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.Short cityid){
        this.cityid = cityid;
    }
    public java.lang.Double getRewardstd(){
        return rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd){
        this.rewardstd = rewardstd;
    }
    public java.lang.String  getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    }
    public java.lang.String getOpercode(){
        return opercode;
    }

    public void setOpercode(java.lang.String opercode){
        this.opercode = opercode;
    }
    public java.lang.String getOpertype(){
        return opertype;
    }

    public void setOpertype(java.lang.String opertype){
        this.opertype = opertype;
    }
    public java.util.Date getOpertime(){
        return opertime;
    }

    public void setOpertime(java.util.Date opertime){
        this.opertime = opertime;
    }


}
