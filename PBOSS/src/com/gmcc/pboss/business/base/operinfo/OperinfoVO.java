package com.gmcc.pboss.business.base.operinfo;

import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OperinfoVO extends BaseVO implements Serializable {
	// Fields

	private String operid;
	private Long region;
	private Date birthday;
	private Date workdate;
	private String sex;
	private String trainlevel;
	private String educationlevel;
	private String skilllevel;
	private String totallevel;
	private String comitylevel;
	private String certid;
	private Long operatorType;
	private String nativehome;
	private Date graduatedate;
	private Long ismarray;
	private String polityface;
	private String homeaddress;
	private String joblive;
	private String nowpostid;
	private String bloodtype;
	private String healthy;
	private String character;
	private String enjoyful;
	private String prisocietyrelation;
	private String familydes;
	private String starlevel;
	private String assessrec;
	private Long hrStatus;
	private String title;
	private String countyId;
	private String specialty;
	private String fax;
	private String homeTele;
	private String email;
	private String msisdn;

	// Constructors

	/** default constructor */
	public OperinfoVO() {
	}

	/** full constructor */
	public OperinfoVO(String operid,Long region, Date birthday, Date workdate,
			String sex, String trainlevel, String educationlevel,
			String skilllevel, String totallevel, String comitylevel,
			String certid, Long operatorType, String nativehome,
			Date graduatedate, Long ismarray, String polityface,
			String homeaddress, String joblive, String nowpostid,
			String bloodtype, String healthy, String character,
			String enjoyful, String prisocietyrelation, String familydes,
			String starlevel, String assessrec, Long hrStatus, String title,
			String countyId, String specialty, String fax, String homeTele,
			String email, String msisdn) {
		this.operid = operid;
		this.region=region;
		this.birthday = birthday;
		this.workdate = workdate;
		this.sex = sex;
		this.trainlevel = trainlevel;
		this.educationlevel = educationlevel;
		this.skilllevel = skilllevel;
		this.totallevel = totallevel;
		this.comitylevel = comitylevel;
		this.certid = certid;
		this.operatorType = operatorType;
		this.nativehome = nativehome;
		this.graduatedate = graduatedate;
		this.ismarray = ismarray;
		this.polityface = polityface;
		this.homeaddress = homeaddress;
		this.joblive = joblive;
		this.nowpostid = nowpostid;
		this.bloodtype = bloodtype;
		this.healthy = healthy;
		this.character = character;
		this.enjoyful = enjoyful;
		this.prisocietyrelation = prisocietyrelation;
		this.familydes = familydes;
		this.starlevel = starlevel;
		this.assessrec = assessrec;
		this.hrStatus = hrStatus;
		this.title = title;
		this.countyId = countyId;
		this.specialty = specialty;
		this.fax = fax;
		this.homeTele = homeTele;
		this.email = email;
		this.msisdn = msisdn;
	}

	
	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long region) {
		this.region = region;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTrainlevel() {
		return this.trainlevel;
	}

	public void setTrainlevel(String trainlevel) {
		this.trainlevel = trainlevel;
	}

	public String getEducationlevel() {
		return this.educationlevel;
	}

	public void setEducationlevel(String educationlevel) {
		this.educationlevel = educationlevel;
	}

	public String getSkilllevel() {
		return this.skilllevel;
	}

	public void setSkilllevel(String skilllevel) {
		this.skilllevel = skilllevel;
	}

	public String getTotallevel() {
		return this.totallevel;
	}

	public void setTotallevel(String totallevel) {
		this.totallevel = totallevel;
	}

	public String getComitylevel() {
		return this.comitylevel;
	}

	public void setComitylevel(String comitylevel) {
		this.comitylevel = comitylevel;
	}

	public String getCertid() {
		return this.certid;
	}

	public void setCertid(String certid) {
		this.certid = certid;
	}

	public Long getOperatorType() {
		return this.operatorType;
	}

	public void setOperatorType(Long operatorType) {
		this.operatorType = operatorType;
	}

	public String getNativehome() {
		return this.nativehome;
	}

	public void setNativehome(String nativehome) {
		this.nativehome = nativehome;
	}

	public Date getGraduatedate() {
		return this.graduatedate;
	}

	public void setGraduatedate(Date graduatedate) {
		this.graduatedate = graduatedate;
	}

	public Long getIsmarray() {
		return this.ismarray;
	}

	public void setIsmarray(Long ismarray) {
		this.ismarray = ismarray;
	}

	public String getPolityface() {
		return this.polityface;
	}

	public void setPolityface(String polityface) {
		this.polityface = polityface;
	}

	public String getHomeaddress() {
		return this.homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getJoblive() {
		return this.joblive;
	}

	public void setJoblive(String joblive) {
		this.joblive = joblive;
	}

	public String getNowpostid() {
		return this.nowpostid;
	}

	public void setNowpostid(String nowpostid) {
		this.nowpostid = nowpostid;
	}

	public String getBloodtype() {
		return this.bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getHealthy() {
		return this.healthy;
	}

	public void setHealthy(String healthy) {
		this.healthy = healthy;
	}

	public String getCharacter() {
		return this.character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getEnjoyful() {
		return this.enjoyful;
	}

	public void setEnjoyful(String enjoyful) {
		this.enjoyful = enjoyful;
	}

	public String getPrisocietyrelation() {
		return this.prisocietyrelation;
	}

	public void setPrisocietyrelation(String prisocietyrelation) {
		this.prisocietyrelation = prisocietyrelation;
	}

	public String getFamilydes() {
		return this.familydes;
	}

	public void setFamilydes(String familydes) {
		this.familydes = familydes;
	}

	public String getStarlevel() {
		return this.starlevel;
	}

	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}

	public String getAssessrec() {
		return this.assessrec;
	}

	public void setAssessrec(String assessrec) {
		this.assessrec = assessrec;
	}

	public Long getHrStatus() {
		return this.hrStatus;
	}

	public void setHrStatus(Long hrStatus) {
		this.hrStatus = hrStatus;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountyId() {
		return this.countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHomeTele() {
		return this.homeTele;
	}

	public void setHomeTele(String homeTele) {
		this.homeTele = homeTele;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}


	public String toString() {
        return new ToStringBuilder(this)
            .append("operid", this.getOperid())
            .append("region",this.getRegion())
            .toString();
    }
	
	public int hashCode() {
        return new HashCodeBuilder()
            .append(getOperid())
            .append(getRegion())
            .toHashCode();
    }
	
	public boolean equals(Object other) {
	        if ( !(other instanceof OperinfoVO) ) return false;
	        OperinfoVO castOther = (OperinfoVO) other;
	        return new EqualsBuilder()
	            .append(this.getOperid(), castOther.getOperid())
	            .append(this.getRegion(), castOther.getRegion())
	            .isEquals();
	}

   

}
