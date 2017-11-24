/**
* auto-generated code
* Sun Nov 29 14:15:38 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.coefficient;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientVO;

/**
 * <p>Title: CoefficientForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CoefficientForm extends BaseActionForm {

    private java.lang.Integer exmnid;
    private java.lang.String wayid;
    private java.lang.String exmnperiod;
    private java.lang.Double coefficientsum;
    private java.lang.Double coefficient;

    private String _ne_exmnid;
    private String _se_wayid;
    private String _snm_exmnperiod;
    private String _se_exmnperiod;
    private String _snl_exmnperiod;
    private String _ne_coefficient;

    public java.lang.Integer getExmnid(){
        return exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid){
        this.exmnid = exmnid;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getExmnperiod(){
        return exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod){
        this.exmnperiod = exmnperiod;
    }
    public java.lang.Double getCoefficient(){
        return coefficient;
    }

    public void setCoefficient(java.lang.Double coefficient){
        this.coefficient = coefficient;
    }

    public String get_ne_exmnid(){
        return _ne_exmnid;
    }

    public void set_ne_exmnid(String _ne_exmnid){
        this._ne_exmnid = _ne_exmnid;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_snm_exmnperiod(){
        return _snm_exmnperiod;
    }

    public void set_snm_exmnperiod(String _snm_exmnperiod){
        this._snm_exmnperiod = _snm_exmnperiod;
    }
    public String get_se_exmnperiod(){
        return _se_exmnperiod;
    }

    public void set_se_exmnperiod(String _se_exmnperiod){
        this._se_exmnperiod = _se_exmnperiod;
    }
    public String get_snl_exmnperiod(){
        return _snl_exmnperiod;
    }

    public void set_snl_exmnperiod(String _snl_exmnperiod){
        this._snl_exmnperiod = _snl_exmnperiod;
    }
    public String get_ne_coefficient(){
        return _ne_coefficient;
    }

    public void set_ne_coefficient(String _ne_coefficient){
        this._ne_coefficient = _ne_coefficient;
    }

	public java.lang.Double getCoefficientsum() {
		return coefficientsum;
	}

	public void setCoefficientsum(java.lang.Double coefficientsum) {
		this.coefficientsum = coefficientsum;
	}

}
