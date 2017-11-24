package com.gmcc.pboss.business.channel.checkedapplydetail;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class ViewCADVO extends BaseVO implements Serializable {
	private String cityid;
	private String nettype;
	private String chainhead;
	private String wayname;
	private String wayid;
	private String address;
	private String buztypecode;
	private String chktype;
	private String starlevel;
	private String wtype;
	private String status;
	private String applytype;
	
	private String applyno;
	private String aptime;
	private String oprtime;
	private String seq;
	private String waystatus;
	
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getNettype() {
		return nettype;
	}
	public void setNettype(String nettype) {
		this.nettype = nettype;
	}
	public String getChainhead() {
		return chainhead;
	}
	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuztypecode() {
		return buztypecode;
	}
	public void setBuztypecode(String buztypecode) {
		this.buztypecode = buztypecode;
	}
	public String getChktype() {
		return chktype;
	}
	public void setChktype(String chktype) {
		this.chktype = chktype;
	}
	public String getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}
	public String getWtype() {
		return wtype;
	}
	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApplytype() {
		return applytype;
	}
	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}
	public String getApplyno() {
		return applyno;
	}
	public void setApplyno(String applyno) {
		this.applyno = applyno;
	}
	public String getAptime() {
		return aptime;
	}
	public void setAptime(String aptime) {
		this.aptime = aptime;
	}
	public String getOprtime() {
		return oprtime;
	}
	public void setOprtime(String oprtime) {
		this.oprtime = oprtime;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getWaystatus() {
		return waystatus;
	}
	public void setWaystatus(String waystatus) {
		this.waystatus = waystatus;
	}
}
