package com.sunrise.boss.business.fee.woff.acct.persistent;

import java.sql.Date;
import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BillItemMagListVO</p>
 * <p>Description: Bill item management List VO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class AcctListVO extends BaseListVO{
	
    private String _sk_acctname;
    private String _ne_accttype;
    private String _ne_acctstate;
    private String _ne_acctlevel;
    private String _ne_acctid;
    private String _sk_acctid;
    private String _sql_incdecAcct;
    private List _nin_acctid;;
    
	private String startindex;  //����������ҳ
	private String endindex;   //��������βҳ
    
//    private Date _dnl_starttime;
//    private Date _dnm_stoptime;
    
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

	public String get_sql_incdecAcct() {
		return _sql_incdecAcct;
	}

	public void set_sql_incdecAcct(String acct) {
		_sql_incdecAcct = acct;
	}

	public AcctListVO(){
    	set_desc("0");
    }
    
    public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}

	public void set_sk_acctname( String _sk_acctname ){
    	this._sk_acctname = _sk_acctname;
    }
    
    public String get_sk_acctname(){
    	return _sk_acctname;
    }
    
    public void set_ne_accttype( String _ne_accttype ){
    	this._ne_accttype = _ne_accttype;
    }
    
    public String get_ne_accttype(){
    	return _ne_accttype;
    }
    
    public void set_ne_acctstate( String _ne_acctstate ){
    	this._ne_acctstate = _ne_acctstate;
    }
    
    public String get_ne_acctstate(){
    	return _ne_acctstate;
    }
    
    public void set_ne_acctlevel( String _ne_acctlevel ){
    	this._ne_acctlevel = _ne_acctlevel;
    }
    
    public String get_ne_acctlevel(){
    	return _ne_acctlevel;
    }

	public String get_sk_acctid() {
		return _sk_acctid;
	}

	public void set_sk_acctid(String _sk_acctid) {
		this._sk_acctid = _sk_acctid;
	}

	public List get_nin_acctid() {
		return _nin_acctid;
	}

	public void set_nin_acctid(List _nin_acctid) {
		this._nin_acctid = _nin_acctid;
	}
    
//    public void set_dnl_starttime( Date _dnl_starttime ){
//    	this._dnl_starttime = _dnl_starttime;
//    }
//    
//    public Date get_dnl_starttime(){
//    	return _dnl_starttime;
//    }
//    
//    public void set_dnm_stoptime( Date _dnm_stoptime ){
//    	this._dnm_stoptime = _dnm_stoptime;
//    }
//    
//    public Date get_dnm_stoptime(){
//    	return _dnm_stoptime;
//    }
}
