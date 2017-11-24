/**
* auto-generated code
* Wed Nov 25 11:12:10 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnitem;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;

/**
 * <p>Title: ExmnitemForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemForm extends BaseActionForm {

    private java.lang.Integer exmnid;
    private java.lang.Integer exmnstdid;
    private java.lang.String isvoted;
    private java.lang.Double exmnscore;

    private String _ne_exmnid;
    private String _ne_exmnstdid;
    private String _se_isvoted;
    private String _sk_exmnstdname;

    public String get_sk_exmnstdname() {
		return _sk_exmnstdname;
	}

	public void set_sk_exmnstdname(String _sk_exmnstdname) {
		this._sk_exmnstdname = _sk_exmnstdname;
	}

	public java.lang.Integer getExmnid(){
        return exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid){
        this.exmnid = exmnid;
    }
    public java.lang.Integer getExmnstdid(){
        return exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid){
        this.exmnstdid = exmnstdid;
    }
    public java.lang.String getIsvoted(){
        return isvoted;
    }

    public void setIsvoted(java.lang.String isvoted){
        this.isvoted = isvoted;
    }
    public java.lang.Double getExmnscore(){
        return exmnscore;
    }

    public void setExmnscore(java.lang.Double exmnscore){
        this.exmnscore = exmnscore;
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
    public String get_se_isvoted(){
        return _se_isvoted;
    }

    public void set_se_isvoted(String _se_isvoted){
        this._se_isvoted = _se_isvoted;
    }

}
