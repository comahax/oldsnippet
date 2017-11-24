/**
* auto-generated code
* Wed Nov 25 11:16:38 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnitemdtl;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;

/**
 * <p>Title: ExmnitemdtlForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtlForm extends BaseActionForm {

    private java.lang.Long seqid;
    private java.lang.Integer exmnid;
    private java.lang.Integer exmnstdid;
    private java.lang.String cityid;
    private java.lang.String marktype;
    private java.lang.Double basemk;
    private java.lang.Double dynamicmk;
    private java.lang.Double leastcrtcl;
    private java.lang.Double largestcrtcl;
    private java.lang.Long pseqid;

    private String _ne_seqid;
    private String _ne_exmnid;
    private String _ne_exmnstdid;
    private String _se_cityid;
    private String _ne_pseqid;
    private String _nn_pseqid;
    
    public String get_nn_pseqid() {
		return _nn_pseqid;
	}

	public void set_nn_pseqid(String _nn_pseqid) {
		this._nn_pseqid = _nn_pseqid;
	}

	public java.lang.Long getSeqid(){
        return seqid;
    }

    public void setSeqid(java.lang.Long seqid){
        this.seqid = seqid;
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
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getMarktype(){
        return marktype;
    }

    public void setMarktype(java.lang.String marktype){
        this.marktype = marktype;
    }
   
    public java.lang.Double getBasemk() {
		return basemk;
	}

	public void setBasemk(java.lang.Double basemk) {
		this.basemk = basemk;
	}

	public java.lang.Double getDynamicmk() {
		return dynamicmk;
	}

	public void setDynamicmk(java.lang.Double dynamicmk) {
		this.dynamicmk = dynamicmk;
	}

	public java.lang.Double getLeastcrtcl() {
		return leastcrtcl;
	}

	public void setLeastcrtcl(java.lang.Double leastcrtcl) {
		this.leastcrtcl = leastcrtcl;
	}

	public java.lang.Double getLargestcrtcl() {
		return largestcrtcl;
	}

	public void setLargestcrtcl(java.lang.Double largestcrtcl) {
		this.largestcrtcl = largestcrtcl;
	}

	public java.lang.Long getPseqid(){
        return pseqid;
    }

    public void setPseqid(java.lang.Long pseqid){
        this.pseqid = pseqid;
    }

    public String get_ne_seqid(){
        return _ne_seqid;
    }

    public void set_ne_seqid(String _ne_seqid){
        this._ne_seqid = _ne_seqid;
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
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

	public String get_ne_pseqid() {
		return _ne_pseqid;
	}

	public void set_ne_pseqid(String _ne_pseqid) {
		this._ne_pseqid = _ne_pseqid;
	}

}
