/**
* auto-generated code
* Thu Feb 25 14:28:35 CST 2010
*/
package com.sunrise.boss.ui.cms.bbc.hdnetsales;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: hdnetsalesForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class HdnetsalesForm extends BaseActionForm {

    private java.lang.String srcseq;
    private java.lang.String ruleid;
    private java.lang.String opnid;
    private java.lang.String calcopnid;
    private java.lang.String calcmonth;
    private java.lang.String wayid;
    private java.util.Date oprtime;
    private java.lang.String oprcode;
    private java.lang.String mobile;
    private java.lang.Double busivalue;
    private java.lang.Short rewardtype;
    private java.lang.Short ossrc;
    private java.lang.Long seq;

    private String _se_seq;
    private String _se_opnid;
    private String _se_mobile;
    private String _dnl_oprtime;
    private String _dnm_oprtime;
    private String _sk_name;
    
    public java.lang.String getSrcseq(){
        return srcseq;
    }

    public void setSrcseq(java.lang.String srcseq){
        this.srcseq = srcseq;
    }
    public java.lang.String getRuleid(){
        return ruleid;
    }

    public void setRuleid(java.lang.String ruleid){
        this.ruleid = ruleid;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getCalcopnid(){
        return calcopnid;
    }

    public void setCalcopnid(java.lang.String calcopnid){
        this.calcopnid = calcopnid;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }
    public java.lang.Double getBusivalue(){
        return busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue){
        this.busivalue = busivalue;
    }
    public java.lang.Short getRewardtype(){
        return rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype){
        this.rewardtype = rewardtype;
    }
    public java.lang.Short getOssrc(){
        return ossrc;
    }

    public void setOssrc(java.lang.Short ossrc){
        this.ossrc = ossrc;
    }
    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }

	public String get_se_seq() {
		return _se_seq;
	}

	public void set_se_seq(String _se_seq) {
		this._se_seq = _se_seq;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}

	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}

	public String get_dnm_oprtime() {
		if(StringUtils.isEmpty(_dnm_oprtime))return _dnm_oprtime;
		return _dnm_oprtime + " 23:59:59";
	}

	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}

	public String get_sk_name() {
		return _sk_name;
	}

	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}
	
}
