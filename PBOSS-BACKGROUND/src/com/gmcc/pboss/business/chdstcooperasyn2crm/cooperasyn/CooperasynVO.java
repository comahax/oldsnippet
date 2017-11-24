package com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasyn;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CooperasynVO extends BaseVO implements Serializable {

	
	
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
    
    
    


	public CooperasynVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public CooperasynVO(Long itemid, String oprtype, Date oprtime,
			Short opract, String cooperauid, String cooperaname,
			String cpabbrname, String cocheckname, String servman,
			String cooperadel, String postaddr, String zipcode, String conntel,
			String connfaxno, String usremail, Double area, String licenceid,
			Date licvalidate, String connpers, String busconntel,
			String sendaddr, String recpers, String recconntel,
			String reccertno, String smsmobileno, String bankname,
			String acctno, String districtid, Date intime, String custmanager,
			Date starttime, String servpwd, Short state, String oldcoopera,
			Double baillwrlmt, String memo, String waysubtype, String cityid,
			String countyid, String svccode, String mareacode,
			Double cashdeposit, Double cdradix) {
		super();
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


	
	
	


	public Long getItemid() {
		return itemid;
	}




	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}




	public String getOprtype() {
		return oprtype;
	}




	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}




	public java.util.Date getOprtime() {
		return oprtime;
	}




	public void setOprtime(java.util.Date oprtime) {
		this.oprtime = oprtime;
	}




	public Short getOpract() {
		return opract;
	}




	public void setOpract(Short opract) {
		this.opract = opract;
	}




	public String getCooperauid() {
		return cooperauid;
	}




	public void setCooperauid(String cooperauid) {
		this.cooperauid = cooperauid;
	}




	public String getCooperaname() {
		return cooperaname;
	}




	public void setCooperaname(String cooperaname) {
		this.cooperaname = cooperaname;
	}




	public String getCpabbrname() {
		return cpabbrname;
	}




	public void setCpabbrname(String cpabbrname) {
		this.cpabbrname = cpabbrname;
	}




	public String getCocheckname() {
		return cocheckname;
	}




	public void setCocheckname(String cocheckname) {
		this.cocheckname = cocheckname;
	}




	public String getServman() {
		return servman;
	}




	public void setServman(String servman) {
		this.servman = servman;
	}




	public String getCooperadel() {
		return cooperadel;
	}




	public void setCooperadel(String cooperadel) {
		this.cooperadel = cooperadel;
	}




	public String getPostaddr() {
		return postaddr;
	}




	public void setPostaddr(String postaddr) {
		this.postaddr = postaddr;
	}




	public String getZipcode() {
		return zipcode;
	}




	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}




	public String getConntel() {
		return conntel;
	}




	public void setConntel(String conntel) {
		this.conntel = conntel;
	}




	public String getConnfaxno() {
		return connfaxno;
	}




	public void setConnfaxno(String connfaxno) {
		this.connfaxno = connfaxno;
	}




	public String getUsremail() {
		return usremail;
	}




	public void setUsremail(String usremail) {
		this.usremail = usremail;
	}




	public Double getArea() {
		return area;
	}




	public void setArea(Double area) {
		this.area = area;
	}




	public String getLicenceid() {
		return licenceid;
	}




	public void setLicenceid(String licenceid) {
		this.licenceid = licenceid;
	}




	public java.util.Date getLicvalidate() {
		return licvalidate;
	}




	public void setLicvalidate(java.util.Date licvalidate) {
		this.licvalidate = licvalidate;
	}




	public String getConnpers() {
		return connpers;
	}




	public void setConnpers(String connpers) {
		this.connpers = connpers;
	}




	public String getBusconntel() {
		return busconntel;
	}




	public void setBusconntel(String busconntel) {
		this.busconntel = busconntel;
	}




	public String getSendaddr() {
		return sendaddr;
	}




	public void setSendaddr(String sendaddr) {
		this.sendaddr = sendaddr;
	}




	public String getRecpers() {
		return recpers;
	}




	public void setRecpers(String recpers) {
		this.recpers = recpers;
	}




	public String getRecconntel() {
		return recconntel;
	}




	public void setRecconntel(String recconntel) {
		this.recconntel = recconntel;
	}




	public String getReccertno() {
		return reccertno;
	}




	public void setReccertno(String reccertno) {
		this.reccertno = reccertno;
	}




	public String getSmsmobileno() {
		return smsmobileno;
	}




	public void setSmsmobileno(String smsmobileno) {
		this.smsmobileno = smsmobileno;
	}




	public String getBankname() {
		return bankname;
	}




	public void setBankname(String bankname) {
		this.bankname = bankname;
	}




	public String getAcctno() {
		return acctno;
	}




	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}




	public String getDistrictid() {
		return districtid;
	}




	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}




	public java.util.Date getIntime() {
		return intime;
	}




	public void setIntime(java.util.Date intime) {
		this.intime = intime;
	}




	public String getCustmanager() {
		return custmanager;
	}




	public void setCustmanager(String custmanager) {
		this.custmanager = custmanager;
	}




	public java.util.Date getStarttime() {
		return starttime;
	}




	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}




	public String getServpwd() {
		return servpwd;
	}




	public void setServpwd(String servpwd) {
		this.servpwd = servpwd;
	}




	public Short getState() {
		return state;
	}




	public void setState(Short state) {
		this.state = state;
	}




	public String getOldcoopera() {
		return oldcoopera;
	}




	public void setOldcoopera(String oldcoopera) {
		this.oldcoopera = oldcoopera;
	}




	public Double getBaillwrlmt() {
		return baillwrlmt;
	}




	public void setBaillwrlmt(Double baillwrlmt) {
		this.baillwrlmt = baillwrlmt;
	}




	public String getMemo() {
		return memo;
	}




	public void setMemo(String memo) {
		this.memo = memo;
	}




	public String getWaysubtype() {
		return waysubtype;
	}




	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}




	public String getCityid() {
		return cityid;
	}




	public void setCityid(String cityid) {
		this.cityid = cityid;
	}




	public String getCountyid() {
		return countyid;
	}




	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}




	public String getSvccode() {
		return svccode;
	}




	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}




	public String getMareacode() {
		return mareacode;
	}




	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}




	public Double getCashdeposit() {
		return cashdeposit;
	}




	public void setCashdeposit(Double cashdeposit) {
		this.cashdeposit = cashdeposit;
	}




	public Double getCdradix() {
		return cdradix;
	}




	public void setCdradix(Double cdradix) {
		this.cdradix = cdradix;
	}




	public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CooperasynVO) ) return false;
        CooperasynVO castOther = (CooperasynVO) other;
        return new EqualsBuilder()
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getItemid())
            .toHashCode();
    }

}
