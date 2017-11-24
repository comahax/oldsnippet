package com.sunrise.boss.business.cms.employeelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EmployeelogVO implements Serializable {

	/** identifier field */
	private Long logid;

	/** persistent field */
	private java.util.Date optime;

	/** persistent field */
	private String oprcode;

	/** persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

	/** persistent field */
	private String employeeid;

	/** nullable persistent field */
	private String oprcode2;

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
	private Short station;

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

	private String selectmobile;
	
	private String subname;
	
	private java.sql.Date regdate;
	
	private Short istenseed;
	
	private Short isinternal;
	
	public String getSelectmobile() {
		return selectmobile;
	}

	public void setSelectmobile(String selectmobile) {
		this.selectmobile = selectmobile;
	}

	public String getActbank() {
		return actbank;
	}

	public void setActbank(String actbank) {
		this.actbank = actbank;
	}

	public String getActname() {
		return actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public String getActno() {
		return actno;
	}

	public void setActno(String actno) {
		this.actno = actno;
	}

	public String getActpid() {
		return actpid;
	}

	public void setActpid(String actpid) {
		this.actpid = actpid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Short getContacttype() {
		return contacttype;
	}

	public void setContacttype(Short contacttype) {
		this.contacttype = contacttype;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public Short getEmpstatus() {
		return empstatus;
	}

	public void setEmpstatus(Short empstatus) {
		this.empstatus = empstatus;
	}

	public String getOfcemail() {
		return ofcemail;
	}

	public void setOfcemail(String ofcemail) {
		this.ofcemail = ofcemail;
	}

	public String getOfcphone() {
		return ofcphone;
	}

	public void setOfcphone(String ofcphone) {
		this.ofcphone = ofcphone;
	}

	public String getPosittype() {
		return posittype;
	}

	public void setPosittype(String posittype) {
		this.posittype = posittype;
	}

	public String getPvtemail() {
		return pvtemail;
	}

	public void setPvtemail(String pvtemail) {
		this.pvtemail = pvtemail;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getWaytype() {
		return waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	private Double bail;

	private String gradschool;

	private java.sql.Date gradtime;

	private Short ismarried;

	private Short outreason;

	private String trainlevel;

	private String hobby;

	private String character;

	private String asses;

	private String workhistry;

	private String prizeorpunish;

	private Short right;

	private String empass;

	private Short isnet;

	private Short isopen;

	private String netpass;
	
	private String empattr;
	
	private String empattrmemo;
	
	private Short empattr2;

	/** full constructor */
	public EmployeelogVO(java.util.Date optime, java.lang.String oprcode,
			java.lang.String oprtype, java.lang.String success,
			java.lang.String employeeid, java.lang.String oprcode2,
			java.lang.String employeename, java.util.Date birthday,
			java.lang.Short sex, java.lang.Short edulevel,
			java.lang.String nativehome, java.lang.Short polivisage,
			java.lang.String department, java.lang.String servoffice,
			java.lang.Short station, java.lang.Short joblevel,
			java.util.Date intime, java.lang.Short worktime,
			java.lang.Short hereworktime, java.lang.Short employtype,
			java.lang.String company, java.lang.String telephone,
			java.lang.String officetel, java.util.Date outtime,
			java.lang.String outresult, java.lang.String homeaddr,
			java.lang.String cardid, java.lang.String wayid, Double bail,
			String gradschool, java.sql.Date gradtime, Short ismarried,
			Short outreason, String trainlevel, String hobby, String character,
			String asses, String workhistry, String prizeorpunish,
			String empass, Short right, Short isnet, Short isopen,
			String netpass) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.employeeid = employeeid;
		this.oprcode2 = oprcode2;
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
		this.isopen = isopen;
		this.netpass = netpass;
	}

	/** default constructor */
	public EmployeelogVO() {
	}

	/** minimal constructor */
	public EmployeelogVO(java.util.Date optime, java.lang.String oprcode,
			java.lang.String oprtype, java.lang.String employeeid,
			java.lang.String wayid) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.employeeid = employeeid;
		this.wayid = wayid;
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

	public java.lang.String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(java.lang.String employeeid) {
		this.employeeid = employeeid;
	}

	public java.lang.String getOprcode2() {
		return this.oprcode2;
	}

	public void setOprcode2(java.lang.String oprcode2) {
		this.oprcode2 = oprcode2;
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

	public java.lang.Short getStation() {
		return this.station;
	}

	public void setStation(java.lang.Short station) {
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

	public Double getBail() {
		return bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	public String getGradschool() {
		return gradschool;
	}

	public void setGradschool(String gradschool) {
		this.gradschool = gradschool;
	}

	public java.util.Date getGradtime() {
		return gradtime;
	}

	public void setGradtime(java.sql.Date gradtime) {
		this.gradtime = gradtime;
	}

	public Short getIsmarried() {
		return ismarried;
	}

	public void setIsmarried(Short ismarried) {
		this.ismarried = ismarried;
	}

	public Short getOutreason() {
		return outreason;
	}

	public void setOutreason(Short outreason) {
		this.outreason = outreason;
	}

	public String getTrainlevel() {
		return trainlevel;
	}

	public void setTrainlevel(String trainlevel) {
		this.trainlevel = trainlevel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getAsses() {
		return asses;
	}

	public void setAsses(String asses) {
		this.asses = asses;
	}

	public String getWorkhistry() {
		return workhistry;
	}

	public void setWorkhistry(String workhistry) {
		this.workhistry = workhistry;
	}

	public String getPrizeorpunish() {
		return prizeorpunish;
	}

	public void setPrizeorpunish(String prizeorpunish) {
		this.prizeorpunish = prizeorpunish;
	}

	public String getEmpass() {
		return empass;
	}

	public void setEmpass(String empass) {
		this.empass = empass;
	}

	public Short getRight() {
		return right;
	}

	public void setRight(Short right) {
		this.right = right;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof EmployeelogVO))
			return false;
		EmployeelogVO castOther = (EmployeelogVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}

	public Short getIsnet() {
		return isnet;
	}

	public void setIsnet(Short isnet) {
		this.isnet = isnet;
	}

	public Short getIsopen() {
		return isopen;
	}

	public void setIsopen(Short isopen) {
		this.isopen = isopen;
	}

	public String getNetpass() {
		return netpass;
	}

	public void setNetpass(String netpass) {
		this.netpass = netpass;
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

	public String getEmpattr() {
		return empattr;
	}

	public void setEmpattr(String empattr) {
		this.empattr = empattr;
	}

	public String getEmpattrmemo() {
		return empattrmemo;
	}

	public void setEmpattrmemo(String empattrmemo) {
		this.empattrmemo = empattrmemo;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public java.sql.Date getRegdate() {
		return regdate;
	}

	public void setRegdate(java.sql.Date regdate) {
		this.regdate = regdate;
	}

	public Short getEmpattr2() {
		return empattr2;
	}

	public void setEmpattr2(Short empattr2) {
		this.empattr2 = empattr2;
	}
}
