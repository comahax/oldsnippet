/**
* auto-generated code
* Mon Aug 20 10:59:12 CST 2012
*/
package com.sunrise.boss.business.cms.adjustment.persistent;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: VAdjustmentListVO</p>
 * <p>Description: Query Params Object for VAdjustmentDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class VAdjustmentListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_rewardmonth;
    private String _se_countyid;
    private String _sk_wayname;
    private String _ne_accttype;
    
    private Integer _checked;
    
    private String[] _selectitem;
    
    private String _se_batchno;
    private String _se_chainhead;
    private Short _ne_starlevel;
    
    private String _sql_batchno;
    
    private String _hasupperopnid="0";//1支持业务大类，0不支持，默认不支持
    
    private String _hassubopnidreport="0";//1付款报表按照业务小类展示，0不支持业务小类展示（即默认的业务大类展示）
    
    private List<String> _sin_upperopnid;
    
    private boolean supportPaymonth = false;//是否支持付款月份字段
    
    private String _paymonth;//付款月份
    
    public boolean isSupportPaymonth() {
		return supportPaymonth;
	}

	public void setSupportPaymonth(boolean supportPaymonth) {
		this.supportPaymonth = supportPaymonth;
	}

	public String get_paymonth() {
		return _paymonth;
	}

	public void set_paymonth(String _paymonth) {
		this._paymonth = _paymonth;
	}

	public boolean suppertUpper(){
    	return ("1".equals(_hasupperopnid));
    }
    
    public boolean supportSubopnReport(){
    	return ("1".equals(_hassubopnidreport));
    }

	public List<String> get_sin_upperopnid() {
		return _sin_upperopnid;
	}

	public void set_sin_upperopnid(List<String> _sin_upperopnid) {
		this._sin_upperopnid = _sin_upperopnid;
	}

	public String get_hasupperopnid() {
		return _hasupperopnid;
	}

	public void set_hasupperopnid(String _hasupperopnid) {
		this._hasupperopnid = _hasupperopnid;
	}

	public String get_sql_batchno() {
		return _sql_batchno;
	}

	public void set_sql_batchno(String _sql_batchno) {
		this._sql_batchno = _sql_batchno;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public Short get_ne_starlevel() {
		return _ne_starlevel;
	}

	public void set_ne_starlevel(Short _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}

	public String[] get_selectitem() {
		return _selectitem;
	}

	public void set_selectitem(String[] _selectitem) {
		this._selectitem = _selectitem;
	}

    public Integer get_checked() {
		return _checked;
	}

	public void set_checked(Integer _checked) {
		this._checked = _checked;
	}

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_sk_wayname(){
        return _sk_wayname;
    }

    public void set_sk_wayname(String _sk_wayname){
        this._sk_wayname = _sk_wayname;
    }

	public String get_ne_accttype() {
		return _ne_accttype;
	}

	public void set_ne_accttype(String _ne_accttype) {
		this._ne_accttype = _ne_accttype;
	}

	public String get_hassubopnidreport() {
		return _hassubopnidreport;
	}

	public void set_hassubopnidreport(String _hassubopnidreport) {
		this._hassubopnidreport = _hassubopnidreport;
	}
}
