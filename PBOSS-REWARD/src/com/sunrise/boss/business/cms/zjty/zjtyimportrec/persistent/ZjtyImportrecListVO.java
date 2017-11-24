/**
* auto-generated code
* Mon Mar 05 15:38:34 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyImportrecListVO</p>
 * <p>Description: Query Params Object for ZjtyImportrecDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyImportrecListVO extends BaseListVO {
    private String _ne_seq;
    private String _se_calcmonth;
    private String _se_opnid;
    private String _se_wayid;
    private String _se_mobile;
    private String _de_oprtime;

    public String get_ne_seq(){
        return _ne_seq;
    }

    public void set_ne_seq(String _ne_seq){
        this._ne_seq = _ne_seq;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }

	public String get_de_oprtime() {
		return _de_oprtime;
	}

	public void set_de_oprtime(String _de_oprtime) {
		this._de_oprtime = _de_oprtime;
	}

}
