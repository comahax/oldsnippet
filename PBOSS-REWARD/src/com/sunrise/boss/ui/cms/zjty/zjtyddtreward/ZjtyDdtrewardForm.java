/**
* auto-generated code
* Tue Jul 07 16:26:52 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtyddtreward;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardVO;

/**
 * <p>Title: ZjtyDdtrewardForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDdtrewardForm extends BaseActionForm {

    private Long seqid;
    private Short ddttype;
    private String wayid;
    private String rewardmont;
    private Double amount;
    private String remark;
    
    private String _snl_rewardmont;
	
	private String _snm_rewardmont;
	
	private String _se_wayid;
	
	private String _se_ddttype;

	public String get_se_ddttype() {
		return _se_ddttype;
	}

	public void set_se_ddttype(String _se_ddttype) {
		this._se_ddttype = _se_ddttype;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_snl_rewardmont() {
		return _snl_rewardmont;
	}

	public void set_snl_rewardmont(String _snl_rewardmont) {
		this._snl_rewardmont = _snl_rewardmont;
	}

	public String get_snm_rewardmont() {
		return _snm_rewardmont;
	}

	public void set_snm_rewardmont(String _snm_rewardmont) {
		this._snm_rewardmont = _snm_rewardmont;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Short getDdttype() {
		return ddttype;
	}

	public void setDdttype(Short ddttype) {
		this.ddttype = ddttype;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRewardmont() {
		return rewardmont;
	}

	public void setRewardmont(String rewardmont) {
		this.rewardmont = rewardmont;
	}

	public Long getSeqid() {
		return seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
}
