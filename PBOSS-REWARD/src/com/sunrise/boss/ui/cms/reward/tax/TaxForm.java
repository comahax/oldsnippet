/**
* auto-generated code
* Fri May 27 12:04:23 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.tax;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: TaxForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class TaxForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.Short cityid;
    private java.lang.Short taxtype;
    private java.lang.String parameter;
    private java.lang.Float value;
    private java.lang.Integer value2;

    private String _ne_cityid;
    private String _ne_taxtype;
    private String _se_parameter;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.Short getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.Short cityid){
        this.cityid = cityid;
    }
    public java.lang.Short getTaxtype(){
        return taxtype;
    }

    public void setTaxtype(java.lang.Short taxtype){
        this.taxtype = taxtype;
    }
    public java.lang.String getParameter(){
        return parameter;
    }

    public void setParameter(java.lang.String parameter){
        this.parameter = parameter;
    }
    public java.lang.Float getValue(){
        return value;
    }

    public void setValue(java.lang.Float value){
        this.value = value;
    }

    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_ne_taxtype(){
        return _ne_taxtype;
    }

    public void set_ne_taxtype(String _ne_taxtype){
        this._ne_taxtype = _ne_taxtype;
    }
    public String get_se_parameter(){
        return _se_parameter;
    }

    public void set_se_parameter(String _se_parameter){
        this._se_parameter = _se_parameter;
    }

	public java.lang.Integer getValue2() {
		return value2;
	}

	public void setValue2(java.lang.Integer value2) {
		this.value2 = value2;
	}

}
