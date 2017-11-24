package com.gmcc.pboss.model.employee;

import java.util.Date;

import com.gmcc.pboss.common.bean.AutoLogBean;

/**
 * ChPwEmployeeapply entity. @author MyEclipse Persistence Tools
 */

public class ChPwEmployeeapply implements AutoLogBean {

	// Fields

	private Long applyno;
	private Date optime;
	private Byte auditstatus;
	private String description;
	private String employeeid;
	private String oprcode;
	private String employeename;
	private Date birthday;
	private Short sex;
	private Short edulevel;
	private String nativehome;
	private Short polivisage;
	private String department;
	private String servoffice;
	private Long station;
	private Short joblevel;
	private Date intime;
	private Short worktime;
	private Short hereworktime;
	private Short employtype;
	private String company;
	private String telephone;
	private String officetel;
	private Date outtime;
	private String outresult;
	private String homeaddr;
	private String cardid;
	private String wayid;
	private String waytype;
	private String pvtemail;
	private String ofcphone;
	private String ofcemail;
	private String speciality;
	private String cityid;
	private String countyid;
	private String svccode;
	private String posittype;
	private Byte contacttype;
	private Byte empstatus;
	private String actbank;
	private String actno;
	private String actname;
	private String actpid;
	private Double bail;
	private String gradschool;
	private Date gradtime;
	private Byte ismarried;
	private Byte outreason;
	private String trainlevel;
	private String hobby;
	private String character;
	private String asses;
	private String workhistry;
	private String prizeorpunish;
	private String empass;
	private Byte right;
	private Byte isnet;
	private String netpass;
	private Byte isopen;
	private String selectmobile;

	// Constructors

	/** default constructor */
	public ChPwEmployeeapply() {
	}

	/** minimal constructor */
	public ChPwEmployeeapply(String wayid) {
		this.wayid = wayid;
	}

	/** full constructor */
	public ChPwEmployeeapply(Date optime, Byte auditstatus, String description,
			String employeeid, String oprcode, String employeename,
			Date birthday, Short sex, Short edulevel, String nativehome,
			Short polivisage, String department, String servoffice,
			Long station, Short joblevel, Date intime, Short worktime,
			Short hereworktime, Short employtype, String company,
			String telephone, String officetel, Date outtime, String outresult,
			String homeaddr, String cardid, String wayid, String waytype,
			String pvtemail, String ofcphone, String ofcemail,
			String speciality, String cityid, String countyid, String svccode,
			String posittype, Byte contacttype, Byte empstatus, String actbank,
			String actno, String actname, String actpid, Double bail,
			String gradschool, Date gradtime, Byte ismarried, Byte outreason,
			String trainlevel, String hobby, String character, String asses,
			String workhistry, String prizeorpunish, String empass, Byte right,
			Byte isnet, String netpass, Byte isopen, String selectmobile) {
		this.optime = optime;
		this.auditstatus = auditstatus;
		this.description = description;
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
	}

	// Property accessors

	public Long getApplyno() {
		return this.applyno;
	}

	public void setApplyno(Long applyno) {
		this.applyno = applyno;
	}

	public Date getOptime() {
		return this.optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	public Byte getAuditstatus() {
		return this.auditstatus;
	}

	public void setAuditstatus(Byte auditstatus) {
		this.auditstatus = auditstatus;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getEmployeename() {
		return this.employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Short getEdulevel() {
		return this.edulevel;
	}

	public void setEdulevel(Short edulevel) {
		this.edulevel = edulevel;
	}

	public String getNativehome() {
		return this.nativehome;
	}

	public void setNativehome(String nativehome) {
		this.nativehome = nativehome;
	}

	public Short getPolivisage() {
		return this.polivisage;
	}

	public void setPolivisage(Short polivisage) {
		this.polivisage = polivisage;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getServoffice() {
		return this.servoffice;
	}

	public void setServoffice(String servoffice) {
		this.servoffice = servoffice;
	}

	public Long getStation() {
		return this.station;
	}

	public void setStation(Long station) {
		this.station = station;
	}

	public Short getJoblevel() {
		return this.joblevel;
	}

	public void setJoblevel(Short joblevel) {
		this.joblevel = joblevel;
	}

	public Date getIntime() {
		return this.intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public Short getWorktime() {
		return this.worktime;
	}

	public void setWorktime(Short worktime) {
		this.worktime = worktime;
	}

	public Short getHereworktime() {
		return this.hereworktime;
	}

	public void setHereworktime(Short hereworktime) {
		this.hereworktime = hereworktime;
	}

	public Short getEmploytype() {
		return this.employtype;
	}

	public void setEmploytype(Short employtype) {
		this.employtype = employtype;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOfficetel() {
		return this.officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public Date getOuttime() {
		return this.outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}

	public String getOutresult() {
		return this.outresult;
	}

	public void setOutresult(String outresult) {
		this.outresult = outresult;
	}

	public String getHomeaddr() {
		return this.homeaddr;
	}

	public void setHomeaddr(String homeaddr) {
		this.homeaddr = homeaddr;
	}

	public String getCardid() {
		return this.cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWaytype() {
		return this.waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	public String getPvtemail() {
		return this.pvtemail;
	}

	public void setPvtemail(String pvtemail) {
		this.pvtemail = pvtemail;
	}

	public String getOfcphone() {
		return this.ofcphone;
	}

	public void setOfcphone(String ofcphone) {
		this.ofcphone = ofcphone;
	}

	public String getOfcemail() {
		return this.ofcemail;
	}

	public void setOfcemail(String ofcemail) {
		this.ofcemail = ofcemail;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getSvccode() {
		return this.svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getPosittype() {
		return this.posittype;
	}

	public void setPosittype(String posittype) {
		this.posittype = posittype;
	}

	public Byte getContacttype() {
		return this.contacttype;
	}

	public void setContacttype(Byte contacttype) {
		this.contacttype = contacttype;
	}

	public Byte getEmpstatus() {
		return this.empstatus;
	}

	public void setEmpstatus(Byte empstatus) {
		this.empstatus = empstatus;
	}

	public String getActbank() {
		return this.actbank;
	}

	public void setActbank(String actbank) {
		this.actbank = actbank;
	}

	public String getActno() {
		return this.actno;
	}

	public void setActno(String actno) {
		this.actno = actno;
	}

	public String getActname() {
		return this.actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public String getActpid() {
		return this.actpid;
	}

	public void setActpid(String actpid) {
		this.actpid = actpid;
	}

	public Double getBail() {
		return this.bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	public String getGradschool() {
		return this.gradschool;
	}

	public void setGradschool(String gradschool) {
		this.gradschool = gradschool;
	}

	public Date getGradtime() {
		return this.gradtime;
	}

	public void setGradtime(Date gradtime) {
		this.gradtime = gradtime;
	}

	public Byte getIsmarried() {
		return this.ismarried;
	}

	public void setIsmarried(Byte ismarried) {
		this.ismarried = ismarried;
	}

	public Byte getOutreason() {
		return this.outreason;
	}

	public void setOutreason(Byte outreason) {
		this.outreason = outreason;
	}

	public String getTrainlevel() {
		return this.trainlevel;
	}

	public void setTrainlevel(String trainlevel) {
		this.trainlevel = trainlevel;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getCharacter() {
		return this.character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getAsses() {
		return this.asses;
	}

	public void setAsses(String asses) {
		this.asses = asses;
	}

	public String getWorkhistry() {
		return this.workhistry;
	}

	public void setWorkhistry(String workhistry) {
		this.workhistry = workhistry;
	}

	public String getPrizeorpunish() {
		return this.prizeorpunish;
	}

	public void setPrizeorpunish(String prizeorpunish) {
		this.prizeorpunish = prizeorpunish;
	}

	public String getEmpass() {
		return this.empass;
	}

	public void setEmpass(String empass) {
		this.empass = empass;
	}

	public Byte getRight() {
		return this.right;
	}

	public void setRight(Byte right) {
		this.right = right;
	}

	public Byte getIsnet() {
		return this.isnet;
	}

	public void setIsnet(Byte isnet) {
		this.isnet = isnet;
	}

	public String getNetpass() {
		return this.netpass;
	}

	public void setNetpass(String netpass) {
		this.netpass = netpass;
	}

	public Byte getIsopen() {
		return this.isopen;
	}

	public void setIsopen(Byte isopen) {
		this.isopen = isopen;
	}

	public String getSelectmobile() {
		return this.selectmobile;
	}

	public void setSelectmobile(String selectmobile) {
		this.selectmobile = selectmobile;
	}

	public Class getLogClass() {
		// TODO Auto-generated method stub
		return ChPwEmployeeapplylog.class;
	}

	public String[] getLogProperties() {
		// TODO Auto-generated method stub
		return AutoLogBean.logProperties;
	}

}