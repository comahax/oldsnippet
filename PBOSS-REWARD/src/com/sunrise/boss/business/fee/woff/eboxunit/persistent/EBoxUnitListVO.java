package com.sunrise.boss.business.fee.woff.eboxunit.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: EBoxUnitListVO</p>
 * <p>Description: EBox Unit List VO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class EBoxUnitListVO extends BaseListVO{
	
    private String _sk_eboxunitname;
    private String _sk_eboxunittype;
    private String _sk_eboxunitstate;
    private String _ne_eboxunitid;
    
    private String startindex;
    private String endindex;
    
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

	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}

	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	}

	public void set_sk_eboxunitname( String _sk_eboxunitname ){
    	this._sk_eboxunitname = _sk_eboxunitname;
    }
    
    public String get_sk_eboxunitname(){
    	return _sk_eboxunitname;
    }
    
    public void set_sk_eboxunittype( String _sk_eboxunittype ){
    	this._sk_eboxunittype = _sk_eboxunittype;
    }
    
    public String get_sk_eboxunittype(){
    	return _sk_eboxunittype;
    }
    
    public void set_sk_eboxunitstate( String _sk_eboxunitstate ){
    	this._sk_eboxunitstate = _sk_eboxunitstate;
    }
    
    public String get_sk_eboxunitstate(){
    	return _sk_eboxunitstate;
    }
}
