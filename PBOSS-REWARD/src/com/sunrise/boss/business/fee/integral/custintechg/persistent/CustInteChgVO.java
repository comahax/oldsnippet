package com.sunrise.boss.business.fee.integral.custintechg.persistent;

import java.util.Date;


public class CustInteChgVO  implements java.io.Serializable {

 
    // Fields    

     private Long logid;
     
     private Long custid;
     private Long integralcyc;
     private Long subsid;
     private Long beforesaleint;
     private Long aftersaleint;
     private Long beforeavlint;
     private Long afteravlint;
     private Date updatetime;
     private String oprcode;
     private Integer intchgrsn;
     private String descrp;
     private Long workfid;
     private Long bankserial;
     private String firmid;
     private Double consume;



    

   
    // Property accessors


	public Long getLogid() {
        return this.logid;
    }
    
    public void setLogid(Long logid) {
        this.logid = logid;
    }

    public Long getCustid() {
        return this.custid;
    }
    
    public void setCustid(Long custid) {
        this.custid = custid;
    }

    public Long getIntegralcyc() {
        return this.integralcyc;
    }
    
    public void setIntegralcyc(Long integralcyc) {
        this.integralcyc = integralcyc;
    }

    public Long getSubsid() {
        return this.subsid;
    }
    
    public void setSubsid(Long subsid) {
        this.subsid = subsid;
    }



    

    
    
    public Long getAftersaleint() {
		return aftersaleint;
	}

	public void setAftersaleint(Long aftersaleint) {
		this.aftersaleint = aftersaleint;
	}

	public Long getBeforesaleint() {
		return beforesaleint;
	}

	public void setBeforesaleint(Long beforesaleint) {
		this.beforesaleint = beforesaleint;
	}

	public Long getAfteravlint() {
		return afteravlint;
	}

	public void setAfteravlint(Long afteravlint) {
		this.afteravlint = afteravlint;
	}

	public Long getBeforeavlint() {
		return beforeavlint;
	}

	public void setBeforeavlint(Long beforeavlint) {
		this.beforeavlint = beforeavlint;
	}

	public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getOprcode() {
        return this.oprcode;
    }
    
    public void setOprcode(String oprcode) {
        this.oprcode = oprcode;
    }

    public Integer getIntchgrsn() {
        return this.intchgrsn;
    }
    
    public void setIntchgrsn(Integer intchgrsn) {
        this.intchgrsn = intchgrsn;
    }

    public String getDescrp() {
        return this.descrp;
    }
    
    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public Long getWorkfid() {
        return this.workfid;
    }
    
    public void setWorkfid(Long workfid) {
        this.workfid = workfid;
    }

    public Long getBankserial() {
        return this.bankserial;
    }
    
    public void setBankserial(Long bankserial) {
        this.bankserial = bankserial;
    }

    public String getFirmid() {
        return this.firmid;
    }
    
    public void setFirmid(String firmid) {
        this.firmid = firmid;
    }

    public Double getConsume() {
        return this.consume;
    }
    
    public void setConsume(Double consume) {
        this.consume = consume;
    }
   








}