/**
* auto-generated code
* Thu May 19 16:35:38 CST 2011
*/
package com.sunrise.boss.ui.cms.rewardreport;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportVO;

/**
 * <p>Title: RewardreportForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardreportForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.String name;
    private java.lang.Double piece;
    private java.lang.Double star;
    private java.lang.Double terminal;
    private java.lang.Double cooperate;
    private java.lang.Long isaffirm;
    private java.lang.String calcmonth;
    private java.lang.Double sum;
    private java.util.Date sendtime;
    private java.lang.Double paymoney;//已付酬金
    private java.lang.Double adjmoney;//酬金调整金额
    private java.lang.Double remark;//支付金额

    private String _se_wayid;
    private String _se_calcmonth;
    private String _de_sendtime;
    private String _se_countyid;
    private String officetel;
    private java.lang.String audittype;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getName(){
        return name;
    }

    public void setName(java.lang.String name){
        this.name = name;
    }
    public java.lang.Double getPiece(){
        return piece;
    }

    public void setPiece(java.lang.Double piece){
        this.piece = piece;
    }
    public java.lang.Double getStar(){
        return star;
    }

    public void setStar(java.lang.Double star){
        this.star = star;
    }
    public java.lang.Double getTerminal(){
        return terminal;
    }

    public void setTerminal(java.lang.Double terminal){
        this.terminal = terminal;
    }
    public java.lang.Double getCooperate(){
        return cooperate;
    }

    public void setCooperate(java.lang.Double cooperate){
        this.cooperate = cooperate;
    }
    public java.lang.Long getIsaffirm(){
        return isaffirm;
    }

    public void setIsaffirm(java.lang.Long isaffirm){
        this.isaffirm = isaffirm;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }
    public java.lang.Double getSum(){
        return sum;
    }

    public void setSum(java.lang.Double sum){
        this.sum = sum;
    }
    public java.util.Date getSendtime(){
        return sendtime;
    }

    public void setSendtime(java.util.Date sendtime){
        this.sendtime = sendtime;
    }

    public String get_se_wayid(){
        return _se_wayid;
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
    public String get_de_sendtime(){
        return _de_sendtime;
    }

    public void set_de_sendtime(String _de_sendtime){
        this._de_sendtime = _de_sendtime;
    }

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public java.lang.Double getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(java.lang.Double paymoney) {
		this.paymoney = paymoney;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public java.lang.Double getAdjmoney() {
		return adjmoney;
	}

	public void setAdjmoney(java.lang.Double adjmoney) {
		this.adjmoney = adjmoney;
	}

	public java.lang.String getAudittype() {
		return audittype;
	}

	public void setAudittype(java.lang.String audittype) {
		this.audittype = audittype;
	}

	public java.lang.Double getRemark() {
		return remark;
	}

	public void setRemark(java.lang.Double remark) {
		this.remark = remark;
	}

}
