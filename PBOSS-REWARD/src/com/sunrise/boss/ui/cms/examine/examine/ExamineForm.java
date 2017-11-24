/**
* auto-generated code
* Wed Nov 18 16:17:06 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.examine;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;

/**
 * <p>Title: ExamineForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExamineForm extends BaseActionForm {

    private java.lang.Integer exmnid;
    private java.lang.String exmnname;
    private java.lang.String state;
    private java.lang.String cityid;
    private java.lang.String applycityid;
    private java.lang.String adtype;
    private java.lang.String starlevel;
    private java.lang.String memo;
    private java.lang.String rights;

    private String _ne_exmnid;
    private String _sk_exmnname;
    private String _se_state;
    private String _se_adtype;
    private String _sk_adtype;
    private String _se_starlevel;
    private String _sk_starlevel;
    private String _se_cityid;

    public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public java.lang.Integer getExmnid(){
        return exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid){
        this.exmnid = exmnid;
    }
    public java.lang.String getExmnname(){
        return exmnname;
    }

    public void setExmnname(java.lang.String exmnname){
        this.exmnname = exmnname;
    }
    public java.lang.String getState(){
        return state;
    }

    public void setState(java.lang.String state){
        this.state = state;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getApplycityid(){
        return applycityid;
    }

    public void setApplycityid(java.lang.String applycityid){
        this.applycityid = applycityid;
    }
    public java.lang.String getAdtype(){
        return adtype;
    }

    public void setAdtype(java.lang.String adtype){
        this.adtype = adtype;
    }
    public java.lang.String getStarlevel(){
        return starlevel;
    }

    public void setStarlevel(java.lang.String starlevel){
        this.starlevel = starlevel;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
    }
    public java.lang.String getRights(){
        return rights;
    }

    public void setRights(java.lang.String rights){
        this.rights = rights;
    }

    public String get_ne_exmnid(){
        return _ne_exmnid;
    }

    public void set_ne_exmnid(String _ne_exmnid){
        this._ne_exmnid = _ne_exmnid;
    }
    public String get_sk_exmnname(){
        return _sk_exmnname;
    }

    public void set_sk_exmnname(String _sk_exmnname){
        this._sk_exmnname = _sk_exmnname;
    }
    public String get_se_state(){
        return _se_state;
    }

    public void set_se_state(String _se_state){
        this._se_state = _se_state;
    }
    public String get_se_adtype(){
        return _se_adtype;
    }

    public void set_se_adtype(String _se_adtype){
        this._se_adtype = _se_adtype;
    }
    public String get_sk_adtype(){
        return _sk_adtype;
    }

    public void set_sk_adtype(String _sk_adtype){
        this._sk_adtype = _sk_adtype;
    }
    public String get_se_starlevel(){
        return _se_starlevel;
    }

    public void set_se_starlevel(String _se_starlevel){
        this._se_starlevel = _se_starlevel;
    }
    public String get_sk_starlevel(){
        return _sk_starlevel;
    }

    public void set_sk_starlevel(String _sk_starlevel){
        this._sk_starlevel = _sk_starlevel;
    }

}
