package com.gmcc.pboss.model.sales.bankshop;

/**
 * FxCbBankshop entity. @author MyEclipse Persistence Tools
 */
public class FxCbBankshop implements java.io.Serializable {
	// Fields
	private Long recid;
	private String cityid;
	private String countyid;
	private String shopnum;
	private String terminalnum;
	private String receivebank;
	
	// Constructors
	public FxCbBankshop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FxCbBankshop(Long recid, String cityid, String countyid,
			String shopnum, String terminalnum, String receivebank) {
		super();
		this.recid = recid;
		this.cityid = cityid;
		this.countyid = countyid;
		this.shopnum = shopnum;
		this.terminalnum = terminalnum;
		this.receivebank = receivebank;
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getShopnum() {
		return shopnum;
	}

	public void setShopnum(String shopnum) {
		this.shopnum = shopnum;
	}

	public String getTerminalnum() {
		return terminalnum;
	}

	public void setTerminalnum(String terminalnum) {
		this.terminalnum = terminalnum;
	}

	public String getReceivebank() {
		return receivebank;
	}

	public void setReceivebank(String receivebank) {
		this.receivebank = receivebank;
	}
}
