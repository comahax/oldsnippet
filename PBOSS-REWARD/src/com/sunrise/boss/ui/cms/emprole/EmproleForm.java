/**
* auto-generated code
* Thu May 27 10:43:08 CST 2010
*/
package com.sunrise.boss.ui.cms.emprole;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.emprole.persistent.EmproleVO;

/**
 * <p>Title: EmproleForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class EmproleForm extends BaseActionForm {

    private java.lang.String employeeid;
    private java.lang.String ekey;
    private java.lang.String evalue;

    private String _se_employeeid;

    public java.lang.String getEmployeeid(){
        return employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid){
        this.employeeid = employeeid;
    }
    public java.lang.String getEkey(){
        return ekey;
    }

    public void setEkey(java.lang.String ekey){
        this.ekey = ekey;
    }
    public java.lang.String getEvalue(){
        return evalue;
    }

    public void setEvalue(java.lang.String evalue){
        this.evalue = evalue;
    }

    public String get_se_employeeid(){
        return _se_employeeid;
    }

    public void set_se_employeeid(String _se_employeeid){
        this._se_employeeid = _se_employeeid;
    }

}
