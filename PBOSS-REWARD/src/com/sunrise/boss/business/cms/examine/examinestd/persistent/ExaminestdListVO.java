/**
* auto-generated code
* Tue Nov 17 16:06:35 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examinestd.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ExaminestdListVO</p>
 * <p>Description: Query Params Object for ExaminestdDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdListVO extends BaseListVO {
    private String _sk_exmnstdname;
    private String _se_markmode;
    private String _ne_exmnstdid;

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

	public String get_ne_exmnstdid() {
		return _ne_exmnstdid;
	}

	public void set_ne_exmnstdid(String _ne_exmnstdid) {
		this._ne_exmnstdid = _ne_exmnstdid;
	}

}
