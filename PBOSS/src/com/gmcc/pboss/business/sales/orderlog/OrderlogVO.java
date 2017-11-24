package com.gmcc.pboss.business.sales.orderlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String orderid;

    /** nullable persistent field */
    private Long flowid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String cooptype;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String orderave;

    /** nullable persistent field */
    private String storarea;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String orderstate;

    /** nullable persistent field */
    private java.util.Date statechgtime;

    /** nullable persistent field */
    private String paytype;

    /** nullable persistent field */
    private String delitype;

    /** nullable persistent field */
    private Double recamt;

    /** nullable persistent field */
    private Double actamt;

    /** nullable persistent field */
    private String posstream;

    /** nullable persistent field */
    private String bossworkfid;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String discomcode;

    /** nullable persistent field */
    private java.util.Date paytime;

    /** nullable persistent field */
    private String deductstate;

    /** nullable persistent field */
    private String signstate;

    /** nullable persistent field */
    private String alarmlevel;

    /** nullable persistent field */
    private Short confirmflag;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private java.util.Date signtime;

    /** nullable persistent field */
    private java.util.Date recordtime;

    /** nullable persistent field */
    private java.util.Date disovertime;

    /** nullable persistent field */
    private String signtype;

    /** nullable persistent field */
    private String smssignno;

    /** nullable persistent field */
    private Short reviewstate;
    
    /**受理单打印次数*/
    private Integer accepprintamt;

    /** full constructor */
    public OrderlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String orderid, java.lang.Long flowid, java.lang.String wayid, java.lang.String countyid, java.lang.String cooptype, java.lang.Short starlevel, java.lang.String orderave, java.lang.String storarea, java.util.Date createtime, java.lang.String orderstate, java.util.Date statechgtime, java.lang.String paytype, java.lang.String delitype, java.lang.Double recamt, java.lang.Double actamt, java.lang.String posstream, java.lang.String bossworkfid, java.lang.String memo, java.lang.String discomcode, java.util.Date paytime, java.lang.String deductstate, java.lang.String signstate, java.lang.String alarmlevel, java.lang.Short confirmflag, java.lang.String mareacode, java.util.Date signtime, java.util.Date recordtime, java.util.Date disovertime, java.lang.String signtype, java.lang.String smssignno, java.lang.Short reviewstate,java.lang.Integer accepprintamt) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.orderid = orderid;
        this.flowid = flowid;
        this.wayid = wayid;
        this.countyid = countyid;
        this.cooptype = cooptype;
        this.starlevel = starlevel;
        this.orderave = orderave;
        this.storarea = storarea;
        this.createtime = createtime;
        this.orderstate = orderstate;
        this.statechgtime = statechgtime;
        this.paytype = paytype;
        this.delitype = delitype;
        this.recamt = recamt;
        this.actamt = actamt;
        this.posstream = posstream;
        this.bossworkfid = bossworkfid;
        this.memo = memo;
        this.discomcode = discomcode;
        this.paytime = paytime;
        this.deductstate = deductstate;
        this.signstate = signstate;
        this.alarmlevel = alarmlevel;
        this.confirmflag = confirmflag;
        this.mareacode = mareacode;
        this.signtime = signtime;
        this.recordtime = recordtime;
        this.disovertime = disovertime;
        this.signtype = signtype;
        this.smssignno = smssignno;
        this.reviewstate = reviewstate;
        this.accepprintamt = accepprintamt;
    }

    /** default constructor */
    public OrderlogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Long getFlowid() {
        return this.flowid;
    }

    public void setFlowid(java.lang.Long flowid) {
        this.flowid = flowid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getCooptype() {
        return this.cooptype;
    }

    public void setCooptype(java.lang.String cooptype) {
        this.cooptype = cooptype;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getOrderave() {
        return this.orderave;
    }

    public void setOrderave(java.lang.String orderave) {
        this.orderave = orderave;
    }

    public java.lang.String getStorarea() {
        return this.storarea;
    }

    public void setStorarea(java.lang.String storarea) {
        this.storarea = storarea;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getOrderstate() {
        return this.orderstate;
    }

    public void setOrderstate(java.lang.String orderstate) {
        this.orderstate = orderstate;
    }

    public java.util.Date getStatechgtime() {
        return this.statechgtime;
    }

    public void setStatechgtime(java.util.Date statechgtime) {
        this.statechgtime = statechgtime;
    }

    public java.lang.String getPaytype() {
        return this.paytype;
    }

    public void setPaytype(java.lang.String paytype) {
        this.paytype = paytype;
    }

    public java.lang.String getDelitype() {
        return this.delitype;
    }

    public void setDelitype(java.lang.String delitype) {
        this.delitype = delitype;
    }

    public java.lang.Double getRecamt() {
        return this.recamt;
    }

    public void setRecamt(java.lang.Double recamt) {
        this.recamt = recamt;
    }

    public java.lang.Double getActamt() {
        return this.actamt;
    }

    public void setActamt(java.lang.Double actamt) {
        this.actamt = actamt;
    }

    public java.lang.String getPosstream() {
        return this.posstream;
    }

    public void setPosstream(java.lang.String posstream) {
        this.posstream = posstream;
    }

    public java.lang.String getBossworkfid() {
        return this.bossworkfid;
    }

    public void setBossworkfid(java.lang.String bossworkfid) {
        this.bossworkfid = bossworkfid;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.util.Date getPaytime() {
        return this.paytime;
    }

    public void setPaytime(java.util.Date paytime) {
        this.paytime = paytime;
    }

    public java.lang.String getDeductstate() {
        return this.deductstate;
    }

    public void setDeductstate(java.lang.String deductstate) {
        this.deductstate = deductstate;
    }

    public java.lang.String getSignstate() {
        return this.signstate;
    }

    public void setSignstate(java.lang.String signstate) {
        this.signstate = signstate;
    }

    public java.lang.String getAlarmlevel() {
        return this.alarmlevel;
    }

    public void setAlarmlevel(java.lang.String alarmlevel) {
        this.alarmlevel = alarmlevel;
    }

    public java.lang.Short getConfirmflag() {
        return this.confirmflag;
    }

    public void setConfirmflag(java.lang.Short confirmflag) {
        this.confirmflag = confirmflag;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.util.Date getSigntime() {
        return this.signtime;
    }

    public void setSigntime(java.util.Date signtime) {
        this.signtime = signtime;
    }

    public java.util.Date getRecordtime() {
        return this.recordtime;
    }

    public void setRecordtime(java.util.Date recordtime) {
        this.recordtime = recordtime;
    }

    public java.util.Date getDisovertime() {
        return this.disovertime;
    }

    public void setDisovertime(java.util.Date disovertime) {
        this.disovertime = disovertime;
    }

    public java.lang.String getSigntype() {
        return this.signtype;
    }

    public void setSigntype(java.lang.String signtype) {
        this.signtype = signtype;
    }

    public java.lang.String getSmssignno() {
        return this.smssignno;
    }

    public void setSmssignno(java.lang.String smssignno) {
        this.smssignno = smssignno;
    }

    public java.lang.Short getReviewstate() {
        return this.reviewstate;
    }

    public void setReviewstate(java.lang.Short reviewstate) {
        this.reviewstate = reviewstate;
    }
    
    public Integer getAccepprintamt() {
		return accepprintamt;
	}

	public void setAccepprintamt(Integer accepprintamt) {
		this.accepprintamt = accepprintamt;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderlogVO) ) return false;
        OrderlogVO castOther = (OrderlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
