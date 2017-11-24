/**
* auto-generated code
* Tue Jan 05 15:32:41 CST 2010
*/
package com.sunrise.boss.ui.cms.zjty.zjtydataquery;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryVO;

/**
 * <p>Title: ZjtyDataqueryForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDataqueryForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.Long srcseq;
    private java.lang.String cityid;
    private java.lang.String opnid;
    private java.lang.String wayid;
    private java.lang.String oprcode;
    private java.util.Date oprtime;
    private java.lang.String mobile;
    private java.lang.Double busivalue;
    private Double wrapfee;
    private Short noncyc;
    private Short rewardtype;
    private Short calcflag;
    private String calcremark;
    private java.util.Date createtime;
    private java.util.Date wadttime;
    private java.util.Date updatetime;
    private java.lang.Byte brand;
    private java.util.Date creattime;
    private java.util.Date adttime;
    private java.lang.String src;
    private java.lang.String calcopnid;
    private java.lang.String calcmonth;
    private java.lang.String ruleid;
    private java.lang.String ruleitemid;
    private java.lang.Short adtflag;
    private java.lang.String adtcode;
    private java.lang.String adtremark;
    
    private String _ne_mobile;
	
	private String _se_wayid;
	
	private String _se_opnid;
	
	private String _dnl_oprtime;

	private String _dnm_oprtime;
	
	private String _se_oprcode;
	
	private String _se_cityid;
    
    public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}

	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}

	public String get_dnm_oprtime() {
		return _dnm_oprtime;
	}

	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}

	public String get_ne_mobile() {
		return _ne_mobile;
	}

	public void set_ne_mobile(String _ne_mobile) {
		this._ne_mobile = _ne_mobile;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.Long getSrcseq(){
        return srcseq;
    }

    public void setSrcseq(java.lang.Long srcseq){
        this.srcseq = srcseq;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
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
    public java.lang.Byte getBrand(){
        return brand;
    }

    public void setBrand(java.lang.Byte brand){
        this.brand = brand;
    }
    public java.util.Date getCreattime(){
        return creattime;
    }

    public void setCreattime(java.util.Date creattime){
        this.creattime = creattime;
    }
    public java.util.Date getAdttime(){
        return adttime;
    }

    public void setAdttime(java.util.Date adttime){
        this.adttime = adttime;
    }
    public java.lang.String getSrc(){
        return src;
    }

    public void setSrc(java.lang.String src){
        this.src = src;
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
    public java.lang.String getRuleid(){
        return ruleid;
    }

    public void setRuleid(java.lang.String ruleid){
        this.ruleid = ruleid;
    }
    public java.lang.String getRuleitemid(){
        return ruleitemid;
    }

    public void setRuleitemid(java.lang.String ruleitemid){
        this.ruleitemid = ruleitemid;
    }
    public java.lang.Short getAdtflag(){
        return adtflag;
    }

    public void setAdtflag(java.lang.Short adtflag){
        this.adtflag = adtflag;
    }
    public java.lang.String getAdtcode(){
        return adtcode;
    }

    public void setAdtcode(java.lang.String adtcode){
        this.adtcode = adtcode;
    }
    public java.lang.String getAdtremark(){
        return adtremark;
    }

    public void setAdtremark(java.lang.String adtremark){
        this.adtremark = adtremark;
    }

	public Short getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(Short calcflag) {
		this.calcflag = calcflag;
	}

	public String getCalcremark() {
		return calcremark;
	}

	public void setCalcremark(String calcremark) {
		this.calcremark = calcremark;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public Short getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Short noncyc) {
		this.noncyc = noncyc;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public java.util.Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}

	public java.util.Date getWadttime() {
		return wadttime;
	}

	public void setWadttime(java.util.Date wadttime) {
		this.wadttime = wadttime;
	}

	public Double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}

}
