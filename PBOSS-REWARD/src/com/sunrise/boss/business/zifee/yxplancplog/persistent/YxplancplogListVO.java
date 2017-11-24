/**
* auto-generated code
* Sun Sep 23 15:29:50 CST 2007
*/
package com.sunrise.boss.business.zifee.yxplancplog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: YxplancplogListVO</p>
 * <p>Description: Query Params Object for YxplancplogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class YxplancplogListVO extends BaseListVO {
    private String _dnl_createtime;
    private String _dnm_createtime;
    private String _sk_oprcode;
    private String _se_oprtype;
    private String _sk_batchno;
    private String _se_oprresulte;
    private String _se_oprstate;

    public String get_dnl_createtime(){
        return _dnl_createtime;
    }

    public void set_dnl_createtime(String _dnl_createtime){
        this._dnl_createtime = _dnl_createtime;
    }
    public String get_dnm_createtime(){
        return _dnm_createtime;
    }

    public void set_dnm_createtime(String _dnm_createtime){
    	if(null!=_dnm_createtime && _dnm_createtime.length()>0){
	    	String _dnm_createtime_end = _dnm_createtime + " 23:59:59";
			this._dnm_createtime = _dnm_createtime_end;
		}else{
			this._dnm_createtime = _dnm_createtime;
		}
    }
    public String get_sk_oprcode(){
        return _sk_oprcode;
    }

    public void set_sk_oprcode(String _sk_oprcode){
        this._sk_oprcode = _sk_oprcode;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }
    public String get_sk_batchno(){
        return _sk_batchno;
    }

    public void set_sk_batchno(String _sk_batchno){
        this._sk_batchno = _sk_batchno;
    }
    public String get_se_oprresulte(){
        return _se_oprresulte;
    }

    public void set_se_oprresulte(String _se_oprresulte){
        this._se_oprresulte = _se_oprresulte;
    }
    public String get_se_oprstate(){
        return _se_oprstate;
    }

    public void set_se_oprstate(String _se_oprstate){
        this._se_oprstate = _se_oprstate;
    }

}
