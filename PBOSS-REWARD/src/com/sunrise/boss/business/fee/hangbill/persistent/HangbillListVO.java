package com.sunrise.boss.business.fee.hangbill.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: HangbillListVO</p>
 * <p>Description: Query Params Object for HangbillDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class HangbillListVO extends BaseListVO {
	
	/**  add by mys -- start  **/
	private String _ne_eboxid;
	private String _ne_subsid;
	private String _ne_validbillcyc;
	private String _ne_acctid;
	private String _dnl_hangtime;
	private String _dnm_hangtime;
	private String _ne_hangstate;
	
	private String startindex;
	private String endindex;
	
	
	public String get_ne_hangstate() {
		return _ne_hangstate;
	}
	public void set_ne_hangstate(String _ne_hangstate) {
		this._ne_hangstate = _ne_hangstate;
	}
	public String get_dnl_hangtime() {
		return _dnl_hangtime;
	}
	public void set_dnl_hangtime(String _dnl_hangtime) {
		this._dnl_hangtime = _dnl_hangtime;
	}
	public String get_dnm_hangtime() {
		return _dnm_hangtime;
	}
	public void set_dnm_hangtime(String _dnm_hangtime) {
		this._dnm_hangtime = _dnm_hangtime;
	}
	public String get_ne_acctid() {
		return _ne_acctid;
	}
	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}
	public String get_ne_eboxid() {
		return _ne_eboxid;
	}
	public void set_ne_eboxid(String _ne_eboxid) {
		this._ne_eboxid = _ne_eboxid;
	}
	public String get_ne_subsid() {
		return _ne_subsid;
	}
	public void set_ne_subsid(String _ne_subsid) {
		this._ne_subsid = _ne_subsid;
	}
	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}
	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}	
	
	/**  add by mys -- end  **/
	
	
	/** identifier field */
    private Long hangid;

    /** persistent field */
    private Long eboxid;

    /** persistent field */
    private Long subsid;

    /** persistent field */
    private Long acctid;

    /** persistent field */
    private Integer validbillcyc;

    /** persistent field */
    private Integer hangstate;

    /** nullable persistent field */
    private Double hangamt;

    /** nullable persistent field */
    private Double dispute;

    /** persistent field */
    private  Integer hangtype;

    /** nullable persistent field */
    private String hangoprcode;

    /** nullable persistent field */
    private String checkercode;

    /** nullable persistent field */
    private java.util.Date hangtime;

    /** nullable persistent field */
    private java.util.Date back;

    /** nullable persistent field */
    private Double checkdecr;

    /** nullable persistent field */
    private String unite;

    /** nullable persistent field */
    private Long billchecklogid;

    /** nullable persistent field */
    private String lrsncode;

    /** nullable persistent field */
    private String srsncode;

    /** nullable persistent field */
    private Integer isicp;

    /** nullable persistent field */
    private String portid;

    /** nullable persistent field */
    private String icptype;

    /** nullable persistent field */
    private String lodge;

    /** nullable persistent field */
    private Integer isaward;

    /** nullable persistent field */
    private String memo;
    /** default constructor */
    public HangbillListVO() {
    }
    public java.lang.Long getHangid() {
        return this.hangid;
    }

    public void setHangid(java.lang.Long hangid) {
        this.hangid = hangid;
    }

    public java.lang.Long getEboxid() {
        return this.eboxid;
    }

    public void setEboxid(java.lang.Long eboxid) {
        this.eboxid = eboxid;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Integer getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Integer validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public Integer getHangstate() {
        return this.hangstate;
    }

    public void setHangstate(Integer hangstate) {
        this.hangstate = hangstate;
    }

    public java.lang.Double getHangamt() {
        return this.hangamt;
    }

    public void setHangamt(java.lang.Double hangamt) {
        this.hangamt = hangamt;
    }

    public java.lang.Double getDispute() {
        return this.dispute;
    }

    public void setDispute(java.lang.Double dispute) {
        this.dispute = dispute;
    }

    public java.lang.Integer getHangtype() {
        return this.hangtype;
    }

    public void setHangtype(java.lang.Integer hangtype) {
        this.hangtype = hangtype;
    }

    public java.lang.String getHangoprcode() {
        return this.hangoprcode;
    }

    public void setHangoprcode(java.lang.String hangoprcode) {
        this.hangoprcode = hangoprcode;
    }

    public java.lang.String getCheckercode() {
        return this.checkercode;
    }

    public void setCheckercode(java.lang.String checkercode) {
        this.checkercode = checkercode;
    }

    public java.util.Date getHangtime() {
        return this.hangtime;
    }

    public void setHangtime(java.util.Date hangtime) {
        this.hangtime = hangtime;
    }

    public java.util.Date getBack() {
        return this.back;
    }

    public void setBack(java.util.Date back) {
        this.back = back;
    }

    public java.lang.Double getCheckdecr() {
        return this.checkdecr;
    }

    public void setCheckdecr(java.lang.Double checkdecr) {
        this.checkdecr = checkdecr;
    }

    public java.lang.String getUnite() {
        return this.unite;
    }

    public void setUnite(java.lang.String unite) {
        this.unite = unite;
    }

    public java.lang.Long getBillchecklogid() {
        return this.billchecklogid;
    }

    public void setBillchecklogid(java.lang.Long billchecklogid) {
        this.billchecklogid = billchecklogid;
    }

    public java.lang.String getLrsncode() {
        return this.lrsncode;
    }

    public void setLrsncode(java.lang.String lrsncode) {
        this.lrsncode = lrsncode;
    }

    public java.lang.String getSrsncode() {
        return this.srsncode;
    }

    public void setSrsncode(java.lang.String srsncode) {
        this.srsncode = srsncode;
    }

    public java.lang.Integer getIsicp() {
        return this.isicp;
    }

    public void setIsicp(java.lang.Integer isicp) {
        this.isicp = isicp;
    }

    public java.lang.String getPortid() {
        return this.portid;
    }

    public void setPortid(java.lang.String portid) {
        this.portid = portid;
    }

    public java.lang.String getIcptype() {
        return this.icptype;
    }

    public void setIcptype(java.lang.String icptype) {
        this.icptype = icptype;
    }

    public java.lang.String getLodge() {
        return this.lodge;
    }

    public void setLodge(java.lang.String lodge) {
        this.lodge = lodge;
    }

    public java.lang.Integer getIsaward() {
        return this.isaward;
    }

    public void setIsaward(java.lang.Integer isaward) {
        this.isaward = isaward;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hangid", getHangid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof HangbillVO) ) return false;
        HangbillVO castOther = (HangbillVO) other;
        return new EqualsBuilder()
            .append(this.getHangid(), castOther.getHangid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHangid())
            .toHashCode();
    }
	public String getEndindex() {
		return endindex;
	}
	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}
	public String getStartindex() {
		return startindex;
	}
	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}
	
    

}
