package com.gmcc.pboss.business.channel.checkedapply;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class ViewCDVO extends BaseVO implements Serializable {
	private String cityid;
	private String applytype;
	private String status;
	private Long nettypestat;
	private Long nettype1stat;
	private Long istopstat;
	private Long statstat;
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getApplytype() {
		return applytype;
	}
	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getNettypestat() {
		return nettypestat;
	}
	public void setNettypestat(Long nettypestat) {
		this.nettypestat = nettypestat;
	}
	public Long getNettype1stat() {
		return nettype1stat;
	}
	public void setNettype1stat(Long nettype1stat) {
		this.nettype1stat = nettype1stat;
	}
	public Long getIstopstat() {
		return istopstat;
	}
	public void setIstopstat(Long istopstat) {
		this.istopstat = istopstat;
	}
	public Long getStatstat() {
		return statstat;
	}
	public void setStatstat(Long statstat) {
		this.statstat = statstat;
	}
}
