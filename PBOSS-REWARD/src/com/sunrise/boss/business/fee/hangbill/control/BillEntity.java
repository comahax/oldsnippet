package com.sunrise.boss.business.fee.hangbill.control;

import java.io.Serializable;

public class BillEntity implements Serializable {
	
    
	private String paidmobileno; /**±»´ú¸¶ºÅÂë**/
	private String mobileno;
    private Long hangid;
    private Long eboxid;
    private Long subsid;
    private String acctid;
    private String validbillcyc;
    private Integer hangstate;
    private Double hangamt;
    private String hangoprcode;
    private String checkercode;
    private java.sql.Timestamp hangtime;
    private Double checkdecr;
    private String lrsncode;
    private String srsncode;
    private Integer isicp;
    private String portid;
    private String icptype;
    private Integer isaward;
    private String memo;
    private String unite;
	private String  _ne_acctid;
	private String  _ne_validbillcyc;
	private String  _ne_mainclass;
	private String  _ne_subclass;
	private String  _ne_bwang;
	private String  _ne_wangport;
	private String  _ne_wangflag;
    
    public java.lang.String getUnite() {
        return this.unite;
    }
    public void set_ne_acctid(java.lang.String _ne_acctid) {
        this._ne_acctid = _ne_acctid;
    }
    public java.lang.String get_ne_acctid() {
        return this._ne_acctid;
    }
    public void set_ne_validbillcyc(java.lang.String _ne_validbillcyc) {
        this._ne_validbillcyc = _ne_validbillcyc;
    }
    public java.lang.String get_ne_validbillcyc() {
        return this._ne_validbillcyc;
    }
    public void set_ne_mainclass(java.lang.String _ne_mainclass) {
        this._ne_mainclass = _ne_mainclass;
    }
    public java.lang.String get_ne_mainclass() {
        return this._ne_mainclass;
    }
    public void set_ne_subclass(java.lang.String _ne_subclass) {
        this._ne_subclass = _ne_subclass;
    }
    public java.lang.String get_ne_subclass() {
        return this._ne_subclass;
    }
    public void set_ne_bwang(java.lang.String _ne_bwang) {
        this._ne_bwang = _ne_bwang;
    }
    public java.lang.String get_ne_bwang() {
        return this._ne_bwang;
    }
    public void set_ne_wangport(java.lang.String _ne_wangport) {
        this._ne_wangport = _ne_wangport;
    }
    public java.lang.String get_ne_wangport() {
        return this._ne_wangport;
    }
    public void set_ne_wangflag(java.lang.String _ne_wangflag) {
        this._ne_wangflag = _ne_wangflag;
    }
    public java.lang.String get_ne_wangflag() {
        return this._ne_wangflag;
    }

    public void setUnite(java.lang.String unite) {
        this.unite = unite;
    }
    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
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

    public java.lang.String getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.String acctid) {
        this.acctid = acctid;
    }

    public java.lang.String getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.String validbillcyc) {
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

    public java.sql.Timestamp getHangtime() {
        return this.hangtime;
    }

    public void setHangtime(java.sql.Timestamp hangtime) {
        this.hangtime = hangtime;
    }


    public java.lang.Double getCheckdecr() {
        return this.checkdecr;
    }

    public void setCheckdecr(java.lang.Double checkdecr) {
        this.checkdecr = checkdecr;
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
    
    private String cmdState;
    private String _pageno;
    private String _pagesize;

    private String _orderby;
    private String _desc;

    private String[] _selectitem;

    public String getCmdState() {
        return cmdState;
    }

    public void setCmdState(String cmdState) {
        this.cmdState = cmdState;
    }

    public String get_pageno() {
        return _pageno;
    }

    public void set_pageno(String _pageno) {
        this._pageno = _pageno;
    }

    public String get_pagesize() {
        return _pagesize;
    }

    public void set_pagesize(String _pagesize) {
        this._pagesize = _pagesize;
    }

    public String get_orderby() {
        return _orderby;
    }

    public void set_orderby(String _orderby) {
        this._orderby = _orderby;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public String[] get_selectitem() {
        return _selectitem;
    }

    public void set_selectitem(String[] _selectitem) {
        this._selectitem = _selectitem;
    }
	public String getPaidmobileno() {
		return paidmobileno;
	}
	public void setPaidmobileno(String paidmobileno) {
		this.paidmobileno = paidmobileno;
	}

}
