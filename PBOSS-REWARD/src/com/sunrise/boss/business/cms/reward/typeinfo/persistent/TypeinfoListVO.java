/**
* auto-generated code
* Tue Apr 10 15:46:57 CST 2012
*/
package com.sunrise.boss.business.cms.reward.typeinfo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: TypeinfoListVO</p>
 * <p>Description: Query Params Object for TypeinfoDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class TypeinfoListVO extends BaseListVO {
    private String _ne_facetype;
    private String _se_facename;
    private String _se_cityid;
    private String _se_type;
    private String _se_typename;

    public String get_ne_facetype(){
        return _ne_facetype;
    }

    public void set_ne_facetype(String _ne_facetype){
        this._ne_facetype = _ne_facetype;
    }
    public String get_se_facename(){
        return _se_facename;
    }

    public void set_se_facename(String _se_facename){
        this._se_facename = _se_facename;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_se_type(){
        return _se_type;
    }

    public void set_se_type(String _se_type){
        this._se_type = _se_type;
    }
    public String get_se_typename(){
        return _se_typename;
    }

    public void set_se_typename(String _se_typename){
        this._se_typename = _se_typename;
    }

}
