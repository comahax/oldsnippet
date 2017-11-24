package com.sunrise.boss.business.cms.recompense.persistent;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.recomprulelg.persistent.RecompRuleLgVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RecompenseVO implements Serializable,OperationLog{

	private static final long serialVersionUID = 2000893037796434372L;

	/** identifier field */
    private Long recid; // ���������

    /** nullable persistent field */
    private Long target; // ���ָ��

    /** nullable persistent field */
    private Double quotiety; // ��Ȩϵ��

    /** nullable persistent field */
    private String balanceterm; // ��������

    /** nullable persistent field */
    private Double standard; // ����׼

    /** nullable persistent field */
    private String comtype; // �����������

    /** nullable persistent field */
    private String bchlevel; // ���������ȼ�

    /** nullable persistent field */
    private Double integral; // ��������

    /** nullable persistent field */
    private String businesstype; // ҵ������

    /** nullable persistent field */
    private Integer prodid; // �ͻ�Ʒ��

    /** nullable persistent field */
    private String prosalecode; // ��������

    /** nullable persistent field */
    private Integer salseprodid; // ���۲�Ʒ

    /** nullable persistent field */
    private Long inyxplanid; // �����ײ�

    /** nullable persistent field */
    private java.sql.Timestamp intime; // �û�����ʱ��

    /** nullable persistent field */
    private Short custstate; // �û�״̬

    /** nullable persistent field */
    private Short chargetype; // �ɷѷ�ʽ

    /** nullable persistent field */
    private Short moment; // ���׶�

    /** nullable persistent field */
    private Short fitstation; // ���ø�λ

    /** nullable persistent field */
    private String fitopr; // ������Ա

    /** persistent field */
    private String bossarea; // �й�˾��ʶ

    /** nullable persistent field */
    private String calculatemode; // ����ģʽ

    /** nullable persistent field */
    private java.sql.Timestamp starttime; // ��ʼʱ��

    /** nullable persistent field */
    private java.sql.Timestamp stoptime; // ֹͣʱ��

    /** nullable persistent field */
    private Short pri; // ���ȼ�

    
    public RecompenseVO(Long target, Double quotiety, String balanceterm, Double standard, String comtype, String bchlevel, Double integral, String businesstype, Integer prodid, String prosalecode, Integer salseprodid, Long inyxplanid, Timestamp intime, Short custstate, Short chargetype, Short moment, Short fitstation, String fitopr, String bossarea, String calculatemode, Timestamp starttime, Timestamp stoptime, Short pri) {
		super();
		// TODO �Զ����ɹ��캯�����
		this.target = target;
		this.quotiety = quotiety;
		this.balanceterm = balanceterm;
		this.standard = standard;
		this.comtype = comtype;
		this.bchlevel = bchlevel;
		this.integral = integral;
		this.businesstype = businesstype;
		this.prodid = prodid;
		this.prosalecode = prosalecode;
		this.salseprodid = salseprodid;
		this.inyxplanid = inyxplanid;
		this.intime = intime;
		this.custstate = custstate;
		this.chargetype = chargetype;
		this.moment = moment;
		this.fitstation = fitstation;
		this.fitopr = fitopr;
		this.bossarea = bossarea;
		this.calculatemode = calculatemode;
		this.starttime = starttime;
		this.stoptime = stoptime;
		this.pri = pri;
	}

	/** default constructor */
    public RecompenseVO() {
    }

    public java.sql.Timestamp getIntime() {
		return intime;
	}

	public void setIntime(java.sql.Timestamp intime) {
		this.intime = intime;
	}

	public java.sql.Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(java.sql.Timestamp starttime) {
		this.starttime = starttime;
	}

	public java.sql.Timestamp getStoptime() {
		return stoptime;
	}

	public void setStoptime(java.sql.Timestamp stoptime) {
		this.stoptime = stoptime;
	}

	/** minimal constructor */
    public RecompenseVO(java.lang.String bossarea) {
        this.bossarea = bossarea;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getTarget() {
        return this.target;
    }

    public void setTarget(java.lang.Long target) {
        this.target = target;
    }

    public java.lang.Double getQuotiety() {
        return this.quotiety;
    }

    public void setQuotiety(java.lang.Double quotiety) {
        this.quotiety = quotiety;
    }

    public java.lang.String getBalanceterm() {
        return this.balanceterm;
    }

    public void setBalanceterm(java.lang.String balanceterm) {
        this.balanceterm = balanceterm;
    }

    public java.lang.Double getStandard() {
        return this.standard;
    }

    public void setStandard(java.lang.Double standard) {
        this.standard = standard;
    }

    public java.lang.String getComtype() {
        return this.comtype;
    }

    public void setComtype(java.lang.String comtype) {
        this.comtype = comtype;
    }

    public java.lang.String getBchlevel() {
        return this.bchlevel;
    }

    public void setBchlevel(java.lang.String bchlevel) {
        this.bchlevel = bchlevel;
    }

    public java.lang.Double getIntegral() {
        return this.integral;
    }

    public void setIntegral(java.lang.Double integral) {
        this.integral = integral;
    }

    public java.lang.String getBusinesstype() {
        return this.businesstype;
    }

    public void setBusinesstype(java.lang.String businesstype) {
        this.businesstype = businesstype;
    }

    public java.lang.Integer getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.Integer prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getProsalecode() {
        return this.prosalecode;
    }

    public void setProsalecode(java.lang.String prosalecode) {
        this.prosalecode = prosalecode;
    }

    public java.lang.Integer getSalseprodid() {
        return this.salseprodid;
    }

    public void setSalseprodid(java.lang.Integer salseprodid) {
        this.salseprodid = salseprodid;
    }

    public java.lang.Long getInyxplanid() {
        return this.inyxplanid;
    }

    public void setInyxplanid(java.lang.Long inyxplanid) {
        this.inyxplanid = inyxplanid;
    }

  
    public java.lang.Short getCuststate() {
        return this.custstate;
    }

    public void setCuststate(java.lang.Short custstate) {
        this.custstate = custstate;
    }

    public java.lang.Short getChargetype() {
        return this.chargetype;
    }

    public void setChargetype(java.lang.Short chargetype) {
        this.chargetype = chargetype;
    }

    public java.lang.Short getMoment() {
        return this.moment;
    }

    public void setMoment(java.lang.Short moment) {
        this.moment = moment;
    }

    public java.lang.Short getFitstation() {
        return this.fitstation;
    }

    public void setFitstation(java.lang.Short fitstation) {
        this.fitstation = fitstation;
    }

    public java.lang.String getFitopr() {
        return this.fitopr;
    }

    public void setFitopr(java.lang.String fitopr) {
        this.fitopr = fitopr;
    }

    public java.lang.String getBossarea() {
        return this.bossarea;
    }

    public void setBossarea(java.lang.String bossarea) {
        this.bossarea = bossarea;
    }

    public java.lang.String getCalculatemode() {
        return this.calculatemode;
    }

    public void setCalculatemode(java.lang.String calculatemode) {
        this.calculatemode = calculatemode;
    }

 

    public java.lang.Short getPri() {
        return this.pri;
    }

    public void setPri(java.lang.Short pri) {
        this.pri = pri;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RecompenseVO) ) return false;
        RecompenseVO castOther = (RecompenseVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

	public Class logVOClass() {
		
		return RecompRuleLgVO.class;
	}

}
