package com.gmcc.pboss.business.sales.disformintervaltime;

import java.io.Serializable;

public class DisformintervalStatInfo implements Serializable {
	private String countyid;
	private String mareacode;
	private Long starlevel;
	private Long totalorder;
	private Long totalovertime;
	public DisformintervalStatInfo() {
		super();
	}
	public DisformintervalStatInfo(String countyid, String mareacode,
			Long starlevel, Long totalorder, Long totalovertime) {
		super();
		this.countyid = countyid;
		this.mareacode = mareacode;
		this.starlevel = starlevel;
		this.totalorder = totalorder;
		this.totalovertime = totalovertime;
	}
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public String getMareacode() {
		return mareacode;
	}
	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}
	public Long getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}
	public Long getTotalorder() {
		return totalorder;
	}
	public void setTotalorder(Long totalorder) {
		this.totalorder = totalorder;
	}
	public Long getTotalovertime() {
		return totalovertime;
	}
	public void setTotalovertime(Long totalovertime) {
		this.totalovertime = totalovertime;
	}
	
}
