/**
 * auto-generated code
 * Wed Apr 29 10:50:04 CST 2009
 */
package com.sunrise.boss.ui.cms.bbc.bbcfaildataquery;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: BbcFaildataqueryForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Li Zhaoliang
 * @version 1.0
 */
public class BbcFaildataqueryForm extends BaseActionForm {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String opnid;

    private String name;
    /** nullable persistent field */
    private String wayid;
    
    private String wayname;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private java.util.Date creattime;

    /** nullable persistent field */
    private java.util.Date adtttime;

    /** nullable persistent field */
    private String src;

    /** nullable persistent field */
    private String calcopnid;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private Short adtflag;

    /** nullable persistent field */
    private String adtcode;

    /** nullable persistent field */
    private String adtremark;

    /** nullable persistent field */
    private String srcseq;
    
    private String rewardtype;
    
	private Integer ossrc;
    
    private String _se_rewardtype;

	private String _se_opnid;

	private String _se_wayid;

	private String _dnl_oprtime;

	private String _dnm_oprtime;

	private String _se_oprcode;
	
	private String _se_mobile;
	
	private String _sk_adtcode;
	
	private String _sk_adtremark;
	
	private String _se_ossrc;
	
	private String _sql_ossrc = "ossrc in ('0','1','2')";
	
	private String _se_batchno;

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_sql_ossrc() {
		return _sql_ossrc;
	}

	public void set_sql_ossrc(String _sql_ossrc) {
		this._sql_ossrc = _sql_ossrc;
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

	public String get_sk_adtcode() {
		return _sk_adtcode;
	}

	public void set_sk_adtcode(String _sk_adtcode) {
		this._sk_adtcode = _sk_adtcode;
	}

	public String get_sk_adtremark() {
		return _sk_adtremark;
	}

	public void set_sk_adtremark(String _sk_adtremark) {
		this._sk_adtremark = _sk_adtremark;
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

	public java.util.Date getAdtttime() {
		return adtttime;
	}

	public void setAdtttime(java.util.Date adtttime) {
		this.adtttime = adtttime;
	}

	public Double getBusivalue() {
		return busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getCalcopnid() {
		return calcopnid;
	}

	public void setCalcopnid(String calcopnid) {
		this.calcopnid = calcopnid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public java.util.Date getCreattime() {
		return creattime;
	}

	public void setCreattime(java.util.Date creattime) {
		this.creattime = creattime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public java.util.Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(java.util.Date oprtime) {
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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSrcseq() {
		return srcseq;
	}

	public void setSrcseq(String srcseq) {
		this.srcseq = srcseq;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	public Integer getOssrc() {
		return ossrc;
	}

	public void setOssrc(Integer ossrc) {
		this.ossrc = ossrc;
	}

	public String get_se_ossrc() {
		return _se_ossrc;
	}

	public void set_se_ossrc(String _se_ossrc) {
		this._se_ossrc = _se_ossrc;
	}


}
