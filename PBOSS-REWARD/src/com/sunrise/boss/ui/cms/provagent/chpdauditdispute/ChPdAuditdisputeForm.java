/**
* auto-generated code
* Tue Sep 03 20:54:50 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdauditdispute;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChPdAuditdisputeForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPdAuditdisputeForm extends BaseActionForm {

    private java.lang.Long disputeid;
    private java.lang.Long rewardid;
    private java.lang.String cityid;
    private java.lang.Byte auditrole;
    private java.lang.String content;
    private java.lang.String auditeename;
    private java.lang.String telephone;
    private java.lang.Byte isaccepted;
    private java.lang.Byte isdealed;
    private java.lang.Byte dealtype;
    private java.lang.Long suppleseq;
    private java.lang.String memo;
    private java.util.Date incomstime;

    private String _se_cityid;
	private String _se_provagentid;
	private String _se_prodid;
	private String _se_rewardmonth;
	
	private boolean query;

    public java.lang.Long getDisputeid(){
        return disputeid;
    }

    public void setDisputeid(java.lang.Long disputeid){
        this.disputeid = disputeid;
    }
    public java.lang.Long getRewardid(){
        return rewardid;
    }

    public void setRewardid(java.lang.Long rewardid){
        this.rewardid = rewardid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.Byte getAuditrole(){
        return auditrole;
    }

    public void setAuditrole(java.lang.Byte auditrole){
        this.auditrole = auditrole;
    }
    public java.lang.String getContent(){
        return content;
    }

    public void setContent(java.lang.String content){
        this.content = content;
    }
    public java.lang.String getAuditeename(){
        return auditeename;
    }

    public void setAuditeename(java.lang.String auditeename){
        this.auditeename = auditeename;
    }
    public java.lang.String getTelephone(){
        return telephone;
    }

    public void setTelephone(java.lang.String telephone){
        this.telephone = telephone;
    }
    public java.lang.Byte getIsaccepted(){
        return isaccepted;
    }

    public void setIsaccepted(java.lang.Byte isaccepted){
        this.isaccepted = isaccepted;
    }
    public java.lang.Byte getIsdealed(){
        return isdealed;
    }

    public void setIsdealed(java.lang.Byte isdealed){
        this.isdealed = isdealed;
    }
    public java.lang.Byte getDealtype(){
        return dealtype;
    }

    public void setDealtype(java.lang.Byte dealtype){
        this.dealtype = dealtype;
    }
    public java.lang.Long getSuppleseq(){
        return suppleseq;
    }

    public void setSuppleseq(java.lang.Long suppleseq){
        this.suppleseq = suppleseq;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
    }
    public java.util.Date getIncomstime(){
        return incomstime;
    }

    public void setIncomstime(java.util.Date incomstime){
        this.incomstime = incomstime;
    }

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_provagentid() {
		return _se_provagentid;
	}

	public void set_se_provagentid(String _se_provagentid) {
		this._se_provagentid = _se_provagentid;
	}

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

	public boolean isQuery() {
		return query;
	}

	public void setQuery(boolean query) {
		this.query = query;
	}

}
