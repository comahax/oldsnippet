/**
* auto-generated code
* Sat Nov 28 17:48:48 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.mapping;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingVO;

/**
 * <p>Title: MappingForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappingForm extends BaseActionForm {

    private java.lang.Long seqid;
    private java.lang.Integer exmnid;
    private java.lang.String cityid;
    private java.lang.String mmode;
    private java.lang.Double markul;
    private java.lang.Double markll;
    private java.lang.Double coeforbase;

    private String _ne_seqid;
    private String _ne_exmnid;
    private String _se_cityid;

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
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getMmode(){
        return mmode;
    }

    public void setMmode(java.lang.String mmode){
        this.mmode = mmode;
    }
    public java.lang.Double getMarkul(){
        return markul;
    }

    public void setMarkul(java.lang.Double markul){
        this.markul = markul;
    }
    public java.lang.Double getMarkll(){
        return markll;
    }

    public void setMarkll(java.lang.Double markll){
        this.markll = markll;
    }
    public java.lang.Double getCoeforbase(){
        return coeforbase;
    }

    public void setCoeforbase(java.lang.Double coeforbase){
        this.coeforbase = coeforbase;
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
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

}
