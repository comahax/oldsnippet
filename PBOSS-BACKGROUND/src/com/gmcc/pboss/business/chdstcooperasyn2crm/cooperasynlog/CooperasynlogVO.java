package com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasynlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CooperasynlogVO extends BaseVO implements Serializable {

    /** nullable persistent field */
    private Long logid;

    /** nullable persistent field */
    private Short synstate;

    /** nullable persistent field */
    private String synmemo;

    /** persistent field */
    private Long itemid;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Short opract;

    /** nullable persistent field */
    private String cooperauid;

    /** nullable persistent field */
    private String cooperaname;

    /** nullable persistent field */
    private String cpabbrname;

    /** nullable persistent field */
    private String cocheckname;

    /** nullable persistent field */
    private String servman;

    /** nullable persistent field */
    private String cooperadel;

    /** nullable persistent field */
    private String postaddr;

    /** nullable persistent field */
    private String zipcode;

    /** nullable persistent field */
    private String conntel;

    /** nullable persistent field */
    private String connfaxno;

    /** nullable persistent field */
    private String usremail;

    /** nullable persistent field */
    private Double area;

    /** nullable persistent field */
    private String licenceid;

    /** nullable persistent field */
    private java.util.Date licvalidate;

    /** nullable persistent field */
    private String connpers;

    /** nullable persistent field */
    private String busconntel;

    /** nullable persistent field */
    private String sendaddr;

    /** nullable persistent field */
    private String recpers;

    /** nullable persistent field */
    private String recconntel;

    /** nullable persistent field */
    private String reccertno;

    /** nullable persistent field */
    private String smsmobileno;

    /** nullable persistent field */
    private String bankname;

    /** nullable persistent field */
    private String acctno;

    /** nullable persistent field */
    private String districtid;

    /** nullable persistent field */
    private java.util.Date intime;

    /** nullable persistent field */
    private String custmanager;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private String servpwd;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private String oldcoopera;

    /** nullable persistent field */
    private Double baillwrlmt;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String waysubtype;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Double cashdeposit;

    /** nullable persistent field */
    private Double cdradix;

    /** full constructor */
    public CooperasynlogVO(java.lang.Long logid, java.lang.Short synstate, java.lang.String synmemo, java.lang.Long itemid, java.lang.String oprtype, java.util.Date oprtime, java.lang.Short opract, java.lang.String cooperauid, java.lang.String cooperaname, java.lang.String cpabbrname, java.lang.String cocheckname, java.lang.String servman, java.lang.String cooperadel, java.lang.String postaddr, java.lang.String zipcode, java.lang.String conntel, java.lang.String connfaxno, java.lang.String usremail, java.lang.Double area, java.lang.String licenceid, java.util.Date licvalidate, java.lang.String connpers, java.lang.String busconntel, java.lang.String sendaddr, java.lang.String recpers, java.lang.String recconntel, java.lang.String reccertno, java.lang.String smsmobileno, java.lang.String bankname, java.lang.String acctno, java.lang.String districtid, java.util.Date intime, java.lang.String custmanager, java.util.Date starttime, java.lang.String servpwd, java.lang.Short state, java.lang.String oldcoopera, java.lang.Double baillwrlmt, java.lang.String memo, java.lang.String waysubtype, java.lang.String cityid, java.lang.String countyid, java.lang.String svccode, java.lang.String mareacode, java.lang.Double cashdeposit, java.lang.Double cdradix) {
        this.logid = logid;
        this.synstate = synstate;
        this.synmemo = synmemo;
        this.itemid = itemid;
        this.oprtype = oprtype;
        this.oprtime = oprtime;
        this.opract = opract;
        this.cooperauid = cooperauid;
        this.cooperaname = cooperaname;
        this.cpabbrname = cpabbrname;
        this.cocheckname = cocheckname;
        this.servman = servman;
        this.cooperadel = cooperadel;
        this.postaddr = postaddr;
        this.zipcode = zipcode;
        this.conntel = conntel;
        this.connfaxno = connfaxno;
        this.usremail = usremail;
        this.area = area;
        this.licenceid = licenceid;
        this.licvalidate = licvalidate;
        this.connpers = connpers;
        this.busconntel = busconntel;
        this.sendaddr = sendaddr;
        this.recpers = recpers;
        this.recconntel = recconntel;
        this.reccertno = reccertno;
        this.smsmobileno = smsmobileno;
        this.bankname = bankname;
        this.acctno = acctno;
        this.districtid = districtid;
        this.intime = intime;
        this.custmanager = custmanager;
        this.starttime = starttime;
        this.servpwd = servpwd;
        this.state = state;
        this.oldcoopera = oldcoopera;
        this.baillwrlmt = baillwrlmt;
        this.memo = memo;
        this.waysubtype = waysubtype;
        this.cityid = cityid;
        this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.cashdeposit = cashdeposit;
        this.cdradix = cdradix;
    }

    /** default constructor */
    public CooperasynlogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Short getSynstate() {
        return this.synstate;
    }

    public void setSynstate(java.lang.Short synstate) {
        this.synstate = synstate;
    }

    public java.lang.String getSynmemo() {
        return this.synmemo;
    }

    public void setSynmemo(java.lang.String synmemo) {
        this.synmemo = synmemo;
    }

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Short getOpract() {
        return this.opract;
    }

    public void setOpract(java.lang.Short opract) {
        this.opract = opract;
    }

    public java.lang.String getCooperauid() {
        return this.cooperauid;
    }

    public void setCooperauid(java.lang.String cooperauid) {
        this.cooperauid = cooperauid;
    }

    public java.lang.String getCooperaname() {
        return this.cooperaname;
    }

    public void setCooperaname(java.lang.String cooperaname) {
        this.cooperaname = cooperaname;
    }

    public java.lang.String getCpabbrname() {
        return this.cpabbrname;
    }

    public void setCpabbrname(java.lang.String cpabbrname) {
        this.cpabbrname = cpabbrname;
    }

    public java.lang.String getCocheckname() {
        return this.cocheckname;
    }

    public void setCocheckname(java.lang.String cocheckname) {
        this.cocheckname = cocheckname;
    }

    public java.lang.String getServman() {
        return this.servman;
    }

    public void setServman(java.lang.String servman) {
        this.servman = servman;
    }

    public java.lang.String getCooperadel() {
        return this.cooperadel;
    }

    public void setCooperadel(java.lang.String cooperadel) {
        this.cooperadel = cooperadel;
    }

    public java.lang.String getPostaddr() {
        return this.postaddr;
    }

    public void setPostaddr(java.lang.String postaddr) {
        this.postaddr = postaddr;
    }

    public java.lang.String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(java.lang.String zipcode) {
        this.zipcode = zipcode;
    }

    public java.lang.String getConntel() {
        return this.conntel;
    }

    public void setConntel(java.lang.String conntel) {
        this.conntel = conntel;
    }

    public java.lang.String getConnfaxno() {
        return this.connfaxno;
    }

    public void setConnfaxno(java.lang.String connfaxno) {
        this.connfaxno = connfaxno;
    }

    public java.lang.String getUsremail() {
        return this.usremail;
    }

    public void setUsremail(java.lang.String usremail) {
        this.usremail = usremail;
    }

    public java.lang.Double getArea() {
        return this.area;
    }

    public void setArea(java.lang.Double area) {
        this.area = area;
    }

    public java.lang.String getLicenceid() {
        return this.licenceid;
    }

    public void setLicenceid(java.lang.String licenceid) {
        this.licenceid = licenceid;
    }

    public java.util.Date getLicvalidate() {
        return this.licvalidate;
    }

    public void setLicvalidate(java.util.Date licvalidate) {
        this.licvalidate = licvalidate;
    }

    public java.lang.String getConnpers() {
        return this.connpers;
    }

    public void setConnpers(java.lang.String connpers) {
        this.connpers = connpers;
    }

    public java.lang.String getBusconntel() {
        return this.busconntel;
    }

    public void setBusconntel(java.lang.String busconntel) {
        this.busconntel = busconntel;
    }

    public java.lang.String getSendaddr() {
        return this.sendaddr;
    }

    public void setSendaddr(java.lang.String sendaddr) {
        this.sendaddr = sendaddr;
    }

    public java.lang.String getRecpers() {
        return this.recpers;
    }

    public void setRecpers(java.lang.String recpers) {
        this.recpers = recpers;
    }

    public java.lang.String getRecconntel() {
        return this.recconntel;
    }

    public void setRecconntel(java.lang.String recconntel) {
        this.recconntel = recconntel;
    }

    public java.lang.String getReccertno() {
        return this.reccertno;
    }

    public void setReccertno(java.lang.String reccertno) {
        this.reccertno = reccertno;
    }

    public java.lang.String getSmsmobileno() {
        return this.smsmobileno;
    }

    public void setSmsmobileno(java.lang.String smsmobileno) {
        this.smsmobileno = smsmobileno;
    }

    public java.lang.String getBankname() {
        return this.bankname;
    }

    public void setBankname(java.lang.String bankname) {
        this.bankname = bankname;
    }

    public java.lang.String getAcctno() {
        return this.acctno;
    }

    public void setAcctno(java.lang.String acctno) {
        this.acctno = acctno;
    }

    public java.lang.String getDistrictid() {
        return this.districtid;
    }

    public void setDistrictid(java.lang.String districtid) {
        this.districtid = districtid;
    }

    public java.util.Date getIntime() {
        return this.intime;
    }

    public void setIntime(java.util.Date intime) {
        this.intime = intime;
    }

    public java.lang.String getCustmanager() {
        return this.custmanager;
    }

    public void setCustmanager(java.lang.String custmanager) {
        this.custmanager = custmanager;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.lang.String getServpwd() {
        return this.servpwd;
    }

    public void setServpwd(java.lang.String servpwd) {
        this.servpwd = servpwd;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getOldcoopera() {
        return this.oldcoopera;
    }

    public void setOldcoopera(java.lang.String oldcoopera) {
        this.oldcoopera = oldcoopera;
    }

    public java.lang.Double getBaillwrlmt() {
        return this.baillwrlmt;
    }

    public void setBaillwrlmt(java.lang.Double baillwrlmt) {
        this.baillwrlmt = baillwrlmt;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getWaysubtype() {
        return this.waysubtype;
    }

    public void setWaysubtype(java.lang.String waysubtype) {
        this.waysubtype = waysubtype;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.Double getCashdeposit() {
        return this.cashdeposit;
    }

    public void setCashdeposit(java.lang.Double cashdeposit) {
        this.cashdeposit = cashdeposit;
    }

    public java.lang.Double getCdradix() {
        return this.cdradix;
    }

    public void setCdradix(java.lang.Double cdradix) {
        this.cdradix = cdradix;
    }

	public String toString() {
        return new ToStringBuilder(this)
            .append("cooperauid", getCooperauid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CooperasynlogVO) ) return false;
        CooperasynlogVO castOther = (CooperasynlogVO) other;
        return new EqualsBuilder()
            .append(this.getCooperauid(), castOther.getCooperauid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCooperauid())
            .toHashCode();
    }


}
