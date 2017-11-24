package com.sunrise.boss.business.fee.hangbill.control;

import java.io.Serializable;

public class HangBillEntity implements Serializable {

	private String mobileno;
    private Long eboxid;

    private Long subsid;
    private String acctid;
	private String validbillcyc;
	private Integer hangtype;
	
	/** persistent field */
    private Double recamt;

    /** persistent field */
    private Double paiclupamt;

    /** persistent field */
    private Short state;
	
	private Long   _ne_subsid;
	private String  _ne_acctid;
	private String  _ne_validbillcyc;
	
	private String  _ne_mainclass;
	private String  _ne_subclass;
	private String  _ne_bwang;
	private String  _ne_wangport;
	private String  _ne_wangflag;
	private String  billno;
	private String  memo;
	
	public HangBillEntity() {
		
	}
	
	public String get_ne_mainclass() {
        return _ne_mainclass;
    }
	public void set_ne_mainclass(String _ne_mainclass) {
        this._ne_mainclass = _ne_mainclass;
    }
	
	public String get_ne_subclass() {
        return _ne_subclass;
    }
	public void set_ne_subclass(String _ne_subclass) {
        this._ne_subclass = _ne_subclass;
    }
	
	public String get_ne_bwang() {
        return _ne_bwang;
    }
	public void set_ne_bwang(String _ne_bwang) {
        this._ne_bwang = _ne_bwang;
    }
	
	public String get_ne_wangport() {
        return _ne_wangport;
    }
	public void set_ne_wangport(String _ne_wangport) {
        this._ne_wangport = _ne_wangport;
    }
	
	public String getBillno() {
        return billno;
    }
	public void setBillno(String billno) {
        this.billno = billno;
    }
	
	public String get_ne_wangflag() {
        return _ne_wangflag;
    }
	public void set_ne_wangflag(String _ne_wangflag) {
        this._ne_wangflag = _ne_wangflag;
    }
	
	public String getMemo() {
        return memo;
    }
	public void setMemo(String memo) {
        this.memo = memo;
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
    
    public java.lang.Double getRecamt() {
        return this.recamt;
    }

    public void setRecamt(java.lang.Double recamt) {
        this.recamt = recamt;
    }

    public java.lang.Double getPaiclupamt() {
        return this.paiclupamt;
    }

    public void setPaiclupamt(java.lang.Double paiclupamt) {
        this.paiclupamt = paiclupamt;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }
    
    public String getMobileno() {
        return mobileno;
    }
    
	public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

	public String getAcctid() {
        return acctid;
    }
	public void setAcctid(String feeid) {
        this.acctid = feeid;
    }
	public String getValidbillcyc() {
        return validbillcyc;
    }
	public void setValidbillcyc(String billcyc) {
        this.validbillcyc = billcyc;
    }
	public Long get_ne_subsid() {
        return _ne_subsid;
    }
	public void set_ne_subsid(Long feeid) {
        this._ne_subsid = feeid;
    }
	
	public String get_ne_acctid() {
        return _ne_acctid;
    }
	public void set_ne_acctid(String feeid) {
        this._ne_acctid = feeid;
    }
	
	public String get_ne_validbillcyc() {
        return _ne_validbillcyc;
    }
	public void set_ne_validbillcyc(String billcyc) {
        this._ne_validbillcyc = billcyc;
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

	public Integer getHangtype() {
		return hangtype;
	}

	public void setHangtype(Integer hangtype) {
		this.hangtype = hangtype;
	}
}
