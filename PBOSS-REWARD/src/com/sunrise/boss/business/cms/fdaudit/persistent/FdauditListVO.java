/**
* auto-generated code
* Thu Jul 26 16:12:39 CST 2007
*/
package com.sunrise.boss.business.cms.fdaudit.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: FdauditListVO</p>
 * <p>Description: Query Params Object for FdauditDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yuanweihai
 * @version 1.0
 */
public class FdauditListVO extends BaseListVO {
    private String _ne_recno;
    private String _se_tablename;
    private String _se_typename;
    private String _se_pkvalue;
    private String _se_pkvalue2;
    private String _se_field;
    private String _se_fieldvalue;
    private String _ne_auditstatus;

    public String get_ne_recno(){
        return _ne_recno;
    }

    public void set_ne_recno(String _ne_recno){
        this._ne_recno = _ne_recno;
    }
    public String get_se_tablename(){
        return _se_tablename;
    }

    public void set_se_tablename(String _se_tablename){
        this._se_tablename = _se_tablename;
    }
    public String get_se_typename(){
        return _se_typename;
    }

    public void set_se_typename(String _se_typename){
        this._se_typename = _se_typename;
    }
    public String get_se_pkvalue(){
        return _se_pkvalue;
    }

    public void set_se_pkvalue(String _se_pkvalue){
        this._se_pkvalue = _se_pkvalue;
    }
    public String get_se_pkvalue2(){
        return _se_pkvalue2;
    }

    public void set_se_pkvalue2(String _se_pkvalue2){
        this._se_pkvalue2 = _se_pkvalue2;
    }
    public String get_se_field(){
        return _se_field;
    }

    public void set_se_field(String _se_field){
        this._se_field = _se_field;
    }
    public String get_se_fieldvalue(){
        return _se_fieldvalue;
    }

    public void set_se_fieldvalue(String _se_fieldvalue){
        this._se_fieldvalue = _se_fieldvalue;
    }
    public String get_ne_auditstatus(){
        return _ne_auditstatus;
    }

    public void set_ne_auditstatus(String _ne_auditstatus){
        this._ne_auditstatus = _ne_auditstatus;
    }

}
