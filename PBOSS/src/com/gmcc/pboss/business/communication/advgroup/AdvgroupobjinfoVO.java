package com.gmcc.pboss.business.communication.advgroup;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class AdvgroupobjinfoVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long groupid;

    /** nullable persistent field */
    private String groupname;
    
    private String oid;
    
    private String oname;

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}
}
