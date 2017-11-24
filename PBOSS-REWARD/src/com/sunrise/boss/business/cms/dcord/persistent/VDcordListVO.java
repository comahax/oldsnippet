/**
* auto-generated code
* Wed Aug 15 20:50:15 CST 2012
*/
package com.sunrise.boss.business.cms.dcord.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: VDcordListVO</p>
 * <p>Description: Query Params Object for VDcordDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class VDcordListVO extends BaseListVO {
    private String _se_countyid;
    private String _se_wayid;
    private String _sk_wayname;
    private String _ne_starlevel;
    private List _sin_opnid;
    private String _se_upperopnid;
    private String _se_subopnid;
    private String _se_oprmonth;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _ne_isflag;
    
    private int threshhold;//酬金出账明细查询结果集大小阀值

    private String _se_batchno;
    private String _se_abatchno;
    
    private String _se_paymonth;
    
	public String get_se_paymonth() {
		return _se_paymonth;
	}

	public void set_se_paymonth(String _se_paymonth) {
		this._se_paymonth = _se_paymonth;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_se_abatchno() {
		return _se_abatchno;
	}

	public void set_se_abatchno(String _se_abatchno) {
		this._se_abatchno = _se_abatchno;
	}

	public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_sk_wayname(){
        return _sk_wayname;
    }

    public void set_sk_wayname(String _sk_wayname){
        this._sk_wayname = _sk_wayname;
    }
    public String get_ne_starlevel(){
        return _ne_starlevel;
    }

    public void set_ne_starlevel(String _ne_starlevel){
        this._ne_starlevel = _ne_starlevel;
    }
    public List get_sin_opnid(){
        return _sin_opnid;
    }

    public void set_sin_opnid(List _sin_opnid){
        this._sin_opnid = _sin_opnid;
    }
    public String get_se_upperopnid(){
        return _se_upperopnid;
    }

    public void set_se_upperopnid(String _se_upperopnid){
        this._se_upperopnid = _se_upperopnid;
    }
    public String get_se_subopnid(){
        return _se_subopnid;
    }

    public void set_se_subopnid(String _se_subopnid){
        this._se_subopnid = _se_subopnid;
    }
    public String get_se_oprmonth(){
        return _se_oprmonth;
    }

    public void set_se_oprmonth(String _se_oprmonth){
        this._se_oprmonth = _se_oprmonth;
    }
    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    
    public int getThreshhold() {
		return threshhold;
	}

	public void setThreshhold(int threshhold) {
		this.threshhold = threshhold;
	}

	public String get_ne_isflag() {
		return _ne_isflag;
	}

	public void set_ne_isflag(String _ne_isflag) {
		this._ne_isflag = _ne_isflag;
	}

}
