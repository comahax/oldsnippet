package com.sunrise.boss.ui.cms.zjty.zjtyemployeedetail;

import com.sunrise.boss.ui.base.BaseActionForm;

public class ZjtyEmployeedetailForm extends BaseActionForm {
	
	private String employeeid;

	private String wayid;

	private String wayname;

	private String employeename;

	private String cityid;

	private String chainhead;

	private String oprcode;

	private java.util.Date start_using_time;

	private String _se_chainhead;

	private String _se_wayid;

	private String _se_oprcode;
	
	private String _se_station;
	
	private String _ne_employeeid;

	private String _sk_employeename;

	private String _sk_oprcode2;

	private String _sk_wayid;

	private String _dnl_intime;

	private String _dnm_intime;

	private String _se_svccode;

	private String _ne_station;

	private String _se_officetel;

	private String _ne_isnet;

	private String _ne_empstatus;

	private String citycompname;

	private String countycompname;

	private String societyFlag;

	private String ditchFlag;

	private String KIND;// 用于区分服务厅人员和渠道经理

	private String way_name;

	private String _sk_servoffice;

	private String cancelFlag;

	/** nullable persistent field */
	private String oprcode2;

	/** nullable persistent field */
	private java.sql.Date birthday;

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
	private java.sql.Date intime;

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
	private java.sql.Date outtime;

	/** nullable persistent field */
	private String outresult;

	/** nullable persistent field */
	private String homeaddr;

	/** nullable persistent field */
	private String cardid;

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

	private java.sql.Date gradtime;

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

	private String empassagin;

	private Short isnet;

	private Short isopen;

	private boolean isunpb;
	
	private String netpass;
	
	private String selectmobile;

	private Short _ne_isopen;

	private String _se_selectmobile;
	
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

	public String getEmpassagin() {
		return empassagin;
	}

	public void setEmpassagin(String empassagin) {
		this.empassagin = empassagin;
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

	public java.sql.Date getGradtime() {
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

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public String get_ne_employeeid() {
		return _ne_employeeid;
	}

	public void set_ne_employeeid(String _ne_employeeid) {
		this._ne_employeeid = _ne_employeeid;
	}

	public String get_sk_employeename() {
		return _sk_employeename;
	}

	public void set_sk_employeename(String _sk_employeename) {
		this._sk_employeename = _sk_employeename;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Short getEdulevel() {
		return edulevel;
	}

	public void setEdulevel(Short edulevel) {
		this.edulevel = edulevel;
	}

	public Short getEmploytype() {
		return employtype;
	}

	public void setEmploytype(Short employtype) {
		this.employtype = employtype;
	}

	public Short getHereworktime() {
		return hereworktime;
	}

	public void setHereworktime(Short hereworktime) {
		this.hereworktime = hereworktime;
	}

	public String getHomeaddr() {
		return homeaddr;
	}

	public void setHomeaddr(String homeaddr) {
		this.homeaddr = homeaddr;
	}

	public java.sql.Date getIntime() {
		return intime;
	}

	public void setIntime(java.sql.Date intime) {
		this.intime = intime;
	}

	public Short getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(Short joblevel) {
		this.joblevel = joblevel;
	}

	public String getNativehome() {
		return nativehome;
	}

	public void setNativehome(String nativehome) {
		this.nativehome = nativehome;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getOprcode2() {
		return oprcode2;
	}

	public void setOprcode2(String oprcode2) {
		this.oprcode2 = oprcode2;
	}

	public String getOutresult() {
		return outresult;
	}

	public void setOutresult(String outresult) {
		this.outresult = outresult;
	}

	public java.sql.Date getOuttime() {
		return outtime;
	}

	public void setOuttime(java.sql.Date outtime) {
		this.outtime = outtime;
	}

	public Short getPolivisage() {
		return polivisage;
	}

	public void setPolivisage(Short polivisage) {
		this.polivisage = polivisage;
	}

	public String getServoffice() {
		return servoffice;
	}

	public void setServoffice(String servoffice) {
		this.servoffice = servoffice;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Long getStation() {
		return station;
	}

	public void setStation(Long station) {
		this.station = station;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Short getWorktime() {
		return worktime;
	}

	public void setWorktime(Short worktime) {
		this.worktime = worktime;
	}

	public String get_sk_oprcode2() {
		return _sk_oprcode2;
	}

	public void set_sk_oprcode2(String _sk_oprcode2) {
		this._sk_oprcode2 = _sk_oprcode2;
	}

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}

	public String get_dnl_intime() {
		return _dnl_intime;
	}

	public void set_dnl_intime(String _dnl_intime) {
		this._dnl_intime = _dnl_intime;
	}

	public String get_dnm_intime() {
		return _dnm_intime;
	}

	public void set_dnm_intime(String _dnm_intime) {
		this._dnm_intime = _dnm_intime;
	}

	public String get_se_svccode() {
		return _se_svccode;
	}

	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}

	public String get_ne_station() {
		return _ne_station;
	}

	public void set_ne_station(String _ne_station) {
		this._ne_station = _ne_station;
	}

	public String getWay_name() {
		return way_name;
	}

	public void setWay_name(String way_name) {
		this.way_name = way_name;
	}

	public String get_sk_servoffice() {
		return _sk_servoffice;
	}

	public void set_sk_servoffice(String _sk_servoffice) {
		this._sk_servoffice = _sk_servoffice;
	}

	public String getCitycompname() {
		return citycompname;
	}

	public void setCitycompname(String citycompname) {
		this.citycompname = citycompname;
	}

	public String getCountycompname() {
		return countycompname;
	}

	public void setCountycompname(String countycompname) {
		this.countycompname = countycompname;
	}

	public String getSocietyFlag() {
		return societyFlag;
	}

	public void setSocietyFlag(String societyFlag) {
		this.societyFlag = societyFlag;
	}

	public String getDitchFlag() {
		return ditchFlag;
	}

	public void setDitchFlag(String ditchFlag) {
		this.ditchFlag = ditchFlag;
	}

	public String getKIND() {
		return KIND;
	}

	public void setKIND(String kind) {
		KIND = kind;
	}

	public String get_ne_empstatus() {
		return _ne_empstatus;
	}

	public void set_ne_empstatus(String _ne_empstatus) {
		this._ne_empstatus = _ne_empstatus;
	}

	public String get_ne_isnet() {
		return _ne_isnet;
	}

	public void set_ne_isnet(String _ne_isnet) {
		this._ne_isnet = _ne_isnet;
	}

	public String get_se_officetel() {
		return _se_officetel;
	}

	public void set_se_officetel(String _se_officetel) {
		this._se_officetel = _se_officetel;
	}

	public Short get_ne_isopen() {
		return _ne_isopen;
	}

	public void set_ne_isopen(Short _ne_isopen) {
		this._ne_isopen = _ne_isopen;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getSelectmobile() {
		return selectmobile;
	}

	public void setSelectmobile(String selectmobile) {
		this.selectmobile = selectmobile;
	}

	public String get_se_selectmobile() {
		return _se_selectmobile;
	}

	public void set_se_selectmobile(String _se_selectmobile) {
		this._se_selectmobile = _se_selectmobile;
	}
	

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String getChainhead() {
		return chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	

	public java.util.Date getStart_using_time() {
		return start_using_time;
	}

	public void setStart_using_time(java.util.Date start_using_time) {
		this.start_using_time = start_using_time;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String get_se_station() {
		return _se_station;
	}

	public void set_se_station(String _se_station) {
		this._se_station = _se_station;
	}

	public boolean isIsunpb() {
		return isunpb;
	}

	public void setIsunpb(boolean isunpb) {
		this.isunpb = isunpb;
	}
}
