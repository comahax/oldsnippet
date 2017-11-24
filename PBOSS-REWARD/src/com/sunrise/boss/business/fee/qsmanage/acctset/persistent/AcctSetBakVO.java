package com.sunrise.boss.business.fee.qsmanage.acctset.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * <p>Title: AcctSetVO</p>
 * <p>Description: Account Set VO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class AcctSetBakVO implements Serializable{
	
    private Long acctsetid;
    private Long acctid;
    
    //  Property accessors
    public AcctSetBakVO(){	
    }
    
    public AcctSetBakVO( Long acctsetid, Long acctid ){
    	this.acctsetid = acctsetid;
    	this.acctid = acctid;
    }
    
    public Long getAcctsetid() {
        return this.acctsetid;
    }
    
    public void setAcctsetid(Long acctsetid) {
        this.acctsetid = acctsetid;
    }

    public Long getAcctid() {
        return this.acctid;
    }
    
    public void setAcctid(Long acctid) {
        this.acctid = acctid;
    }
    
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.getAcctsetid()).append("~").append(this.getAcctid()).append("~");
        return buf.toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AcctSetBakVO) ) return false;
        AcctSetBakVO castOther = (AcctSetBakVO) other;
        return new EqualsBuilder()
            .append(this.getAcctsetid(), castOther.getAcctsetid())
            .append(this.getAcctid(), castOther.getAcctid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcctsetid())
            .append(getAcctid())
            .toHashCode();
    }
}
