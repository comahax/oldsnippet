package com.sunrise.boss.ui.cms.reward.faildataquery;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: FaildataqueryForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author 	Linli
 * @version 1.0
 */
public class FaildataqueryForm extends BaseActionForm {
	private Long seq;
	private String calcmonth;
	private String opnid;
	private String name;//“业务名称”取CH_PW_OPERATION（公共库）的name字段，通过opnid关联；
	private String wayid;
	private String wayname;//“渠道名称”取CH_PW_WAY（公共库）的wayname字段，通过wayid关联；
	private String oprcode;
	private String mobile;
	private Date oprtime;
	private Date creattime;
	private String ruleid;
	private Short adtflag;
	private String adtcode;
	private String adtremark;//“失败原因”取CH_ADT_ADTCODE（公共库）的ADTREMARK字段，通过adtcode关联；
	private Short rewardflag;
	private String repairmonth;
	private String batchno;
	private String bakinfo;
	private String bakinfo2;
	private Double bakinfo3;
	private Double wrapfee;
	private String prodid;
	private Double bakinfo4;
	private Double bakinfo5;
	private String bakinfo6;
	private String bakinfo7;
	private String bakinfo8;
	private String bakinfo9;
	private String bakinfo10;  
	private String _se_rewardtype;
	private String _se_opnid;
	private String _se_wayid;
	private String _dnl_oprtime;
	private String _dnm_oprtime;
	private String _se_oprcode;
	private String _se_mobile;
	private String _sk_adtcode;
	private String _sk_adtremark;
	private String _ne_rewardflag;
	private String _se_repairmonth;
	private String _se_batchno;
	private String checked;
	private String backcalmonth;
	private String _sql_condition;
	private String _se_calcmonth;
	
	public String get_se_calcmonth() {
		return _se_calcmonth;
	}
	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}
	public String get_sql_condition() {
		return _sql_condition;
	}
	public void set_sql_condition(String _sql_condition) {
		this._sql_condition = _sql_condition;
	}
	public String getAdtcode() {
		return adtcode;
	}
	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}
	public Short getAdtflag() {
		return adtflag;
	}
	public void setAdtflag(Short adtflag) {
		this.adtflag = adtflag;
	}
	public String getAdtremark() {
		return adtremark;
	}
	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}
	public String getCalcmonth() {
		return calcmonth;
	}
	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public Date getOprtime() {
		return oprtime;
	}
	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}
	public String getRuleid() {
		return ruleid;
	}
	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	public String get_se_mobile() {
		return _se_mobile;
	}
	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}
	public String get_se_opnid() {
		return _se_opnid;
	}
	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}
	public String get_se_oprcode() {
		return _se_oprcode;
	}
	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}
	public String get_se_rewardtype() {
		return _se_rewardtype;
	}
	public void set_se_rewardtype(String _se_rewardtype) {
		this._se_rewardtype = _se_rewardtype;
	}
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
	public String get_sk_adtremark() {
		return _sk_adtremark;
	}
	public void set_sk_adtremark(String _sk_adtremark) {
		this._sk_adtremark = _sk_adtremark;
	}
	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}
	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}
	public String get_dnm_oprtime() {
		return _dnm_oprtime;
	}
	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}
	public String get_sk_adtcode() {
		return _sk_adtcode;
	}
	public void set_sk_adtcode(String _sk_adtcode) {
		this._sk_adtcode = _sk_adtcode;
	}
	public String getBackcalmonth() {
		return backcalmonth;
	}
	public void setBackcalmonth(String backcalmonth) {
		this.backcalmonth = backcalmonth;
	}
	public Short getRewardflag() {
		return rewardflag;
	}
	public void setRewardflag(Short rewardflag) {
		this.rewardflag = rewardflag;
	}
	public String getRepairmonth() {
		return repairmonth;
	}
	public void setRepairmonth(String repairmonth) {
		this.repairmonth = repairmonth;
	}
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public String get_ne_rewardflag() {
		return _ne_rewardflag;
	}
	public void set_ne_rewardflag(String _ne_rewardflag) {
		this._ne_rewardflag = _ne_rewardflag;
	}
	public String get_se_repairmonth() {
		return _se_repairmonth;
	}
	public void set_se_repairmonth(String _se_repairmonth) {
		this._se_repairmonth = _se_repairmonth;
	}
	public String get_se_batchno() {
		return _se_batchno;
	}
	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getBakinfo() {
		return bakinfo;
	}
	public void setBakinfo(String bakinfo) {
		this.bakinfo = bakinfo;
	}
	public String getBakinfo2() {
		return bakinfo2;
	}
	public void setBakinfo2(String bakinfo2) {
		this.bakinfo2 = bakinfo2;
	}
	public Double getBakinfo3() {
		return bakinfo3;
	}
	public void setBakinfo3(Double bakinfo3) {
		this.bakinfo3 = bakinfo3;
	}
	public Double getWrapfee() {
		return wrapfee;
	}
	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public Double getBakinfo4() {
		return bakinfo4;
	}
	public void setBakinfo4(Double bakinfo4) {
		this.bakinfo4 = bakinfo4;
	}
	public Double getBakinfo5() {
		return bakinfo5;
	}
	public void setBakinfo5(Double bakinfo5) {
		this.bakinfo5 = bakinfo5;
	}
	public String getBakinfo6() {
		return bakinfo6;
	}
	public void setBakinfo6(String bakinfo6) {
		this.bakinfo6 = bakinfo6;
	}
	public String getBakinfo7() {
		return bakinfo7;
	}
	public void setBakinfo7(String bakinfo7) {
		this.bakinfo7 = bakinfo7;
	}
	public String getBakinfo8() {
		return bakinfo8;
	}
	public void setBakinfo8(String bakinfo8) {
		this.bakinfo8 = bakinfo8;
	}
	public String getBakinfo9() {
		return bakinfo9;
	}
	public void setBakinfo9(String bakinfo9) {
		this.bakinfo9 = bakinfo9;
	}
	public String getBakinfo10() {
		return bakinfo10;
	}
	public void setBakinfo10(String bakinfo10) {
		this.bakinfo10 = bakinfo10;
	}
}
