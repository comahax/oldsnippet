/**
 * auto-generated code
 * Wed Dec 24 11:06:41 CST 2008
 */
package com.sunrise.boss.ui.cms.rewardadjust;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustVO;

/**
 * <p>Title: RewardadjustForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardadjustForm extends BaseActionForm {
	private String _se_adjustkind;
	private String _se_wayid;
	private String _snl_eftmonth;
	private String _snm_eftmonth;
	private String _se_adjusttype;
	private String _sk_reasontype;
	private String _se_rewardtype;
	private String _ne_islock;
    private String _se_srcmonth;
	private String _nne_islock;
	private String dictid;
	private String dictid2;
	private String[] _selecttype;

	private Long seq;
	private String adjustkind;
	private String wayid;
	private String eftmonth;
	private Double adjmoney;
	private String adjusttype;
	private String reasontype;
	private String remark;
	private String createoprcode;
	private java.util.Date createtime;
	private String updateoprcode;
	private java.util.Date updatetime;
	private Long relateseq;
	private Double actualmoney;
	private Short rewardtype;
	private Short islock;
	private String adtoprcode;
	private java.util.Date adttime;
	private String srcmonth;

	public String get_se_adjustkind() {
		return _se_adjustkind;
	}

	public void set_se_adjustkind(String _se_adjustkind) {
		this._se_adjustkind = _se_adjustkind;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_snl_eftmonth() {
		return _snl_eftmonth;
	}

	public void set_snl_eftmonth(String _snl_eftmonth) {
		this._snl_eftmonth = _snl_eftmonth;
	}

	public String get_snm_eftmonth() {
		return _snm_eftmonth;
	}

	public void set_snm_eftmonth(String _snm_eftmonth) {
		this._snm_eftmonth = _snm_eftmonth;
	}

	public String get_se_adjusttype() {
		return _se_adjusttype;
	}

	public void set_se_adjusttype(String _se_adjusttype) {
		this._se_adjusttype = _se_adjusttype;
	}

	public String get_sk_reasontype() {
		return _sk_reasontype;
	}

	public void set_sk_reasontype(String _sk_reasontype) {
		this._sk_reasontype = _sk_reasontype;
	}

	public String get_se_rewardtype() {
		return _se_rewardtype;
	}

	public void set_se_rewardtype(String _se_rewardtype) {
		this._se_rewardtype = _se_rewardtype;
	}

	public String get_ne_islock() {
		return _ne_islock;
	}

	public void set_ne_islock(String _ne_islock) {
		this._ne_islock = _ne_islock;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getAdjustkind() {
		return adjustkind;
	}

	public void setAdjustkind(String adjustkind) {
		this.adjustkind = adjustkind;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getEftmonth() {
		return eftmonth;
	}

	public void setEftmonth(String eftmonth) {
		this.eftmonth = eftmonth;
	}

	public Double getAdjmoney() {
		return adjmoney;
	}

	public void setAdjmoney(Double adjmoney) {
		this.adjmoney = adjmoney;
	}

	public String getAdjusttype() {
		return adjusttype;
	}

	public void setAdjusttype(String adjusttype) {
		this.adjusttype = adjusttype;
	}

	public String getReasontype() {
		return reasontype;
	}

	public void setReasontype(String reasontype) {
		this.reasontype = reasontype;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateoprcode() {
		return createoprcode;
	}

	public void setCreateoprcode(String createoprcode) {
		this.createoprcode = createoprcode;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public String getUpdateoprcode() {
		return updateoprcode;
	}

	public void setUpdateoprcode(String updateoprcode) {
		this.updateoprcode = updateoprcode;
	}

	public java.util.Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}

	public Long getRelateseq() {
		return relateseq;
	}

	public void setRelateseq(Long relateseq) {
		this.relateseq = relateseq;
	}

	public Double getActualmoney() {
		return actualmoney;
	}

	public void setActualmoney(Double actualmoney) {
		this.actualmoney = actualmoney;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public Short getIslock() {
		return islock;
	}

	public void setIslock(Short islock) {
		this.islock = islock;
	}

	public String getDictid() {
		return dictid;
	}

	public void setDictid(String dictid) {
		this.dictid = dictid;
	}

	public String getDictid2() {
		return dictid2;
	}

	public void setDictid2(String dictid2) {
		this.dictid2 = dictid2;
	}

	public String[] get_selecttype() {
		return _selecttype;
	}

	public void set_selecttype(String[] _selecttype) {
		this._selecttype = _selecttype;
	}

	public String getAdtoprcode() {
		return adtoprcode;
	}

	public void setAdtoprcode(String adtoprcode) {
		this.adtoprcode = adtoprcode;
	}

	public java.util.Date getAdttime() {
		return adttime;
	}

	public void setAdttime(java.util.Date adttime) {
		this.adttime = adttime;
	}

	public String getSrcmonth() {
		return srcmonth;
	}

	public void setSrcmonth(String srcmonth) {
		this.srcmonth = srcmonth;
	}

	public String get_se_srcmonth() {
		return _se_srcmonth;
	}

	public void set_se_srcmonth(String _se_srcmonth) {
		this._se_srcmonth = _se_srcmonth;
	}

	public String get_nne_islock() {
		return _nne_islock;
	}

	public void set_nne_islock(String _nne_islock) {
		this._nne_islock = _nne_islock;
	}

}
