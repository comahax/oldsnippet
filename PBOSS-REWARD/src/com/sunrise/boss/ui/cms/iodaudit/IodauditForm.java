/**
 * auto-generated code
 * Thu Oct 09 13:08:46 CST 2008
 */
package com.sunrise.boss.ui.cms.iodaudit;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditVO;

/**
 * <p>
 * Title: IodauditForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class IodauditForm extends BaseActionForm {
	private String _se_mobile;

	private String _dnl_iodtime;

	private String _dnm_iodtime;

	private String _se_officetel;

	private String _ne_adtcode;

	private String _ne_compare;
	
	private String _ne_mendflag;

	private Long seq;

	private String adtcontent;

	private String mobile;

	private java.util.Date iodtime;

	private Byte sucess;

	private String officetel;

	private Byte adtcode;

	private String adtremark;

	private Byte compare;
	
	private String opnid;
	
	private Byte mendflag;
	
	private java.util.Date mendtime;
	
	private java.util.Date addtime;
	

	public String get_ne_mendflag() {
		return _ne_mendflag;
	}

	public void set_ne_mendflag(String _ne_mendflag) {
		this._ne_mendflag = _ne_mendflag;
	}

	public Byte getMendflag() {
		return mendflag;
	}

	public void setMendflag(Byte mendflag) {
		this.mendflag = mendflag;
	}

	public java.util.Date getMendtime() {
		return mendtime;
	}

	public void setMendtime(java.util.Date mendtime) {
		this.mendtime = mendtime;
	}

	public java.util.Date getAddtime() {
		return addtime;
	}

	public void setAddtime(java.util.Date addtime) {
		this.addtime = addtime;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_dnl_iodtime() {
		return _dnl_iodtime;
	}

	public void set_dnl_iodtime(String _dnl_iodtime) {
		this._dnl_iodtime = _dnl_iodtime;
	}

	public String get_dnm_iodtime() {
		return _dnm_iodtime;
	}

	public void set_dnm_iodtime(String _dnm_iodtime) {
		this._dnm_iodtime = _dnm_iodtime;
	}

	public String get_se_officetel() {
		return _se_officetel;
	}

	public void set_se_officetel(String _se_officetel) {
		this._se_officetel = _se_officetel;
	}

	public String get_ne_adtcode() {
		return _ne_adtcode;
	}

	public void set_ne_adtcode(String _ne_adtcode) {
		this._ne_adtcode = _ne_adtcode;
	}

	public String get_ne_compare() {
		return _ne_compare;
	}

	public void set_ne_compare(String _ne_compare) {
		this._ne_compare = _ne_compare;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getAdtcontent() {
		return adtcontent;
	}

	public void setAdtcontent(String adtcontent) {
		this.adtcontent = adtcontent;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public java.util.Date getIodtime() {
		return iodtime;
	}

	public void setIodtime(java.util.Date iodtime) {
		this.iodtime = iodtime;
	}

	public Byte getSucess() {
		return sucess;
	}

	public void setSucess(Byte sucess) {
		this.sucess = sucess;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public Byte getAdtcode() {
		return adtcode;
	}

	public void setAdtcode(Byte adtcode) {
		this.adtcode = adtcode;
	}

	public String getAdtremark() {
		return adtremark;
	}

	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}

	public Byte getCompare() {
		return compare;
	}

	public void setCompare(Byte compare) {
		this.compare = compare;
	}

}
