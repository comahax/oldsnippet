/**
* auto-generated code
* Thu Dec 29 14:47:31 CST 2011
*/
package com.sunrise.boss.ui.cms.zjty.zjtyassess;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessVO;

/**
 * <p>Title: ZjtyAssessForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyAssessForm extends BaseActionForm {

    private java.lang.String wayid;
    private java.lang.String calcmonth;
    private java.lang.Float coef1;
    private java.lang.Float coef2;
    private java.lang.Float coef3;
    private java.lang.Short cityid;
    private java.lang.Integer empnum;

    private String _se_wayid;
    private String _se_calcmonth;
    private String _ne_cityid;

    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }
    public java.lang.Float getCoef1(){
        return coef1;
    }

    public void setCoef1(java.lang.Float coef1){
        this.coef1 = coef1;
    }
    public java.lang.Float getCoef2(){
        return coef2;
    }

    public void setCoef2(java.lang.Float coef2){
        this.coef2 = coef2;
    }
    public java.lang.Float getCoef3(){
        return coef3;
    }

    public void setCoef3(java.lang.Float coef3){
        this.coef3 = coef3;
    }
    public java.lang.Short getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.Short cityid){
        this.cityid = cityid;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public java.lang.Integer getEmpnum() {
		return empnum;
	}

	public void setEmpnum(java.lang.Integer empnum) {
		this.empnum = empnum;
	}

	public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }

}
