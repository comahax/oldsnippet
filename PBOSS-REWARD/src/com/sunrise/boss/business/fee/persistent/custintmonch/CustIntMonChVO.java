package com.sunrise.boss.business.fee.persistent.custintmonch;

import java.util.Date;

public class CustIntMonChVO  implements java.io.Serializable {

    // Fields    

     private Long custid;
     private Long billcyc;
     private Long balance;
     private Long increase;
     private Long decrease;
     private Long exchintegral;
     private Long moveint;
     private Date updatetime;
     private Long state;
     private Long intPreserve1;
     private Long intPreserve2;


   
   
    // Property accessors

    public Long getCustid() {
        return this.custid;
    }
    
    public void setCustid(Long custid) {
        this.custid = custid;
    }


    public Long getBalance() {
        return this.balance;
    }
    
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getIncrease() {
        return this.increase;
    }
    
    public void setIncrease(Long increase) {
        this.increase = increase;
    }

    public Long getDecrease() {
        return this.decrease;
    }
    
    public void setDecrease(Long decrease) {
        this.decrease = decrease;
    }

    public Long getExchintegral() {
        return this.exchintegral;
    }
    
    public void setExchintegral(Long exchintegral) {
        this.exchintegral = exchintegral;
    }

    public Long getMoveint() {
        return this.moveint;
    }
    
    public void setMoveint(Long moveint) {
        this.moveint = moveint;
    }

    public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getState() {
        return this.state;
    }
    
    public void setState(Long state) {
        this.state = state;
    }

    public Long getIntPreserve1() {
        return this.intPreserve1;
    }
    
    public void setIntPreserve1(Long intPreserve1) {
        this.intPreserve1 = intPreserve1;
    }

    public Long getIntPreserve2() {
        return this.intPreserve2;
    }
    
    public void setIntPreserve2(Long intPreserve2) {
        this.intPreserve2 = intPreserve2;
    }

	public Long getBillcyc() {
		return billcyc;
	}

	public void setBillcyc(Long billcyc) {
		this.billcyc = billcyc;
	}
   
}