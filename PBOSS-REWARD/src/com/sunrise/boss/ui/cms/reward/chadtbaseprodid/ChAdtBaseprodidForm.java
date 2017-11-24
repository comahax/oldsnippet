/**
* auto-generated code
* Tue Jun 03 21:10:10 CST 2014
*/
package com.sunrise.boss.ui.cms.reward.chadtbaseprodid;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidVO;

/**
 * <p>Title: ChAdtBaseprodidForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtBaseprodidForm extends BaseActionForm {
	private String _se_prodid;
	private String _se_cityid;
	private String _se_type;
	private String _se_oprtype;
    private java.lang.String prodid;
    private java.lang.String cityid;
    private java.lang.String type;
    private java.lang.String prodname;
    private java.lang.String oprtype;
    private java.lang.String tertype;
    private java.lang.Double wrapfee;
    private java.util.Date createtime;
    private java.lang.String adtremark;


    public java.lang.String getProdid(){
        return prodid;
    }

    public void setProdid(java.lang.String prodid){
        this.prodid = prodid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getType(){
        return type;
    }

    public void setType(java.lang.String type){
        this.type = type;
    }
    public java.lang.String getProdname(){
        return prodname;
    }

    public void setProdname(java.lang.String prodname){
        this.prodname = prodname;
    }
    public java.lang.String getOprtype(){
        return oprtype;
    }

    public void setOprtype(java.lang.String oprtype){
        this.oprtype = oprtype;
    }
    public java.lang.String getTertype(){
        return tertype;
    }

    public void setTertype(java.lang.String tertype){
        this.tertype = tertype;
    }
    public java.lang.Double getWrapfee(){
        return wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee){
        this.wrapfee = wrapfee;
    }
    public java.util.Date getCreatetime(){
        return createtime;
    }

    public void setCreatetime(java.util.Date createtime){
        this.createtime = createtime;
    }
    public java.lang.String getAdtremark(){
        return adtremark;
    }

    public void setAdtremark(java.lang.String adtremark){
        this.adtremark = adtremark;
    }

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_type() {
		return _se_type;
	}

	public void set_se_type(String _se_type) {
		this._se_type = _se_type;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}


}
