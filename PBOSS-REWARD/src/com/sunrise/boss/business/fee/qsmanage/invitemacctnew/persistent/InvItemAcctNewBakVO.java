package com.sunrise.boss.business.fee.qsmanage.invitemacctnew.persistent;

import java.io.Serializable;


public class InvItemAcctNewBakVO implements Serializable {


    private Long feeid;

    private Long invitemid;

    private Short feekind;

    private Short type;

	public Long getFeeid() {
		return feeid;
	}

	public void setFeeid(Long feeid) {
		this.feeid = feeid;
	}

	public Long getInvitemid() {
		return invitemid;
	}

	public void setInvitemid(Long invitemid) {
		this.invitemid = invitemid;
	}

	public Short getFeekind() {
		return feekind;
	}

	public void setFeekind(Short feekind) {
		this.feekind = feekind;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
	
	public String toString() {
    	StringBuffer buf = new StringBuffer();
        buf.append(this.getFeeid().toString()).append("~").append(this.getInvitemid().toString()).append("~")
           .append(this.getFeekind().toString()).append("~").append(this.getType().toString()).append("~");
        return buf.toString();
    }
    

}
