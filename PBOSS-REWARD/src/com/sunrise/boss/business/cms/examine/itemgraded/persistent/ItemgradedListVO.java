/**
* auto-generated code
* Sat Nov 28 17:53:15 CST 2009
*/
package com.sunrise.boss.business.cms.examine.itemgraded.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ItemgradedListVO</p>
 * <p>Description: Query Params Object for ItemgradedDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ItemgradedListVO extends BaseListVO {
    private String _ne_seqid;
    private String _se_wayid;
    private String _ne_exmnid;
    private String _ne_exmnstdid;
    private String _snm_exmnperiod;
    private String _snl_exmnperiod;
    private String _se_exmnperiod;
    private String _se_registercode;
    private String _se_state;
    private String _se_curauditor;
    private List _sin_seqid;

    public List get_sin_seqid() {
		return _sin_seqid;
	}

	public void set_sin_seqid(List _sin_seqid) {
		this._sin_seqid = _sin_seqid;
	}

	public String get_ne_seqid(){
        return _ne_seqid;
    }

    public void set_ne_seqid(String _ne_seqid){
        this._ne_seqid = _ne_seqid;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_ne_exmnid(){
        return _ne_exmnid;
    }

    public void set_ne_exmnid(String _ne_exmnid){
        this._ne_exmnid = _ne_exmnid;
    }
    public String get_ne_exmnstdid(){
        return _ne_exmnstdid;
    }

    public void set_ne_exmnstdid(String _ne_exmnstdid){
        this._ne_exmnstdid = _ne_exmnstdid;
    }
    public String get_snm_exmnperiod(){
        return _snm_exmnperiod;
    }

    public void set_snm_exmnperiod(String _snm_exmnperiod){
        this._snm_exmnperiod = _snm_exmnperiod;
    }
    public String get_snl_exmnperiod(){
        return _snl_exmnperiod;
    }

    public void set_snl_exmnperiod(String _snl_exmnperiod){
        this._snl_exmnperiod = _snl_exmnperiod;
    }
    public String get_se_state(){
        return _se_state;
    }

    public void set_se_state(String _se_state){
        this._se_state = _se_state;
    }
    public String get_se_curauditor(){
        return _se_curauditor;
    }

    public void set_se_curauditor(String _se_curauditor){
        this._se_curauditor = _se_curauditor;
    }

	public String get_se_exmnperiod() {
		return _se_exmnperiod;
	}

	public void set_se_exmnperiod(String _se_exmnperiod) {
		this._se_exmnperiod = _se_exmnperiod;
	}

	public String get_se_registercode() {
		return _se_registercode;
	}

	public void set_se_registercode(String _se_registercode) {
		this._se_registercode = _se_registercode;
	}

}
