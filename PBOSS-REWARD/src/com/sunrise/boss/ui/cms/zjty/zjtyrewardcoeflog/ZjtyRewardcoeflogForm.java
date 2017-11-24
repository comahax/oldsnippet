package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoeflog;



import com.sunrise.boss.ui.base.BaseActionForm;


public class ZjtyRewardcoeflogForm extends BaseActionForm {
	
	/** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Short coefid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String effectiblemonth;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Double providecoef;

    /** nullable persistent field */
    private String result;

    /** nullable persistent field */
    private Short ispass;

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Short getCoefid() {
		return coefid;
	}

	public void setCoefid(Short coefid) {
		this.coefid = coefid;
	}

	public String getEffectiblemonth() {
		return effectiblemonth;
	}

	public void setEffectiblemonth(String effectiblemonth) {
		this.effectiblemonth = effectiblemonth;
	}

	public Short getIspass() {
		return ispass;
	}

	public void setIspass(Short ispass) {
		this.ispass = ispass;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
	}

	public Double getProvidecoef() {
		return providecoef;
	}

	public void setProvidecoef(Double providecoef) {
		this.providecoef = providecoef;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

    
    
	
}
