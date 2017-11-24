package com.gmcc.pboss.business.cms.examine.itemgraded.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: ItemgradedListVO</p>
 * <p>Description: Query Params Object for ItemgradedDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ItemgradedListVO extends DBQueryParam {
    private String _ne_seqid;
    private String _se_wayid;
    private String _ne_exmnid;
    private String _ne_exmnstdid;
    private String _snm_exmnperiod;
    private String _snl_exmnperiod;
    private String _se_state;
    private String _se_curauditor;

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

}
