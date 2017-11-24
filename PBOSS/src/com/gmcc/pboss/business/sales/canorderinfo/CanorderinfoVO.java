package com.gmcc.pboss.business.sales.canorderinfo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class CanorderinfoVO extends BaseVO implements Serializable {

    /** identifier field */
    private String brand;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Long canorder;

    /** nullable persistent field */
    private Long maxorder;

    /** nullable persistent field */
    private Long curorder;

    /** nullable persistent field */
    private Double thrmonavg;

    /** nullable persistent field */
    private Double sixmonavg;

    /** nullable persistent field */
    private String referdata;

    /** nullable persistent field */
    private String cardtype;

    /** nullable persistent field */
    private Long cardcanorder;

    /** nullable persistent field */
    private Long cardmonlim;

    /** nullable persistent field */
    private Long carddaylim;

    /** nullable persistent field */
    private Long cardtimelim;

    /** nullable persistent field */
    private Long cardmonordered;

    /** nullable persistent field */
    private Long carddayordered;
    
    private String brandName;
    
    private List referdataList;
    
    private String smsContent;
    private List smsContentList;
    
    private String officetel;//短信接收号码
    private String sendNum;//短信发送号码

    /** full constructor */
    public CanorderinfoVO(java.lang.String brand, java.lang.String wayid, java.lang.Long canorder, java.lang.Long maxorder, java.lang.Long curorder, java.lang.Double thrmonavg, java.lang.Double sixmonavg, java.lang.String referdata, java.lang.String cardtype, java.lang.Long cardcanorder, java.lang.Long cardmonlim, java.lang.Long carddaylim, java.lang.Long cardtimelim, java.lang.Long cardmonordered, java.lang.Long carddayordered) {
        this.brand = brand;
        this.wayid = wayid;
        this.canorder = canorder;
        this.maxorder = maxorder;
        this.curorder = curorder;
        this.thrmonavg = thrmonavg;
        this.sixmonavg = sixmonavg;
        this.referdata = referdata;
        this.cardtype = cardtype;
        this.cardcanorder = cardcanorder;
        this.cardmonlim = cardmonlim;
        this.carddaylim = carddaylim;
        this.cardtimelim = cardtimelim;
        this.cardmonordered = cardmonordered;
        this.carddayordered = carddayordered;
    }

    /** default constructor */
    public CanorderinfoVO() {
    }

    /** minimal constructor */
    public CanorderinfoVO(java.lang.String brand, java.lang.String wayid) {
        this.brand = brand;
        this.wayid = wayid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Long getCanorder() {
        return this.canorder;
    }

    public void setCanorder(java.lang.Long canorder) {
        this.canorder = canorder;
    }

    public java.lang.Long getMaxorder() {
        return this.maxorder;
    }

    public void setMaxorder(java.lang.Long maxorder) {
        this.maxorder = maxorder;
    }

    public java.lang.Long getCurorder() {
        return this.curorder;
    }

    public void setCurorder(java.lang.Long curorder) {
        this.curorder = curorder;
    }

    public java.lang.Double getThrmonavg() {
        return this.thrmonavg;
    }

    public void setThrmonavg(java.lang.Double thrmonavg) {
        this.thrmonavg = thrmonavg;
    }

    public java.lang.Double getSixmonavg() {
        return this.sixmonavg;
    }

    public void setSixmonavg(java.lang.Double sixmonavg) {
        this.sixmonavg = sixmonavg;
    }

    public java.lang.String getReferdata() {
        return this.referdata;
    }

    public void setReferdata(java.lang.String referdata) {
        this.referdata = referdata;
    }

    public java.lang.String getCardtype() {
        return this.cardtype;
    }

    public void setCardtype(java.lang.String cardtype) {
        this.cardtype = cardtype;
    }

    public java.lang.Long getCardcanorder() {
        return this.cardcanorder;
    }

    public void setCardcanorder(java.lang.Long cardcanorder) {
        this.cardcanorder = cardcanorder;
    }

    public java.lang.Long getCardmonlim() {
        return this.cardmonlim;
    }

    public void setCardmonlim(java.lang.Long cardmonlim) {
        this.cardmonlim = cardmonlim;
    }

    public java.lang.Long getCarddaylim() {
        return this.carddaylim;
    }

    public void setCarddaylim(java.lang.Long carddaylim) {
        this.carddaylim = carddaylim;
    }

    public java.lang.Long getCardtimelim() {
        return this.cardtimelim;
    }

    public void setCardtimelim(java.lang.Long cardtimelim) {
        this.cardtimelim = cardtimelim;
    }

    public java.lang.Long getCardmonordered() {
        return this.cardmonordered;
    }

    public void setCardmonordered(java.lang.Long cardmonordered) {
        this.cardmonordered = cardmonordered;
    }

    public java.lang.Long getCarddayordered() {
        return this.carddayordered;
    }

    public void setCarddayordered(java.lang.Long carddayordered) {
        this.carddayordered = carddayordered;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("brand", getBrand())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CanorderinfoVO) ) return false;
        CanorderinfoVO castOther = (CanorderinfoVO) other;
        return new EqualsBuilder()
            .append(this.getBrand(), castOther.getBrand())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBrand())
            .append(getWayid())
            .toHashCode();
    }

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List getReferdataList() {
		return referdataList;
	}

	public void setReferdataList(List referdataList) {
		this.referdataList = referdataList;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public List getSmsContentList() {
		return smsContentList;
	}

	public void setSmsContentList(List smsContentList) {
		this.smsContentList = smsContentList;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getSendNum() {
		return sendNum;
	}

	public void setSendNum(String sendNum) {
		this.sendNum = sendNum;
	}

}
