package com.gmcc.pboss.business.cms.examine.examinestd.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: ExaminestdListVO</p>
 * <p>Description: Query Params Object for ExaminestdDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdListVO extends DBQueryParam {
    private String _sk_exmnstdname;
    private String _se_markmode;

    public String get_sk_exmnstdname(){
        return _sk_exmnstdname;
    }

    public void set_sk_exmnstdname(String _sk_exmnstdname){
        this._sk_exmnstdname = _sk_exmnstdname;
    }
    public String get_se_markmode(){
        return _se_markmode;
    }

    public void set_se_markmode(String _se_markmode){
        this._se_markmode = _se_markmode;
    }

}
