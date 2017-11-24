package net.gmcc.pboss.domain.model.employee;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_PW_EMPLOYEELOG")//, schema = "PBOSS_ZS"
public class EmployeelogVO implements java.io.Serializable {
	// Fields
	private Long logid;
	private Date optime;
	private String oprcode2;
	private String oprtype;
	private String success;
	private String employeeid;
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
	private Short istenseed;
	private Short isinternal;
	private String oprcode;
	private Date regdate;
	private String subname;
	private Byte auditstatus;
	private String empattrmemo;
	private String empattr;
	private Short empattr2;

	// Constructors

	/** default constructor */
	public EmployeelogVO() {
	}

	/** minimal constructor */
	public EmployeelogVO(Date optime, String oprtype, String wayid) {
		this.optime = optime;
		this.oprtype = oprtype;
		this.wayid = wayid;
	}

	/** full constructor */
	public EmployeelogVO(Date optime, String oprcode2, String oprtype,
			String success, String employeeid, String employeename,
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
			Byte isnet, String netpass, Byte isopen, String selectmobile,
			Short istenseed, Short isinternal, String oprcode, Date regdate,
			String subname, Byte auditstatus, String empattrmemo,
			String empattr, Short empattr2) {
		this.optime = optime;
		this.oprcode2 = oprcode2;
		this.oprtype = oprtype;
		this.success = success;
		this.employeeid = employeeid;
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
		this.istenseed = istenseed;
		this.isinternal = isinternal;
		this.oprcode = oprcode;
		this.regdate = regdate;
		this.subname = subname;
		this.auditstatus = auditstatus;
		this.empattrmemo = empattrmemo;
		this.empattr = empattr;
		this.empattr2 = empattr2;
	}

	// Property accessors
	@Id
//	@SequenceGenerator(name = "CH_PW_EMPLOYEE_SEQ")
//	@GeneratedValue(strategy = SEQUENCE, generator = "CH_PW_EMPLOYEE_SEQ")
	@GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "CH_PW_EMPLOYEELOG_SEQ", allocationSize=1)
	@Column(name = "LOGID", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "OPTIME", nullable = false, length = 7)
	public Date getOptime() {
		return this.optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	@Column(name = "OPRCODE2", length = 15)
	public String getOprcode2() {
		return this.oprcode2;
	}

	public void setOprcode2(String oprcode2) {
		this.oprcode2 = oprcode2;
	}

	@Column(name = "OPRTYPE", nullable = false, length = 8)
	public String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	@Column(name = "SUCCESS", length = 8)
	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Column(name = "EMPLOYEEID", length = 15)
	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	@Column(name = "EMPLOYEENAME", length = 30)
	public String getEmployeename() {
		return this.employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "BIRTHDAY", length = 7)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "SEX", precision = 3, scale = 0)
	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	@Column(name = "EDULEVEL", precision = 3, scale = 0)
	public Short getEdulevel() {
		return this.edulevel;
	}

	public void setEdulevel(Short edulevel) {
		this.edulevel = edulevel;
	}

	@Column(name = "NATIVEHOME", length = 20)
	public String getNativehome() {
		return this.nativehome;
	}

	public void setNativehome(String nativehome) {
		this.nativehome = nativehome;
	}

	@Column(name = "POLIVISAGE", precision = 3, scale = 0)
	public Short getPolivisage() {
		return this.polivisage;
	}

	public void setPolivisage(Short polivisage) {
		this.polivisage = polivisage;
	}

	@Column(name = "DEPARTMENT", length = 18)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "SERVOFFICE", length = 18)
	public String getServoffice() {
		return this.servoffice;
	}

	public void setServoffice(String servoffice) {
		this.servoffice = servoffice;
	}

	@Column(name = "STATION", precision = 14, scale = 0)
	public Long getStation() {
		return this.station;
	}

	public void setStation(Long station) {
		this.station = station;
	}

	@Column(name = "JOBLEVEL", precision = 3, scale = 0)
	public Short getJoblevel() {
		return this.joblevel;
	}

	public void setJoblevel(Short joblevel) {
		this.joblevel = joblevel;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "INTIME", length = 7)
	public Date getIntime() {
		return this.intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	@Column(name = "WORKTIME", precision = 3, scale = 0)
	public Short getWorktime() {
		return this.worktime;
	}

	public void setWorktime(Short worktime) {
		this.worktime = worktime;
	}

	@Column(name = "HEREWORKTIME", precision = 3, scale = 0)
	public Short getHereworktime() {
		return this.hereworktime;
	}

	public void setHereworktime(Short hereworktime) {
		this.hereworktime = hereworktime;
	}

	@Column(name = "EMPLOYTYPE", precision = 3, scale = 0)
	public Short getEmploytype() {
		return this.employtype;
	}

	public void setEmploytype(Short employtype) {
		this.employtype = employtype;
	}

	@Column(name = "COMPANY", length = 50)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "TELEPHONE", length = 15)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "OFFICETEL", length = 12)
	public String getOfficetel() {
		return this.officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "OUTTIME", length = 7)
	public Date getOuttime() {
		return this.outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}

	@Column(name = "OUTRESULT")
	public String getOutresult() {
		return this.outresult;
	}

	public void setOutresult(String outresult) {
		this.outresult = outresult;
	}

	@Column(name = "HOMEADDR")
	public String getHomeaddr() {
		return this.homeaddr;
	}

	public void setHomeaddr(String homeaddr) {
		this.homeaddr = homeaddr;
	}

	@Column(name = "CARDID", length = 18)
	public String getCardid() {
		return this.cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	@Column(name = "WAYID", nullable = false, length = 18)
	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	@Column(name = "WAYTYPE", length = 4)
	public String getWaytype() {
		return this.waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	@Column(name = "PVTEMAIL", length = 128)
	public String getPvtemail() {
		return this.pvtemail;
	}

	public void setPvtemail(String pvtemail) {
		this.pvtemail = pvtemail;
	}

	@Column(name = "OFCPHONE", length = 64)
	public String getOfcphone() {
		return this.ofcphone;
	}

	public void setOfcphone(String ofcphone) {
		this.ofcphone = ofcphone;
	}

	@Column(name = "OFCEMAIL", length = 128)
	public String getOfcemail() {
		return this.ofcemail;
	}

	public void setOfcemail(String ofcemail) {
		this.ofcemail = ofcemail;
	}

	@Column(name = "SPECIALITY", length = 16)
	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Column(name = "CITYID", length = 14)
	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	@Column(name = "COUNTYID", length = 14)
	public String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	@Column(name = "SVCCODE", length = 14)
	public String getSvccode() {
		return this.svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	@Column(name = "POSITTYPE", length = 16)
	public String getPosittype() {
		return this.posittype;
	}

	public void setPosittype(String posittype) {
		this.posittype = posittype;
	}

	@Column(name = "CONTACTTYPE", precision = 2, scale = 0)
	public Byte getContacttype() {
		return this.contacttype;
	}

	public void setContacttype(Byte contacttype) {
		this.contacttype = contacttype;
	}

	@Column(name = "EMPSTATUS", precision = 2, scale = 0)
	public Byte getEmpstatus() {
		return this.empstatus;
	}

	public void setEmpstatus(Byte empstatus) {
		this.empstatus = empstatus;
	}

	@Column(name = "ACTBANK", length = 64)
	public String getActbank() {
		return this.actbank;
	}

	public void setActbank(String actbank) {
		this.actbank = actbank;
	}

	@Column(name = "ACTNO", length = 32)
	public String getActno() {
		return this.actno;
	}

	public void setActno(String actno) {
		this.actno = actno;
	}

	@Column(name = "ACTNAME", length = 32)
	public String getActname() {
		return this.actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	@Column(name = "ACTPID", length = 20)
	public String getActpid() {
		return this.actpid;
	}

	public void setActpid(String actpid) {
		this.actpid = actpid;
	}

	@Column(name = "BAIL", precision = 12)
	public Double getBail() {
		return this.bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	@Column(name = "GRADSCHOOL", length = 40)
	public String getGradschool() {
		return this.gradschool;
	}

	public void setGradschool(String gradschool) {
		this.gradschool = gradschool;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "GRADTIME", length = 7)
	public Date getGradtime() {
		return this.gradtime;
	}

	public void setGradtime(Date gradtime) {
		this.gradtime = gradtime;
	}

	@Column(name = "ISMARRIED", precision = 2, scale = 0)
	public Byte getIsmarried() {
		return this.ismarried;
	}

	public void setIsmarried(Byte ismarried) {
		this.ismarried = ismarried;
	}

	@Column(name = "OUTREASON", precision = 2, scale = 0)
	public Byte getOutreason() {
		return this.outreason;
	}

	public void setOutreason(Byte outreason) {
		this.outreason = outreason;
	}

	@Column(name = "TRAINLEVEL", length = 20)
	public String getTrainlevel() {
		return this.trainlevel;
	}

	public void setTrainlevel(String trainlevel) {
		this.trainlevel = trainlevel;
	}

	@Column(name = "HOBBY")
	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Column(name = "CHARACTER")
	public String getCharacter() {
		return this.character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	@Column(name = "ASSES")
	public String getAsses() {
		return this.asses;
	}

	public void setAsses(String asses) {
		this.asses = asses;
	}

	@Column(name = "WORKHISTRY")
	public String getWorkhistry() {
		return this.workhistry;
	}

	public void setWorkhistry(String workhistry) {
		this.workhistry = workhistry;
	}

	@Column(name = "PRIZEORPUNISH")
	public String getPrizeorpunish() {
		return this.prizeorpunish;
	}

	public void setPrizeorpunish(String prizeorpunish) {
		this.prizeorpunish = prizeorpunish;
	}

	@Column(name = "EMPASS", length = 20)
	public String getEmpass() {
		return this.empass;
	}

	public void setEmpass(String empass) {
		this.empass = empass;
	}

	@Column(name = "RIGHT", precision = 2, scale = 0)
	public Byte getRight() {
		return this.right;
	}

	public void setRight(Byte right) {
		this.right = right;
	}

	@Column(name = "ISNET", precision = 2, scale = 0)
	public Byte getIsnet() {
		return this.isnet;
	}

	public void setIsnet(Byte isnet) {
		this.isnet = isnet;
	}

	@Column(name = "NETPASS", length = 6)
	public String getNetpass() {
		return this.netpass;
	}

	public void setNetpass(String netpass) {
		this.netpass = netpass;
	}

	@Column(name = "ISOPEN", precision = 2, scale = 0)
	public Byte getIsopen() {
		return this.isopen;
	}

	public void setIsopen(Byte isopen) {
		this.isopen = isopen;
	}

	@Column(name = "SELECTMOBILE", length = 12)
	public String getSelectmobile() {
		return this.selectmobile;
	}

	public void setSelectmobile(String selectmobile) {
		this.selectmobile = selectmobile;
	}

	@Column(name = "ISTENSEED", precision = 3, scale = 0)
	public Short getIstenseed() {
		return this.istenseed;
	}

	public void setIstenseed(Short istenseed) {
		this.istenseed = istenseed;
	}

	@Column(name = "ISINTERNAL", precision = 3, scale = 0)
	public Short getIsinternal() {
		return this.isinternal;
	}

	public void setIsinternal(Short isinternal) {
		this.isinternal = isinternal;
	}

	@Column(name = "OPRCODE", length = 15)
	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "REGDATE", length = 7)
	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Column(name = "SUBNAME", length = 40)
	public String getSubname() {
		return this.subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	@Column(name = "AUDITSTATUS", precision = 2, scale = 0)
	public Byte getAuditstatus() {
		return this.auditstatus;
	}

	public void setAuditstatus(Byte auditstatus) {
		this.auditstatus = auditstatus;
	}

	@Column(name = "EMPATTRMEMO", length = 512)
	public String getEmpattrmemo() {
		return this.empattrmemo;
	}

	public void setEmpattrmemo(String empattrmemo) {
		this.empattrmemo = empattrmemo;
	}

	@Column(name = "EMPATTR", length = 50)
	public String getEmpattr() {
		return this.empattr;
	}

	public void setEmpattr(String empattr) {
		this.empattr = empattr;
	}

	@Column(name = "EMPATTR2", precision = 3, scale = 0)
	public Short getEmpattr2() {
		return this.empattr2;
	}

	public void setEmpattr2(Short empattr2) {
		this.empattr2 = empattr2;
	}

}