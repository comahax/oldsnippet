/**
 * auto-generated code
 * Tue Oct 24 17:27:56 CST 2006
 */
package com.sunrise.boss.ui.cms.employeelog;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: EmployeelogForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author He Kun
 * @version 1.0
 */
public class EmployeelogForm extends BaseActionForm {
	private String _dnl_optime;

	private String _dnm_optime;

	private String _sk_oprcode;

	private String _se_oprtype;

	private String _se_success;

	private Long logid;

	private java.util.Date optime;

	private String oprcode;

	private String oprtype;

	private String success;

	private String employeeid;

	private String oprcode2;

	private String employeename;

	private java.util.Date birthday;

	private Short sex;

	private Short edulevel;

	private String nativehome;

	private Short polivisage;

	private String department;

	private String servoffice;

	private Short station;

	private Short joblevel;

	private java.util.Date intime;

	private Short worktime;

	private Short hereworktime;

	private Short employtype;

	private String company;

	private String telephone;

	private String officetel;

	private java.util.Date outtime;

	private String outresult;

	private String homeaddr;

	private String cardid;

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

	private Double bail;

	private String gradschool;

	private java.util.Date gradtime;

	private Short ismarried;

	private Short outreason;

	private String trainlevel;

	private String hobby;

	private String character;

	private String asses;

	private String workhistry;

	private String prizeorpunish;

	private Short auditstatus;

	private Short right;

	private String empass;

	private Short isnet;

	private Short isopen;

	private String netpass;

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

	public void setGradtime(java.util.Date gradtime) {
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

	public Short getAuditstatus() {
		return auditstatus;
	}

	public void setAuditstatus(Short auditstatus) {
		this.auditstatus = auditstatus;
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

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		this._dnm_optime = _dnm_optime;
	}

	public String get_sk_oprcode() {
		return _sk_oprcode;
	}

	public void set_sk_oprcode(String _sk_oprcode) {
		this._sk_oprcode = _sk_oprcode;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_success() {
		return _se_success;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getOprcode2() {
		return oprcode2;
	}

	public void setOprcode2(String oprcode2) {
		this.oprcode2 = oprcode2;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Short getEdulevel() {
		return edulevel;
	}

	public void setEdulevel(Short edulevel) {
		this.edulevel = edulevel;
	}

	public String getNativehome() {
		return nativehome;
	}

	public void setNativehome(String nativehome) {
		this.nativehome = nativehome;
	}

	public Short getPolivisage() {
		return polivisage;
	}

	public void setPolivisage(Short polivisage) {
		this.polivisage = polivisage;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getServoffice() {
		return servoffice;
	}

	public void setServoffice(String servoffice) {
		this.servoffice = servoffice;
	}

	public Short getStation() {
		return station;
	}

	public void setStation(Short station) {
		this.station = station;
	}

	public Short getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(Short joblevel) {
		this.joblevel = joblevel;
	}

	public java.util.Date getIntime() {
		return intime;
	}

	public void setIntime(java.util.Date intime) {
		this.intime = intime;
	}

	public Short getWorktime() {
		return worktime;
	}

	public void setWorktime(Short worktime) {
		this.worktime = worktime;
	}

	public Short getHereworktime() {
		return hereworktime;
	}

	public void setHereworktime(Short hereworktime) {
		this.hereworktime = hereworktime;
	}

	public Short getEmploytype() {
		return employtype;
	}

	public void setEmploytype(Short employtype) {
		this.employtype = employtype;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public java.util.Date getOuttime() {
		return outtime;
	}

	public void setOuttime(java.util.Date outtime) {
		this.outtime = outtime;
	}

	public String getOutresult() {
		return outresult;
	}

	public void setOutresult(String outresult) {
		this.outresult = outresult;
	}

	public String getHomeaddr() {
		return homeaddr;
	}

	public void setHomeaddr(String homeaddr) {
		this.homeaddr = homeaddr;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

}
