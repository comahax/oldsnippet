package com.sunrise.boss.business.fee.common.multinode.persistent;

import java.io.Serializable;
import java.util.Date;

public class MultiNodeVO implements Serializable {

	private Long multinodeid;
	private String beginno;
	private String endno;
	private String areacode;
	private String nodeid;
	private Date starttime;
	private Short nosectstate;
	private Date intime;
	
	
	public Long getMultinodeid() {
		return multinodeid;
	}

	public void setMultinodeid(Long multinodeid) {
		this.multinodeid = multinodeid;
	}

	public String getBeginno() {
		return beginno;
	}

	public void setBeginno(String beginno) {
		this.beginno = beginno;
	}

	public String getEndno() {
		return endno;
	}

	public void setEndno(String endno) {
		this.endno = endno;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Short getNosectstate() {
		return nosectstate;
	}

	public void setNosectstate(Short nosectstate) {
		this.nosectstate = nosectstate;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

}
