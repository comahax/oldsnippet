package com.sunrise.boss.business.cms.empconfirm.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EmpconfirmVO implements Serializable {

    /** identifier field */
    private Long confirmid;

    /** persistent field */
    private String employeeid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String employeename;

    /** nullable persistent field */
    private java.util.Date birthday;

    /** nullable persistent field */
    private Short sex;

    /** nullable persistent field */
    private Short edulevel;

    /** nullable persistent field */
    private String nativehome;

    /** nullable persistent field */
    private Short polivisage;

    /** nullable persistent field */
    private String department;

    /** nullable persistent field */
    private String servoffice;

    /** nullable persistent field */
    private Long station;

    /** nullable persistent field */
    private Short joblevel;

    /** nullable persistent field */
    private java.util.Date intime;

    /** nullable persistent field */
    private Short worktime;

    /** nullable persistent field */
    private Short hereworktime;

    /** nullable persistent field */
    private Short employtype;

    /** nullable persistent field */
    private String company;

    /** nullable persistent field */
    private String telephone;

    /** nullable persistent field */
    private String officetel;

    /** nullable persistent field */
    private java.util.Date outtime;

    /** nullable persistent field */
    private String outresult;

    /** nullable persistent field */
    private String homeaddr;

    /** nullable persistent field */
    private String cardid;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String waytype;

    /** nullable persistent field */
    private String pvtemail;

    /** nullable persistent field */
    private String ofcphone;

    /** nullable persistent field */
    private String ofcemail;

    /** nullable persistent field */
    private String speciality;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String posittype;

    /** nullable persistent field */
    private Short contacttype;

    /** nullable persistent field */
    private Short empstatus;

    /** nullable persistent field */
    private String actbank;

    /** nullable persistent field */
    private String actno;

    /** nullable persistent field */
    private String actname;

    /** nullable persistent field */
    private String actpid;

    /** nullable persistent field */
    private Double bail;

    /** nullable persistent field */
    private String gradschool;

    /** nullable persistent field */
    private java.util.Date gradtime;

    /** nullable persistent field */
    private Short ismarried;

    /** nullable persistent field */
    private Short outreason;

    /** nullable persistent field */
    private String trainlevel;

    /** nullable persistent field */
    private String hobby;

    /** nullable persistent field */
    private String character;

    /** nullable persistent field */
    private String asses;

    /** nullable persistent field */
    private String workhistry;

    /** nullable persistent field */
    private String prizeorpunish;

    /** nullable persistent field */
    private String empass;

    /** nullable persistent field */
    private Short right;

    /** nullable persistent field */
    private Short isnet;

    /** nullable persistent field */
    private String netpass;

    /** nullable persistent field */
    private Short isopen;

    /** nullable persistent field */
    private String selectmobile;

    /** nullable persistent field */
    private String subname;

    /** nullable persistent field */
    private java.util.Date regdate;

    /** nullable persistent field */
    private String empattr;

    /** nullable persistent field */
    private String empattrmemo;

    /** nullable persistent field */
    private Short smsstatus;

    /** nullable persistent field */
    private java.util.Date smscreattime;

    /** nullable persistent field */
    private java.util.Date smsconfirmtime;
    
    private boolean isunpb;

    private String _ne_smsstatus;
    
	private Short istenseed;
	
	private Short isinternal;
	
    
    public boolean isIsunpb() {
		return isunpb;
	}

	public void setIsunpb(boolean isunpb) {
		this.isunpb = isunpb;
	}
	private Short state;
	
	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	/** full constructor */
    public EmpconfirmVO(java.lang.Long confirmid, java.lang.String employeeid, java.lang.String oprcode, java.lang.String employeename, java.util.Date birthday, java.lang.Short sex, java.lang.Short edulevel, java.lang.String nativehome, java.lang.Short polivisage, java.lang.String department, java.lang.String servoffice, java.lang.Long station, java.lang.Short joblevel, java.util.Date intime, java.lang.Short worktime, java.lang.Short hereworktime, java.lang.Short employtype, java.lang.String company, java.lang.String telephone, java.lang.String officetel, java.util.Date outtime, java.lang.String outresult, java.lang.String homeaddr, java.lang.String cardid, java.lang.String wayid, java.lang.String waytype, java.lang.String pvtemail, java.lang.String ofcphone, java.lang.String ofcemail, java.lang.String speciality, java.lang.String cityid, java.lang.String countyid, java.lang.String svccode, java.lang.String posittype, java.lang.Short contacttype, java.lang.Short empstatus, java.lang.String actbank, java.lang.String actno, java.lang.String actname, java.lang.String actpid, java.lang.Double bail, java.lang.String gradschool, java.util.Date gradtime, java.lang.Short ismarried, java.lang.Short outreason, java.lang.String trainlevel, java.lang.String hobby, java.lang.String character, java.lang.String asses, java.lang.String workhistry, java.lang.String prizeorpunish, java.lang.String empass, java.lang.Short right, java.lang.Short isnet, java.lang.String netpass, java.lang.Short isopen, java.lang.String selectmobile, java.lang.String subname, java.util.Date regdate, java.lang.String empattr, java.lang.String empattrmemo, java.lang.Short smsstatus, java.util.Date smscreattime, java.util.Date smsconfirmtime) {
        this.confirmid = confirmid;
        this.employeeid = employeeid;
        this.oprcode = oprcode;
        this.employeename = employeename;
        this.birthday = birthday;
        this.sex = sex;
        this.edulevel = edulevel;
        this.nativehome = nativehome;
        this.polivisage = polivisage;
        this.department = department;
        this.servoffice = servoffice;
        this.station = station;
        this.joblevel = joblevel;
        this.intime = intime;
        this.worktime = worktime;
        this.hereworktime = hereworktime;
        this.employtype = employtype;
        this.company = company;
        this.telephone = telephone;
        this.officetel = officetel;
        this.outtime = outtime;
        this.outresult = outresult;
        this.homeaddr = homeaddr;
        this.cardid = cardid;
        this.wayid = wayid;
        this.waytype = waytype;
        this.pvtemail = pvtemail;
        this.ofcphone = ofcphone;
        this.ofcemail = ofcemail;
        this.speciality = speciality;
        this.cityid = cityid;
        this.countyid = countyid;
        this.svccode = svccode;
        this.posittype = posittype;
        this.contacttype = contacttype;
        this.empstatus = empstatus;
        this.actbank = actbank;
        this.actno = actno;
        this.actname = actname;
        this.actpid = actpid;
        this.bail = bail;
        this.gradschool = gradschool;
        this.gradtime = gradtime;
        this.ismarried = ismarried;
        this.outreason = outreason;
        this.trainlevel = trainlevel;
        this.hobby = hobby;
        this.character = character;
        this.asses = asses;
        this.workhistry = workhistry;
        this.prizeorpunish = prizeorpunish;
        this.empass = empass;
        this.right = right;
        this.isnet = isnet;
        this.netpass = netpass;
        this.isopen = isopen;
        this.selectmobile = selectmobile;
        this.subname = subname;
        this.regdate = regdate;
        this.empattr = empattr;
        this.empattrmemo = empattrmemo;
        this.smsstatus = smsstatus;
        this.smscreattime = smscreattime;
        this.smsconfirmtime = smsconfirmtime;
    }

    /** default constructor */
    public EmpconfirmVO() {
    }

    /** minimal constructor */
    public EmpconfirmVO(java.lang.Long confirmid, java.lang.String employeeid, java.lang.String wayid) {
        this.confirmid = confirmid;
        this.employeeid = employeeid;
        this.wayid = wayid;
    }

    public java.lang.Long getConfirmid() {
        return this.confirmid;
    }

    public void setConfirmid(java.lang.Long confirmid) {
        this.confirmid = confirmid;
    }

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getEmployeename() {
        return this.employeename;
    }

    public void setEmployeename(java.lang.String employeename) {
        this.employeename = employeename;
    }

    public java.util.Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    public java.lang.Short getSex() {
        return this.sex;
    }

    public void setSex(java.lang.Short sex) {
        this.sex = sex;
    }

    public java.lang.Short getEdulevel() {
        return this.edulevel;
    }

    public void setEdulevel(java.lang.Short edulevel) {
        this.edulevel = edulevel;
    }

    public java.lang.String getNativehome() {
        return this.nativehome;
    }

    public void setNativehome(java.lang.String nativehome) {
        this.nativehome = nativehome;
    }

    public java.lang.Short getPolivisage() {
        return this.polivisage;
    }

    public void setPolivisage(java.lang.Short polivisage) {
        this.polivisage = polivisage;
    }

    public java.lang.String getDepartment() {
        return this.department;
    }

    public void setDepartment(java.lang.String department) {
        this.department = department;
    }

    public java.lang.String getServoffice() {
        return this.servoffice;
    }

    public void setServoffice(java.lang.String servoffice) {
        this.servoffice = servoffice;
    }

    public java.lang.Long getStation() {
        return this.station;
    }

    public void setStation(java.lang.Long station) {
        this.station = station;
    }

    public java.lang.Short getJoblevel() {
        return this.joblevel;
    }

    public void setJoblevel(java.lang.Short joblevel) {
        this.joblevel = joblevel;
    }

    public java.util.Date getIntime() {
        return this.intime;
    }

    public void setIntime(java.util.Date intime) {
        this.intime = intime;
    }

    public java.lang.Short getWorktime() {
        return this.worktime;
    }

    public void setWorktime(java.lang.Short worktime) {
        this.worktime = worktime;
    }

    public java.lang.Short getHereworktime() {
        return this.hereworktime;
    }

    public void setHereworktime(java.lang.Short hereworktime) {
        this.hereworktime = hereworktime;
    }

    public java.lang.Short getEmploytype() {
        return this.employtype;
    }

    public void setEmploytype(java.lang.Short employtype) {
        this.employtype = employtype;
    }

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }

    public java.lang.String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(java.lang.String telephone) {
        this.telephone = telephone;
    }

    public java.lang.String getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.String officetel) {
        this.officetel = officetel;
    }

    public java.util.Date getOuttime() {
        return this.outtime;
    }

    public void setOuttime(java.util.Date outtime) {
        this.outtime = outtime;
    }

    public java.lang.String getOutresult() {
        return this.outresult;
    }

    public void setOutresult(java.lang.String outresult) {
        this.outresult = outresult;
    }

    public java.lang.String getHomeaddr() {
        return this.homeaddr;
    }

    public void setHomeaddr(java.lang.String homeaddr) {
        this.homeaddr = homeaddr;
    }

    public java.lang.String getCardid() {
        return this.cardid;
    }

    public void setCardid(java.lang.String cardid) {
        this.cardid = cardid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWaytype() {
        return this.waytype;
    }

    public void setWaytype(java.lang.String waytype) {
        this.waytype = waytype;
    }

    public java.lang.String getPvtemail() {
        return this.pvtemail;
    }

    public void setPvtemail(java.lang.String pvtemail) {
        this.pvtemail = pvtemail;
    }

    public java.lang.String getOfcphone() {
        return this.ofcphone;
    }

    public void setOfcphone(java.lang.String ofcphone) {
        this.ofcphone = ofcphone;
    }

    public java.lang.String getOfcemail() {
        return this.ofcemail;
    }

    public void setOfcemail(java.lang.String ofcemail) {
        this.ofcemail = ofcemail;
    }

    public java.lang.String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(java.lang.String speciality) {
        this.speciality = speciality;
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

    public java.lang.String getPosittype() {
        return this.posittype;
    }

    public void setPosittype(java.lang.String posittype) {
        this.posittype = posittype;
    }

    public java.lang.Short getContacttype() {
        return this.contacttype;
    }

    public void setContacttype(java.lang.Short contacttype) {
        this.contacttype = contacttype;
    }

    public java.lang.Short getEmpstatus() {
        return this.empstatus;
    }

    public void setEmpstatus(java.lang.Short empstatus) {
        this.empstatus = empstatus;
    }

    public java.lang.String getActbank() {
        return this.actbank;
    }

    public void setActbank(java.lang.String actbank) {
        this.actbank = actbank;
    }

    public java.lang.String getActno() {
        return this.actno;
    }

    public void setActno(java.lang.String actno) {
        this.actno = actno;
    }

    public java.lang.String getActname() {
        return this.actname;
    }

    public void setActname(java.lang.String actname) {
        this.actname = actname;
    }

    public java.lang.String getActpid() {
        return this.actpid;
    }

    public void setActpid(java.lang.String actpid) {
        this.actpid = actpid;
    }

    public java.lang.Double getBail() {
        return this.bail;
    }

    public void setBail(java.lang.Double bail) {
        this.bail = bail;
    }

    public java.lang.String getGradschool() {
        return this.gradschool;
    }

    public void setGradschool(java.lang.String gradschool) {
        this.gradschool = gradschool;
    }

    public java.util.Date getGradtime() {
        return this.gradtime;
    }

    public void setGradtime(java.util.Date gradtime) {
        this.gradtime = gradtime;
    }

    public java.lang.Short getIsmarried() {
        return this.ismarried;
    }

    public void setIsmarried(java.lang.Short ismarried) {
        this.ismarried = ismarried;
    }

    public java.lang.Short getOutreason() {
        return this.outreason;
    }

    public void setOutreason(java.lang.Short outreason) {
        this.outreason = outreason;
    }

    public java.lang.String getTrainlevel() {
        return this.trainlevel;
    }

    public void setTrainlevel(java.lang.String trainlevel) {
        this.trainlevel = trainlevel;
    }

    public java.lang.String getHobby() {
        return this.hobby;
    }

    public void setHobby(java.lang.String hobby) {
        this.hobby = hobby;
    }

    public java.lang.String getCharacter() {
        return this.character;
    }

    public void setCharacter(java.lang.String character) {
        this.character = character;
    }

    public java.lang.String getAsses() {
        return this.asses;
    }

    public void setAsses(java.lang.String asses) {
        this.asses = asses;
    }

    public java.lang.String getWorkhistry() {
        return this.workhistry;
    }

    public void setWorkhistry(java.lang.String workhistry) {
        this.workhistry = workhistry;
    }

    public java.lang.String getPrizeorpunish() {
        return this.prizeorpunish;
    }

    public void setPrizeorpunish(java.lang.String prizeorpunish) {
        this.prizeorpunish = prizeorpunish;
    }

    public java.lang.String getEmpass() {
        return this.empass;
    }

    public void setEmpass(java.lang.String empass) {
        this.empass = empass;
    }

    public java.lang.Short getRight() {
        return this.right;
    }

    public void setRight(java.lang.Short right) {
        this.right = right;
    }

    public java.lang.Short getIsnet() {
        return this.isnet;
    }

    public void setIsnet(java.lang.Short isnet) {
        this.isnet = isnet;
    }

    public java.lang.String getNetpass() {
        return this.netpass;
    }

    public void setNetpass(java.lang.String netpass) {
        this.netpass = netpass;
    }

    public java.lang.Short getIsopen() {
        return this.isopen;
    }

    public void setIsopen(java.lang.Short isopen) {
        this.isopen = isopen;
    }

    public java.lang.String getSelectmobile() {
        return this.selectmobile;
    }

    public void setSelectmobile(java.lang.String selectmobile) {
        this.selectmobile = selectmobile;
    }

    public java.lang.String getSubname() {
        return this.subname;
    }

    public void setSubname(java.lang.String subname) {
        this.subname = subname;
    }

    public java.util.Date getRegdate() {
        return this.regdate;
    }

    public void setRegdate(java.util.Date regdate) {
        this.regdate = regdate;
    }

    public java.lang.String getEmpattr() {
        return this.empattr;
    }

    public void setEmpattr(java.lang.String empattr) {
        this.empattr = empattr;
    }

    public java.lang.String getEmpattrmemo() {
        return this.empattrmemo;
    }

    public void setEmpattrmemo(java.lang.String empattrmemo) {
        this.empattrmemo = empattrmemo;
    }

    public java.lang.Short getSmsstatus() {
        return this.smsstatus;
    }

    public void setSmsstatus(java.lang.Short smsstatus) {
        this.smsstatus = smsstatus;
    }

    public java.util.Date getSmscreattime() {
        return this.smscreattime;
    }

    public void setSmscreattime(java.util.Date smscreattime) {
        this.smscreattime = smscreattime;
    }

    public java.util.Date getSmsconfirmtime() {
        return this.smsconfirmtime;
    }

    public void setSmsconfirmtime(java.util.Date smsconfirmtime) {
        this.smsconfirmtime = smsconfirmtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("confirmid", getConfirmid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmpconfirmVO) ) return false;
        EmpconfirmVO castOther = (EmpconfirmVO) other;
        return new EqualsBuilder()
            .append(this.getConfirmid(), castOther.getConfirmid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getConfirmid())
            .toHashCode();
    }

	public String get_ne_smsstatus() {
		return _ne_smsstatus;
	}

	public void set_ne_smsstatus(String _ne_smsstatus) {
		this._ne_smsstatus = _ne_smsstatus;
	}

	public Short getIstenseed() {
		return istenseed;
	}

	public void setIstenseed(Short istenseed) {
		this.istenseed = istenseed;
	}

	public Short getIsinternal() {
		return isinternal;
	}

	public void setIsinternal(Short isinternal) {
		this.isinternal = isinternal;
	}

}
