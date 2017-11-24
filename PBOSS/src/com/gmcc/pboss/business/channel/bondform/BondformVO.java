package com.gmcc.pboss.business.channel.bondform;

import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogVO;
import com.gmcc.pboss.business.channel.bondformlog.BondformlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BondformVO extends BaseVO implements Serializable, BusinessLog{

    /** identifier field */
    private Long formid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String bondtype;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String principal;

    /** nullable persistent field */
    private String principaltel;

    /** nullable persistent field */
    private String paymentmode;

    /** nullable persistent field */
    private Double payamt;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private java.util.Date confirmtime;

    /** nullable persistent field */
    private String receiptno;

    /** nullable persistent field */
    private Double receiptamt;

    /** nullable persistent field */
    private String filepath;

    /** nullable persistent field */
    private String receiptmeomo;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private Short boneobjtype;

    /** nullable persistent field */
    private Short bailtype;

    /** nullable persistent field */
    private String payno;

    /** nullable persistent field */
    private String payfilepath;

    /** full constructor */
    public BondformVO(java.lang.Long formid, java.lang.String wayid, java.lang.String bondtype, java.lang.String countyid, java.lang.String principal, java.lang.String principaltel, java.lang.String paymentmode, java.lang.Double payamt, java.lang.Short state, java.util.Date confirmtime, java.lang.String receiptno, java.lang.Double receiptamt, java.lang.String filepath, java.lang.String receiptmeomo, java.util.Date createtime, java.lang.String memo, java.lang.Short boneobjtype, java.lang.Short bailtype, java.lang.String payno, java.lang.String payfilepath) {
        this.formid = formid;
        this.wayid = wayid;
        this.bondtype = bondtype;
        this.countyid = countyid;
        this.principal = principal;
        this.principaltel = principaltel;
        this.paymentmode = paymentmode;
        this.payamt = payamt;
        this.state = state;
        this.confirmtime = confirmtime;
        this.receiptno = receiptno;
        this.receiptamt = receiptamt;
        this.filepath = filepath;
        this.receiptmeomo = receiptmeomo;
        this.createtime = createtime;
        this.memo = memo;
        this.boneobjtype = boneobjtype;
        this.bailtype = bailtype;
        this.payno = payno;
        this.payfilepath = payfilepath;
    }

    /** default constructor */
    public BondformVO() {
    }

    /** minimal constructor */
    public BondformVO(java.lang.Long formid) {
        this.formid = formid;
    }

    public java.lang.Long getFormid() {
        return this.formid;
    }

    public void setFormid(java.lang.Long formid) {
        this.formid = formid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getBondtype() {
        return this.bondtype;
    }

    public void setBondtype(java.lang.String bondtype) {
        this.bondtype = bondtype;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(java.lang.String principal) {
        this.principal = principal;
    }

    public java.lang.String getPrincipaltel() {
        return this.principaltel;
    }

    public void setPrincipaltel(java.lang.String principaltel) {
        this.principaltel = principaltel;
    }

    public java.lang.String getPaymentmode() {
        return this.paymentmode;
    }

    public void setPaymentmode(java.lang.String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public java.lang.Double getPayamt() {
        return this.payamt;
    }

    public void setPayamt(java.lang.Double payamt) {
        this.payamt = payamt;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.util.Date getConfirmtime() {
        return this.confirmtime;
    }

    public void setConfirmtime(java.util.Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    public java.lang.String getReceiptno() {
        return this.receiptno;
    }

    public void setReceiptno(java.lang.String receiptno) {
        this.receiptno = receiptno;
    }

    public java.lang.Double getReceiptamt() {
        return this.receiptamt;
    }

    public void setReceiptamt(java.lang.Double receiptamt) {
        this.receiptamt = receiptamt;
    }

    public java.lang.String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(java.lang.String filepath) {
        this.filepath = filepath;
    }

    public java.lang.String getReceiptmeomo() {
        return this.receiptmeomo;
    }

    public void setReceiptmeomo(java.lang.String receiptmeomo) {
        this.receiptmeomo = receiptmeomo;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.Short getBoneobjtype() {
        return this.boneobjtype;
    }

    public void setBoneobjtype(java.lang.Short boneobjtype) {
        this.boneobjtype = boneobjtype;
    }

    public java.lang.Short getBailtype() {
        return this.bailtype;
    }

    public void setBailtype(java.lang.Short bailtype) {
        this.bailtype = bailtype;
    }

    public java.lang.String getPayno() {
        return this.payno;
    }

    public void setPayno(java.lang.String payno) {
        this.payno = payno;
    }

    public java.lang.String getPayfilepath() {
        return this.payfilepath;
    }

    public void setPayfilepath(java.lang.String payfilepath) {
        this.payfilepath = payfilepath;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("formid", getFormid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BondformVO) ) return false;
        BondformVO castOther = (BondformVO) other;
        return new EqualsBuilder()
            .append(this.getFormid(), castOther.getFormid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFormid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return BondformlogVO.class;
	}

}
